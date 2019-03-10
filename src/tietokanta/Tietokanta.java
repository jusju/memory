package tietokanta;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import model.Pelaaja;

public class Tietokanta {
	private Connection connection = null;
	private Statement stmt = null;

	public void luoYhteys() {
		try {
			Class.forName("org.sqlite.JDBC");
			connection = DriverManager.getConnection("jdbc:sqlite:highscore.db");
			System.out.println("SQLite DB connected");
			Statement stmt = connection.createStatement();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public void suljeYhteys() {
		try {
			stmt.close();
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void talleta(String nickname, int score) {
		luoYhteys();
		try {
			String sql = "INSERT INTO highscore(score, nickname) " + 
					"VALUES(" + score + ",'" + nickname + "');";
			stmt.execute(sql);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public List<Pelaaja> listaaPisteet() {
		luoYhteys();
		List<Pelaaja> tulokset = new ArrayList<Pelaaja>();
		try {
			String sql = "SELECT * FROM highscore";
			ResultSet rs = stmt.executeQuery(sql);
			while (rs.next()) {
				int score = rs.getInt("score");
				String nickname = rs.getString("nickname");
				System.out.print(score + " ");
				System.out.println(nickname);
				tulokset.add(new Pelaaja(score, nickname));
			}
			stmt.execute(sql);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return tulokset;
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
