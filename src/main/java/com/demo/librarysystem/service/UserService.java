package com.demo.librarysystem.service;

import com.demo.librarysystem.model.User;
import com.demo.librarysystem.repository.UserAccountRepository;
import com.demo.librarysystem.util.HibernateConfig;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class UserService {
    Session session;

    public UserService(){
        session = HibernateConfig.getSession();
    }

    public void addUser(ArrayList<User> userDetails) {
        Iterator<User> itr = userDetails.iterator();
        while (itr.hasNext()) {
            User user = itr.next();
            UserAccountRepository repo = new UserAccountRepository(user.getId(), user.getName(), user.getEmail(), user.getContact());
            session.beginTransaction();
            session.save(repo);

            session.getTransaction().commit();
        }
    }

        /*public int getIdByEmail(String email) {
            session = sessionFact.openSession();
            Query query = session.createQuery("SELECT u.user_id FROM User u WHERE u.email=:emailParam");
            query.setParameter("emailParam", email);
            return (int) query.uniqueResult();
        }*/
        /*public User getUserDetailsbyId(int id){
            Transaction transaction = null;
            User user = null;
            try {
                transaction = session.beginTransaction();
                user = session.get(User.class, id);
                transaction.commit();
            } catch (Exception e) {
                transaction.rollback();
            }
            return  user;
        }*/

}
