package com.example.messagestread;

import javafx.beans.property.SimpleStringProperty;

public class MyMessage {
    SimpleStringProperty nameOfSender =new SimpleStringProperty();
    SimpleStringProperty message =new SimpleStringProperty();
    SimpleStringProperty dateTime =new SimpleStringProperty();

    public MyMessage(String nameOfSender, String message, String dateTime) {
        this.nameOfSender.set(nameOfSender);
        this.message.set(message);
        this.dateTime.set(dateTime);
    }

    public String getNameOfSender() {
        return nameOfSender.get();
    }

    public SimpleStringProperty nameOfSenderProperty() {
        return nameOfSender;
    }

    public void setNameOfSender(String nameOfSender) {
        this.nameOfSender.set(nameOfSender);
    }

    public String getMessage() {
        return message.get();
    }

    public SimpleStringProperty messageProperty() {
        return message;
    }

    public void setMessage(String message) {
        this.message.set(message);
    }

    public String getDateTime() {
        return dateTime.get();
    }

    public SimpleStringProperty dateTimeProperty() {
        return dateTime;
    }

    public void setDateTime(String dateTime) {
        this.dateTime.set(dateTime);
    }
}
