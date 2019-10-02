package com.gunseful.service;

import com.gunseful.entity.Message;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public interface MessageService {
    List<Message> allMessages();
    Message getMessageById(int id);
    void add(Message message);
    void delete(int id);
    void edit(int id, Map<String, String> message);
}
