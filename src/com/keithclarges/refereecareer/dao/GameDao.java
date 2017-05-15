/**
 * 
 */
package com.keithclarges.refereecareer.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSourceUtils;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;

import com.keithclarges.refereecareer.model.Game;

/**
 * @author keithclarges
 * 
 *         Class that is fully configured to use a JDBC connection pool
 *
 */
@Component("gameDao")
public class GameDao {

	private NamedParameterJdbcTemplate jdbc;

	@Autowired
	public void setDataSource(DataSource jdbc) {
		// The jdbc class wraps the datasource, providing us with lots of cool
		// methods
		this.jdbc = new NamedParameterJdbcTemplate(jdbc);
	}

	public List<Game> getRefereeCareerDetails() {

		return jdbc.query("select * from Games order by Date desc", new RowMapper<Game>() {

			// This is an anonymous method
			public Game mapRow(ResultSet rs, int rowNum) throws SQLException {

				Game game = new Game();
				game.setDateAndTimeOfGame(rs.getString("Date"));
				game.setMatchId(rs.getInt("Match_Id"));
				game.setHome(rs.getString("Home"));
				game.setAway(rs.getString("Away"));
				game.setHomeScore(rs.getInt("Home_Score"));
				game.setAwayScore(rs.getInt("Away_Score"));
				game.setAgeGroup(rs.getInt("Age_Group"));
				game.setDivision(rs.getString("Division"));
				game.setFreeKicks(rs.getInt("Num_Frees"));
				game.setPenalties(rs.getInt("Num_Pens"));
				game.setWeatherConditions(rs.getString("Weather"));
				game.setMatchFee(rs.getInt("Match_Fee"));
				game.setGameDuration(rs.getInt("Game_Duration"));
				game.setOffsides(rs.getInt("Offsides"));
				game.setMatchQuality(rs.getInt("Game_Quality"));
				game.setMyPerformance(rs.getInt("My_Performance"));
				game.setVenue(rs.getString("Venue"));
				game.setAdditionalComments(rs.getString("Comments"));
				game.setYellows(rs.getInt("yellows"));
				game.setReds(rs.getInt("reds"));
				game.setDistanceCovered(rs.getInt("Distance_Covered"));

				return game;
			}

		});
	}

	public int getGamesWithAtLeastOneRedCard() {
		String sql = "SELECT count(reds) FROM GAMES WHERE reds > 0";
		MapSqlParameterSource params = new MapSqlParameterSource();
		return jdbc.queryForObject(sql, params, Integer.class);
	}

	public int getCareerReds() {

		String sql = "SELECT sum(reds) FROM GAMES";
		MapSqlParameterSource params = new MapSqlParameterSource();
		return jdbc.queryForObject(sql, params, Integer.class);
	}

	public int getCareerYellows() {
		String sql = "SELECT SUM(yellows) FROM GAMES";
		MapSqlParameterSource params = new MapSqlParameterSource();
		return jdbc.queryForObject(sql, params, Integer.class);
	}
	
	public int getCareerMinutesRefereed() {
		String sql = "SELECT SUM(Game_Duration) FROM GAMES";
		MapSqlParameterSource params = new MapSqlParameterSource();
		return jdbc.queryForObject(sql, params, Integer.class);
	}

	 public double getAverageReds() {
	 String sql = "SELECT ROUND (AVG(reds),2) FROM games";
	 MapSqlParameterSource params = new MapSqlParameterSource();	
	 return jdbc.queryForObject(sql, params, Double.class);	
	 }
	 
	 public double getAverageYellows() {	
	 String sql = "SELECT ROUND(AVG(yellows),2) FROM games";
	 MapSqlParameterSource params = new MapSqlParameterSource();	
	 double averageYellows = jdbc.queryForObject(sql, params, Double.class);
	 return averageYellows;
	 }
	 
	 public double getAverageFrees() {	
	 String sql = "SELECT ROUND(AVG(Num_Frees),2) FROM games where Num_Frees IS NOT NULL AND Num_Frees <> 0";
	 MapSqlParameterSource params = new MapSqlParameterSource();	
	 return  jdbc.queryForObject(sql, params, Double.class);
	 }
	 
	 public double getAveragePenalties() {	
	 String sql = "SELECT ROUND(AVG (Num_Pens),2) FROM games where Num_Pens IS NOT NULL AND date > '2014/04/22'";
	 MapSqlParameterSource params = new MapSqlParameterSource();	
	 return jdbc.queryForObject(sql, params, Double.class);
	 }
	 
		public int getCareerFrees() {
			String sql = "SELECT SUM(Num_Frees) FROM GAMES";
			MapSqlParameterSource params = new MapSqlParameterSource();
			return jdbc.queryForObject(sql, params, Integer.class);
		}
		
		public int getCareerPenalties() {
			String sql = "SELECT SUM(Num_Pens) FROM GAMES";
			MapSqlParameterSource params = new MapSqlParameterSource();
			return jdbc.queryForObject(sql, params, Integer.class);
		}
		
		public int getTotalGoals(){
			String sql = "select sum(Home_Score + Away_Score) from Games";
			MapSqlParameterSource params = new MapSqlParameterSource();
			return jdbc.queryForObject(sql, params, Integer.class);
			}
		
		public double getAverageGoalsPerGame(){
			String sql = "select ROUND(avg(Home_Score + Away_Score),2) from Games";
			MapSqlParameterSource params = new MapSqlParameterSource();
			return jdbc.queryForObject(sql, params, Double.class);
			}
		
		public int getTotalEarnings(){
			String sql = "select sum(Match_Fee) from Games";
			MapSqlParameterSource params = new MapSqlParameterSource();
			return jdbc.queryForObject(sql, params, Integer.class);
		}
		public double getAverageMatchFee(){
			String sql = "select ROUND(avg(Match_Fee),2) from Games";
			MapSqlParameterSource params = new MapSqlParameterSource();
			return jdbc.queryForObject(sql, params, Double.class);
			}
		public double getAveragePerformanceRating(){
			String sql = "select avg(My_Performance) from Games where My_Performance IS NOT NULL AND My_Performance <> 0";
			MapSqlParameterSource params = new MapSqlParameterSource();
			return jdbc.queryForObject(sql, params, Double.class);
		}
		public double getAverageEnjoymentRating(){
			String sql = "select ROUND(avg(Game_Quality),2) from Games where Game_Quality IS NOT NULL AND Game_Quality <> 0";
			MapSqlParameterSource params = new MapSqlParameterSource();
			return jdbc.queryForObject(sql, params, Double.class);
			}
		
		public int getMultipleYellows (){
			String sql = "SELECT COUNT(yellows) FROM GAMES where yellows > 4";
			MapSqlParameterSource params = new MapSqlParameterSource();
			return jdbc.queryForObject(sql, params, Integer.class);
		}
		
		public int getMultipleReds (){
			String sql = "SELECT COUNT(reds) FROM GAMES where reds > 1";
			MapSqlParameterSource params = new MapSqlParameterSource();
			return jdbc.queryForObject(sql, params, Integer.class);
		}
		
		public double getAverageDistanceCovered(){
			String sql = "SELECT ROUND(AVG(distance_covered),2 )FROM games where date > '2016-03-21'";
			MapSqlParameterSource params = new MapSqlParameterSource();
			return jdbc.queryForObject(sql, params, Double.class);
		}
		
		public double getTotalDistanceCovered(){
			String sql = "SELECT SUM(distance_covered) FROM games where date > '2016-03-21'";
			MapSqlParameterSource params = new MapSqlParameterSource();
			return jdbc.queryForObject(sql, params, Double.class);
		}

	public Game getGameById(int id) {

		MapSqlParameterSource params = new MapSqlParameterSource();
		params.addValue("id", id);

		return jdbc.queryForObject("select * from Games where Match_Id = :id", params, new RowMapper<Game>() {

			// This is an anonymous method
			public Game mapRow(ResultSet rs, int rowNum) throws SQLException {

				Game game = new Game();
				game.setDateAndTimeOfGame(rs.getString("Date"));
				game.setMatchId(rs.getInt("Match_Id"));
				game.setHome(rs.getString("Home"));
				game.setAway(rs.getString("Away"));
				game.setHomeScore(rs.getInt("Home_Score"));
				game.setAwayScore(rs.getInt("Away_Score"));
				game.setAgeGroup(rs.getInt("Age_Group"));
				game.setDivision(rs.getString("Division"));
				game.setFreeKicks(rs.getInt("Num_Frees"));
				game.setPenalties(rs.getInt("Num_Pens"));
				game.setWeatherConditions(rs.getString("Weather"));
				game.setMatchFee(rs.getInt("Match_Fee"));
				game.setGameDuration(rs.getInt("Game_Duration"));
				game.setOffsides(rs.getInt("Offsides"));
				game.setMatchQuality(rs.getInt("Game_Quality"));
				game.setMyPerformance(rs.getInt("My_Performance"));
				game.setVenue(rs.getString("Venue"));
				game.setAdditionalComments(rs.getString("Comments"));
				game.setYellows(rs.getInt("yellows"));
				game.setReds(rs.getInt("reds"));
				game.setDistanceCovered(rs.getInt("Distance_Covered"));

				return game;
			}

		});

	}

	@Transactional // All or nothing. Insert will only work if all are valid
	public int[] insertMultipleGames(List<Game> games) {

		SqlParameterSource[] params = SqlParameterSourceUtils.createBatch(games.toArray());

		return jdbc.batchUpdate(
				"Insert into Games (Match_Id, Date, Home, Away, Home_Score, Away_Score, Age_Group, Division, "
						+ "Num_Frees, Num_Pens, Weather, Match_Fee, Game_Duration,  Offsides, Game_Quality, "
						+ "My_Performance, Venue, Comments, yellows, reds, Distance_Covered ) values (:matchId, :dateAndTimeOfGame, :Home, :Away, "
						+ ":homeScore, :awayScore, :ageGroup, :division, :freeKicks, :penalties, :weatherConditions, "
						+ ":matchFee, :gameDuration,  :offside, :matchQuality, :myPerformance, :Venue, "
						+ ":additionalComments, :yellows, :reds, :distanceCovered)",
				params);

	}

	public boolean insertGame(Game game) {

		BeanPropertySqlParameterSource params = new BeanPropertySqlParameterSource(game);

		return jdbc.update("Insert into Games (Date, Home, Away, Home_Score, Away_Score, Age_Group, Division, "
				+ "Num_Frees, Num_Pens, Weather, Match_Fee, Game_Duration,  Offsides, Game_Quality, "
				+ "My_Performance, Venue, Comments, yellows, reds, Distance_Covered ) values (:dateAndTimeOfGame, :Home, :Away, "
				+ ":homeScore, :awayScore, :ageGroup, :division, :freeKicks, :penalties, :weatherConditions, "
				+ ":matchFee, :gameDuration,  :offsides, :matchQuality, :myPerformance, :Venue, "
				+ ":additionalComments, :yellows, :reds, :distanceCovered)", params) == 1;

	}

	public boolean deleteMatchBasedOnMatchId(int matchId) {
		MapSqlParameterSource params = new MapSqlParameterSource("Match_Id", matchId);
		return jdbc.update("delete from Games where Match_Id = :Match_Id", params) == 1;
	}

	public boolean updateGame(Game game) {

		BeanPropertySqlParameterSource params = new BeanPropertySqlParameterSource(game);

		return jdbc.update(
				"Update Games set Home = :home, Date=:dateAndTimeOfGame, Away=away, Home_Score=:homeScore, Away_Score=:awayScore, Age_Group=:ageGroup, Division=:division, "
						+ "Num_Frees=:freeKicks, Num_Pens=:penalties, Weather=:weatherConditions, Match_Fee=:matchFee, Game_Duration=:gameDuration,  Offsides=:offsides, Game_Quality=:matchQuality, "
						+ "My_Performance=:myPerformance, Venue=:Venue, Comments=:additionalComments, yellows=:yellows, reds=:reds, Distance_Covered=:distanceCovered where Match_Id = :matchId",
				params) == 1;

	}
	
	public Model getAgeSpecificStats(String ageStats, Model model){
		
		String sql = "SELECT ROUND(AVG(distance_covered),2 )FROM games where date > '2016-03-21' AND Age_Group = " + ageStats;
		MapSqlParameterSource params = new MapSqlParameterSource();
		double averageDistancePerGame =  jdbc.queryForObject(sql, params, Double.class);
		
		model.addAttribute("averageDistancePerGame", averageDistancePerGame);
		return model;
	}
}
