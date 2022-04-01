package com.demo.librarysystem.service;

import com.demo.librarysystem.model.Users;
import com.demo.librarysystem.repository.UserAccountRepository;
import com.demo.librarysystem.util.HibernateConfig;
import org.hibernate.Session;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class UserService {

    Session session;

    public UserService(){
        session = HibernateConfig.getSession();
    }


    public void addUser(ArrayList<Users> usersDetails) {
        Iterator<Users> itr = usersDetails.iterator();
        while (itr.hasNext()) {
            Users users = itr.next();
            UserAccountRepository repo = new UserAccountRepository(users.getUserName(), users.getFirstname(), users.getLastname(), users.getPassword(), users.getEmail(), users.getAddress(), users.getBirthdate(), users.getContact());
            session.beginTransaction();
            session.save(repo);
            session.getTransaction().commit();

        }

    }
}
