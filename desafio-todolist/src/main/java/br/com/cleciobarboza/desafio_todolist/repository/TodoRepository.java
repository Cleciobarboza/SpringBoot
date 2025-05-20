package br.com.cleciobarboza.desafio_todolist.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.cleciobarboza.desafio_todolist.entity.Todo;

public interface TodoRepository extends JpaRepository<Todo, Long>{
    
}
