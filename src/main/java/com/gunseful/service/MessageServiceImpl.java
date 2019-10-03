package com.gunseful.service;

import com.gunseful.dao.MessageDao;
import com.gunseful.entity.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Map;

@Service
public class MessageServiceImpl implements MessageService {

    @Autowired
    private MessageDao messageDao;

    @Transactional
    @Override
    public List<Message> allMessages() {
        return messageDao.allMessages();
    }

    @Transactional
    @Override
    public Message getMessageById(int id){
        return messageDao.getMessageById(id);
    }

    @Transactional
    @Override
    public void add(Message message) {
        messageDao.add(message);
    }

    @Transactional
    @Override
    public void delete(int id) {
        Message message = messageDao.getMessageById(id);
        messageDao.delete(message);
    }

    @Transactional
    @Override
    public void edit(int id, Map<String, String> message) {
        Message messageFromDb = messageDao.getMessageById(id);
        messageFromDb.setText(message.get("text"));
        messageDao.edit(messageFromDb);
    }
}
