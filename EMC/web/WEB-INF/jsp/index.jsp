<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%><%@taglib prefix="c"
                                         uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:include page="header.jsp">
    <jsp:param name="pageTitle" value="Home"/>
</jsp:include>


<div class="primo">

    <div class="cover"> <!-- Divisione del documento html -->
        <img class="cover_image" src="img/Loghi/intestaz png bianco.png" alt="Nature">
    </div>

    <div class="cards"> <!--  Contenitore dei tre articoli   -->

        <div class="demo">
            <figure class="figure">
                <img class="img1" src="img/Loghi/tasto ind png.png">
                <figcaption class="figcaption">
                    <h3>Sedi</h3>
                    <p>European Metals Corporation è formato da società e sedi del gruppo distribuite sia nel Paese italiano che in quelli esteri.</p>
                </figcaption>
            </figure>
        </div>    <!--  Primo articolo   -->

        <div class="demo">
            <figure class="figure">
                <img class="img1" src="img/Loghi/tasto qual png.png">
                <figcaption class="figcaption">
                    <h3>Qualità</h3>
                    <p>Con i suoi prodotti in acciaio e in altri metalli e i suoi sistemi di altissima qualità, il gruppo è uno dei maggiori
                        partner dell'industria automobilistica e degli elettrodomestici a livello europeo, nonchè dell'industria aeronautica
                        petrolifera e del gas a livello mondiale. European Metals Corporation è anche leader mondiale nella tecnologia dei deviatoi
                        e nel settore dei binari speciali, dell'acciaio da utensili e dei profilati speciali.</p>
                </figcaption>
            </figure>

        </div>   <!--  Secondo articolo   -->

        <div class="demo">
            <figure class="figure">
                <img class="img1" src="img/Loghi/tasto engin png.png">
                <figcaption class="figcaption">
                    <h3>Ingegneria</h3>
                    <p>Fornitura di particolari semilavorati o finiti secondo progetti di ingegneria strutturale e motoristica automotive.</p>
                </figcaption>
            </figure>

        </div>   <!--  Secondo articolo   -->
    </div>
</div>


<div class="card1">
    <img class="cover_image1" src="img/Loghi/intestaz png bianco.png" alt="Nature">
    <figure class="figure">
        <a class="click">Per maggiori informazioni vedi qui!<img class="img1" src="img/Loghi/tasto qual png.png"></a>
        <figcaption class="figcaption">
            <h3>Qualità</h3>
            <p>Con i suoi prodotti in acciaio e in altri metalli e i suoi sistemi di altissima qualità, il gruppo è uno dei maggiori
                partner dell'industria automobilistica e degli elettrodomestici a livello europeo, nonchè dell'industria aeronautica
                petrolifera e del gas a livello mondiale. European Metals Corporation è anche leader mondiale nella tecnologia dei deviatoi
                e nel settore dei binari speciali, dell'acciaio da utensili e dei profilati speciali.</p>
        </figcaption>
    </figure>
    <h1 class="fine">  La nostra forza e lavorare in gruppo, uniti piu che mai!     <br>    ⇓</h1>
</div>


<div class="card2">
    <h1 class="intro"> EMC: Materiali di prima qualita a cura dell'ambiente!</h1>
    <figure class="figure">
        <a class="click">Per maggiori informazioni vedi qui!<img class="img1" src="img/Loghi/tasto envir png.png"></a>

        <figcaption class="figcaption">
            <h3>Ambiente</h3>
            <p>Siamo un'azienda attenta all'ambiente: i processi produttivi sostenibili, la gestione responsabile delle risorse e l'utilizzo
                delle migliori tecnologie, anche dal punto di vista ambientale, fanno parte da decenni della nostra
                filosofia aziendale e di tutte le nostre attività. Su queste premessi si basa la nostra ambizione:
                essere, a lungo termine, i leader di mercato per la qualità dei nostri prodotti e servizi.</p>
        </figcaption>
    </figure>

</div>


<section class="banner">
    <div class="banner_image"></div>
    <div class="banner_copy">
        <div class="banner_copy_text">
            <h3>Soddisfazione del cliente</h3>
            <p>L'area commerciale della società, è abituata a pretendere la piena soddisfazione del Cliente. La politica Aziendale include anche
                il mantenimento di lotti nel magazzino prodotti finiti di prodotti sia normalizzati che speciali dedicati ai vari Clienti, gestendo
                così ordini pianificati su una durata annuale ma con consegne mensili.
            </p>
        </div>
    </div>
</section>

<div class="secondo">

    <div class="cards2 "> <!--  Contenitore dei tre articoli   -->

        <div class="demo2">
            <figure class="figure2">
                <img class="img1" src="img/Loghi/tasto envir png.png">
                <figcaption class="figcaption2">
                    <h3>Ambiente</h3>
                    <p>Siamo un'azienda attenta all'ambiente: i processi produttivi sostenibili, la gestione responsabile delle risorse e l'utilizzo
                        delle migliori tecnologie, anche dal punto di vista ambientale, fanno parte da decenni della nostra
                        filosofia aziendale e di tutte le nostre attività. Su queste premessi si basa la nostra ambizione:
                        essere, a lungo termine, i leader di mercato per la qualità dei nostri prodotti e servizi.</p>
                </figcaption>
            </figure>
        </div>    <!--  Primo articolo   -->

        <div class="demo2">
            <figure class="figure2">
                <img class="img1" src="img/Loghi/tasto safety png .png">
                <figcaption class="figcaption2">
                    <h3>Sicurezza</h3>
                    <p>Dal 2009 l'Azienda ha implementato e mantiene attivo, un sistema di gestione per la salute e sicurezza sul
                        lavoro (SGSSL) conforme ai requisiti della norma internazionale BS OHSAS 18001 "Occupational Health and Safety Assessment Series"
                        quale strumento per assicurare il rispetto delle norme cogenti, il miglioramento continuo delle prestazioni il soddisfacimento
                        dei principi enunciati nella propria politica per la salute e sicurezza sul lavoro.
                        Infine, le attrezzature, macchine e impianti forniti devono essere conformi alle normative vigenti e rispettare quanto riportato nella
                        Pratica Operativa Standard (P.O.S) POS S31.
                    </p>
                </figcaption>
            </figure>

        </div>   <!--  fdo articolo   -->


    </div>

</div>
<%@include file="footer.html"%>




