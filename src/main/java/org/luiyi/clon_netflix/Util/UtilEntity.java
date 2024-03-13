package org.luiyi.clon_netflix.Util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class UtilEntity {
    private static final EntityManagerFactory entityManagerFactory = buildEntityManagerFactory();
    public static EntityManagerFactory buildEntityManagerFactory()  {
        return Persistence.createEntityManagerFactory("persistenceUnit");
    }
    public static EntityManager getEntityManager() {
        return entityManagerFactory.createEntityManager();
    }
}
