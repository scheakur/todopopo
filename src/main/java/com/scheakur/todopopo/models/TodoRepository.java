package com.scheakur.todopopo.models;

import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface TodoRepository extends CrudRepository<Todo, UUID> {

}
