package project.DAO;

import org.hibernate.Session;
import project.Interfaces.CRUD;
import project.Models.User;
import project.SessionFactory.SessionFactoryImpl;

import java.util.List;

public class UserDAO implements CRUD <User> {
    @Override
    public boolean add(User user) {
        boolean isAdded = false;
        try(Session session = SessionFactoryImpl.getSessionFactory().openSession()){
            session.beginTransaction();
            session.persist(user);
            session.getTransaction().commit();
            isAdded = true;
        } catch (NoClassDefFoundError e){
            System.out.println("Exception: " + e);
        }
        return isAdded;
    }

    @Override
    public boolean update(User user) {
        boolean isUpdated = false;
        try(Session session = SessionFactoryImpl.getSessionFactory().openSession()){
            session.beginTransaction();
            session.merge(user);
            session.getTransaction().commit();
            isUpdated = true;
        } catch (NoClassDefFoundError e){
            System.out.println("Exception: " + e);
        }
        return isUpdated;
    }

    @Override
    public boolean delete(int id) {
        boolean isDeleted = false;
        try(Session session = SessionFactoryImpl.getSessionFactory().openSession()){
            session.beginTransaction();
            User user = session.get(User.class, id);
            session.remove(user);
            session.getTransaction().commit();
            isDeleted = true;
        } catch (NoClassDefFoundError e){
            System.out.println("Exception: " + e);
        }
        return isDeleted;
    }

    @Override
    public List<User> showAll() {
        List<User> users = null;
        try (Session session = SessionFactoryImpl.getSessionFactory().openSession()){
            users = session.createQuery("From User", User.class).list();
        } catch (NoClassDefFoundError e){
            System.out.println("Exception: " + e);
        }
        return users;
    }

    @Override
    public User findById(int id) {
        User user = null;
        try(Session session = SessionFactoryImpl.getSessionFactory().openSession()){
            session.beginTransaction();
            user = session.get(User.class, id);
            session.getTransaction().commit();
        } catch (NoClassDefFoundError e){
            System.out.println("Exception: " + e);
        }
        return user;
    }
}
