package com.example.messagestread;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.util.Callback;

/*
сделать 2 потока, которые генерируют объекты MyMessage со свойствами:
Имя потока
сообщение
время
каждый поток генерирует заданное количество MyMessage с интервалом случайным от 100 до 500 мс
сделать GUI, в котором будут 2 кнопки для запуска потоков и таблица с произведенными объектами MyMessage
 */
public class HelloController {

    ObservableList<MyMessage> messages = FXCollections.observableArrayList();
    ObservableList<MyMessage> messages2 = javafx.collections.FXCollections.synchronizedObservableList(messages);

    @FXML
    Button generator1Btn;
    @FXML
    Button generator2Btn;

    @FXML
    TableView<MyMessage> table;

    public void initialize() {
        initTable();
        Generator gen1 = new Generator(200, "gen1", messages2);
        Generator gen2 = new Generator(300, "gen2", messages2);
        generator1Btn.setOnAction(actionEvent -> gen1.start());
        generator2Btn.setOnAction(actionEvent -> gen2.start());
    }

    private void initTable() {
        table.getColumns().clear();

        TableColumn<MyMessage, String> columnNameOfSender = new TableColumn<>("Generator");
        columnNameOfSender.setCellValueFactory(new PropertyValueFactory<>("nameOfSender"));
        columnNameOfSender.setCellFactory(TextFieldTableCell.forTableColumn());

        TableColumn<MyMessage, String> columnMessage = new TableColumn<>("Message");
        columnMessage.setCellValueFactory(new PropertyValueFactory<>("message"));
        columnMessage.setCellFactory(TextFieldTableCell.forTableColumn());
        columnMessage.setMinWidth(200);

        TableColumn<MyMessage, String> columnDateTime = new TableColumn<>("DateTime");
        columnDateTime.setCellValueFactory(new PropertyValueFactory<>("dateTime"));
        columnDateTime.setCellFactory(TextFieldTableCell.forTableColumn());
        columnDateTime.setPrefWidth(200);

        table.getColumns().add(columnNameOfSender);
        table.getColumns().add(columnMessage);
        table.getColumns().add(columnDateTime);
        table.setItems(messages2);
    }


}