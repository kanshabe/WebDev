<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
 <title>Passengers Management Application</title>
</head>
<body>
 <center>
  <h1>Passengers Management</h1>
        <h2>
         <a href="new">Add New Passenger</a>
         &nbsp;&nbsp;&nbsp;
         <a href="list">List All Passengers</a>
         
        </h2>
 </center>
    <div align="center">
  <c:if test="${passenger != null}">
   <form action="update" method="post">
        </c:if>
        <c:if test="${passenger == null}">
   <form action="insert" method="post">
        </c:if>
        <table border="1" cellpadding="5">
            <caption>
             <h2>
              <c:if test="${passenger != null}">
               Edit Passenger
              </c:if>
              <c:if test="${user == null}">
               Add New Passenger
              </c:if>
             </h2>
            </caption>
          <c:if test="${passengers != null}">
           <input type="hidden" name="id" value="<c:out value='${passenger.id}' />" />
          </c:if>            
            <tr>
                <th>First Name: </th>
                <td>
                 <input type="text" name="firstName" size="45"
                   value="<c:out value='${passenger.firstName}' />"
                  />
                </td>
            </tr>
            <tr>
                <th>Last Name: </th>
                <td>
                 <input type="text" name="lastName" size="45"
                   value="<c:out value='${passenger.lastName}' />"
                 />
                </td>
            </tr>
            <tr>
                <th>Age: </th>
                <td>
                 <input type="number" name="age" size="15"
                   value="<c:out value='${passenger.age}' />"
                 />
                </td>
                
                </tr>
            <tr>
                <th>Gender: </th>
                <td>
                 <input type="text" name="gender" size="15"
                   value="<c:out value='${passenger.gender}' />"
                 />
                </td>
            </tr>
            
           
            <tr>
             <td colspan="2" align="center">
              <input type="submit" value="Save" />
             </td>
            </tr>
        </table>
        
    </div> 
</body>
</html>