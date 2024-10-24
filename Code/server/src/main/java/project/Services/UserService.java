package project.Services;

import org.hibernate.HibernateError;
import project.DAO.UserDAO;
import project.Interfaces.CRUD;
import project.Models.User;

import java.util.List;

public class UserService implements CRUD<User> {
    UserDAO userDAO = new UserDAO();

    @Override
    public boolean add(User user) {
        boolean isAdded = false;
        try {
            if (userDAO.add(user)) {
                isAdded = true;
            }
        } catch (HibernateError e) {
            System.out.println(e.getMessage());
        }
        return isAdded;
    }

    @Override
    public boolean update(User user) {
        boolean isUpdated = false;
        try {
            if (userDAO.update(user)) {
                isUpdated = true;
            }
        } catch (HibernateError e) {
            System.out.println(e.getMessage());
        }
        return isUpdated;
    }

    @Override
    public boolean delete(int id) {
        boolean isDeleted = false;
        try {
            if (userDAO.delete(id)) {
                isDeleted = true;
            }
        } catch (HibernateError e) {
            System.out.println(e.getMessage());
        }
        return isDeleted;
    }

    @Override
    public List<User> showAll() {
        List<User> users = null;
        try {
            users = userDAO.showAll();
        } catch (HibernateError e) {
            System.out.println(e.getMessage());
        }
        return users;
    }

    @Override
    public User findById(int id) {
        User user = null;
        try {
            user = userDAO.findById(id);
        } catch (HibernateError e) {
            System.out.println(e.getMessage());
        }
        return user;
    }
}
