package org.mockito.javapoint._01.stubbing;

import java.util.ArrayList;
import java.util.List;

public class ToDoBusiness {
	public ToDoService doService;

	public ToDoBusiness(ToDoService doService) {
		this.doService = doService;
	}
	
	public List<String> getTodosForSpring(String user){
		ArrayList<String> retrievetodos = new ArrayList<String>();
		List<String> todos = doService.getTodos(user);
		for(String todo: todos) {
			if(todo.contains("Spring")) {
				retrievetodos.add(todo);
			}
		}
		return retrievetodos;
	}

}
