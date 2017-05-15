/**
 * 
 */
'use strict'

App.controller('GameController', ['$scope', 'GameService', function($scope, GameService){
	var self=this;
	self.game={matchId:null,dateAndTimeOfGame:'',home:'',away:'',homeScore:'',awayScore:'',ageGroup:'',division:'',
			freeKicks:'',penalties:'',matchFee:'',gameDuration:'',weatherConditions:'',assistants:'',matchQuality:'',
			myPerformance:'',venue:'',additionalComments:'',yellows:'',reds:''};
	self.games=[];
	
	self.getAllGamesRefereed=function(){
		gameService.getAllGamesRefereed()
		.then(
		function(d){
			self.games=d;
		},
		function(errResponse){
			console.error('Error while retrieving games');
		}
		);
	};
	
	self.addGame=function(game){
		GameService.addGame(game)
		.then(
			self.getAllGamesRefereed,
			function(errResponse){
				console.error('Error while adding game');
			}
		);
	};

}])