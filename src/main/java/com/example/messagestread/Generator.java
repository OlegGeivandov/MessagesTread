package com.example.messagestread;

import javafx.collections.ObservableList;

import java.util.Date;
import java.util.Random;

public class Generator extends Thread {

    int k;
    String name;
    ObservableList<MyMessage> messages;

    public Generator(int k, String name, ObservableList<MyMessage> messages) {
        this.k = k;
        this.name = name;
        this.messages = messages;
    }

    public void work() throws InterruptedException {
        while(k>0)
        {
            messages.add(new MyMessage(this.name, "MyMessage"+k, new Date().toString()));
            k--;
            sleep(new Random().nextInt(400)+100);
        }
    }

    @Override
    public void run() {
        try {
            work();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
