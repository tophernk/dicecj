package cj;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.persistence.metamodel.EntityType;

public class PlayerDao extends AbstractDao {

    public Player findPlayerByName(String name) {
        EntityManager entityManager = CrudSupport.getEntityManager();
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Player> query = criteriaBuilder.createQuery(Player.class);
        Root<Player> root = query.from(Player.class);
        EntityType<Player> playerModel = root.getModel();
        query.where(criteriaBuilder.equal(root.get(playerModel.getAttribute("name").getName()), name));
        query.select(root);
        TypedQuery<Player> typedQuery = entityManager.createQuery(query);
        return typedQuery.getSingleResult();
    }
}