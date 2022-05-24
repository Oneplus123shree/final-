package net.app.Team.Controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import net.app.Team.Entity.Team;
import net.app.Team.Service.TeamService;

@RestController
public class TeamController {
	
	@Autowired
	private TeamService teamService;
	
	@CrossOrigin(origins="http://localhost:4200")
	@PostMapping("/createTeam")
	public Team saveTeam(@RequestBody Team team) throws Exception
	{
		Team teamObj=teamService.fetchTeamByName(team.getTeamName());
		if(teamObj!=null)
		{
			throw new Exception("Team Name already exist");
		}
		else
		{
			teamService.saveTeam(team);
		}
		return team;
	}
	
	@CrossOrigin(origins="http://localhost:4200")
	@GetMapping("/teamName")
	public List<String> teamNames()
	{
		return teamService.allTeamName();
	}
	
	

}
