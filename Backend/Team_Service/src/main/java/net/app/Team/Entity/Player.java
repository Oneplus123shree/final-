package net.app.Team.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Player {
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	private int playerId;
	private String playerName;
	private int playerBiddingBudget;
	private String playerTeamName;
	public Player(int playerId, String playerName, int playerBiddingBudget, String playerTeamName) {
		super();
		this.playerId = playerId;
		this.playerName = playerName;
		this.playerBiddingBudget = playerBiddingBudget;
		this.playerTeamName = playerTeamName;
	}
	public Player() {
		super();
	}
	public int getPlayerId() {
		return playerId;
	}


	public void setPlayerId(int playerId) {
		this.playerId = playerId;
	}


	public String getPlayerName() {
		return playerName;
	}


	public void setPlayerName(String playerName) {
		this.playerName = playerName;
	}


	public int getPlayerBiddingBudget() {
		return playerBiddingBudget;
	}


	public void setPlayerBiddingBudget(int playerBiddingBudget) {
		this.playerBiddingBudget = playerBiddingBudget;
	}

	public String getPlayerTeamName() {
		return playerTeamName;
	}

	public void setPlayerTeamName(String playerTeamName) {
		this.playerTeamName = playerTeamName;
	}	

}
