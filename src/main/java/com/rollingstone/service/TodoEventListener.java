package com.rollingstone.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

@Component
public class TodoEventListener implements ApplicationListener<TodoServiceEvent> {
	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	//TODO Change this according to your application needs
	public void onApplicationEvent(TodoServiceEvent event) {
		TodoServiceEvent todoEvent = (TodoServiceEvent) event;
		logger.info("Todo " + event.getEventType() + " with details : " + todoEvent.getEventTodo());
	}
}
