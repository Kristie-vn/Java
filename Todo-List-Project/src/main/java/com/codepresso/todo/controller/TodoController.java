package com.codepresso.todo.controller;

import com.codepresso.todo.service.TodoService;
import com.codepresso.todo.vo.ResultDto;
import com.codepresso.todo.vo.Todo;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TodoController {

    //Hãy viết code Dependency injection để ứng dụng TodoService
    private final TodoService todoService;

    public TodoController(TodoService todoService) {
        this.todoService = todoService;
    }
    //todo Kiểm tra API document rồi sử dụng phương thức GET để hoàn thành /todo REST API

    //todo Hãy sử dụng TodoService
    @GetMapping("/todo")
    @ResponseBody
    public List<Todo> getTodoList(){
        List<Todo> list= todoService.getTodoList();
        return list;
    }

    //todo Kiểm tra API document rồi sử dụng phương thức POST để hoàn thành /todo REST API

    //todo Hãy sử dụng TodoService
    @PostMapping("/todo")
    @ResponseBody
    public Object addTodo(@RequestBody Todo todoParam) {
        Todo todo = new Todo(todoParam.getContent());
        todoService.addTodo(todo);
        //todo Đừng thay đổi return code
        return new ResultDto(200, "Success");
    }

    //todo Kiểm tra API document rồi sử dụng phương thức DELETE để hoàn thành /todo REST API

    //todo Hãy sử dụng TodoService
    @DeleteMapping("/todo/{id}")
    public Object deleteTodo(@PathVariable("id") Integer id) {
        todoService.deleteTodo(id);
        //todo Đừng thay đổi return code
        return new ResultDto(200, "Success");
    }

}
