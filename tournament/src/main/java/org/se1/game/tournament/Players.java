package org.se1.game.tournament;

public class Players {
	int gameNR;
	int player1;
	int player2;
	int winner;
	int turnsToWin;
	Players (){};
	public int getGameNR() {
		return gameNR;
	}
	public void setGameNR(int gameNR) {
		this.gameNR = gameNR;
	}
	public int getPlayer1() {
		return player1;
	}
	public void setPlayer1(int player1) {
		this.player1 = player1;
	}
	public int getPlayer2() {
		return player2;
	}
	public void setPlayer2(int player2) {
		this.player2 = player2;
	}
}
