

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@include file="header.jsp" %>




        <% request.getAttribute("Editobj"); %>
        <div class="col-md-offset-3">
        <form action="AddController" class="col-md-7">
            ID: <input type="text" name="ID" value="${Editobj.getId()}" class="form-control"/> <br>
            FirstName: <input type="text" name="FirstName" value="${Editobj.getFirstname()}" class="form-control"/><br>
            LastName: <input type="text" name="LastName" value="${Editobj.getLastname()}" class="form-control"/><br>
            GPA: <input type="text" name="GPA" value="${Editobj.getGPA()}" class="form-control"/><br>
            <input type="text" value="${Editobj.getAutoID()}" name="AutoID"class="form-control"/>
            <button type="submit" value="submit" class="btn btn-primary"/> Submit  </button>
        </form>
        </div>




 <%@include file="footer.jsp" %>