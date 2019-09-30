package kz.gunseful.controllers;

import kz.gunseful.dao.MessageDao;
import kz.gunseful.dao.MessageDaoImpl;
import kz.gunseful.entity.Message;
import kz.gunseful.exeptions.NotFoundExceptions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/message")
public class MessageController {

    @Autowired
    MessageDao messageDao;

    @GetMapping
    public List<Map<String, String>> messagesList() {
        List<Message> messageList = messageDao.allMessages();
        List<Map<String, String>> messages = new ArrayList<>();
        for (Message message : messageList
        ) {
            messages.add(new HashMap<String, String>() {{
                put("id", String.valueOf(message.getId()));
                put("text", message.getText());
            }});
        }
        return messages;
    }

    @GetMapping("{id}")
    public Map<String, String> getMessage(@PathVariable String id) {
        Message message = messageDao.getMessageById(Integer.parseInt(id)).orElseThrow(NotFoundExceptions::new);
        return new HashMap<String, String>() {{
            put("id", String.valueOf(message.getId()));
            put("text", message.getText());
        }};
    }

    @PostMapping
    public String create(@RequestBody Map<String, String> message) {
        System.out.println("hehe");
        System.out.println(message.get("text"));
        //todo FAIL
//        messageDao.add(new Message(message.get("text")));
        return "";
    }

}
