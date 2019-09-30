package kz.gunseful.dao;

import kz.gunseful.entity.Message;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface MessageDao {
    List<Message> allMessages();
    Optional<Message> getMessageById(int id);
    void add(Message message);
}

