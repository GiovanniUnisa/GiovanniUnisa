<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%><%@taglib prefix="c"
                                         uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:include page="header.jsp">
    <jsp:param name="pageTitle" value="Home"/>
</jsp:include>



<section>
    <h1>Costruisci pensando all'ambiente! </h1>


    <grid>
        <div col="1/3">
            <img src="img/Loghi/442.png">
        </div>

        <div col="2/3">
            <h4>
                European Metals Corporation da sempre offre materiali e servizi di qualita per ogni cliente, per soddisfare qualsiasi tipo di richiesta
            </h4>

            <h4>
                Visita il nostro sito e vieni a trovarci nei nostri punti vendita autorizzati!
            </h4>

            <h4>
                E-mail: EMC@contatti.com
            </h4>

            <h4>
                Numero Telefonico: 081 888 88 88
            </h4>
        </div>
    </grid>
</section>

<%@include file="footer.html"%>