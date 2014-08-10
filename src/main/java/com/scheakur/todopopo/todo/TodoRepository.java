package com.scheakur.todopopo.todo;

import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.UUID;

public interface TodoRepository extends PagingAndSortingRepository<Todo, UUID> {

}
