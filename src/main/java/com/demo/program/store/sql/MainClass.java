package com.demo.program.store.sql;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MainClass {

	public static void main(String[] args) throws IOException, SQLException {

		Connection connection = getConnection();
		Reader reader = new BufferedReader(new FileReader("Path to .sql file"));

		ScriptRunner scriptRunner = new ScriptRunner(connection, true, false);
		scriptRunner.runScript(reader);

	}

	private static Connection getConnection() {

		try (Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "system",
				"Password123")) {

			if (conn != null) {
				System.out.println("Connected to the database!");
				return conn;
			} else {
				System.out.println("Failed to make connection!");
			}

		} catch (SQLException e) {
			System.err.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;

	}

}
