package com.keithclarges.refereecareer.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.keithclarges.refereecareer.model.Game;
import com.keithclarges.refereecareer.service.GameService;

@Controller
public class GameController {

	private GameService gameService;

	@Autowired
	public void setGameService(GameService gameService) {
		this.gameService = gameService;
	}
	
	@RequestMapping("/")
	public String showHomePage (Model model){
		
		List<Game> games = gameService.getGamesFromMyRefereeCareerDatabase();
		model.addAttribute("games", games);
		
		int gamesWithReds = gameService.wasThereAnyReds();
		model.addAttribute("gamesWithReds", gamesWithReds);
		
		double averageReds = gameService.getAverageReds();
		model.addAttribute("averageReds", averageReds);
		
		int numReds = gameService.getTotalReds();
		model.addAttribute("numReds", numReds);
		
		int numYellows = gameService.getCareerYellows();
		model.addAttribute("numYellows", numYellows);
		
		int minutesRefereed = gameService.getCareerMins();
		model.addAttribute("minutesRefereed", minutesRefereed);
		
		double averageYellows = gameService.getAverageYellows();
		model.addAttribute("averageYellows", averageYellows);
		
		double averageFrees = gameService.getAverageFrees();
		model.addAttribute("averageFrees", averageFrees);
		
		int totalFrees = gameService.getCareerFrees();
		model.addAttribute("totalFrees", totalFrees);
		
		double averagePens = gameService.getAveragePenalties();
		model.addAttribute("averagePens", averagePens);
		
		double totalPens = gameService.getCareerPenalties();
		model.addAttribute("totalPens", totalPens);
		
		int totalGoals = gameService.getTotalGoals();
		model.addAttribute("totalGoals", totalGoals);
		
		double averageGoalsPerGame = gameService.getAverageGoalsPerGame();
		model.addAttribute("averageGoalsPerGame", averageGoalsPerGame);
		
		int totalEarnings = gameService.getTotalEarnings();
		model.addAttribute("totalEarnings", totalEarnings);
		
		double averageMatchFee = gameService.getAverageMatchFee();
		model.addAttribute("averageMatchFee", averageMatchFee);
		
		double averagePerformanceRating = gameService.getAveragePerformanceRating();
		model.addAttribute("averagePerformanceRating", averagePerformanceRating);
		
		double averageEnjoymentRating = gameService.getAverageEnjoymentRating();
		model.addAttribute("averageEnjoymentRating", averageEnjoymentRating);
		
		int gamesWithMultipleReds = gameService.getGamesWithMultipleReds();
		model.addAttribute("gamesWithMultipleReds", gamesWithMultipleReds);
		
		int gamesWithMultipleYellows = gameService.getGamesWithMultipleYellows();
		model.addAttribute("gamesWithMultipleYellows", gamesWithMultipleYellows);
		
		double averageDistancePerGame = gameService.getAverageDistance();
		model.addAttribute("averageDistancePerGame", averageDistancePerGame);
		
		double totalCareerDistance = gameService.getTotalDistance();
		model.addAttribute("totalCareerDistance", totalCareerDistance);
		
		//model.addAttribute("ageStats", ageStats);

		/*
		 * To add
		 * 
		 * gamesWithMultipleReds
		 * gamesWithMultipleYellows
		 * sum11Games
		 * sum12Games
		 * sum13Games
		 * sum14Games
		 * sum15Games
		 * sum16Games
		 * sum17Games
		 * sum18Games
		 * sum19Games
		 */
			
		return "home";
	}

	@RequestMapping("/games")
	public String showGames(Model model) {

		List<Game> games = gameService.getGamesFromMyRefereeCareerDatabase();

		model.addAttribute("games", games);

		return "games";
	}
	
//	@RequestMapping("/reds")
//	public String showReds(Model model) {
//		List<Game> gamesWithReds = gameService.getNumberOfGamesWithRedCards();
//		model.addAttribute("gamesWithReds", gamesWithReds);
//		return "home";	
//		}

	@RequestMapping("/recordGameDetails")
	public String recordGameDetails() {
		// return the name of the view
		return "recordGameDetails";
	}

	@RequestMapping(value ="/doRecordGameDetails", method = RequestMethod.POST)
	public String doRecordGameDetails(Model model, @Valid Game game, BindingResult bindingResult) {
		
		if (bindingResult.hasErrors()){
			System.out.println("Form not validated");
			
			List<ObjectError> allErrors = bindingResult.getAllErrors();
			
			for (ObjectError errors : allErrors){
				System.out.println(errors.getDefaultMessage());
				
			}
		}else {
			System.out.println("Form validated");
		}
		gameService.recordGame(game);
		return "redirect:/games";
	}
	
	
	// Returns the edit view.
	@RequestMapping("/edit")
	public ModelAndView editUser(@RequestParam int id,
			@ModelAttribute Game game) {

		game = gameService.getGame(id);

		Map<String, Object> map = new HashMap<String, Object>();
		map.put("game", game);

		return new ModelAndView("edit", "map", map);
	}
	
	// Returns the edit view.
	@RequestMapping(value = "/stats", method = RequestMethod.GET)
	public String getAgeSpecificStats(@RequestParam String ageStats,
		Model model) {

		model = gameService.getAgeSpecificStats(ageStats, model);

		return "stats";
	}
	
	@RequestMapping("/delete")
	public String deleteGame(@RequestParam int id) {
		System.out.println("Game " + id + " has been deleted");
		gameService.deleteGame(id);
		return "redirect:/games";
	}
	
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public String updateReferee(@ModelAttribute Game game) {
		gameService.updateGame(game);
		return "redirect:/games";
	}

	@RequestMapping(value = "/test", method = RequestMethod.GET)
	// can be plenty of parameters here. @RequestParam tells that it is
	// expecting a request parameter in the url with the value id
	public String showTest(Model model, @RequestParam("id") String id) {
		System.out.println("Id is " + id);
		return "hello";
	}
}
