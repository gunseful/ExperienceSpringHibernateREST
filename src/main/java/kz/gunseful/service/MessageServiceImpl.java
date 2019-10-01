package kz.gunseful.service;

import kz.gunseful.dao.MessageDao;
import kz.gunseful.entity.Message;
import kz.gunseful.exeptions.NotFoundExceptions;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.*;

@Service
public class MessageServiceImpl implements MessageService {

    @Autowired
    MessageDao messageDao;

    @Transactional
    @Override
    public List<Map<String, String>> allMessages() {
        List<Map<String, String>> messages = new ArrayList<>();
        for (Message message : messageDao.allMessages()
        ) {
            messages.add(new HashMap<String, String>() {{
                put("id", String.valueOf(message.getId()));
                put("text", message.getText());
            }});
        }
        return messages;
    }

    @Transactional
    @Override
    public Map<String, String> getMessageById(int id){
        Message message = messageDao.getMessageById(id).orElseThrow(NotFoundExceptions::new);
        return new HashMap<String, String>() {{
            put("id", String.valueOf(message.getId()));
            put("text", message.getText());
        }};
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
