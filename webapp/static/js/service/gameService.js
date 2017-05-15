'use strict'

App.factory('GameService', ['$http', '$q', function($http,$q){
	
	return {
		
		getAllGamesRefereed: function(){
			
			return $http.get('http://localhost:8080/MyRefereeCareer/games')
			.then(
			function(response){
		return response.data;
			},
			function(errResponse){
				console.error('Error retrieving games');
				return $q.reject(errResponse);
			}
			);
	},
	
	addGame: function(game){
        return $http.post('http://localhost:8080/MyRefereeCareer/doRecordGameDetails', game)
                .then(
                        function(response){
                            return response.data;
                        }, 
                        function(errResponse){
                            console.error('Error while adding game');
                            return $q.reject(errResponse);
                        }
                );
    }
    
    };
 
}]);