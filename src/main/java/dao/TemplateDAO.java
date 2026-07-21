package dao;

import java.util.List;

import entity.Template;

import jakarta.persistence.NoResultException;

import jakarta.persistence.TypedQuery;

public class TemplateDAO extends BaseDAO {

    // Lấy tất cả Template

    public List<Template> findAll() {

        String jpql = "SELECT t FROM Template t";

        TypedQuery<Template> query = em.createQuery(jpql, Template.class);

        return query.getResultList();

    }

    // Tìm theo ID

    public Template findById(Integer id) {

        return em.find(Template.class, id);

    }

    // Tìm theo tên Template

    public Template findByName(String templateName) {

        try {

            String jpql = "SELECT t FROM Template t WHERE t.templateName = :templateName";

            TypedQuery<Template> query = em.createQuery(jpql, Template.class);

            query.setParameter("templateName", templateName);

            return query.getSingleResult();

        } catch (NoResultException e) {

            return null;

        }

    }

    // Thêm Template

    public void create(Template template) {

        em.getTransaction().begin();

        em.persist(template);

        em.getTransaction().commit();

    }

    // Cập nhật Template

    public void update(Template template) {

        em.getTransaction().begin();

        em.merge(template);

        em.getTransaction().commit();

    }

    // Xóa Template

    public void delete(Integer id) {

        Template template = findById(id);

        if (template != null) {

            em.getTransaction().begin();

            em.remove(template);

            em.getTransaction().commit();

        }

    }

}
