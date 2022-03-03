package com.demo.librarysystem.service;

import com.demo.librarysystem.model.Users;
import com.demo.librarysystem.repository.UserAccountRepository;
import com.demo.librarysystem.util.HibernateConfig;
import org.hibernate.Session;

import java.util.ArrayList;
import java.util.Iterator;

public class UserService {
    Session session;

    public UserService(){
        session = HibernateConfig.getSession();
    }

    public void addUser(ArrayList<Users> usersDetails) {
        Iterator<Users> itr = usersDetails.iterator();
        while (itr.hasNext()) {
            Users users = itr.next();
            UserAccountRepository repo = new UserAccountRepository(users.getUid(), users.getUsername(), users.getUseremail(), users.getUsercontact());
            session.beginTransaction();
            session.save(repo);
            session.getTransaction().commit();
        }
    }






}
