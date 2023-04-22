package com.utils;

import java.util.Properties;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.hibernate.service.ServiceRegistry;
import com.entities.*;
public class HibernateUtil {

	private static SessionFactory sessionFactory;

	private HibernateUtil() {
	};

	public static SessionFactory getSessionFactory() {
		if(sessionFactory==null) {
			try {
				
				
				Configuration con = new Configuration();

				Properties settings = new Properties();

				settings.put(Environment.DRIVER, "com.mysql.cj.jdbc.Driver");
				settings.put(Environment.URL, "jdbc:mysql://localhost:3306/social-media");
				settings.put(Environment.USER, "root");
				settings.put(Environment.PASS, "");
				settings.put(Environment.DIALECT, "org.hibernate.dialect.MySQL8Dialect");

				settings.put(Environment.SHOW_SQL, "true");
				settings.put(Environment.CURRENT_SESSION_CONTEXT_CLASS, "thread");
				settings.put(Environment.HBM2DDL_AUTO, "create");

				con.setProperties(settings);
				con.addAnnotatedClass(User.class);
				con.addAnnotatedClass(Post.class);
				con.addAnnotatedClass(PostImage.class);

				ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(con.getProperties())
						.build();

				sessionFactory = con.buildSessionFactory(serviceRegistry);
				} catch (Exception e) {
					// TODO: handle exception
					e.printStackTrace();
				}

		}
		
		return sessionFactory;
	}
}
