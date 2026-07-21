package dao;

import entity.Subscription;

public class SubscriptionDAO extends BaseDAO {

    public Subscription findById(Integer id) {

        return em.find(Subscription.class, id);

    }

}