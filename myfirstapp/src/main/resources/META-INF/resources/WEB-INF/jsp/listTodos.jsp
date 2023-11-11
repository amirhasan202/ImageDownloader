	
		<%@include file = "common/header.jspf" %>
		<%@include file = "common/navigation.jspf" %>	
	
	
		<div class="container">
			<div> Welcome to in28minutes	</div>	
			<hr>
			<h1>Your Todos :</h1> 
			<br>
			<table class="table">
				<thead>
					<tr>
						<th>description</th>
						<th>Target Date</th>
						<th>Is Done</th>
						<th></th>
						<th></th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items = "${todos }" var = "bb">
						<tr>
							<td>${bb.description }</td>
							<td>${bb.targetdate }</td>
							<td>${bb.done }</td>
							<td><a href="delete-todo?id=${bb.id}" class= "btn btn-warning"> Delete </a></td>
							<td><a href="update-todo?id=${bb.id}" class= "btn btn-success"> Update </a> </td>
							
						</tr>
					</c:forEach>
				</tbody>
			</table>
			<a href="add-todo" class="btn btn-success" >Add Todo</a>
		</div>
		
		<%@include file = "common/footer.jspf" %>