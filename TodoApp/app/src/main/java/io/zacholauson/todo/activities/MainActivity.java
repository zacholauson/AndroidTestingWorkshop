package io.zacholauson.todo.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import java.util.List;
import javax.inject.Inject;

import io.zacholauson.todo.Application;
import io.zacholauson.todo.ApplicationComponent;
import io.zacholauson.todo.R;
import io.zacholauson.todo.fragments.TodosFragment;
import io.zacholauson.todocore.Todo;
import io.zacholauson.todocore.TodoRepository;

public class MainActivity extends AppCompatActivity implements TodosFragment.TodoProvider {

  @Inject
  TodoRepository todoRepository;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);

    getApplicationComponent().inject(this);

    setContentView(R.layout.activity_main);
  }

  @Override
  public List<Todo> getTodos() {
    return todoRepository.getTodos();
  }

  private ApplicationComponent getApplicationComponent() {
    return ((Application) getApplication()).getApplicationComponent();
  }
}
