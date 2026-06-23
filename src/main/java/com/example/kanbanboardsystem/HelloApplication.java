package com.example.kanbanboardsystem;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;

public class HelloApplication extends Application {

    @Override
    public void start(Stage stage) throws IOException {
        // 1. יצירת האובייקט וטעינת קובץ ה-FXML מהשורש של resources
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("/hello-view.fxml"));

        // 2. יצירת הסצנה הגרפית תוך שימוש ב-fxmlLoader שהגדרנו שורה מעל
        Scene scene = new Scene(fxmlLoader.load(), 320, 240);

        // 3. הגדרת כותרת והצגת החלון
        stage.setTitle("Kanban Board System");
        stage.setScene(scene);
        stage.show();
    }

    // === הבלוק החסר שהוספנו עכשיו! ===
    public static void main(String[] args) {
        try {
            System.out.println("MANUAL DB INITIALIZATION START");
            // קריאה לאתחול בסיס הנתונים
            com.example.kanbanboardsystem.repository.DatabaseManager.initializeDatabase();
            System.out.println("MANUAL DB INITIALIZATION END");
        } catch (Exception e) {
            System.out.println("Error during DB init: " + e.getMessage());
        }

        // הפעלת חלון ה-JavaFX
        launch(args);
    }
}