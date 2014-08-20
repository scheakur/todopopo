package com.scheakur.todopopo.habit;

import lombok.Getter;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.time.ZonedDateTime;
import java.util.UUID;

@Entity
@ToString
public class Habit {

	@Id @Getter private final UUID id;
	@Getter private String title;
	@Getter private ZonedDateTime startDate;

	public Habit() {
		this.id = UUID.randomUUID();
	}

}
