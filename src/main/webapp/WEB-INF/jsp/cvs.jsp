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
            <a class="navbar-brand" href="/create-person"> Creer une nouvelle personnes </a>
            <a class="navbar-brand" href="/login">Se connecter </a>

        </nav>
        <div>

            <h2>Liste des CVs </h2>

            <table class="table">
                <tr>
                    <th>id</th>
                    <th>Actions</th>
                </tr>

                <tr v-for="cv in cvs">
                    <td> {{cv.id}}</td>
                    <td><button v-on:click="getCvActivities(cv.id)"> Afficher  </button></td>
                    <td><a class="btn btn-primary btn-sm" href="create-activity"> Ajouter une activite </a></td>

                </tr>
            </table>


        </div>

        <div v-if="(cv != null)">

            <h2>Liste des activites</h2>
            <table class="table">
                <tr>
                    <th>Annee</th>
                    <th>Nature</th>
                    <th>Titre</th>
                    <th>Description</th>
                    <th>Site</th>
                    <th>Actions</th>

                </tr>
                <tr v-for="activity in cv.activities">
                    <td>{{activity.year}}</td>
                    <td>{{activity.activityNature}}</td>
                    <td>{{activity.title}}</td>
                    <td>{{activity.description}}</td>
                    <td>{{activity.webSite}}</td>
                    <td><button v-on:click="getActivityDetails(activity.id)"> Modifier </button></td>


                    <div v-if="(editable != null)">

                        <form id="app" method="post" novalidate="true">

                            <div class="form-group">
                                <label> Annee :</label>
                                <input type="date" v-model="editable.year" class="form-control"
                                       v-bind:class="{'is-invalid':errors.year}"  />
                                <div v-if="(errors.year)" class="alert alert-warning">
                                    {{errors.year}}
                                </div>
                            </div>

                            <div class="form-group">
                                <label> Nature : </label>
                                <select  v-model="editable.activityNature"   class="form-select form-select-lg mb-3" aria-label=".form-select-lg example">
                                    <option selected> Veuillez selectionner la nature  </option>
                                    <option  value="EXPERIENCE">EXPERIENCE</option>
                                    <option  value="FORMATION">FORMATION</option>
                                    <option  value="PROJET">PROJET</option>
                                    <option  value="AUTRE">AUTRE</option>
                                </select>
                            </div>


                            <div class="form-group">
                                <label>Titre :</label>
                                <input type="text" v-model="editable.title" class="form-control"
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
                                <input type="url" v-model="editable.webSite" class="form-control"
                                       v-bind:class="{'is-invalid':errors.webSite}" />
                                <div v-if="(errors.webSite)" class="alert alert-warning">
                                    {{errors.webSite}}
                                </div>
                            </div>

                            <div class="form-group">
                                <button v-on:click.prevent="editActivity(editable)" class="btn btn-primary">Sauvegarder </button>
                                <button v-on:click="getActivities()" class="btn btn-primary">Annuler </button>
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
