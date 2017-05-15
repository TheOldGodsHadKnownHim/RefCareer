package com.keithclarges.refereecareer.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.keithclarges.refereecareer.dao.GameDao;
import com.keithclarges.refereecareer.model.Game;

//class that provides the service of co-ordinating DAOs
@Service("gameService")
public class GameService {

	private GameDao gameDao;

	@Autowired
	public void setGameDao(GameDao gameDao) {
		this.gameDao = gameDao;
	}

	public List<Game> getGamesFromMyRefereeCareerDatabase() {

		return gameDao.getRefereeCareerDetails();

	}

	public void recordGame(Game game) {
		gameDao.insertGame(game);
	}

	public Game getGame(int id) {
		return gameDao.getGameById(id);
	}

	public void deleteGame(int id) {
		gameDao.deleteMatchBasedOnMatchId(id);
	}

	public void updateGame(Game game) {
		gameDao.updateGame(game);
	}

	public int getTotalReds() {
		return gameDao.getCareerReds();
	}

	public double getAverageReds() {
		return gameDao.getAverageReds();
	}

	public double getAverageYellows() {
		return gameDao.getAverageYellows();
	}

	public int wasThereAnyReds() {
		return gameDao.getGamesWithAtLeastOneRedCard();
	}

	public int getCareerYellows() {
		return gameDao.getCareerYellows();
	}
	
	public int getCareerMins() {
		return gameDao.getCareerMinutesRefereed();
	}

	public double getAverageFrees() {
		return gameDao.getAverageFrees();
	}

	public double getAveragePenalties() {
		return gameDao.getAveragePenalties();
	}

	public int getCareerFrees() {
		return gameDao.getCareerFrees();
	}

	public int getCareerPenalties() {
		return gameDao.getCareerPenalties();
	}
	
	public int getTotalGoals(){
		return gameDao.getTotalGoals();
	}
	public double getAverageGoalsPerGame(){
		return gameDao.getAverageGoalsPerGame();
	}
	public int getTotalEarnings(){
		return gameDao.getTotalEarnings();
	}
	public double getAverageMatchFee(){
		return gameDao.getAverageMatchFee();
	}
	public double getAveragePerformanceRating(){
		return gameDao.getAveragePerformanceRating();
	}
	public double getAverageEnjoymentRating(){
		return gameDao.getAverageEnjoymentRating();
	}
	public int getGamesWithMultipleYellows(){
		return gameDao.getMultipleYellows();
	}
	public int getGamesWithMultipleReds(){
		return gameDao.getMultipleReds();
	}
	public double getAverageDistance(){
		return gameDao.getAverageDistanceCovered();
	}
	public double getTotalDistance(){
		return gameDao.getTotalDistanceCovered();
	}
	
	public Model getAgeSpecificStats(String ageStats, Model model){
		return gameDao.getAgeSpecificStats(ageStats, model);

	}
}
