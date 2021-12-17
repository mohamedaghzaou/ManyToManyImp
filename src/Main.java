
import java.util.List;

import org.hibernate.Session;

import com.hibernate.hibernateutils.hibernateUtils;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Session s = hibernateUtils.getSession();
		s.beginTransaction();

		List<Object> l = s.createQuery("select q.inituleProfile, q.niveauscolaire  from Profile q", Object.class)

				.getResultList();

		s.getTransaction().commit();

		System.out.println(l);
		s.close();

	}

}
