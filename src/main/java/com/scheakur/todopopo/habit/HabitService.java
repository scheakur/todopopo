package com.scheakur.todopopo.habit;

import com.google.common.collect.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class HabitService {

	@Autowired
	private HabitRepository habitRepo;

	@Autowired
	private ActivityRepository activityRepo;

	public Map<Habit, List<Activity>> findAll() {
//		Iterable<Habit> habits = habitRepo.findAll(new Sort("startDate"));
//		Map<UUID, Habit> habitMap = Lists.newArrayList(habits).stream().collect(Collectors.toMap(h -> h.getId(), h -> h));
//		Iterable<Activity> activities = activityRepo.findByHabits(habitMap.keySet());
//		return Lists.newArrayList(activities).stream().collect(Collectors.groupingBy(a -> habitMap.get(a.getHabit())));
		return null;
	}

}
