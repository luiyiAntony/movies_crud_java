package org.luiyi.clon_netflix.Repository;

import org.luiyi.clon_netflix.Entity.Category;
import org.luiyi.clon_netflix.Util.UtilEntity;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import java.util.List;

public class CategoryRepository {

    public List<Category> getCategories() {
        EntityManager em = UtilEntity.getEntityManager();
        List<Category> categories = em.createQuery("FROM Category").getResultList();
        return categories;
    }

    public Category getCategory(Integer id) {
        EntityManager em = UtilEntity.getEntityManager();
        return em.find(Category.class, id);
    }

    public Category insertCategory(Category category) {
        EntityManager em = UtilEntity.getEntityManager();
        EntityTransaction et = em.getTransaction();

        et.begin();
        em.persist(category);
        et.commit();
        return category;
    }

    public void updateCategory(Category category) {
        EntityManager em = UtilEntity.getEntityManager();
        EntityTransaction et = em.getTransaction();

        et.begin();
        em.merge(category);
        et.commit();

        System.out.println("Category updated successfully");
    }

    private static void deleteCategory(Category category) {
        EntityManager em = UtilEntity.getEntityManager();
        EntityTransaction et = em.getTransaction();

        Category attached_category = em.find(Category.class, category.getId());
        int id_category = attached_category.getId();

        et.begin();
        em.remove(attached_category);
        et.commit();

        System.out.println("Category deleted successfully");
    }
}
