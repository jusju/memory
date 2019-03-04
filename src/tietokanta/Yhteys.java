package tietokanta;

import java.sql.*;

public class Yhteys {

	public static void main(String[] args) {
		Connection c = null;
		
		try {
			Class.forName("org.sqlite.JDBC");
			c = DriverManager.getConnection("jdbc:sqlite:highscore.db");
			System.out.println("SQLite DB connected");
		} catch(Exception ex) {
			ex.printStackTrace();
		}
	}
	
}
