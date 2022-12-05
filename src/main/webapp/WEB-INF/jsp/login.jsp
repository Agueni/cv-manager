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
<c:url var="login" value="/login.js" />


<div id="login">
    <div class="container">
        <nav class="navbar navbar-expand-lg navbar-light bg-light">
            <img src="img/img.png" class="logo img-thumbnail rounded-circle" alt="logo"></img>

            <a class="navbar-brand" href="/persons"> Consulter la liste des personnes </a>
            <a class="navbar-brand" href="/cvs"> Consulter la liste des CVs </a>
            <a class="navbar-brand" href="/create-person"> Creer une nouvelle personnes </a>
            <a class="navbar-brand" href="/login">Se connecter </a>

        </nav>

        <h2>Connexion</h2>

        <form @submit="handleSubmit" >

            <div class="form-group">

                <label>Email :</label>
                <input type="email" class="form-control" v-model="mail"  placeholder="Email" />
            </div>

            <div class="form-group">
                <label>Password :</label>
                <input type="password" class="form-control" v-model="password"  placeholder="Password" />
            </div>

            <div class="form-group">
                <button type="submit" class="btn btn-primary btn-sm"> Valider</button>
            </div>
        </form>
    </div>
</div>

<script src="${login}"></script>



<%@ include file="/WEB-INF/jsp/footer.jsp"%>