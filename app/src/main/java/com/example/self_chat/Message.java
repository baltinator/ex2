package com.example.self_chat;

public class Message {

    private final String text;

    Message(String message) {

        this.text = message;
    }

    String getText()
    {
        return this.text;
    }

    @Override
    public boolean equals(Object o) {
        return this == o;
    }
}
