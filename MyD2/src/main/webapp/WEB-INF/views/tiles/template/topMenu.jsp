<%@page import="com.shakul.myd2.util.PropertiesCache"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page isELIgnored="false" %>


<br/>
<br/>
<br/>

<div>
<nav class="navbar navbar-inverse" style="background-color: #4682B4;" >
<div class="container-fluid">
  <ul class="nav navbar-nav">
  	<li><a data-toggle="modal" href="#myModal" data-backdrop="static"><%= PropertiesCache.getInstance().getProperty("header_NEW") %> </a></li>
    <li><a href="#"><%= PropertiesCache.getInstance().getProperty("navbar_CONTENT") %> </a></li>
    <li><a href="#"><%= PropertiesCache.getInstance().getProperty("navbar_TASKS") %></a></li>
    <li><a href="#"><%= PropertiesCache.getInstance().getProperty("navbar_My_Recent_Documents") %></a></li>
  </ul>
  
   <!-- Modal -->
  <div class="modal fade" id="myModal" role="dialog">
    <div class="modal-dialog modal-lg">
    
      <!-- Modal content-->
      <div class="modal-content">
        <div class="modal-header">
          <button type="button" class="close" data-dismiss="modal">x</button>
          <h4 class="modal-title">Create New Document</h4>
        </div>
        <div class="modal-body">
          <p>Some text in the modal.</p>
          
          	<div class="container">
	<form:form method="POST" modelAttribute="document" class="form-horizontal">
		<form:input type="hidden" path="r_object_id" id="r_object_id" />

		<div class="row">
			<div class="form-group col-sm-6">
				<label class="col-sm-3 control-lable" for="userloginid">Object Name</label>
				<div class="col-sm-7">
					<form:input type="text" path="strSobjectName" id="userloginid"
						class="form-control input-sm" />
					<div class="has-error">
						<form:errors path="strSobjectName" class="help-inline" />
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
          	
          
          
        </div>
        <div class="modal-footer">
          <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
        </div>
      </div>
      
    </div>
  </div>
  
  <form class="navbar-form navbar-left">
  <div class="input-group">
    <input type="text" class="form-control" placeholder="Search">
    <div class="input-group-btn">
      <button class="btn btn-default" type="submit">
        <i class="glyphicon glyphicon-search"></i>
      </button>
    </div>
  </div>
</form>


</div>
</nav>
