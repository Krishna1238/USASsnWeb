<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1><center><font color="green">All Citizen SSN Details</font></center></h1>

<c:choose>
  <c:when test="${!empty ssnList}">
    <table border="1" bgcolor="red">
     <tr>
     <th>Ssn Number</th>
     <th>First Name</th>
     <th>Last Name</th>
     <th>DOB</th>
     <th>Gender</th>
     <th>PhNo</th>
     <th>State</th>
     <th>Image</th>
     <th>Create Date</th>
     <th>Update Date</th>     
     </tr>
    <c:forEach var="allSsn" items="${ssnList}">
     
       <tr bgcolor="blue">
         <td><c:out value="${allSsn.ssnNumber}"></c:out>
       <td><c:out value="${allSsn.firstName}"/></td>
        <td><c:out value="${allSsn.lastName}"/></td>
        <td><c:out value="${allSsn.dob}"/></td>
        <td><c:out value="${allSsn.gender}"/></td>
        <td><c:out value="${allSsn.phNo }"/></td>
        <td><c:out value="${allSsn.state}"/></td>
        <td><c:out value="${allSsn.image}"/></td>
        <td><c:out value="${allSsn.createDate}"/>
        <td><c:out value="${allSsn.updateDate }"></c:out></td> 
       
       </tr>
    </c:forEach>
    
    
    
    
    </table>
    
    
  
  
  
  
  </c:when>



</c:choose>

</body>
</html>