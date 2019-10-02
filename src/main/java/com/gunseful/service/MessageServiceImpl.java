package com.gunseful.service;

import com.gunseful.dao.MessageDao;
import com.gunseful.entity.Message;
import com.gunseful.exeptions.NotFoundExceptions;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Map;

@Service
public class MessageServiceImpl implements MessageService {

    private final MessageDao messageDao;

    public MessageServiceImpl(MessageDao messageDao) {
        this.messageDao = messageDao;
    }

    @Transactional
    @Override
    public List<Message> allMessages() {
        return messageDao.allMessages();
    }

    @Transactional
    @Override
    public Message getMessageById(int id){
        return messageDao.getMessageById(id).orElseThrow(NotFoundExceptions::new);
    }

    @Transactional
    @Override
    public void add(Message message) {
        messageDao.add(message);
    }

    @Transactional
    @Override
    public void delete(int id) {
        Message message = messageDao.getMessageById(id).orElseThrow(NotFoundExceptions::new);
        messageDao.delete(message);
    }

    @Transactional
    @Override
    public void edit(int id, Map<String, String> message) {
        Message messageFromDb = messageDao.getMessageById(id).orElseThrow(NotFoundExceptions::new);
        messageFromDb.setText(message.get("text"));
        messageDao.edit(messageFromDb);
    }
}
