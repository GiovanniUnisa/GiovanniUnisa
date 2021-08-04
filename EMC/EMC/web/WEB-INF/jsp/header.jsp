<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%><%@taglib prefix="c"
                                         uri="http://java.sun.com/jsp/jstl/core"%><!DOCTYPE html>
<html>
<head>
    <title>EMC ${param.pageTitle}</title>
    <style type = "text/css">
        <%@include file="/style.css" %>
        <%@include file="/media.css" %>
    </style>
    <script src="ricerca.js"></script>
    <meta name="viewport" content="width=device-width", initial-scale="1.0">



</head>
<body>

<div class="nav">


       <a class="a" href="./" ><img class="img" src="img/Loghi/Logo1.png"  /></a>


    <label for="toggle" id="funziona">&#9776</label>
    <input type="checkbox" id="toggle">


    <div class="menu">

        <ul>

            <li>
                <form action="Ricerca" method="post">
                    <input type="text" name="ric" list="ricerca-datalist" placeholder="Ricerca" onkeyup="ricerca(this.value)" value="<c:out value="${param.ric}" />">
                    <datalist id="ricerca-datalist"></datalist>
                </form>
            </li>



            <li><a class="a" href="ChiSiamo">Chi siamo</a></li>
            <li><a class="a" href="Sedi">Sedi</a></li>
            <li><a class="a" >Prodotti</a>
                <ul>

                    <c:forEach items="${categorie}" var="categoria">
                        <li>
                            <a class="a" href="Categoria?id=<c:out value="${categoria.id}"/>"><c:out
                                    value="${categoria.nome}" /></a></li>
                    </c:forEach>

                </ul>
            </li>


            <li><a class="a" href="About">About</a></li>
        </ul>

        <g>
            <li class="login1"><a href="Carrello" target="_self"><img class="img" src="img/Loghi/Carrello1.png" title="Carrello" alt="Carrello"/></a></li>
            <li class="login">
                <c:choose>
                    <c:when test="${utente == null}">
                        <a class="a" ><img class="img" src="img/Loghi/Omino1.png" title="Login" alt="Login"/></a>
                        <ul>
                            <li>
                                <a class="a" >
                                    <form action="Login" method="post">
                                        <input class="accesso" type="text" name="username" placeholder="Username"><br>
                                        <input class="accesso" type="password" name="password" placeholder="Password"><br>
                                        <input class="accesso" type="submit" value="Login">
                                    </form>
                                </a>
                            </li>
                            <li><a class="a" href="RegistrazioneForm">Registrazione</a></li>

                        </ul>


                    </c:when>
                    <c:otherwise>
                        <a class="utente">${utente.admin ? 'Admin' : 'Account'}</a>
                        <ul class="utente1">
                            <a class="a"><c:if test="${utente.admin}"></a>
                            <li><br><br><br><a class="a" href="AdminCategoria">Aggiungi Categoria</a></li>
                            <li><a class="a" href="AdminProdotto">Aggiungi Prodotto</a></li>
                            <li><a class="a" href="AdminUtenti">Utenti</a></li></c:if>
                            <li><a class="a" href="Profilo?id=<c:out value="${utente.id}"/>">Profilo</a></li>
                            <li><a class="a" href="MieiOrdini?id=<c:out value="${utente.id}"/>&username=<c:out value="${utente.username}>"/>">I Miei Ordini</a></li>
                            <li>
                                <a class="a">
                                    <form action="Logout">
                                        <input type="submit" value="Logout">
                                    </form>
                                </a>
                            </li>
                        </ul>



                    </c:otherwise>





                </c:choose>
            </li>
        </g>

    </div>

</div>