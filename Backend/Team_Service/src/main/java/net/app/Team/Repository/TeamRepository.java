package net.app.Team.Repository;

import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import net.app.Team.Entity.Team;

public interface TeamRepository extends JpaRepository<Team,Integer> {
	
	public Team findByTeamName(String teamName);
	
	@Query(value="select teamName from Team")
	public List<String> TeamNames();

}
