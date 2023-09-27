package hiber.dao;

import hiber.model.User;
import lombok.RequiredArgsConstructor;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class UserDaoImp implements UserDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void add(User user) {

        sessionFactory.getCurrentSession().save(user);
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<User> getlistUsers() {
        TypedQuery<User> query = sessionFactory.getCurrentSession().createQuery("from User");
        return query.getResultList();
    }
    @Override
    @SuppressWarnings("unchecked")
    public List<User> findUserByCar(String model, int series) {
        TypedQuery<User> query = sessionFactory.getCurrentSession().createQuery
        ("from User where car.model = :model and car.series = :series");
        query.setParameter("model", model).
        setParameter("series", series);
        return query.getResultList();
    }
}


