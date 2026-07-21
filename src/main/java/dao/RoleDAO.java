package dao;

import java.util.List;

import entity.Role;

import jakarta.persistence.NoResultException;

import jakarta.persistence.TypedQuery;

public class RoleDAO extends BaseDAO {

    // Lấy tất cả Role

    public List<Role> findAll() {

        String jpql = "SELECT r FROM Role r";

        TypedQuery<Role> query = em.createQuery(jpql, Role.class);

        return query.getResultList();

    }

    // Tìm theo ID

    public Role findById(Integer id) {

        return em.find(Role.class, id);

    }

    // Tìm theo tên Role

    public Role findByName(String roleName) {

        try {

            String jpql = "SELECT r FROM Role r WHERE r.roleName = :roleName";

            TypedQuery<Role> query = em.createQuery(jpql, Role.class);

            query.setParameter("roleName", roleName);

            return query.getSingleResult();

        } catch (NoResultException e) {

            return null;

        }

    }

}
