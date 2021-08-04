<%@ page language="java" contentType="text/html; charset=UTF-8"
		 pageEncoding="UTF-8"%><%@taglib prefix="c"
										 uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:include page="header.jsp">
	<jsp:param name="pageTitle" value="${categoria.nome}"/>
</jsp:include>
<section>
	<c:if test="${!utente.admin}">
		<h1>${categoria.nome}</h1>
	</c:if>
	<c:if test="${utente.admin}">
		<form action="AdminCategoria" method="post">
			<h1>${categoria.nome}
				<input type="hidden" name="id" value="${categoria.id}">
				<input type="submit" name="modifica" value="Modifica">
				<input type="submit" name="rimuovi" value="Rimuovi">
			</h1>
		</form>
	</c:if>
	<p>${categoria.descrizione}</p>

	<grid>
		<c:forEach items="${prodotti}" var="prodotto">
		<div col="1/3">
			<a href="Prodotto?id=${prodotto.id}"><img src="img/Materiali/${prodotto.id}.png"></a>
		</div>
		<div col="2/3">
			<h3>
				<a href="Prodotto?id=${prodotto.id}">${prodotto.nome}</a>
			</h3>
			<p>${prodotto.descrizione}</p>
			<h4>Prezzo: ${prodotto.prezzoEuro} &euro;</h4>
		</div>
		</c:forEach>
		<c:if test="${empty prodotti}">
		<div col="1/1">Nessun prodotto nella categoria.</div>
		</c:if>

		</grid>
</section>
<%@include file="footer.html"%>