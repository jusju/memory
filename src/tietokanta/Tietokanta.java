package tietokanta;

import java.sql.*;
import java.util.List;

import model.Pelaaja;

public class Tietokanta {
	private Connection connection = null;
	
	public void luoYhteys() {
		try {
			Class.forName("org.sqlite.JDBC");
			connection = DriverManager.getConnection("jdbc:sqlite:highscore.db");
			System.out.println("SQLite DB connected");
			Statement stmt = connection.createStatement();
		} catch(Exception ex) {
			ex.printStackTrace();
		}
	}
	
	public void suljeYhteys() {
		try {
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void talleta(String nickname, int score) {
		
	}
	public List<Pelaaja> listaaPisteet() {
		return null;
	}

	public static void main(String[] args) {
		Connection c = null;

		try {
			Class.forName("org.sqlite.JDBC");
			c = DriverManager.getConnection("jdbc:sqlite:highscore.db");
			System.out.println("SQLite DB connected");
			Statement stmt = c.createStatement();
			String sql = "SELECT * FROM highscore";
			ResultSet rs = stmt.executeQuery(sql);
			while (rs.next()) {
				int score = rs.getInt("score");
				String nickname = rs.getString("nickname");
				System.out.print(score + " ");
				System.out.println(nickname);
			}

			rs.close();
			stmt.close();
			c.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

}
