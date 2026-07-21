package dao;

import java.util.List;

import entity.Block;

import entity.Website;

import jakarta.persistence.TypedQuery;

public class BlockDAO extends BaseDAO {

    // Lấy tất cả Block

    public List<Block> findAll() {

        String jpql = "SELECT b FROM Block b";

        TypedQuery<Block> query = em.createQuery(jpql, Block.class);

        return query.getResultList();

    }

    // Tìm theo ID

    public Block findById(Integer id) {

        return em.find(Block.class, id);

    }

    // Lấy Block theo Website

    public List<Block> findByWebsite(Website website) {

        String jpql = "SELECT b FROM Block b WHERE b.website = :website ORDER BY b.position";

        TypedQuery<Block> query = em.createQuery(jpql, Block.class);

        query.setParameter("website", website);

        return query.getResultList();

    }

    // Thêm Block

    public void create(Block block) {

        em.getTransaction().begin();

        em.persist(block);

        em.getTransaction().commit();

    }

    // Cập nhật Block

    public void update(Block block) {

        em.getTransaction().begin();

        em.merge(block);

        em.getTransaction().commit();

    }

    // Xóa Block

    public void delete(Integer id) {

        Block block = findById(id);

        if (block != null) {

            em.getTransaction().begin();

            em.remove(block);

            em.getTransaction().commit();

        }

    }

}
