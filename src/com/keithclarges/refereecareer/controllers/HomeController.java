//package com.keithclarges.refereecareer.controllers;
//
//import java.util.List;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.RequestMapping;
//
//import com.keithclarges.refereecareer.model.Game;
//import com.keithclarges.refereecareer.service.GameService;
//
//@Controller
//public class HomeController {
//	
//	private GameService gameService;
//
//	@Autowired
//	public void setGameService(GameService gameService) {
//		this.gameService = gameService;
//	}
//	
//	@RequestMapping("/")
//	public String showHomePage (Model model){
//		
//		List<Game> gamesWithReds = gameService.getNumberOfGamesWithRedCards();
//		model.addAttribute("gamesWithReds", gamesWithReds);
//		
//		return "home";
//	}
//
//}
