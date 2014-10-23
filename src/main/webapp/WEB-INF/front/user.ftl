<!DOCTYPE html>
<html lang="zh-CN">
<head>
  <meta charset="utf-8"/>
  <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1"/>
  <meta name="viewport" content="maximum-scale=1.0,width=device-width,initial-scale=1.0"/>
  <title>api test</title>
  <script>
	// The root URL for the RESTful services
	var rootURL = 'http://localhost:8080/api/users';
	
	var currentUser;
	
	// Retrieve wine list when application starts 
	findAll();
	
	// Nothing to delete in initial application state
	$('#btnDelete').hide();
	
	$('#btnAdd').click(function() {
		addUser();
		return false;
	});
	
	$('#btnSave').click(function() {
	 
		updateUser();
		return false;
	});
	
	$('#btnClear').click(function() {
		newUser();
		return false;
	});
	
	
	$('#btnDelete').click(function() {
		deleteUser();
		return false;
	});
	
	$('#userList a').live('click', function() {
		findById($(this).data('identity'));
	});
	
	$('#btnRefreash').click(function() {
		findAll();
		return false;
	});
	 
	
	function newUser() {
		$('#btnDelete').hide();
		currentUser = {};
		renderDetails(currentUser); // Display empty form
	}
	
	function findAll() {
		console.log('findAll');
		$.ajax({
			type: 'GET',
			url: rootURL,
			dataType: "json", // data type of response
			success: renderList
		});
	}
	
	 
	function findById(id) {
		console.log('findById: ' + id);
		$.ajax({
			type: 'GET',
			url: rootURL + '/' + id,
			dataType: "json",
			success: function(data){
				$('#btnDelete').show();
	
				console.log('findById success: ' + data.userName);
				currentUser = data;
				renderDetails(currentUser);
			}
	 
		});
	}
	
	function addUser() {
		console.log('addUser');
		$.ajax({
			type: 'POST',
			contentType: 'application/json',
			url: rootURL,
			dataType: "json",
			data: formToJSON(),
			success: function(data, textStatus, jqXHR){
				alert('User created successfully');
				$('#btnDelete').show();
				$('#userId').val(data.userId);
			},
			error: function(jqXHR, textStatus, errorThrown){
				alert('addUser error: ' + textStatus);
			}
		});
	}
	
	function updateUser() {
		console.log('updateUser');
		$.ajax({
			type: 'PUT',
	
			contentType: 'application/json',
			url: rootURL,
			dataType: "json",
			data: formToJSON(),
			
			success: function(data, textStatus, jqXHR){
				alert('User updated successfully');
			},
			error: function(jqXHR, textStatus, errorThrown){
				alert('updateUser error: ' + textStatus);
			}
		});
	}
	
	function deleteUser() {
		console.log('deleteUser');
		$.ajax({
			type: 'DELETE',
			url: rootURL + '/' + $('#userId').val(),
			success: function(data, textStatus, jqXHR){
				alert('user deleted successfully');
			},
			error: function(jqXHR, textStatus, errorThrown){
				alert('delete user error');
			}
		});
	}
	
	function renderList(data) {
		// JAX-RS serializes an empty list as null, and a 'collection of one' as an object (not an 'array of one')
		var list = data == null ? [] : (data instanceof Array ? data : [data]);
	
		$('#userList li').remove();
		$.each(list, function(index, data) {
			$('#userList').append('<li><a href="#" data-identity="' + data.userId + '">'+data.userName+'</a></li>');
		});
	}
	
	function renderDetails(data) {
		$('#userId').val(data.userId);
		$('#userName').val(data.userName);
		$('#age').val(data.age);
	 
	}
	
	// Helper function to serialize all the form fields into a JSON string
	function formToJSON() {
		var userId = $('#userId').val();
		return JSON.stringify({
			"userId": userId == "" ? null : userId, 
			"userName": $('#userName').val(), 
			"age": $('#age').val() 
			});
	}

  </script>
</head>
<body>
	<div class="header">

		<button id="btnClear">Clear</button>
		<button id="btnRefreash">Refreash</button>
	</div>


	<div class="leftArea">
		<ul id="userList"></ul>
	</div>

	<form id="wineForm">

		<div class="mainArea">

			<label>Name:</label> <input type="text" id="username" name="username" required> 
			<label>Age:</label> <input	type="text" id="password" name="password" required/>
			
			<button id="btnAdd">Add</button>
			<button id="btnSave">Save</button>
			<button id="btnDelete">Delete</button>
		</div>
 
	</form>
</body>
</html>