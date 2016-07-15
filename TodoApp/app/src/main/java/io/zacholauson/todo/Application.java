package io.zacholauson.todo;

import io.zacholauson.todo.modules.TodoModule;

public class Application extends android.app.Application {

  private ApplicationComponent applicationComponent;

  @Override
  public void onCreate() {
    super.onCreate();

    initializeComponent();
  }

  public ApplicationComponent getApplicationComponent() {
    return applicationComponent;
  }

  protected void initializeComponent() {
    applicationComponent = DaggerApplicationComponent.builder()
        .todoModule(getTodoModule())
        .build();
  }

  protected TodoModule getTodoModule() {
    return new TodoModule();
  }
}
