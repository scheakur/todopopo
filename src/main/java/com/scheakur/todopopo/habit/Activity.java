package com.scheakur.todopopo.habit;

import lombok.Getter;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.time.ZonedDateTime;
import java.util.UUID;

@Entity
@ToString
public class Activity {

	@Id @Getter private final UUID id;
	@Getter private UUID habit;
	@Getter private ZonedDateTime date;

	public Activity(UUID habit, ZonedDateTime date) {
		this.id = UUID.randomUUID();
		this.habit = habit;
		this.date = date;
	}

}