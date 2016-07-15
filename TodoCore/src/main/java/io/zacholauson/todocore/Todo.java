package io.zacholauson.todocore;

public class Todo {

    private final String task;
    private final boolean completed;

    public Todo(final String task, final boolean completed) {
        this.task = task;
        this.completed = completed;
    }

    public String getTask() {
        return task;
    }

    public boolean isCompleted() {
        return completed;
    }
}
