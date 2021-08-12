<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@taglib prefix="c"
          uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:include page="header.jsp">
    <jsp:param name="pageTitle" value="Aggiungi prodotto"/>
</jsp:include>
<section>
    <h1>Aggiungi prodotto</h1>
    <h5>${notifica}</h5>
    <c:if test="${param.rimuovi == null}">
        <form action="AdminProdotto" method="post">
            <input type="hidden" name="id" value="${prodotto.id}">
            <label>Categorie</label>
            <c:forEach items="${categorie}" var="categoria">
                <input type="radio" name="categorie" value="${categoria.id}"
                       <c:if test="${prodotto.idcategoria.stream().anyMatch(c -> c.id == categoria.id).orElse(false)}">checked</c:if>><label>${categoria.nome}</label>
            </c:forEach>
            <label>Nome</label>
            <input type="text" name="nome" value="${prodotto.nome}">
            <label>Descrizione</label>
            <textarea name="descrizione">${prodotto.descrizione}</textarea>
            <label>Prezzo (cent):</label>
            <input type="number" name="prezzoCent" value="${prodotto.prezzoBase}">
            <label>Iva</label>
            <input type="number" name="iva" value="${prodotto.iva}">


            <input type="submit" value="Aggiungi">
            <c:if test="${prodotto != null}">
                <input type="submit" name="rimuovi" value="Rimuovi">
            </c:if>
        </form>
    </c:if>
</section>
<%@include file="footer.html" %>
