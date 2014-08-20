package com.scheakur.todopopo.habit;

import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.UUID;

public interface HabitRepository extends PagingAndSortingRepository<Habit, UUID> {
}
