package kz.gunseful.controllers;

import kz.gunseful.entity.Message;
import kz.gunseful.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/message")
public class MessageController {

    @Autowired
    MessageService messageService;

    @GetMapping
    public List<Map<String, String>> messagesList() {
        return messageService.allMessages();
    }

    @GetMapping("{id}")
    public Map<String, String> getMessage(@PathVariable String id) {
        return messageService.getMessageById(Integer.parseInt(id));
    }

    @PostMapping
    public Map<String, String> create(@RequestBody Map<String, String> message) {
        messageService.add(new Message(message.get("text")));
        return message;
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable String id){
        messageService.delete(Integer.parseInt(id));
    }

    @PutMapping("{id}")
    public Map<String, String> update(@PathVariable String id, @RequestBody Map<String, String> message){
        messageService.edit(Integer.parseInt(id), message);
        return message;
    }
}
