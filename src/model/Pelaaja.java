package model;

public class Pelaaja {
	private int pisteet;
	private String nickname;

	public Pelaaja(int pisteet, String nickname) {
		super();
		this.pisteet = pisteet;
		this.nickname = nickname;
	}
	public Pelaaja() {
		super();
	}
	
	public int getPisteet() {
		return pisteet;
	}
	public void setPisteet(int pisteet) {
		this.pisteet = pisteet;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	@Override
	public String toString() {
		return "Pelaaja [pisteet=" + pisteet + ", nickname=" + nickname + "]";
	}

}
