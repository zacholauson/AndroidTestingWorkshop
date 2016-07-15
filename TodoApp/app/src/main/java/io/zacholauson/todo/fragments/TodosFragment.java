package io.zacholauson.todo.fragments;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.util.List;

import io.zacholauson.todo.R;
import io.zacholauson.todo.adapters.TodoAdapter;
import io.zacholauson.todocore.Todo;

public class TodosFragment extends Fragment {

    public interface TodoProvider {
        List<Todo> getTodos();
    }

    private TodoProvider todoProvider;

    @Override
    public void onAttach(final Context context) {
        super.onAttach(context);

        todoProvider = (TodoProvider) context;
    }

    @Override
    public View onCreateView(
            final LayoutInflater inflater,
            final ViewGroup container,
            final Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.fragment_todos, container, false);

        ListView todoList = (ListView) view.findViewById(R.id.todo_list);
        todoList.setAdapter(new TodoAdapter(getContext(), todoProvider.getTodos()));

        return view;
    }
}
