package kz.gunseful.dao;

import kz.gunseful.entity.Message;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Repository
public class MessageDaoImpl implements MessageDao {

    private SessionFactory sessionFactory;

    @Autowired
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public List<Message> allMessages() {
        Session session = sessionFactory.getCurrentSession();
        return session.createQuery("from Message").list();
    }

    @Override
    public Optional<Message> getMessageById(int id) {
        Session session = sessionFactory.getCurrentSession();
        return session.byId(Message.class).loadOptional(id);
    }

    @Override
    public void add(Message message) {
        Session session = sessionFactory.getCurrentSession();
        session.save(message);
    }

    @Override
    public void delete(Message message) {
        Session session = sessionFactory.getCurrentSession();
        session.delete(message);
    }

    @Override
    public void edit(Message message) {
        Session session = sessionFactory.getCurrentSession();
        session.update(message);
    }
}
