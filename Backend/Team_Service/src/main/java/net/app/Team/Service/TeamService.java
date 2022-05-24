package net.app.Team.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.app.Team.Entity.Team;
import net.app.Team.Repository.TeamRepository;

@Service
public class TeamService {
	
	@Autowired
	private TeamRepository teamRepo;
	
	public Team saveTeam(Team team)
	{
		return teamRepo.save(team);
	}
	
	public Team fetchTeamByName(String teamName)
	{
		return teamRepo.findByTeamName(teamName);
	}
	
	public List<String> allTeamName()
	{
		return teamRepo.TeamNames();
	}

	
}
