package net.app.Team.Controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import net.app.Team.Entity.Player;
import net.app.Team.Entity.Team;
import net.app.Team.Service.PlayerService;
import net.app.Team.Service.TeamService;

@RestController
public class PlayerController {
	
	@Autowired
	private PlayerService playerService;
	
	@Autowired
	private TeamService teamService;
	

	@CrossOrigin(origins="http://localhost:4200")
	@GetMapping("players/{teamName}")
	public List<Player> fetchPlayers(@PathVariable String teamName)
	{
		return playerService.FetchPlayerByTeamName(teamName);
	}
	@CrossOrigin(origins="http://localhost:4200")
	@GetMapping("playerDetails/{playerName}")
	public List<Player> fetchPlayer(@PathVariable String playerName) throws Exception
	{
		if(playerService.playerDetails(playerName).isEmpty())
		{
			throw new Exception("playerNot Exixt");
			
		}
		else {
			return playerService.playerDetails(playerName);
			
		}
	}
	
	
	@CrossOrigin(origins="http://localhost:4200")
	@PostMapping("/createPlayer")
	public Player createPlayer(@RequestBody Player player) throws Exception
	
	
	{ 
		Team teamObj=teamService.fetchTeamByName(player.getPlayerTeamName());
		List<Player> playerObj=playerService.FetchPlayerByTeamName(player.getPlayerTeamName());
	
		if(playerObj.isEmpty() && teamObj!=null)
		{
			if(player.getPlayerBiddingBudget()<=teamObj.getTeamMaxBudget())
			{
			return playerService.createPlayer(player);
			}
			
			else if(player.getPlayerBiddingBudget()>teamObj.getTeamMaxBudget())
			{
				throw new Exception("Player can't be tagged to this team as it's exceeds team's budget");
			}
		}
		else if(playerObj!=null && teamObj!=null)
		{
			int value=playerService.sumOfPlayerBiddingBudget(player.getPlayerTeamName())+player.getPlayerBiddingBudget();
			System.out.println(value);
			if(value>teamObj.getTeamMaxBudget() )
			{
				throw new Exception("Player can't be tagged to this team as it's exceeds team's budget");
			}
			else
			{
				return playerService.createPlayer(player);
			}
		}
		else if(player.getPlayerTeamName().equals("NA"))
		{
			return playerService.createPlayer(player);
		}
		else if(teamObj==null)
		{
			throw new Exception("Team does not exist");
		}
		
		return player;
	}
	
	
	
}
