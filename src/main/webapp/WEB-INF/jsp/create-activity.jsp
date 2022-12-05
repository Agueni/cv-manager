
<%@ include file="/WEB-INF/jsp/header.jsp"%>


<c:url var="home" value="/aaa" />
<c:url var="app" value="/app.js" />


<div id="myApp">
  <div class="container">
    <nav class="navbar navbar-expand-lg navbar-light bg-light">
      <img src="img/img.png" class="logo img-thumbnail rounded-circle" alt="logo">
      <a class="navbar-brand" href="/persons"> Consulter la liste des personnes </a>
      <a class="navbar-brand" href="/cvs"> Consulter la liste des CVs </a>
      <a class="navbar-brand" href="/create-person"> Creer une nouvelle personnes </a>
      <a class="navbar-brand" href="/login">Se connecter </a>

    </nav>

    <h2>Creation d'une nouvelle activite </h2>

    <form id="createActivity" novalidate="true" @submit.prevent="createActivity(newActivity)">


      <div class="form-group">

        <label>Annee :</label>
        <input type="date" placeholder="Annee" v-model="newActivity.year" class="form-control" name="year"
               v-bind:class="{'is-invalid':errors.year}"  />
        <div v-if="(errors.year)" class="alert alert-warning">
          {{errors.year}}
        </div>
      </div>
      <div class="form-group">
        <label>Titre :</label>
        <input placeholder="Titre" v-model="newActivity.title" class="form-control" name="name"
               v-bind:class="{'is-invalid':errors.title}" />
        <div v-if="(errors.title)" class="alert alert-warning">
          {{errors.title}}
        </div>
      </div>
      <div class="form-group">
        <label>Description :</label>
        <input type="text" placeholder="Description" v-model="newActivity.description" class="form-control" name="description"
               v-bind:class="{'is-invalid':errors.description}"  />
        <div v-if="(errors.website)" class="alert alert-warning">
          {{errors.description}}
        </div>
      </div>

      <div class="form-group">
        <label> Nature : </label>
      <select  v-model="newActivity.activityNature"   class="form-select form-select-lg mb-3" aria-label=".form-select-lg example">
        <option selected> Veuillez selectionner la nature  </option>
        <option  value="EXPERIENCE">EXPERIENCE</option>
        <option  value="FORMATION">FORMATION</option>
        <option  value="PROJET">PROJET</option>
        <option  value="AUTRE">AUTRE</option>
      </select>
      </div>

      <div class="form-group">
        <label>Site Web :</label>
        <input type="url" placeholder="Site Web" v-model="newActivity.website" class="form-control" name="website"
               v-bind:class="{'is-invalid':errors.website}"  />
        <div v-if="(errors.website)" class="alert alert-warning">
          {{errors.website}}
        </div>
      </div>

      <div class="form-group">
        <button type="submit"  class="btn btn-primary ">Valider</button>
        <button v-on:click="" class="btn btn-primary">Annuler</button>

      </div>
    </form>

  </div>
</div>

<script src="${app}"></script>

<%@ include file="/WEB-INF/jsp/footer.jsp"%>

