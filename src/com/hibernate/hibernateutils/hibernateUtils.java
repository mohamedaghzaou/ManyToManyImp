package com.hibernate.hibernateutils;

import java.util.Properties;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;

import com.hibernate.model.Diplome;
import com.hibernate.model.Entreprise;
import com.hibernate.model.Post;
import com.hibernate.model.Profile;
import com.hibernate.model.Qualite;
import com.hibernate.model.Tache;

public class hibernateUtils {

	private static final SessionFactory sessionFactory;
	private static final String database_Name = "dbManyToMany";
	private static final String USER = "root";
	private static final String password = "password";

	static {
		// data
		
		Properties prop = new Properties();
		prop.setProperty(Environment.URL, "jdbc:mysql://localhost:3306/" + database_Name);
		prop.setProperty(Environment.DIALECT, "org.hibernate.dialect.MySQL5InnoDBDialect");
		prop.setProperty(Environment.USER, USER);
		prop.setProperty(Environment.PASS, password);
		prop.setProperty(Environment.DRIVER, "com.mysql.cj.jdbc.Driver");
		prop.setProperty(Environment.SHOW_SQL, "true");
		prop.setProperty(Environment.DEFAULT_SCHEMA, "dbproduct");
		prop.setProperty(Environment.USE_NEW_ID_GENERATOR_MAPPINGS, "false");
		prop.setProperty(Environment.HBM2DDL_AUTO, "update");
		prop.setProperty(Environment.FORMAT_SQL, "true");

		Configuration configuration = new Configuration();
		configuration.setProperties(prop);
		// add annotated classes
		configuration.addAnnotatedClass(Diplome.class);
		configuration.addAnnotatedClass(Entreprise.class);
		configuration.addAnnotatedClass(Post.class);
		configuration.addAnnotatedClass(Profile.class);
		configuration.addAnnotatedClass(Qualite.class);
		configuration.addAnnotatedClass(Tache.class);
		

		sessionFactory = configuration.buildSessionFactory();

	}

	public static Session getSession() {
		return sessionFactory.openSession();
	}

}
