package com.example.manage;

import java.util.Date;

public class HomeworkTask implements Task{
    private String taskName;
    private String description;
    private boolean completed;
    private Priority priority;
    private Date  deadline;
    @Override
    public void createTask(String taskName, String taskDescription) {
        this.taskName = taskName;
        this.description = taskDescription;
    }
    @Override
    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }
    @Override
    public void setTaskDescription(String taskDescription) {
        this.description = taskDescription;
    }
    public void markAsComplete() {
        this.completed = true;
    }
    @Override
    public void setPriority(Priority priority) {
        this.priority = priority;
    }
    @Override
    public void setDeadline(Date date) {
        this.deadline = date;
    }

    public String getTaskName() {
        return taskName;
    }

    public String getDescription() {
        return description;
    }

    public String toString(){
        return "Homework: "+ this.taskName + " "+this.description + " completed: " + this.completed + " deadline: " + this.deadline+ " priority:  " + this.priority;
    }
}
