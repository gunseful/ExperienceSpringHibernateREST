package com.gunseful.dao;

import com.gunseful.entity.Message;
import com.gunseful.exeptions.NotFoundExceptions;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

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
        return session.createNamedQuery("Message.findAll", Message.class).getResultList();
    }

    @Override
    public Message getMessageById(int id) {
        Session session = sessionFactory.getCurrentSession();
        return session.byId(Message.class).loadOptional(id).orElseThrow(NotFoundExceptions::new);
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
