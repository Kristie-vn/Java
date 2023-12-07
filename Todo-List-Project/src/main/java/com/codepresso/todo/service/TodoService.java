package com.codepresso.todo.service;

import com.codepresso.todo.vo.Todo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TodoService {

    private final List<Todo> todoList;

    //todo Hoàn thành code để Dependency injection vào biến thành viên todoList
    public TodoService(List<Todo> todoList){
        this.todoList = todoList;
    }
    public void addTodo(Todo todo) {
        //todo Thêm hạng mục mới vào todoList
        todo.setId(todoList.size());
        todoList.add(todo);
    }

    public List<Todo> getTodoList(){
        //todo Trả về thông tin todoList
        return todoList;
    }

    public void deleteTodo(int index) {
        //todo Xóa hạng mục tương ứng với index trong todoList
        int i =0;
        for(Todo todo: todoList){
            if(todo.getId() == index){
                break;
            }
            i++;
        }
        todoList.remove(i);
    }
}
