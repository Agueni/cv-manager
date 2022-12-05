<%--
  Created by IntelliJ IDEA.
  User: h17030347
  Date: 01/12/2022
  Time: 16:18
  To change this template use File | Settings | File Templates.
--%>
<%@ include file="/WEB-INF/jsp/header.jsp"%>

<c:url var="home" value="/aaa" />
<c:url var="app" value="/app.js" />


<div id="myApp">
    <div class="container">
        <nav class="navbar navbar-expand-lg navbar-light bg-light">
            <img src="img/img.png" class="logo img-thumbnail rounded-circle" alt="logo"></img>

            <a class="navbar-brand" href="/persons"> Consulter la liste des personnes </a>
            <a class="navbar-brand" href="/cvs"> Consulter la liste des CVs </a>
            <a class="navbar-brand" href="/create-person"> Creer une nouvelle personne </a>
            <a class="navbar-brand" href="/login">Se connecter </a>

        </nav>

    </div>
    <div class="container">
        <h2>Liste des personnes </h2>

        <table class="table">
            <tr>
                <th>Prenom</th>
                <th>Nom</th>
                <th>Email</th>
                <th>Site Web</th>
                <th>Anniversaire</th>
            </tr>
            <tr v-for="person in persons">
                <td>{{person.firstName}}</td>
                <td>{{person.lastName}}</td>
                <td>{{person.email}}</td>
                <td>{{person.webSite}}</td>
                <td>{{person.birthday}}</td>
            </tr>
        </table>

        <div>
            <a class="btn btn-primary btn-sm" href="app"> Retour </a>
        </div>

    </div>

</div>

<script src="${app}"></script>

<%@ include file="/WEB-INF/jsp/footer.jsp"%>
