package dao;

import java.util.List;

import entity.User;

import jakarta.persistence.NoResultException;

import jakarta.persistence.TypedQuery;

public class UserDAO extends BaseDAO {

    // Lấy tất cả user

    public List<User> findAll() {

        String jpql = "SELECT u FROM User u";

        TypedQuery<User> query = em.createQuery(jpql, User.class);

        return query.getResultList();

    }

    // Tìm theo ID

    public User findById(Integer id) {

        return em.find(User.class, id);

    }

    // Tìm theo Email

    public User findByEmail(String email) {

        try {

            String jpql = "SELECT u FROM User u WHERE u.email = :email";

            TypedQuery<User> query = em.createQuery(jpql, User.class);

            query.setParameter("email", email);

            return query.getSingleResult();

        } catch (NoResultException e) {

            return null;

        }

    }

    // Thêm User

    public void create(User user) {

        em.getTransaction().begin();

        em.persist(user);

        em.getTransaction().commit();

    }

    // Cập nhật User

    public void update(User user) {

        em.getTransaction().begin();

        em.merge(user);

        em.getTransaction().commit();

    }

    // Xóa User

    public void delete(Integer id) {

        User user = findById(id);

        if (user != null) {

            em.getTransaction().begin();

            em.remove(user);

            em.getTransaction().commit();

        }

    }

}