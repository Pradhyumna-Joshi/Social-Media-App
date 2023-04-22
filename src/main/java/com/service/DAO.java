package com.service;


import java.util.ArrayList;
import java.util.List;

import com.entities.Post;
import com.entities.PostImage;
import com.entities.PostInterface;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Component;
import com.entities.User;
import com.utils.HibernateUtil;

@Component
public class DAO {

	public void updatePost(int id) {

		Transaction transaction = null;
		try {

			Session session = HibernateUtil.getSessionFactory().openSession();
			// start
			transaction = session.beginTransaction();

			// save
			Post p = session.get(Post.class, id);
			p.setLikes(p.getLikes() + 1);
			session.merge(p);

			// commit
			transaction.commit();

		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
			// TODO: handle exception
		}
	}

	@SuppressWarnings({ "deprecation", "unchecked" })
	public List<Post> getAll(String query) {

		Transaction transaction = null;
		List<Post> result = new ArrayList<Post>();
		try {

			Session session = HibernateUtil.getSessionFactory().openSession();

			transaction = session.beginTransaction();

			result = session.createQuery(query).list();

			transaction.commit();

		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();

		}
		return result;
	}

	@SuppressWarnings({ "deprecation", "unchecked" })
	public List<PostImage> getAllImages() {

		Transaction transaction = null;
		List<PostImage> result = new ArrayList<PostImage>();
		try {

			Session session = HibernateUtil.getSessionFactory().openSession();

			transaction = session.beginTransaction();

			result = session.createQuery("from PostImage").list();

			transaction.commit();

		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();

		}
		return result;
	}

	@SuppressWarnings({ "deprecation", "unchecked" })
	public boolean fetchUser(User u) {

		System.out.println(u);
		Transaction transaction = null;

		User user = null;
		List<User> list = new ArrayList<User>();
		try {

			Session session = HibernateUtil.getSessionFactory().openSession();

			transaction = session.beginTransaction();

			user = session.get(User.class, u.getEmail());

			transaction.commit();

		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();

		}
		if (user != null) {
			return true;
		}
		return false;
	}

	public void saveUser(User u) {
		Transaction transaction = null;
		try {

			Session session = HibernateUtil.getSessionFactory().openSession();

			transaction = session.beginTransaction();

			session.persist(u);

			transaction.commit();

		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();

		}
	}

	public void savePost(PostInterface p) {

		Transaction transaction = null;
		try {

			Session session = HibernateUtil.getSessionFactory().openSession();
			// start
			transaction = session.beginTransaction();

			// save
			session.persist(p);

			// commit
			transaction.commit();

		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
			// TODO: handle exception
		}

	}



	@SuppressWarnings("deprecation")
	public void deletePost(int t) {
		Transaction transaction = null;
		try {

			Session session = HibernateUtil.getSessionFactory().openSession();
			// start
			transaction = session.beginTransaction();

			// save
			Post u = session.get(Post.class, t);
			session.delete(u);
			;

			// commit
			transaction.commit();

		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
			// TODO: handle exception
		}

	}

}


