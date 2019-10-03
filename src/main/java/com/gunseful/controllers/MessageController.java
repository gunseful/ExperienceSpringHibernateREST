package com.gunseful.controllers;

import com.gunseful.converter.MessageConverter;
import com.gunseful.dto.MessageDto;
import com.gunseful.entity.Message;
import com.gunseful.service.MessageService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/message")
public class MessageController {

    private final MessageService messageService;

    private final MessageConverter messageConverter;

    public MessageController(MessageService messageService, MessageConverter messageConverter) {
        this.messageService = messageService;
        this.messageConverter = messageConverter;
    }

    @GetMapping
    public List<MessageDto> messagesList() {
        return messageService.allMessages()
                .stream()
                .map(messageConverter::toDto)
                .collect(Collectors.toList());
    }

    @GetMapping("{id}")
    public MessageDto getMessage(@PathVariable String id) {
        return messageConverter.toDto(messageService.getMessageById(Integer.parseInt(id)));
    }

    @PostMapping
    public MessageDto create(@RequestBody Map<String, String> message) {
        Message msg = new Message(message.get("text"));
        messageService.add(msg);
        return messageConverter.toDto(msg);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable String id) {
        messageService.delete(Integer.parseInt(id));
    }

    @PutMapping("{id}")
    public MessageDto update(@PathVariable String id, @RequestBody Map<String, String> message) {
        messageService.edit(Integer.parseInt(id), message);
        return messageConverter.toDto(messageService.getMessageById(Integer.parseInt(id)));
    }
}
