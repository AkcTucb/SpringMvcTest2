package ru.Akctucb.springmvc.SpringMvcTest2.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;
import ru.Akctucb.springmvc.SpringMvcTest2.model.User;

import java.util.List;

@Repository
@Transactional
public class UserDaoImpl implements UserDao {

    @PersistenceContext
    private EntityManager em;

    @Transactional
    @Override
    public List<User> getAllUsers() {
        return em.createQuery("SELECT u FROM User u", User.class)
                .getResultList();
    }

    @Transactional
    @Override
    public User getUserById(Long id) {
        return em.find(User.class, id);
    }

    @Transactional
    @Override
    public void saveUser(User user) {
        em.persist(user);
    }

    @Transactional
    @Override
    public void updateUser(User user) {
        em.merge(user);
    }

    @Transactional
    @Override
    public void deleteUser(Long id) {
        User user = getUserById(id);
        if(user != null){
            em.remove(user);
        }
    }
}
