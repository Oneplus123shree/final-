package net.app.Team.Entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Transient;

@Entity
public class Team {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private int team_id;
	private String teamName;
	private int teamMaxBudget;
	
	@Transient
	List<Player> players;
	
	public Team(int team_id, String teamName, int teamMaxBudget, List<Player> players) {
		super();
		this.team_id = team_id;
		this.teamName = teamName;
		this.teamMaxBudget = teamMaxBudget;
		this.players = players;
	}

	public List<Player> getPlayers() {
		return players;
	}

	public void setPlayers(List<Player> players) {
		this.players = players;
	}

	public Team() {
		super();
	}

	public Team(int team_id, String teamName, int teamMaxBudget) {
		super();
		this.team_id = team_id;
		this.teamName = teamName;
		this.teamMaxBudget = teamMaxBudget;
	}

	public int getTeam_id() {
		return team_id;
	}

	public void setTeam_id(int team_id) {
		this.team_id = team_id;
	}

	public String getTeamName() {
		return teamName;
	}

	public void setTeamName(String teamName) {
		this.teamName = teamName;
	}

	public int getTeamMaxBudget() {
		return teamMaxBudget;
	}

	public void setTeamMaxBudget(int teamMaxBudget) {
		this.teamMaxBudget = teamMaxBudget;
	}	

}
