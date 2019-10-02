package com.gunseful.entity;


import javax.persistence.*;

@Entity
@Table(name = "messages")
@NamedQueries({
    @NamedQuery(name = "Message.findAll", query = "FROM Message")
})
public class Message {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    int id;
    @Column(name = "TEXT")
    private String text;

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

    public Message() {    }

    private Message(MessageBuilder messageBuilder) {
        this.id = messageBuilder.id;
        this.text = messageBuilder.text;
    }

    public Message(String text) {
        this.text = text;
    }

    @Override
    public String toString() {
        return "Message{" +
                "id=" + id +
                ", text='" + text + '\'' +
                '}';
    }

    //todo Transient not applicable to type (probably idea means that inner class can't be annotated this)
    public static class MessageBuilder {

        @Transient
        private int id;
        @Transient
        private String text;

        public MessageBuilder() {
        }

        public MessageBuilder setId(int id) {
            this.id = id;
            return this;
        }
        public MessageBuilder setText(String text) {
            this.text = text;
            return this;
        }

        @Transient
        public Message build() {
            return new Message(this);
        }
    }
}
