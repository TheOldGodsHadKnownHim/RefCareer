/**
 * 
 */
package com.keithclarges.refereecareer.model;

import java.util.Date;

import javax.validation.constraints.Size;

/**
 * @author keithclarges
 *
 */
public class Game {
	
	private String dateAndTimeOfGame;
	private int matchId;
	@Size(min=5, max=100)
	private String home;
	private String away;
	private int homeScore;
	private int awayScore;
	private int ageGroup;
	private String division;
	private int freeKicks;
	private int penalties;
	private int matchFee;
	private int gameDuration;
	private String weatherConditions;
	private int offsides;
	private int matchQuality;
	private int myPerformance;
	private String venue;
	private String additionalComments;
	private int yellows;
	private int reds;
	private int distanceCovered;

	public Game() {

	}

	public Game(int matchId, String dateAndTimeOfGame, String home, String away, int homeScore, int awayScore,
			int ageGroup, String division, int freeKicks, int penalties, int matchFee, int gameDuration,
			String weatherConditions, int offsides, int matchQuality, int myPerformance, String venue,
			String additionalComments, int yellows, int reds, int distanceCovered) {
		
		this.matchId = matchId;
		this.dateAndTimeOfGame = dateAndTimeOfGame;
		this.home = home;
		this.away = away;
		this.homeScore = homeScore;
		this.awayScore = awayScore;
		this.ageGroup = ageGroup;
		this.division = division;
		this.freeKicks = freeKicks;
		this.penalties = penalties;
		this.matchFee = matchFee;
		this.gameDuration = gameDuration;
		this.weatherConditions = weatherConditions;
		this.offsides = offsides;
		this.matchQuality = matchQuality;
		this.myPerformance = myPerformance;
		this.venue = venue;
		this.additionalComments = additionalComments;
		this.yellows = yellows;
		this.reds = reds;
		this.distanceCovered=distanceCovered;
	}

	// no match_id here as auto increment will take care of it
	public Game(String dateAndTimeOfGame, String home, String away, int homeScore, int awayScore, int ageGroup,
			String division, int freeKicks, int penalties, int matchFee, int gameDuration, String weatherConditions,
			int offsides, int matchQuality, int myPerformance, String venue, String additionalComments,
			int yellows, int reds, int distanceCovered) {
		this.dateAndTimeOfGame = dateAndTimeOfGame;
		this.home = home;
		this.away = away;
		this.homeScore = homeScore;
		this.awayScore = awayScore;
		this.ageGroup = ageGroup;
		this.division = division;
		this.freeKicks = freeKicks;
		this.penalties = penalties;
		this.matchFee = matchFee;
		this.gameDuration = gameDuration;
		this.weatherConditions = weatherConditions;
		this.offsides = offsides;
		this.matchQuality = matchQuality;
		this.myPerformance = myPerformance;
		this.venue = venue;
		this.additionalComments = additionalComments;
		this.yellows = yellows;
		this.reds = reds;
		this.distanceCovered=distanceCovered;
	}

	public Game(int matchId, String home) {
		super();
		this.matchId = matchId;
		this.home = home;
	}



	@Override
	public String toString() {
		return "MyRefereeCareer [\nMatch Id: " + matchId + "\nDate: " + dateAndTimeOfGame + "\nHome: " + home
				+ "\nAway: " + away + "\nVenue: " + venue + "\nAge Group:" + ageGroup + "\nDivision: " + division
				+ "\nResult: " + homeScore + " - " + awayScore + "\nGame Duration: " + gameDuration + "\nOffsides: "
				+ offsides + "\nFree Kicks: " + freeKicks + "\nPenalties: " + penalties + "\nYellows: " + yellows
				+ "\nReds: " + reds + "\nMatch Fee: " + matchFee + "\nWeather: " + weatherConditions
				+ "\nMatch Quality: " + matchQuality + "\nMy Performance: " + myPerformance + "\nComments: "
				+ additionalComments + "\n]\n";
	}

	public int getYellows() {
		return yellows;
	}

	public void setYellows(int yellows) {
		this.yellows = yellows;
	}

	public int getReds() {
		return reds;
	}

	public void setReds(int reds) {
		this.reds = reds;
	}

	public String getDateAndTimeOfGame() {
		return dateAndTimeOfGame;
	}

	public void setDateAndTimeOfGame(String dateAndTimeOfGame) {
		this.dateAndTimeOfGame = dateAndTimeOfGame;
	}

	public int getMatchId() {
		return matchId;
	}

	public void setMatchId(int matchId) {
		this.matchId = matchId;
	}

	public String getHome() {
		return home;
	}

	public void setHome(String home) {
		this.home = home;
	}

	public String getAway() {
		return away;
	}

	public void setAway(String away) {
		this.away = away;
	}

	public int getHomeScore() {
		return homeScore;
	}

	public void setHomeScore(int homeScore) {
		this.homeScore = homeScore;
	}

	public int getAwayScore() {
		return awayScore;
	}

	public void setAwayScore(int awayScore) {
		this.awayScore = awayScore;
	}

	public int getAgeGroup() {
		return ageGroup;
	}

	public void setAgeGroup(int ageGroup) {
		this.ageGroup = ageGroup;
	}

	public String getDivision() {
		return division;
	}

	public void setDivision(String division) {
		this.division = division;
	}

	public int getFreeKicks() {
		return freeKicks;
	}

	public void setFreeKicks(int freeKicks) {
		this.freeKicks = freeKicks;
	}

	public int getPenalties() {
		return penalties;
	}

	public void setPenalties(int penalties) {
		this.penalties = penalties;
	}

	public int getMatchFee() {
		return matchFee;
	}

	public void setMatchFee(int matchFee) {
		this.matchFee = matchFee;
	}

	public int getGameDuration() {
		return gameDuration;
	}

	public void setGameDuration(int gameDuration) {
		this.gameDuration = gameDuration;
	}

	public String getWeatherConditions() {
		return weatherConditions;
	}

	public void setWeatherConditions(String weatherConditions) {
		this.weatherConditions = weatherConditions;
	}

	public int getOffsides() {
		return offsides;
	}

	public void setOffsides(int offsides) {
		this.offsides = offsides;
	}

	public int getMatchQuality() {
		return matchQuality;
	}

	public void setMatchQuality(int matchQuality) {
		this.matchQuality = matchQuality;
	}

	public int getMyPerformance() {
		return myPerformance;
	}

	public void setMyPerformance(int myPerformance) {
		this.myPerformance = myPerformance;
	}

	public String getVenue() {
		return venue;
	}

	public void setVenue(String venue) {
		this.venue = venue;
	}

	public String getAdditionalComments() {
		return additionalComments;
	}

	public void setAdditionalComments(String additionalComments) {
		this.additionalComments = additionalComments;
	}

	public int getDistanceCovered() {
		return distanceCovered;
	}

	public void setDistanceCovered(int distanceCovered) {
		this.distanceCovered = distanceCovered;
	}

}
