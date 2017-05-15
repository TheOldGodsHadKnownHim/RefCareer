<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link href='http://fonts.googleapis.com/css?family=Bitter' rel='stylesheet' type='text/css'>
<link rel="stylesheet" type="text/css" href="css/globalCSS.css" />
</head>
<body>

	<div class="form-style-10">

		<div class="section">
			<span>1</span>CAREER HISTORY - ${games.size()} games
		</div>
		<div class="inner-wrap">
		<table>
		<tr>
		<td><a href="${pageContext.request.contextPath}/games">View
					all games</a></td>
					<td><a
				href="${pageContext.request.contextPath}/recordGameDetails">Record
					latest fixture</a></td>				
		</tr>
		</table>	
		</div>
		
				<div class="section">
			<span>2</span>VIEW SPECIFIC AGE GROUP STATISTICS
		</div>
		<div class="inner-wrap">
		<table>
		<tr>	

<form method="get" action = "${pageContext.request.contextPath}/stats?">
	        
        	<div class="button-section">
     	<label>Choose an age group you would like to see statistics for
     <input type="number" name="ageStats"  id="ageStats"/></label>
          <input type="submit" />
    		</div>	
</form>		
		</tr>
		</table>	
		</div>

		<div class="section">
			<span>2</span>INTERESTING STATS
		</div>
		<div class="inner-wrap">
				
 			<label><b>Number of games where a red card was issued (${gamesWithReds})</b></label> 
 			<label><b>Number of games where more than one red card was issued (${gamesWithMultipleReds})</b></label>
			<label><b>Total Number of Red cards issued (${numReds})</b></label> 
			<label><b>Average reds per game (${averageReds})</b></label> 
			<label><b>Total Number of Yellow cards issued (${numYellows})</b></label>
			<label><b>Total Number of games with 5 or more Yellow cards issued (${gamesWithMultipleYellows})</b></label>  
			<label><b>Average Yellows per game (${averageYellows})</b></label> 
			<label><b>Total Number of frees awarded (${totalFrees})</b></label> 
			<label><b>Average frees per game(${averageFrees})</b></label> 
<%-- 			<label><b>Average offsides per game(${averageOffsides})</b></label> 
 --%>			<label><b>Total Number of penalties awarded (${totalPens})</b></label> 
			<label><b>Average penalties per game(${averagePens})</b></label> 
			<label><b>Total number of minutes on the field of play (${minutesRefereed})</b></label> 
			<label><b>Total goals scored (${totalGoals})</b></label> 
			<label><b>Average goals per game (${averageGoalsPerGame})</b></label>
			<label><b>Total kilometres covered (${totalCareerDistance})</b></label> 
			<label><b>Average kilometeres per game (${averageDistancePerGame})</b></label>
					
		</div>

		<div class="section">
			<span>3</span>Earnings
		</div>
		<div class="inner-wrap">
			<label><b>Total: €${totalEarnings}</b></label> <label><b>Average
					match fee: €${averageMatchFee}</b></label>
		</div>

		<div class="section">
			<span>4</span>Performance/Enjoyment
		</div>
		<div class="inner-wrap">
			<label><b>Average Performance Rating
					(${averagePerformanceRating})</b></label> <label><b>Average
					Enjoyment Rating (${averageEnjoymentRating})</b></label>
		</div>


	</div>

</body>
</html>