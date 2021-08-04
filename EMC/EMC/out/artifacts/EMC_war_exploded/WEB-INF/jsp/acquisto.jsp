<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%><%@taglib prefix="c"
                                         uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:include page="header.jsp">
    <jsp:param name="pageTitle" value="Carrello"/>
</jsp:include>


    <section>

        <form  action="Ordine" method="post">

            <input type="hidden" name="id" value="${utente.id}">
            <input type="hidden" name="prezzo" value="${carrello.getPrezzoTotEuro()}">

            Specifica un indirizzo di spedizione<input type="text" name="indirizzo">
            <input id="acquista" type="submit" value="Procedi" >

        </form>

    </section>

<%@include file="footer.html"%>
