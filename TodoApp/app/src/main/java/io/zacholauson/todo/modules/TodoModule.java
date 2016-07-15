package io.zacholauson.todo.modules;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import io.zacholauson.todocore.Todo;
import io.zacholauson.todocore.TodoRepository;

@Module
public class TodoModule {

    @Provides
    @Singleton
    public TodoRepository provideRepository() {
        return new TodoRepository() {

            @Override
            public List<Todo> getTodos() {
                return new ArrayList<>();
            }
        };
    }
}

