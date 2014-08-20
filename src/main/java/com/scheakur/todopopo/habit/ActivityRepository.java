package com.scheakur.todopopo.habit;

import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.UUID;

public interface ActivityRepository extends PagingAndSortingRepository<Activity, UUID> {

//	public Iterable<Activity> findByHabits(Iterable<UUID> habitIds);

}
