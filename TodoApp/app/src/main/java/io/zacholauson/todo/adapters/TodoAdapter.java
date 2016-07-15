package io.zacholauson.todo.adapters;

import android.content.Context;
import android.graphics.Paint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

import io.zacholauson.todocore.Todo;

public class TodoAdapter extends ArrayAdapter<Todo> {

    private Context context;

    public TodoAdapter(final Context context, final List<Todo> todos) {
        super(context, android.R.layout.simple_list_item_1, todos);

        this.context = context;
    }

    @Override
    public View getView(final int position, final View convertView, final ViewGroup parent) {
        View view = LayoutInflater.from(context)
                .inflate(android.R.layout.simple_list_item_1, parent, false);

        TextView todoView = (TextView) view.findViewById(android.R.id.text1);
        Todo todo = getItem(position);

        todoView.setText(todo.getTask());

        if (todo.isCompleted()) {
            todoView.setPaintFlags(todoView.getPaintFlags() | Paint.STRIKE_THRU_TEXT_FLAG);
            todoView.setEnabled(false);
        }

        return view;
    }
}
