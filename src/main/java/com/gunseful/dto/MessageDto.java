package com.gunseful.dto;

public class MessageDto {

    int id;
    String text;

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public MessageDto() {
    }

    private MessageDto(MessageDtoBuilder messageDtoBuilder) {
        this.id = messageDtoBuilder.id;
        this.text = messageDtoBuilder.text;
    }

    public MessageDto(String text) {
        this.text = text;
    }


    public static class MessageDtoBuilder {
        private int id;
        private String text;
        public MessageDtoBuilder() {
        }
        public MessageDtoBuilder setId(int id) {
            this.id = id;
            return this;
        }
        public MessageDtoBuilder setText(String text) {
            this.text = text;
            return this;
        }
        public MessageDto build() {
            return new MessageDto(this);
        }
    }
}
