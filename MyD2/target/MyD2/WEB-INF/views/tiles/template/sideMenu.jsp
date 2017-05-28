<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page isELIgnored="false" %>

	<div class = "vertical-menu">        
       <a href = "/MyD2/">Home</a>
       <a href="/MyD2/products">Products</a>
       <a href="/MyD2/contactus">Contact Us</a>      
       <div class="dropdown">
    	  <a  id="menu1" data-toggle="dropdown" style="text-align: left;">User Management
    			<span class="caret"></span>
    	   </a>
    			<ul class="dropdown-menu vertical-menu-dropdown" role="menu" aria-labelledby="menu1" >
    		  		<li role="presentation"><a role="menuitem" tabindex="-1" href="/MyD2/user">User</a></li>
      		  		<li role="presentation"><a role="menuitem" tabindex="-1" href="#">Group</a></li>
     		  		<li role="presentation"><a role="menuitem" tabindex="-1" href="#">Role</a></li>
            	</ul>
  	   </div>
    </div>	
       
      
       