package tietokanta;

import java.sql.*;

public class Yhteys {

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
				System.out.println(score);
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
