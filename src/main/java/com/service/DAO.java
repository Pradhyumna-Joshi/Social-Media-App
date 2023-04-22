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

//	public void savePostImage(PostInterface p) {
//		// TODO Auto-generated method stub
//		
//		Transaction transaction = null;
//		try {
//
//			Session session = HibernateUtil.getSessionFactory().openSession();
//			// start
//			transaction = session.beginTransaction();
//
//			// save
//			session.persist(p);
//
//			// commit
//			transaction.commit();
//
//		} catch (Exception e) {
//			if (transaction != null) {
//				transaction.rollback();
//			}
//			e.printStackTrace();
//			// TODO: handle exception
//		}
//		
//	}

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

//public class DAO {
//	
//	
//	public static void main(String[] args) throws Exception {
//		
//		
//		String url = "jdbc:mysql://localhost::3306//tableName";
//		String username = "";
//		String password = "";
//		String query = ""
//		
//	//2 load and register the driver
//		Class.forName("com.mysql.jdbc.Driver");
//		
//		
//	// 3 create connection
//		Connection con = DriverManager.getConnection(url, username, password);
//		
//		
//	//4 create statement
//		Statement statement = con.createStatement();
//		
//	// 5 query
//		ResultSet rs = statement.executeQuery(query);
//		
//		rs.next();
//		String nameString = rs.getString("columnName");
//		
//		System.out.println(nameString);
//		
//		statement.close();
//		con.close();
//	
//	}
//	
//	
//	
//	
//}

// singleton pattern

//class ConnectionInstance {
//	public static Connection connection;
//
//	private ConnectionInstance() {
//	};
//
//	public static Connection getConnectionInstance() {
//
//		if (connection == null) {
//
//			try {
//
//				String url = "jdbc:mysql://localhost::3306/socialdb";
//				String username = "root";
//				String password = "Pradhyumna@07";
//				Class.forName("com.mysql.cj.jdbc.Driver");
//
//				connection = DriverManager.getConnection(url, username, password);
//
//			} catch (Exception e) {
//				System.out.println(e.getLocalizedMessage());
//			}
//
//		}
//		return connection;
//	}
//
//}
//
//public class DAO {
//
//	public boolean fetchUser(User u) {
//
//		String query = "SELECT * FROM USER WHERE USERNAME=" + u.getUsername();
//
//		try {
//
//			String url = "jdbc:mysql://localhost::3306/socialdb";
//			String username = "pma";
//			String password = "";
//			Class.forName("com.mysql.cj.jdbc.Driver");
//
//			Connection connection = DriverManager.getConnection(
//					"jdbc:mysql://localhost::3306/socialdb",
//					"root",
//					"Pradhyumna@07"
//					
//					);
//
//			Statement statement = connection.createStatement();
//
//			ResultSet result = statement.executeQuery(query);
//
//			result.next();
//			String name = result.getString("username");
//			System.out.println(name);
//			statement.close();
//			connection.close();
//
//			if (!name.isEmpty()) {
//				return true;
//			} else {
//				return false;
//			}
//
//		} catch (Exception e) {
//
//			System.out.println(e.getLocalizedMessage());
//		}
//		return false;
//	}
//	
//	
////	try {
////
////		String url = "jdbc:mysql://localhost::3306/socialdb";
////		String username = "root";
////		String password = "Pradhyumna@07";
////		Class.forName("com.mysql.cj.jdbc.Driver");
////
////		Connection connection = DriverManager.getConnection(url, username, password);
////
////		PreparedStatement statement = connection.prepareStatement(query);
////		statement.setString(1, u.getUsername());
////		statement.setString(2, u.getEmail());
////		statement.setString(3, u.getPassword());
////
////		int count = statement.executeUpdate();
////		statement.close();
////		connection.close();
////		if (count == 1) {
////			return true;
////		}
////
////	} catch (Exception e) {
////		System.out.println(e.getLocalizedMessage());
////	}
////	return false;
//
//	public boolean saveUser(User u) {
//
//		String query = "INSERT INTO USER VALUES(?,?,?)";
//		
//		String url = "jdbc:mysql://localhost::3306/socialdb?useSSL=false";
//		String username ="pma";
//		String password = "";
//		
//		try {
//			Class.forName("com.mysql.cj.jdbc.Driver");
//			System.out.println(1);
//			
//			Connection connection = DriverManager.getConnection(
//					"jdbc:mysql://localhost::3306/social_media",
//					"root",
//					"Pradhyumna@07"		
//					);
//			
//			
//			System.out.println(2);
//			PreparedStatement statement = connection.prepareStatement(query);
//			
//			statement.setString(1, u.getUsername());
//			statement.setString(2, u.getEmail());
//			statement.setString(3, u.getPassword());
//			System.out.println(u);
//			int count = statement.executeUpdate();
//			
//			System.out.println(count);
//			return true;
//			
//		
//		}catch (Exception e) {
//			System.out.println(e.getLocalizedMessage());
//		}
//		
//		return false;
//		
//		
//
//		
//
//	}
//
//}
