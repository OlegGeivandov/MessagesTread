module com.example.messagestread {
    requires javafx.controls;
    requires javafx.fxml;
            
                            
    opens com.example.messagestread to javafx.fxml;
    exports com.example.messagestread;
}