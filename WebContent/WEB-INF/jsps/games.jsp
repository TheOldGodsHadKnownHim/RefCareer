<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="css/globalCSS.css" />
</head>

<body>
<div class="form-style-10">
    <div class="section">
    <h1>
    <a href="/MyRefereeCareer/">Home</a>
    <a href="/MyRefereeCareer/recordGameDetails">Add New Fixture</a>
    </h1>
    </div>
    <div class="section"><h1>My Refereeing Career</h1>
    </div>
    
    <div class="inner-wrap"> 
    <center>
		<h1>
			<b>Matches Officiated (${games.size()})</b>
		</h1>
		
			<c:forEach var="game" items="${games}">
			
			
	<div class="form-style-10">
    <div class="section"><span>${game.matchId}</span>${game.home} V ${game.away}</div>
    <div class="inner-wrap">
        <label>Date: ${game.dateAndTimeOfGame}</br></label>
        <label>Venue: ${game.venue}</br></label>
        <label>Result: ${game.home} ${game.homeScore} - ${game.awayScore} ${game.away}</label>
        <label>Age Group: ${game.ageGroup}</label>
        <label>Division: ${game.division}</label>
        <label>Match Duration: ${game.gameDuration} mins</label>
        <label>Frees: ${game.freeKicks} Free Kicks, ${game.penalties} Penalties</label>
        <label>Offsides: ${game.offsides}</label>
        <label>Discipline: Yellows: ${game.yellows}, Reds: ${game.reds}</label>
        <label>Weather: ${game.weatherConditions}</label>
        <label>Match Fee: ${game.matchFee} euros</label>
        <label>Game Enjoyment: ${game.matchQuality}</label>
        <label>My Performance: ${game.myPerformance}</label>
        <label>Distance Covered (km): ${game.distanceCovered}</label>
        <label>Comments: ${game.additionalComments}</label>
        <label><a href="edit?id=${game.matchId}">Edit Game Details</a></label>
        <label><a href="delete?id=${game.matchId}">Delete Game</a></label>
    </div>
    </div>
			</c:forEach>


	</center>
    </div>
    </div>
</body>
</html>

<%-- <p><c:out value="${game}"></c:out></p>
 --%>