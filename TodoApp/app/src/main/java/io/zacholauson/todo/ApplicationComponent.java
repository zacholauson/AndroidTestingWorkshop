package io.zacholauson.todo;

import javax.inject.Singleton;

import dagger.Component;
import io.zacholauson.todo.activities.MainActivity;
import io.zacholauson.todo.modules.TodoModule;

@Singleton
@Component(modules = { TodoModule.class })
public interface ApplicationComponent {

  void inject(MainActivity mainActivity);

}
