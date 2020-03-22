package firstapp.store;

import firstapp.models.User;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component(value = "jdbc")
public class JDBCStorage implements Storage {

    private static final Logger LOG = LogManager.getLogger(JDBCStorage.class.getName());

    private final SessionFactory factory = new Configuration()
            .configure()
            .buildSessionFactory();

    @Override
    public void add(User user) {
        Session session = factory.openSession();
        Transaction transaction = session.beginTransaction();
        try {
            session.save(user);
            session.getTransaction().commit();
        } catch (Exception e) {
            transaction.rollback();
            LOG.error(e.getMessage(), e);
        } finally {
            session.close();
        }
    }

    @Override
    public List<User> findAll() {
        List<User> result = new ArrayList<>();
        Session session = factory.openSession();
        Transaction transaction = session.beginTransaction();
        try {
            result = session.createQuery("FROM firstapp.models.User").list();
            session.getTransaction().commit();
        } catch (Exception e) {
            transaction.rollback();
            LOG.error(e.getMessage(), e);
        } finally {
            session.close();
        }
        return result;
    }
}
