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

   /* public Library searchByTitle(String title)
    {
        int numBooks = 0;
        for (int i = 0; i < size; i++) {
            if (books[i].titleContains(title)) {
                numBooks++;
            }
        }

        Library selection = new Library(numBooks);

        for (int i = 0; i < size; i++) {
            if (books[i].titleContains(title)) {
                selection.addBook(books[i]);
            }
        }
        return selection;
    }*/

    /* public Library searchByTitle(String title)
    {
        int numBooks = 0;
        for (int i = 0; i < size; i++) {
            if (books[i].titleContains(title)) {
                numBooks++;
            }
        }

        Library selection = new Library(numBooks);

        for (int i = 0; i < size; i++) {
            if (books[i].titleContains(title)) {
                selection.addBook(books[i]);
            }
        }
        return selection;
    }*/
}
