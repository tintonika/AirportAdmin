<%-- 
    Document   : loginForm
    Created on : 6 avr. 2019, 19:12:35
    Author     : Rick
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
            <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    <!--<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>-->
    <link rel="stylesheet" type="text/css" href="css/style.css" />
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
        <title>JSP Page</title>
    </head>
    <body>
        <div class=" flex-container row p-3">

            <form action="adminPanel" type="GET">
            <div class="form-group">
              <label for="nom">Nom utilisateur</label>
              <input type="text" class="form-control" name="nomUtilisateur" id="nom">

            </div>
            <div class="form-group">
              <label for="password1">Password</label>
              <input type="password" class="form-control" name="password" id="password1">
            </div>
             <button type="submit" class="btn btn-primary" >Entrer</button> 
         </form>
        </div><!-- END SECTION -->
    </body>
</html>
