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

        <h1>Mes CVs</h1>

        <table class="table">
            <tr>
                <th>id</th>
                <th>Action</th>
            </tr>

            <tr v-for="cv in cvs">
                <td> {{cv.id}}</td>
                <td><button v-on:click="getCvActivities(cv.id)"> Visualiser </button></td>
             </tr>
        </table>

        <div v-if="(cv != null)">

            <h1>Liste des activities</h1>
            <table class="table">
                <tr>
                    <th>Titre</th>
                    <th>Description</th>
                    <th>Site</th>
                    <th>Annee</th>
                </tr>
                <tr v-for="activity in cv.activities">
                    <td>{{activity.title}}</td>
                    <td>{{activity.description}}</td>
                    <td>{{activity.website}}</td>
                    <td>{{activity.year}}</td>
                </tr>
            </table>
        </div>
    </div>
</div>


<script src="${app}"></script>

<%@ include file="/WEB-INF/jsp/footer.jsp"%>
