<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%><%@taglib prefix="c"
                                         uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:include page="header.jsp">
    <jsp:param name="pageTitle" value="${utente.username}"/>
</jsp:include>
<section>

    <h1>${utente.username}</h1>

    <table>
        <thead>
        <tr>
            <th>Id di spedizione</th>
            <th>Prezzo </th>
            <th>Indirizzo dove verra spedito l'ordine</th>
        </tr>
        </thead>

        <tbody>
        <c:forEach items="${ordini}" var="ordine">
            <tr>
                <td >${ordine.id}</td>
                <td>${ordine.prezzotot}</td>
                <td>${ordine.indirizzo}</td>

            </tr>
        </c:forEach>
        </tbody>
    </table>
</section>
<%@include file="footer.html"%>