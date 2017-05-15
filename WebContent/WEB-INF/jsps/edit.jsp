<!DOCTYPE HTML>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Form Style 10</title>
<link href='http://fonts.googleapis.com/css?family=Bitter' rel='stylesheet' type='text/css'>
<link rel="stylesheet" type="text/css" href="css/globalCSS.css" />
</head>

<body>

<div class="form-style-10">
<h1>Edit Match Details!<span>Insert some catchy quote here!</span></h1>
<form method="post" action ="update" modelAttribute="game">
    <div class="section"><span>1</span>Date, Venue &amp; Weather</div>
    <div class="inner-wrap">
        <label>Match Id <input type = "text" name="matchId"  value ="${map.game.matchId}" readonly/></label>
        <label>Date <input type = "text" name="dateAndTimeOfGame"  value ="${map.game.dateAndTimeOfGame}"/></label>
        <label>Venue <input type = "text" name="venue" value ="${map.game.venue}"/></label>
        <label>Weather <input type = "text" name="weatherConditions" value ="${map.game.weatherConditions}"/></label>
    </div>

    <div class="section"><span>2</span>Game Type</div>
    <div class="inner-wrap">
        <label>Age Group <input type="text" name="ageGroup" value ="${map.game.ageGroup}" /></label>
        <label>Division <input type="text" name="division" value ="${map.game.division}"/></label>
        <label>Duration <input type="text" name="gameDuration" value ="${map.game.gameDuration}"/></label>
    </div>

    <div class="section"><span>3</span>Teams &amp; Result</div>
        <div class="inner-wrap">
        <label>Home <input type="text" name="home" value ="${map.game.home}"/></label>
        <label>Away <input type="text" name="away" value ="${map.game.away}"/></label>
        <label>Home Score <input type="text" name="homeScore" value ="${map.game.homeScore}"/></label>       
        <label>Away Score <input type="text" name="awayScore" value ="${map.game.awayScore}"/></label>       
    </div>
    
    <div class="section"><span>4</span>Disciplinary Matters</div>
        <div class="inner-wrap">
        <label>Free Kicks <input type="text" name="freeKicks" value ="${map.game.freeKicks}"/></label>
        <label>Offsides <input type="text" name="offsides" value ="${map.game.offsides}"/></label>
        <label>Penalties <input type="text" name="penalties" value ="${map.game.penalties}"/></label>
        <label>Yellow Cards <input type="text" name="yellows" value ="${map.game.yellows}"/></label>       
        <label>Red Cards <input type="text" name="reds" value ="${map.game.reds}"/></label>       
    </div>
    
    <div class="section"><span>5</span>Match Fee</div>
        <div class="inner-wrap">
        <label>Match Fee<input type="text" name="matchFee" value ="${map.game.matchFee}"/></label>      
    </div>
    
        <div class="section"><span>6</span>Match Analysis</div>
    <div class="inner-wrap">
        <label>Game Enjoyment (score from 0 to 10) <input type="text" name="matchQuality" value ="${map.game.matchQuality}"/></label>
        <label>Referee Performance (score from 0 to 10) <input type="text" name="myPerformance" value ="${map.game.myPerformance}"/></label>
        <label>Distance Covered (kilometres)<input type="text" name="distanceCovered" value ="${map.game.distanceCovered}"/></label>        
        <label>Additional Comments <textarea name="additionalComments">${map.game.additionalComments}</textarea></label>
    </div>
    
    
    <div class="button-section">
     <input type="submit" name="Submit Edited Match Record" />
    </div>
</form>
</div>