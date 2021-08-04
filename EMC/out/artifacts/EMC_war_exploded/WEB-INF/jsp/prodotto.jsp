<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%><%@taglib prefix="c"
	uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:include page="header.jsp">
	<jsp:param name="pageTitle" value="${prodotto.nome}"/>
</jsp:include>
	<section>
		<grid>

				<div col="1/3">
					<img src="img/Materiali/${prodotto.id}.png"></a>
				</div>

		
			<div col="1/3">
				<c:if test="${utente.admin}">
					<form action="AdminProdottoModifica" method="post">
						<input type="hidden" name="id" value="${prodotto.id}">
						<input type="submit" value="Modifica">
						<input type="submit" name="rimuovi" value="Rimuovi">
					</form>
				</c:if>

				<h4>Prezzo: ${prodotto.prezzoEuro} &euro;</h4>
				<form action="Carrello" method="post">
					<label>Quantità:</label>
					<select name="addNum">
						<c:forEach begin="1" end="5" varStatus="loop">
							<option value="${loop.index}">${loop.index}</option>
						</c:forEach>
					</select>
					<input type="hidden" name="prodId" value="${prodotto.id}">
					<input type="submit" value="Carrello">
				</form>
			</div>
	
		</grid>
	</section>
<%@include file="footer.html"%>
