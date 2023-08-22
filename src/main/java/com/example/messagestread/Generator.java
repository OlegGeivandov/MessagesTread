package com.example.messagestread;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.ObservableList;
import java.util.Date;
import java.util.Random;

public class Generator extends Thread {

//    int k;
    SimpleIntegerProperty k = new SimpleIntegerProperty();
    String name;
    ObservableList<MyMessage> messages;

    public Generator(int k, String name, ObservableList<MyMessage> messages) {
        this.k.set(k);
        this.name = name;
        this.messages = messages;
    }

    public void work() throws InterruptedException {
        while(k.get()>0)
        {
            messages.add(new MyMessage(this.name, "MyMessage"+k.get()+" from " + this.name, new Date().toString()));
            k.set(k.get()-1);
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
