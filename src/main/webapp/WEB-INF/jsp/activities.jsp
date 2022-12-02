<%@ include file="/WEB-INF/jsp/header.jsp"%>


<c:url var="home" value="/aaa" />
<c:url var="app" value="/app.js" />

<div id="myApp">
	<div class="container">
		<h1>Liste des activités </h1>

		<table class="table">
			<tr>
				<th>Titre</th>
				<th>Année</th>
				<th>Description</th>
				<th>Site</th>
			</tr>
			<tr v-for="activity in activities">
				<td>{{activity.title}}</td>
				<td>{{activity.year}}</td>
				<td>{{activity.description}}</td>
				<td>{{activity.webSite}}</td>
			</tr>
		</table>

	</div>
</div>

<script src="${app}"></script>

<%@ include file="/WEB-INF/jsp/footer.jsp"%>
