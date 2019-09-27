package org.studyeasy.hibernate;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.studyeasy.hibernate.entity.Users;

public class App {
	public static void main(String[] args) {
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Users.class)
				.buildSessionFactory();
		Session session = factory.getCurrentSession();
		try {
			// Create object of entity class type
			Users user = new Users("username", "password", "firstName", "lastName");
			Users userNull = new Users();

			// Start Transaction
			session.beginTransaction();

//			// Perform Operation
//			session.save(user);

			// get user
//			userNull = session.get(Users.class, 1);

			// get list
//			List<Users> resultList = session
//					.createQuery("from users where firstName='Shriyansh'" + "OR lastName='Srivastava'").getResultList();

			// update HQL
//			session.createQuery("update users set password='123456'").executeUpdate();

			// delete HQL
			session.createQuery("delete from users Where user_id=1").executeUpdate();
//			System.out.println(resultList);

			// updating object
//			userNull.setUsername("Shey");

			// deleting user
//			session.delete(userNull);

			// Commit the Transaction
			session.getTransaction().commit();
			System.out.println(userNull);

		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			session.close();
			factory.close();
		}

	}
}
