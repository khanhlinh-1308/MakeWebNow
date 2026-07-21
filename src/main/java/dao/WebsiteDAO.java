package dao;

import java.util.List;

import entity.User;

import entity.Website;

import jakarta.persistence.TypedQuery;

public class WebsiteDAO extends BaseDAO {

    // Lấy tất cả Website

    public List<Website> findAll() {

        String jpql = "SELECT w FROM Website w";

        TypedQuery<Website> query = em.createQuery(jpql, Website.class);

        return query.getResultList();

    }

    // Tìm theo ID

    public Website findById(Integer id) {

        return em.find(Website.class, id);

    }

    // Lấy Website theo User

    public List<Website> findByUser(User user) {

        String jpql = "SELECT w FROM Website w WHERE w.user = :user";

        TypedQuery<Website> query = em.createQuery(jpql, Website.class);

        query.setParameter("user", user);

        return query.getResultList();

    }

    // Thêm Website

    public void create(Website website) {

        em.getTransaction().begin();

        em.persist(website);

        em.getTransaction().commit();

    }

    // Cập nhật Website

    public void update(Website website) {

        em.getTransaction().begin();

        em.merge(website);

        em.getTransaction().commit();

    }

    // Xóa Website

    public void delete(Integer id) {

        Website website = findById(id);

        if (website != null) {

            em.getTransaction().begin();

            em.remove(website);

            em.getTransaction().commit();

        }

    }

}
