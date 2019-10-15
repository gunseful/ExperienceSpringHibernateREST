package com.gunseful.converter;

import com.gunseful.dto.MessageDto;
import com.gunseful.entity.Message;
import org.springframework.stereotype.Component;

@Component
public class MessageConverter {
    public MessageDto toDto(Message message){
        return new MessageDto.MessageDtoBuilder()
                .setId(message.getId())
                .setText(message.getText())
                .build();

    }

    public Message toEntity(MessageDto messageDto){
        return new Message.MessageBuilder()
                .setId(messageDto.getId())
                .setText(messageDto.getText())
                .build();
    }
}
