package com.demo.librarysystem.util;

import com.demo.librarysystem.repository.BookRepository;
import com.demo.librarysystem.repository.UserAccountRepository;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

public class HibernateConfig {

    public static Session getSession() {

        Configuration con = new Configuration().configure("hibernate.xml")
                .addAnnotatedClass(UserAccountRepository.class)
                .addAnnotatedClass(BookRepository.class);
        StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
                .applySettings(con.getProperties())
                .build();
        SessionFactory sf = con.buildSessionFactory(registry);
        Session session = sf.openSession();
        return session;
    }
}
