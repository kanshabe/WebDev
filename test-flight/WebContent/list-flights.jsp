<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.*, com.controller.FlightController" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>



<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Flight Booking App. for Flyaway.</title>

<style type="text/css">

html, body{
	margin-left:15px; margin-right:15px; 
	padding:0px; 
	font-family:Verdana, Arial, Helvetica, sans-serif;
}

table {   
	border-collapse:collapse;
	border-bottom:1px solid gray;
	font-family: Tahoma,Verdana,Segoe,sans-serif;
	width:72%;
}
 
th {
	border-bottom:1px solid gray;
	background:none repeat scroll 0 0 #1abc9c;
	padding:10px;
	color: #FFFFFF;
}

tr {
	border-top:1px solid gray;
	text-align:center;	
}
 
tr:nth-child(even) {background: #FFFFFF}
tr:nth-child(odd) {background: #BBBBBB}	
 
#wrapper {width: 100%; margin-top: 0px; }
#header {width: 72%; background: #1abc9c; margin-top: 0px; padding:15px 0px 15px 0px;}
#header h2 {width: 100%; margin:auto; color: #FFFFFF;}
#container {width: 100%; margin:auto}
#container h3 {color: #000;}
#container #content {margin-top: 20px;}

.seacrh-flight-button {
	border: 1px solid #666; 
	border-radius: 5px; 
	padding: 4px; 
	font-size: 12px;
	font-weight: bold;
	width: 120px; 
	padding: 5px 10px; 
	
	margin-bottom: 15px;
	background: #cccccc;
}



</style>

</head>



<body>

<div id="wrapper">
 <div id="header">
    <h2> Flyaway Booking app.</h2>
 </div>
</div>

<div id="container">
	<div id="content">
			
		<!--  add a search box -->
		<form action="FlightController" method="GET">
		
			<input type="hidden" name="command" value="SEARCH" />
			
        	Search Flight: <input type="text" name="theSearchName" />
                
         	<input type="submit" value="Search" class="seacrh-flight-button" />
            
        </form>	   
            
	   <table>
			<tr>
				<th> From </th>
				<th> To </th>
				<th> Seat </th>
				<th> Flight time </th>
				<th> Flight date </th>
				<th> Flight price </th>
				<th> Flight type </th>
				<th> Book Flight </th>
			</tr>
			
			<c:forEach var="tempFlight" items = "${FLIGHT_LIST}">
			
			   <!-- set up a link for each flight -->
				<c:url var="tempLink" value="FlightController">
					<c:param name="command" value="LOAD" />
					<c:param name="flightId" value="${tempFlight.id}" />
				</c:url>
					
				<tr>
					<td>${tempFlight.from}</td>
					<td>${tempFlight.to}</td>
					<td>${tempFlight.seat}</td>
					<td>${tempFlight.flightTime}</td>
					<td>${tempFlight.flightDate}</td>
					<td>${tempFlight.flightPrice}</td>
					<td>${tempFlight.flightType}</td>
					<td>
					   <a href="${tempLink}"
						onclick="if (!(confirm('Are you sure you want to book this flight?'))) return false">
						Get Ticket</a>
					</td>
				</tr>
			</c:forEach>
			
		</table>
	</div>
</div>

</body>
</html>