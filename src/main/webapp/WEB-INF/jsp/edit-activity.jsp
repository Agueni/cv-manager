<%@ include file="/WEB-INF/jsp/header.jsp"%>

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<div id="myApp">

<div class="container">
	<h1>Modification de l'activite </h1>

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
</div>

</div>


<script src="${app}"></script>

<%@ include file="/WEB-INF/jsp/footer.jsp"%>
