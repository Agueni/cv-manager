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

        <h1>La liste des CVs</h1>

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

            <h1>Liste des activites</h1>
            <table class="table">
                <tr>
                    <th>Annee</th>
                    <th>Nature</th>
                    <th>Titre</th>
                    <th>Description</th>
                    <th>Site</th>
                    <th>Action</th>

                </tr>
                <tr v-for="activity in cv.activities">
                    <td>{{activity.year}}</td>
                    <td>{{activity.nature}}</td>
                    <td>{{activity.title}}</td>
                    <td>{{activity.description}}</td>
                    <td>{{activity.website}}</td>
                    <td><button v-on:click="getActivityDetails(activity.id)"> Modifier </button></td>

                    <div v-if="(editable != null)">

                        <form id="app" method="post" novalidate="true">

                            <div class="form-group">
                                <label> Annee :</label>
                                <input v-model="editable.year" class="form-control"
                                       v-bind:class="{'is-invalid':errors.year}" number />
                                <div v-if="(errors.year)" class="alert alert-warning">
                                    {{errors.year}}
                                </div>
                            </div>
                            <div class="form-group">
                                <label>Nature :</label>
                                <input v-model="editable.nature" class="form-control"
                                       v-bind:class="{'is-invalid':errors.nature}" />
                                <div v-if="(errors.nature)" class="alert alert-warning">
                                    {{errors.nature}}
                                </div>
                            </div>
                            <div class="form-group">
                                <label>Titre :</label>
                                <input v-model="editable.title" class="form-control"
                                       v-bind:class="{'is-invalid':errors.title}" />
                                <div v-if="(errors.title)" class="alert alert-warning">
                                    {{errors.title}}
                                </div>
                            </div>

                            <div class="form-group">
                                <label>Description :</label>
                                <textarea v-model="editable.description" rows="5" cols="50"
                                          class="form-control"></textarea>
                            </div>

                            <div class="form-group">
                                <label>Site Web :</label>
                                <input v-model="editable.webSite" class="form-control"
                                       v-bind:class="{'is-invalid':errors.webSite}" />
                                <div v-if="(errors.webSite)" class="alert alert-warning">
                                    {{errors.webSite}}
                                </div>
                            </div>

                            <div class="form-group">
                                <button v-on:click.prevent="editActivity(editable)" class="btn btn-primary">Sauvegarder </button>
                                <button v-on:click="getActivities()" class="btn btn-primary">
                                    Annuler </button>
                            </div>
                        </form>
                    </div>

                </tr>
            </table>


        </div>

        <div>
            <a class="btn btn-primary btn-sm" href="app">Retour</a>
        </div>
    </div>
</div>


<script src="${app}"></script>

<%@ include file="/WEB-INF/jsp/footer.jsp"%>
