package ru.alexeiadamov.hibernate;

import org.hibernate.cfg.Configuration;

import javax.persistence.EntityManagerFactory;

public class SessionFactoryFactory {
    public static EntityManagerFactory create() {
        return new Configuration()
                .configure("hibernate.cfg.xml")
                .buildSessionFactory();
    }
}
