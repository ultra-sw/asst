package ru.ultrasoftware.asst.rest.domain;

public class PingPong {
    private String text;

    public PingPong() {

    }

    public PingPong(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

}
