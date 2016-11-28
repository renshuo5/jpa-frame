package com.rensframework.core.entity.listener;

import java.sql.Timestamp;

import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;

import com.rensframework.core.entity.TimeEntity;

public class TimeEntityListener {
	@PrePersist
	public void onPrePersist(TimeEntity te) {
		Timestamp t = new Timestamp(System.currentTimeMillis());
		te.setCreation(t);
		te.setLastModified(t);
	}

	@PreUpdate
	public void onPreUpdate(TimeEntity te) {
		te.setLastModified(new Timestamp(System.currentTimeMillis()));
	}
}
