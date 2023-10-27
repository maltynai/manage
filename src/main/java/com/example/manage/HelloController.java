package com.example.manage;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

public class HelloController {
    @FXML
    private ListView<Task> listView;
    ObservableList<Task> tasks = FXCollections.observableArrayList();
    public void initialize() {
        listView.setItems(tasks);
    }
    @FXML
    private TextField inputName;
    @FXML
    private TextField inputDesc;
    @FXML
    private Label label;
    @FXML
    private DatePicker deadlineDatePicker;
    @FXML
    private ToggleGroup priorityToggleGroup;
    @FXML
    private RadioButton lowRadioButton;

    @FXML
    private RadioButton mediumRadioButton;

    @FXML
    private RadioButton highRadioButton;
    @FXML
    private Button markAsCompleteButton;
    @FXML
    protected void onListViewSelected() {
        int i = listView.getSelectionModel().getSelectedIndex();
        label.setText("" + i);
        HomeworkTask ht = (HomeworkTask) tasks.get(i);
        inputName.setText(ht.getTaskName());
        inputDesc.setText(ht.getDescription());
    }
    @FXML
    protected Button onCompletedButtonClick() {
        HomeworkTask ht = new HomeworkTask();

        ht.markAsComplete();

        return null;
    }
    @FXML
    protected void onSaveButtonClick() {
        HomeworkTask ht = new HomeworkTask();
        ht.createTask(inputName.getText(), inputDesc.getText());
        tasks.add(ht);
        LocalDate localDate = deadlineDatePicker.getValue();
        Instant instant = localDate.atStartOfDay().atZone(ZoneId.systemDefault()).toInstant();
        Date selectedDate = Date.from(instant);
        ht.setDeadline(selectedDate);
        ht.markAsComplete();
        RadioButton selectedRadioButton = (RadioButton) priorityToggleGroup.getSelectedToggle();
        if (selectedRadioButton != null) {
            String selectedPriority = selectedRadioButton.getText();
            Priority priority = Priority.valueOf(selectedPriority.toUpperCase());
            ht.setPriority(priority);
            if (priority == Priority.LOW) {
                ht.setPriority(Priority.LOW);
            } else if (priority == Priority.MEDIUM) {
                ht.setPriority(Priority.MEDIUM);
            } else if (priority == Priority.HIGH) {
                ht.setPriority(Priority.HIGH);
            }
        } else {
            ht.setPriority(null);
        }
    }
    @FXML
    protected void onChangeButtonClick() {
        int selectedIndex = listView.getSelectionModel().getSelectedIndex();
        if (selectedIndex >= 0) {
            label.setText("" + selectedIndex);
            HomeworkTask ht = (HomeworkTask) tasks.get(selectedIndex);
            String taskName = inputName.getText();
            String taskDescription = inputDesc.getText();
            ht.setTaskName(taskName);
            ht.setTaskDescription(taskDescription);
            LocalDate localDate = deadlineDatePicker.getValue();
            Instant instant = localDate.atStartOfDay().atZone(ZoneId.systemDefault()).toInstant();
            Date selectedDate = Date.from(instant);
            ht.setDeadline(selectedDate);
            ht.markAsComplete();
            RadioButton selectedRadioButton = (RadioButton) priorityToggleGroup.getSelectedToggle();
            if (selectedRadioButton != null) {
                String selectedPriority = selectedRadioButton.getText();
                Priority priority = Priority.valueOf(selectedPriority.toUpperCase());
                ht.setPriority(priority);
                if (priority == Priority.LOW) {
                    ht.setPriority(Priority.LOW);
                } else if (priority == Priority.MEDIUM) {
                    ht.setPriority(Priority.MEDIUM);
                } else if (priority == Priority.HIGH) {
                    ht.setPriority(Priority.HIGH);
                }
            } else {
                ht.setPriority(null);
            }
        } else {
            System.out.println("No item selected");
        }
    }
}