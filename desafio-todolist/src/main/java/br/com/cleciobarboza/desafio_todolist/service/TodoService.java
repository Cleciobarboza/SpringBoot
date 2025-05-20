package br.com.cleciobarboza.desafio_todolist.service;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import br.com.cleciobarboza.desafio_todolist.entity.Todo;
import br.com.cleciobarboza.desafio_todolist.repository.TodoRepository;


@Service
public class TodoService {
    private TodoRepository todoRepoditory;
    
   
    public TodoService(TodoRepository todoRepoditory) {
        this.todoRepoditory = todoRepoditory;
    }
    public List<Todo> create(Todo todo){
        todoRepoditory.save(todo);
        return list();
    }
     public List<Todo> list(){
        Sort sort = Sort.by("prioridade").descending().and(Sort.by("nome").ascending());
        return todoRepoditory.findAll(sort);
        
    }
     public List<Todo> update(Todo todo){
        todoRepoditory.save(todo);
        return list();
    }
     public List<Todo> delete(Long id){
        todoRepoditory.deleteById(id);
        return list();
    }
    
}
