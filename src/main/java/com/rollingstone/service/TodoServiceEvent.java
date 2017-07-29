package com.rollingstone.service;

import org.springframework.context.ApplicationEvent;
import com.rollingstone.domain.Todo;

/**
 * This is an optional class used in publishing application events. This can be
 * used to inject events into the Spring Boot audit management endpoint.
 */

//TODO Replace All Todos with your Domains Object
public class TodoServiceEvent extends ApplicationEvent {
	Todo eventTodo;
	String eventType;

	public TodoServiceEvent(Object source, String eventType, Todo todo) {
		super(source);
		this.eventType = eventType;
		this.eventTodo = todo;
	}

	public String toString() {
		return "My TodoService Event";
	}

	public Todo getEventTodo() {
		return eventTodo;
	}

	public void setEventTodo(Todo eventTodo) {
		this.eventTodo = eventTodo;
	}

	public String getEventType() {
		return eventType;
	}

	public void setEventType(String eventType) {
		this.eventType = eventType;
	}
}
