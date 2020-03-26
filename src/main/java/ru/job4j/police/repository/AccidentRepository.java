package ru.job4j.police.repository;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.springframework.stereotype.Component;
import ru.job4j.police.model.Accident;

import java.util.ArrayList;
import java.util.List;

@Component
public class AccidentRepository implements Repository<Accident> {

    private static final Logger LOG = LogManager.getLogger(AccidentRepository.class.getName());

    private final SessionFactory factory = new Configuration()
            .configure("police.cfg.xml")
            .buildSessionFactory();

    @Override
    public List<Accident> findAll() {
        List<Accident> result = new ArrayList<>();
        Session session = factory.openSession();
        Transaction transaction = session.beginTransaction();
        try {
            result = session.createQuery("FROM ru.job4j.police.model.Accident").list();
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
