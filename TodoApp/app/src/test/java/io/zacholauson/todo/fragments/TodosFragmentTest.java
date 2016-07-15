package io.zacholauson.todo.fragments;

import android.support.v4.app.FragmentActivity;
import android.widget.ListView;

import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.robolectric.RobolectricGradleTestRunner;
import org.robolectric.annotation.Config;
import org.robolectric.shadows.support.v4.SupportFragmentTestUtil;

import java.util.ArrayList;
import java.util.List;

import io.zacholauson.todo.BuildConfig;
import io.zacholauson.todo.R;
import io.zacholauson.todocore.Todo;
import io.zacholauson.todocore.TodoRepository;

@RunWith(RobolectricGradleTestRunner.class)
@Config(constants = BuildConfig.class)
public class TodosFragmentTest {

    static TodoRepository todoRepository;
    private TodosFragment fragment;

    static class MockActivity extends FragmentActivity implements TodosFragment.TodoProvider {

        @Override
        public List<Todo> getTodos() {
            return todoRepository.getTodos();
        }
    }

    @Before
    public void setup() {
        todoRepository = Mockito.mock(TodoRepository.class);
        List<Todo> todos = new ArrayList<>();
        todos.add(new Todo("Read Clean Code", true));
        todos.add(new Todo("Read Refactoring", true));
        Mockito.when(todoRepository.getTodos())
                .thenReturn(todos);

        fragment = new TodosFragment();

        SupportFragmentTestUtil.startFragment(fragment, MockActivity.class);
    }

    @Test
    public void displaysAllOfTheProvidedTodosInAListView() throws Exception {
        ListView todoList = (ListView) fragment.getView().findViewById(R.id.todo_list);

        Mockito.verify(todoRepository).getTodos();
        Assertions.assertThat(todoList.getCount()).isEqualTo(2);
    }
}
