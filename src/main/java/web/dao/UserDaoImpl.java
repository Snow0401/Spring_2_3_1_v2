package web.dao;

import org.springframework.stereotype.Repository;
import web.models.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Repository
public class UserDaoImpl implements UserDao {

    @PersistenceContext
    private EntityManager entityManager;

    public List<User> getAllUsers() {
        return entityManager.createQuery("FROM User").getResultList();
    }

    public User getUserById(int id) {
        return entityManager.find(User.class, id);
    }

    public void createNewUser(User user) {
        entityManager.persist(user);
    }

    public void editUserById(int id, User user) {
        entityManager.merge(user);
    }

    public void deleteUserById(int id) {
        Query query = entityManager.createQuery("delete User where id = :ID");
        query.setParameter("ID", id);
        query.executeUpdate();
    }
}
