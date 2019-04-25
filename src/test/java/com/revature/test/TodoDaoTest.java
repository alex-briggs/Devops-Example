package com.revature.test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.revature.dao.TodoDao;
import com.revature.dao.TodoDaoImpl;

public class TodoDaoTest {

	private final TodoDao dao = new TodoDaoImpl();
	
	@Test
	public void getAllTodos_ShouldReturn1Record() {
		assertEquals(1, dao.getAllTodos().size());
	}
}
