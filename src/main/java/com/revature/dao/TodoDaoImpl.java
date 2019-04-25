package com.revature.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.revature.model.Todo;
import com.revature.util.ConnectionFactory;

public class TodoDaoImpl implements TodoDao {

	@Override
	public List<Todo> getAllTodos() {
		final List<Todo> todos = new ArrayList<>();
		try (Connection conn = ConnectionFactory.getConnection()) {
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM todos");
			while (rs.next())
				todos.add(new Todo(rs.getInt("todo_id"), rs.getString("title"), rs.getString("description")));
			return todos;
		} catch (SQLException e) {
			System.err.println("SQL State: " + e.getSQLState());
			System.err.println("Error Code: " + e.getErrorCode());
			throw new RuntimeException("Failed to get all todos");
		}
	}

	
}
