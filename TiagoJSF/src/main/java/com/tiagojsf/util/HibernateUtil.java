package com.tiagojsf.util;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

/**
 * Criação da SessionFactory do hibernate
 * @author Tiago
 */
public class HibernateUtil {

    public static final SessionFactory sessionFactory;
    public static final String HIBERNATE_SESSION = "hibernate_session";

    static {
        try {
            System.err.println("Tentando Abrir uma SessionFactory");
            Configuration configuration = new Configuration().configure();
            ServiceRegistry serviceRegistre = new ServiceRegistryBuilder().applySettings(configuration.getProperties()).buildServiceRegistry();

            sessionFactory = configuration.buildSessionFactory(serviceRegistre);
            System.out.println("SessionFactory criada com sucesso");

        } catch (HibernateException ex) {
            System.out.println("Ocorreu um erro ao iniciar a SessionFactory" + ex);
            throw new ExceptionInInitializerError(ex);
            
        }
    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }

}
