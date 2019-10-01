package kz.gunseful.service;

import kz.gunseful.entity.Message;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public interface MessageService {
    List<Map<String, String>> allMessages();
    Map<String, String> getMessageById(int id);
    void add(Message message);
    void delete(int id);
    void edit(int id, Map<String, String> message);
}
