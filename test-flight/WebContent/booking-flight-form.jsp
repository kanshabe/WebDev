<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.*, com.controller.*" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<% 
	
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Booking the flight ticket.</title>
<link type="text/css" rel="stylesheet" href="css/NewFile1.css">
	<link type="text/css" rel="stylesheet" href="css/search-Flight-style.css">	
</head>
<body>
    <div id="wrapper">
		<div id="header">
			<h2>Flyaway Booking app.</h2>
		</div>
	</div>
		
		<div id="container">
			<h3>Book Flight</h3>
	    <form action="FlightController" method="GET">
	    
	    <input type="hidden" name="command" value="UPDATE" />
	    
	    <input type="hidden" name="flightId" value="${THE_FLIGHT.id}" />
		
			<table>
				<tbody>
					<tr>
						<td><label>First name:</label></td>
						<td><input type="text" name="firstName" /></td>
					</tr>

					<tr>
						<td><label>Last name:</label></td>
						<td><input type="text" name="lastName" /></td>
					</tr>
					<tr>
						<td><label>Gender:</label></td>
						<td><input type="text" name="gender"  /></td>
					</tr>
					<tr>
						<td><label>Seat Number:</label></td>
						<td><input type="text" name="seatNumber" /></td>
					</tr>
					
					<tr>
						<td><label></label></td>
						<td><input type="submit" value="Issue Ticket" class="save" /></td>
					</tr>
					
				</tbody>
			</table>
		
		
		</form>
	    
	    <div style="clear: both;"></div>
			
		<p>
			<a href="FlightController"><b>Back</b></a>
		</p>
	</div>
</body>
</html>