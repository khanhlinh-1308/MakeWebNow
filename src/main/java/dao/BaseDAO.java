package dao;

import jakarta.persistence.EntityManager;

import utils.JpaUtil;

public abstract class BaseDAO {

    protected EntityManager em;

    public BaseDAO() {

        em = JpaUtil.getEntityManager();

    }

}