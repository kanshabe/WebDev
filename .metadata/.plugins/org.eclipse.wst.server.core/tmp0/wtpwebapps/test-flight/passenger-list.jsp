<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
 <title>flight search App</title>
</head>
<body>
 <center>
  <h1>Admin-Passenger Management Panel</h1>
        <h2>
         <a href="new">Add New Passengers</a>
         &nbsp;&nbsp;&nbsp;
         <a href="list">List All Passengers</a>
         
        </h2>
 </center>
    <div align="center">
        <table border="1" cellpadding="5">
            <caption><h2>List of Passengers</h2></caption>
            <tr>
                <th>First Name</th>
                <th>Last Name</th>
                <th>Age</th>
                <th>Gender</th>
                <th>Actions</th>
            </tr>
            <c:forEach var="passengers" items="${listPassengers}">
                <tr>
                    <td><c:out value="${passengers.firstName}" /></td>
                    <td><c:out value="${passengers.lastName}" /></td>
                    <td><c:out value="${passengers.age}" /></td>
                    <td><c:out value="${passengers.gender}" /></td>
                    <td>
                     <a href="edit?id=<c:out value='${passengers.id}' />">Edit</a>
                     &nbsp;&nbsp;&nbsp;&nbsp;
                     <a href="delete?id=<c:out value='${passengers.id}' />">Delete</a>                     
                    </td>
                </tr>
            </c:forEach>
        </table>
    </div> 
</body>
</html>