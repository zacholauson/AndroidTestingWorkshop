package io.zacholauson.todo.modules;

import io.zacholauson.todocore.TodoRepository;

public class MockTodoModule extends TodoModule {

  private final TodoRepository todoRepository;

  public MockTodoModule(TodoRepository todoRepository) {
    this.todoRepository = todoRepository;
  }

  @Override
  public TodoRepository provideRepository() {
    return todoRepository;
  }
}
