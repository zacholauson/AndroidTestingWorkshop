package io.zacholauson.todo.adapters;

import android.graphics.Paint;
import android.view.View;
import android.widget.TextView;

import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.RobolectricGradleTestRunner;
import org.robolectric.RuntimeEnvironment;
import org.robolectric.annotation.Config;

import java.util.ArrayList;
import java.util.List;

import io.zacholauson.todo.BuildConfig;
import io.zacholauson.todocore.Todo;

@RunWith(RobolectricGradleTestRunner.class)
@Config(constants = BuildConfig.class)
public class TodoAdapterTest {

    @Test
    public void buildsAnEnabledTodoTaskView() throws Exception {
        List<Todo> todos = new ArrayList<>();
        todos.add(new Todo("Setup Workshop", false));

        TodoAdapter adapter = new TodoAdapter(RuntimeEnvironment.application, todos);

        View todoTaskView = adapter.getView(0, null, null);
        TextView todoTask = (TextView) todoTaskView.findViewById(android.R.id.text1);

        Assertions.assertThat(todoTask.getText()).isEqualTo("Setup Workshop");
        Assertions.assertThat(todoTask.isEnabled()).isTrue();
    }

    @Test
    public void buildsADisabledTodoTaskView() throws Exception {
        List<Todo> todos = new ArrayList<>();
        todos.add(new Todo("Setup Workshop", true));

        TodoAdapter adapter = new TodoAdapter(RuntimeEnvironment.application, todos);

        View todoTaskView = adapter.getView(0, null, null);
        TextView todoTask = (TextView) todoTaskView.findViewById(android.R.id.text1);

        Assertions.assertThat(todoTask.getText()).isEqualTo("Setup Workshop");
        Assertions.assertThat(todoTask.getPaintFlags()).isEqualTo(Paint.STRIKE_THRU_TEXT_FLAG);
        Assertions.assertThat(todoTask.isEnabled()).isFalse();
    }
}