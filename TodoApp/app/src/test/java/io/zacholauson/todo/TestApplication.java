package io.zacholauson.todo;

import io.zacholauson.todo.modules.TodoModule;

public class TestApplication extends Application {

  private TodoModule todoModule;

  public void setTodoModule(TodoModule todoModule) {
    this.todoModule = todoModule;

    initializeComponent();
  }

  @Override
  protected TodoModule getTodoModule() {
    if (todoModule == null) {
      return super.getTodoModule();
    }

    return todoModule;
  }
}
