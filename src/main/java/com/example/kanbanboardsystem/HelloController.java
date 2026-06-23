package com.example.kanbanboardsystem;

import com.example.kanbanboardsystem.model.Task;
import com.example.kanbanboardsystem.model.TaskStatus;
import com.example.kanbanboardsystem.repository.TaskRepository;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import java.util.List;

public class HelloController {

    // 1. חיבור לרכיבי הרשימות הגרפיות ב-FXML
    @FXML
    private ListView<Task> todoListView;

    @FXML
    private ListView<Task> inProgressListView;

    @FXML
    private ListView<Task> doneListView;

    // 2. חיבור לשדות הטקסט החדשים שהוספנו ב-FXML (זה מה שהיה חסר!)
    @FXML
    private TextField titleInput;

    @FXML
    private TextField descriptionInput;

    // מופע של ה-Repository לעבודה מול ה-Database
    private final TaskRepository taskRepository = new TaskRepository();

    // פונקציית האתחול של המסך
    @FXML
    public void initialize() {
        System.out.println("Controller initialized. Loading tasks...");
        refreshBoard();
    }

    // 3. הפונקציה שהכפתור ב-FXML מפעיל כשלוחצים עליו (onAction)
    @FXML
    public void onAddTaskClicked() {
        String title = titleInput.getText().trim();
        String description = descriptionInput.getText().trim();

        // בדיקה שלא מנסים להכניס משימה ריקה
        if (!title.isEmpty()) {
            // יצירת אובייקט משימה בסטטוס ברירת מחדל TO DO
            Task newTask = new Task();
            newTask.setTitle(title);
            newTask.setDescription(description);
            newTask.setStatus(TaskStatus.TODO);

            // שמירה בבסיס הנתונים
            taskRepository.addTask(newTask);

            // ניקוי השדות במסך לאחר ההוספה
            titleInput.clear();
            descriptionInput.clear();

            // רענון הלוח כדי לראות את המשימה החדשה מיד
            refreshBoard();
        }
    }

    // פונקציה לרענון והצגת המשימות מהדאטאבייס על המסך
    public void refreshBoard() {
        todoListView.getItems().clear();
        inProgressListView.getItems().clear();
        doneListView.getItems().clear();

        List<Task> allTasks = taskRepository.getAllTasks();

        for (Task task : allTasks) {
            if (task.getStatus() == TaskStatus.TODO) {
                todoListView.getItems().add(task);
            } else if (task.getStatus() == TaskStatus.IN_PROGRESS) {
                inProgressListView.getItems().add(task);
            } else if (task.getStatus() == TaskStatus.DONE) {
                doneListView.getItems().add(task);
            }
        }
    }
}