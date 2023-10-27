package com.example.manage;

import java.util.Date;

public interface Task {
    void createTask(String taskName, String taskDescription);
    void setTaskName(String taskName);
    void setTaskDescription(String taskDescription);
    void markAsComplete();
    void setPriority(Priority priority);
    void setDeadline(Date date);
}
