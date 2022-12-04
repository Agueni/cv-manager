<%--
  Created by IntelliJ IDEA.
  User: h17030347
  Date: 04/12/2022
  Time: 11:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@ include file="/WEB-INF/jsp/header.jsp"%>
<c:url var="home" value="/aaa" />
<c:url var="app" value="/app.js" />


<div id="myApp">
    <div class="container">
        <h1> Gestion de CVs </h1>

        <nav class="navbar navbar-expand-lg navbar-light bg-light">

            <a class="navbar-brand" href="/persons"> Consulter la liste des personnes </a>
            <a class="navbar-brand" href="/cvs"> Consulter la liste des CVs </a>
            <a class="navbar-brand" href="/create-person"> Creer une nouvelle personnes </a>
            <a class="navbar-brand" href="/login">Se connecter </a>

        </nav>

        <h2>Connexion</h2>

        <form @submit="userAuthentification" >

            <div class="form-group">

                <label>Username :</label>
                <input path="userName" class="form-control" v-model="userName"cssErrorClass="form-control is-invalid" />
            </div>
            <div class="form-group">
                <label>Password :</label>
                <input path="password" class="form-control" v-model="password" cssErrorClass="form-control is-invalid" />
            </div>

            <div class="form-group">
                <button type="submit" class="btn btn-primary btn-sm">Enregister</button>
            </div>
        </form>
    </div>
</div>

<script src="${app}"></script>

<%@ include file="/WEB-INF/jsp/footer.jsp"%>