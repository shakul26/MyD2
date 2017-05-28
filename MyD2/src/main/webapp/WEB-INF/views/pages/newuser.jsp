<%@ page isELIgnored="false"  %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

 <div class="well well-sm" style="width: 50%;">New User </div>
 		
 			 ${success}
		
	<div class="container">
 	     <form:form method="POST"  modelAttribute="user" class="form-horizontal">
            <form:input type="hidden" path="r_object_id" id="r_object_id"/>
             
            <div class="row">
                <div class="form-group col-sm-4">
                    <label class="col-sm-4 control-lable" for="firstName">First Name</label>
                    <div class="col-sm-7">
                        <form:input type="text" path="strUserFirstName" id="firstName" class="form-control input-sm"/>
                        <div class="has-error">
                            <form:errors path="strUserFirstName" class="help-inline"/>
                        </div>
                    </div>
                </div>
            </div>
            
            <div class="row">
                <div class="form-group col-sm-4">
                    <label class="col-sm-4 control-lable" for="lastName">Last Name</label>
                    <div class="col-sm-7">
                        <form:input type="text" path="strUserLastName" id="lastName" class="form-control input-sm"/>
                        <div class="has-error">
                            <form:errors path="strUserLastName" class="help-inline"/>
                        </div>
                    </div>
                </div>
            </div>
            
             <div class="row">
                <div class="form-group col-sm-4">
                    <label class="col-sm-4 control-lable" for="userloginid">User Id</label>
                    <div class="col-sm-7">
                        <form:input type="text" path="strUserLoginId" id="userloginid" class="form-control input-sm"/>
                        <div class="has-error">
                            <form:errors path="strUserLoginId" class="help-inline"/>
                        </div>
                    </div>
                </div>
            </div>
            
              <div class="row">
                <div class="form-group col-sm-4">
                    <label class="col-sm-4 control-lable" for="useremailid">Email Id</label>
                    <div class="col-sm-7">
                        <form:input type="text" path="strUserEmail" id="useremailid" class="form-control input-sm"/>
                        <div class="has-error">
                            <form:errors path="strUserEmail" class="help-inline"/>
                        </div>
                    </div>
                </div>
            </div>
            
            <div class="row">
                <div class="form-actions floatRight">
                 <input type="submit" value="save" class="btn btn-primary btn-sm"/> <a href="<c:url value='/newuser' />">Cancel</a>
  
                </div>
            </div>
          </form:form>
    </div>