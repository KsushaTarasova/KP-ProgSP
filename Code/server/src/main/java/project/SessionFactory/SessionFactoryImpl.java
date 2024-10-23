package project.SessionFactory;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class SessionFactoryImpl {
    private static SessionFactory sessionFactory;

    private SessionFactoryImpl() {
    }

    public static SessionFactory getSessionFactory() {
        if (sessionFactory == null) {
            try {
                Configuration configuration = new Configuration().configure();
                sessionFactory = configuration.buildSessionFactory();
            } catch (Exception e) {
                System.out.println("Исключение! " + e);
            }
        }
        return sessionFactory;
    }
}
