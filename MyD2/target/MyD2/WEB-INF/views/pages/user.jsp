<%@ page isELIgnored="false"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<strong>Users</strong>
<div class="well well-sm" style="background-color: gray;"></div>

<div class="container">
	<form:form method="POST" modelAttribute="user" class="form-horizontal">
		<form:input type="hidden" path="r_object_id" id="r_object_id" />

		<div class="row">
			<div class="form-group col-sm-6">
				<label class="col-sm-3 control-lable" for="userloginid">User
					Login Id</label>
				<div class="col-sm-7">
					<form:input type="text" path="strUserLoginId" id="userloginid"
						class="form-control input-sm" />
					<div class="has-error">
						<form:errors path="strUserLoginId" class="help-inline" />
					</div>
				</div>
			</div>
		</div>

		<div class="row">
			<div class="form-group col-sm-6">
				<label class="col-sm-3 control-lable" for="useranme">User
					Name</label>
				<div class="col-sm-7">
					<form:input type="text" path="strUserName" id="useranme"
						class="form-control input-sm" />
					<div class="has-error">
						<form:errors path="strUserName" class="help-inline" />
					</div>
				</div>
			</div>
		</div>

		<div class="row">
			<div class="form-group col-sm-6">
				<label class="col-sm-3 control-lable" for="useremail">User
					Email</label>
				<div class="col-sm-7">
					<form:input type="text" path="strUserEmail" id="useremail"
						class="form-control input-sm" />
					<div class="has-error">
						<form:errors path="strUserEmail" class="help-inline" />
					</div>
				</div>
			</div>
		</div>
		<div class="row">
			<div class="form-actions floatRight">
				<input type="submit" value="search" class="btn btn-primary btn-sm" />
				<a href="<c:url value='/user' />">Cancel</a>

			</div>
		</div>

	</form:form>

</div>
<div class="well well-sm" style="background-color: gray;"></div>

<div oncontextmenu="return false">
	<div class="container">
		<c:if test="${result!= null }">
			<table class="table table-striped">
	  		  <thead>
	  		  	<tr>
	        		<th>User Name</th>
	        		<th>State</th>
	        		<th>Email</th>
	      		</tr>
	  		  </thead>
	  		  <tbody  onblur="hideMenu('contextMenu');"
	  		  		  onmousedown="hideMenu('contextMenu');"     
	  		  		  onmouseup="hideMenu('contextMenu');"    
	  		  		  oncontextmenu="showMenu('contextMenu',event);"
	  		  		  class="detailItem">
	  		  	<tr>
	  		  		<td>
		  		  		 ${result.strUserName}
	  		  		</td>
	  		  		<td>
		  		  		 ${result.strUserState}
	  		  		</td>
	  		  		<td>
	  			  		 ${result.strUserEmail}
  			  		</td>
  		  		</tr>
  		  	</tbody>
  			</table>
		</c:if>
		<div style="display:none; "   id="contextMenu">
        <table  border="0" cellpadding="0" cellspacing="0" 

            style="border: thin solid #808080; cursor: default;" width="200px" 

            bgcolor="White">
            <tr>
                <td >
                    <div  class="ContextItem">Properties</div>
                </td>
            </tr>
            <tr>
                <td >
                <div  class="ContextItem">Add user to Group</div>
                </td>
            </tr>
            <tr>
                <td >
                    <div  class="ContextItem">View all guser group</div>
                </td>
            </tr>
        </table>
</div>
		
	</div>
</div>

    
    
    
<script type="text/javascript">
function showMenu(control, e){
	var posx = e.clientX + window.pageXOffset +'px';
	var posy = e.clientY + window.pageYOffset + 'px';
	document.getElementById(control).style.position = 'absolute';
    document.getElementById(control).style.display = 'inline';
    document.getElementById(control).style.left = posx-1;
    document.getElementById(control).style.top = posy-1;   
}
function hideMenu(control){
	document.getElementById(control).style.display = 'none';
}

</script>    
    
    
    
<!--div class="context-container" oncontextmenu="return showContextMenu(event);">
	<div id="contextMenu" class="context-menu">
		<ul>
			<li>A </li>
			<li>B </li>
			<li>C </li>
		</ul>
	</div>
</div>

<script type="text/javascript">
window.onclick = hideContextMenu;
window.onkeydown = listenKeys;
	var contextMenu = document.getElementById('contextMenu');
	function showContextMenu(event) {
		contextMenu.style.display = 'block';
		contextMenu.style.left=event.clientX-225 + 'px';
		contextMenu.style.top=event.clientY-147 + 'px';
		return false;
	}
	
	function hideContextMenu() {
		contextMenu.style.display = 'none';
	}
	
	function listenKeys(event){
		var keyCode = event.which || event.keyCode;
		if(keyCode ==  27){
			hideContextMenu();
		}
	}
</script -->
