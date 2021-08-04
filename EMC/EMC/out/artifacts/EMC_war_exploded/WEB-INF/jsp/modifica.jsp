<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@taglib prefix="c"
          uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="header.jsp">
    <jsp:param name="pageTitle" value="Registrazione utente"/>
</jsp:include>
<section>
    <h1>Modifica utente</h1>
    <h5>${notifica}</h5>
    <form name="registrazione" action="ModificaServlet" method="post">
        <input type="hidden" name="id" value="${id}">
        <label>Username (almeno 6 caratteri, solo lettere e numeri, che non sia utilizzato da altri utenti)</label>
        <input type="text" name="username" oninput="validaUsername()">
        <label>Nome (solo lettere e spazi)</label>
        <input type="text" name="nome" oninput="validaNome()">
        <label>Email (Diversa da quella degli altri utenti)</label>
        <input type="text" name="email" oninput="validaEmail()">
        <input id="registrami" type="submit" value="Modifica" disabled><span id="registramimessaggio"></span>
    </form>
</section>
<script>
    var borderOk = '2px solid #080';
    var borderNo = '2px solid #f00';
    var usernameOk = false;

    var nomeOk = false;
    var emailOk = false;

    function validaUsername() {
        var input = document.forms['registrazione']['username'];
        if (input.value.length >= 6 && input.value.match(/^[0-9a-zA-Z]+$/)) {
            // verifica se esiste un utente con lo stesso username
            var xmlHttpReq = new XMLHttpRequest();
            xmlHttpReq.onreadystatechange = function () {
                if (this.readyState == 4 && this.status == 200
                    && this.responseText == '<ok/>') {
                    usernameOk = true;
                    input.style.border = borderOk;
                } else {
                    input.style.border = borderNo;
                    usernameOk = false;
                }
                cambiaStatoRegistrami();
            }
            xmlHttpReq.open("GET", "VerificaUsername?username="
                + encodeURIComponent(input.value), true);
            xmlHttpReq.send();
        } else {
            input.style.border = borderNo;
            usernameOk = false;
            cambiaStatoRegistrami();
        }
    }


    function validaNome() {
        var input = document.forms['registrazione']['nome'];
        if (input.value.trim().length > 0
            && input.value.match(/^[ a-zA-Z\u00C0-\u00ff]+$/)) {
            input.style.border = borderOk;
            nomeOk = true;
        } else {
            input.style.border = borderNo;
            nomeOk = false;
        }
        cambiaStatoRegistrami();
    }

    function validaEmail() {
        var input = document.forms['registrazione']['email'];
        if (input.value.match(/^\w+([\.-]?\w+)@\w+([\.-]?\w+)(\.\w+)+$/)) {
            input.style.border = borderOk;
            emailOk = true;
        } else {
            input.style.border = borderNo;
            emailOk = false;
        }
        cambiaStatoRegistrami();
    }

    function cambiaStatoRegistrami() {
        if (usernameOk && nomeOk && emailOk) {
            document.getElementById('registrami').disabled = false;
            document.getElementById('registramimessaggio').innerHTML = '';
        } else {
            document.getElementById('registrami').disabled = true;
            document.getElementById('registramimessaggio').innerHTML = 'Verifica che tutti i campi siano in verde.';
        }
    }
</script>
<%@include file="footer.html" %>