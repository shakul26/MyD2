<%@ page isELIgnored="false" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="container">
 	     <form:form method="POST"  modelAttribute="searchUser" class="form-horizontal">
            <form:input type="hidden" path="r_object_id" id="r_object_id"/>
             
            <div class="row">
                <div class="form-group col-sm-6">
                    <label class="col-sm-3 control-lable" for="userloginid">User Login Id</label>
                    <div class="col-sm-7">
                        <form:input type="text" path="strUserLoginId" id="userloginid" class="form-control input-sm"/>
                        <div class="has-error">
                            <form:errors path="strUserLoginId" class="help-inline"/>
                        </div>
                    </div>
                </div>
            </div>
            
            <div class="row">
                <div class="form-group col-sm-6">
                    <label class="col-sm-3 control-lable" for="useranme">User Name</label>
                    <div class="col-sm-7">
                        <form:input type="text" path="strUserName" id="useranme" class="form-control input-sm"/>
                        <div class="has-error">
                            <form:errors path="strUserName" class="help-inline"/>
                        </div>
                    </div>
                </div>
            </div>
            
            <div class="row">
                <div class="form-group col-sm-6">
                    <label class="col-sm-3 control-lable" for="useremail">User Email</label>
                    <div class="col-sm-7">
                        <form:input type="text" path="strUserEmail" id="useremail" class="form-control input-sm"/>
                        <div class="has-error">
                            <form:errors path="strUserEmail" class="help-inline"/>
                        </div>
                    </div>
                </div>
            </div>
            <div class="row">
                <div class="form-actions floatRight">
                 <input type="submit" value="search" class="btn btn-primary btn-sm"/> <a href="<c:url value='/searchcond' />">Cancel</a>
  
                </div>
            </div>
   
    </form:form>        
    
    
     <div class="well well-sm" style="width: 50%;">
      ${result.strUserName} 
     
     <div class="col-sm-7">${result.strUserState}  </div>
     </div>
   
</div>