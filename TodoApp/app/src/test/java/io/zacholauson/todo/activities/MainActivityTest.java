package io.zacholauson.todo.activities;

import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricGradleTestRunner;
import org.robolectric.RuntimeEnvironment;
import org.robolectric.annotation.Config;

import java.util.ArrayList;
import java.util.List;

import io.zacholauson.todo.BuildConfig;
import io.zacholauson.todo.R;
import io.zacholauson.todo.TestApplication;
import io.zacholauson.todo.fragments.TodosFragment;
import io.zacholauson.todo.modules.MockTodoModule;
import io.zacholauson.todocore.Todo;
import io.zacholauson.todocore.TodoRepository;

@RunWith(RobolectricGradleTestRunner.class)
@Config(constants = BuildConfig.class, application = TestApplication.class)
public class MainActivityTest {

    private TodoRepository todoRepository;
    private MainActivity activity;

    @Before
    public void setup() {
        todoRepository = Mockito.mock(TodoRepository.class);

        getApplication().setTodoModule(
                new MockTodoModule(todoRepository));

        activity = Robolectric.setupActivity(MainActivity.class);
    }

    @Test
    public void providesAllTodosFromRepository() {
        List<Todo> todos = new ArrayList<>();
        todos.add(new Todo("Write Slides", false));
        todos.add(new Todo("Practice Robolectric configuration", true));

        Mockito.when(todoRepository.getTodos())
                .thenReturn(todos);

        Assertions.assertThat(activity.getTodos())
                .isEqualTo(todos);
    }

    @Test
    public void hostsATodoFragment() {
        TodosFragment todosFragment = (TodosFragment) activity.getSupportFragmentManager().findFragmentById(R.id.todos_fragment);

        Assertions.assertThat(todosFragment).isNotNull();
        Assertions.assertThat(todosFragment.isVisible()).isTrue();
    }

    private TestApplication getApplication() {
        return ((TestApplication) RuntimeEnvironment.application);
    }
}