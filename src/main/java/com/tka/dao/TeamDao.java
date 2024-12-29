package com.tka.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.tka.model.Team;

@Repository
public class TeamDao {

	List<Team> teams = new ArrayList<Team>();

	public TeamDao() {
		teams.add(new Team(1, "MI", "Mumbai", "Mahela Jayawardene"));
		teams.add(new Team(2, "RCB", "Banglore", " Andy Flowers "));

	}

	public String addTeam(Team team) {

		teams.add(team);

		return "Added Successfully";

	}

	public List<Team> getAllTeams() {

		return teams;

	}

	public Team getTeamById(int id) {

		for (Team team : teams) {

			if (team.getTeamId() == id) {
				return team;
			}

		}

		return null;
	}

	public int deleteTeam(int id) {

		String msg = "";
		for (Team team : teams) {

			if (team.getTeamId() == id) {
				teams.remove(team);

				return 1;
			}
		}

		return 0;

	}

	public int updateTeam(int id, Team team) {

		int status = deleteTeam(id);

		if (status == 1) {
			teams.add(team);
			return 1;

		}else {
			
			return 0;
		}
		
	}

}
