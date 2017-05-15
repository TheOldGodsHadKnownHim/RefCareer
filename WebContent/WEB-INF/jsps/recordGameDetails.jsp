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

<h1>Record Match Details!<span><a href="/MyRefereeCareer/">Back To Home</a></span></h1>
<form method="post" action = "${pageContext.request.contextPath}/doRecordGameDetails">
    <div class="section"><span>1</span>Date, Venue &amp; Weather</div>
    <div class="inner-wrap">
<!--     pattern="^\d{4}\-(0?[1-9]|1[012])\-(0?[1-9]|[12][0-9]|3[01])$"
 -->        <label>Date <input type="text" name="dateAndTimeOfGame"  maxlength="10"  required/></label>
        <label>Venue <input type = "text" name="venue" maxlength="50" /></label>
        <label>Weather <input type = "text" name="weatherConditions" maxlength="50"/></label>
    </div>

    <div class="section"><span>2</span>Game Type</div>
    <div class="inner-wrap">
        <label>Age Group <input type="number" name="ageGroup"  maxlength="2" required/></label>
        <label>Competition <input type="text" name="division"  maxlength="20" required/></label>
        <label>Game Duration <input type="number" name="gameDuration"  required/></label>
    </div>

    <div class="section"><span>3</span>Teams &amp; Result</div>
        <div class="inner-wrap">
        <label>Home <input type="text" name="home" maxlength="50" required/></label>
        <label>Away <input type="text" name="away" maxlength="50" required/></label>
        <label>Home Score <input type="number" name="homeScore" required/></label>       
        <label>Away Score <input type="number" name="awayScore" required/></label>       
    </div>
    
    <div class="section"><span>4</span>Disciplinary Matters</div>
        <div class="inner-wrap">
        <label>Free Kicks <input type="number" name="freeKicks" required/></label>
        <label>Offsides <input type="text" name="offsides" /></label>
        <label>Penalties <input type="number" name="penalties" required/></label>
        <label>Yellow Cards <input type="number" name="yellows" required/></label>       
        <label>Red Cards <input type="number" name="reds" required/></label>       
    </div>
    
    <div class="section"><span>5</span>Match Fee</div>
        <div class="inner-wrap">
        <label>Match Fee<input type="number" name="matchFee" required/></label>      
    </div>
    
        <div class="section"><span>6</span>Match Analysis</div>
    <div class="inner-wrap">
        <label>Game Enjoyment (score from 0 to 10) <input type="number" name="matchQuality" required/></label>
        <label>Referee Performance (score from 0 to 10) <input type="number" name="myPerformance" required/></label>
        <label>Distance Covered (kilometres - [use rounding]) <input type="number" name="distanceCovered" required/></label>
        <label>Additional Comments <textarea name="additionalComments"></textarea></label>
    </div>
    
    
    <div class="button-section">
     <input type="submit" name="Submit Match Record" />
    </div>
</form>
</div>
</body>