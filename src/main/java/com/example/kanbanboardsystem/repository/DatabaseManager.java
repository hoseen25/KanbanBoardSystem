package com.example.kanbanboardsystem.repository; // ודא שזה ה-package הנכון אצלך


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseManager {

    // שם קובץ הדאטאבייס שייווצר באופן אוטומטי בשורש הפרויקט
    private static final String URL = "jdbc:sqlite:kanban.db";

    // פונקציה שמחזירה חיבור פעיל ל-Database
    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL);
    }

    // פונקציה שמקימה את הטבלאות בפעם הראשונה שהאפליקציה עולה
    public static void initializeDatabase() {
        String createTasksTable = "CREATE TABLE IF NOT EXISTS tasks (" +
                "id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "title TEXT NOT NULL, " +
                "description TEXT, " +
                "status TEXT NOT NULL" +
                ");";

        try (Connection conn = getConnection();
             Statement stmt = conn.createStatement()) {

            // הרצת השאילתה ליצירת הטבלה
            stmt.execute(createTasksTable);
            System.out.println("Database tables initialized successfully.");
            System.out.println("Database absolute path: " + new java.io.File("kanban.db").getAbsolutePath());

        } catch (SQLException e) {
            System.err.println("Failed to initialize database: " + e.getMessage());
        }
    }
}