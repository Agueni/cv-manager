<%@ include file="/WEB-INF/jsp/header.jsp"%>

<c:url var="home" value="/aaa" />
<c:url var="app" value="/app.js" />



<div id="myApp">
	<div class="container">
		<h1> Gestion de CVs </h1>
		<nav class="navbar navbar-expand-lg navbar-light bg-light">

				<a class="navbar-brand" href="/persons"> Consulter la liste des personnes </a>
				<a class="navbar-brand" href="/cvs"> Consulter la liste des CVs </a>
				<a class="navbar-brand" href="/create-person"> Creer une nouvelle personne </a>
				<a class="navbar-brand" href="/login">Se connecter </a>

		</nav>


	</div>
</div>
<script src="${app}"></script>

<%@ include file="/WEB-INF/jsp/footer.jsp"%>

