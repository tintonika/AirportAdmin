<%-- 
    Document   : adminPanel
    Created on : 6 avr. 2019, 19:19:57
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
        <title>Panneau d'administration</title>
        
        
    </head>
    <body>
        <div class="flex-container bg-danger">
            <div class="block-inline">
            <label for='btn1'>lancer le chargement du calendrier des vols</label>
        <a href="/" class="btn btn-text-success" id='btn1' role="button">Start</a>       
               </div>
            <div class="block-inline">
            <label for='btn2'>lancer le chargement du calendrier des vols</label>        
        <a href="/" class="btn btn-text-success" id='btn2' role="button">Start</a>   
        </div>
            </div>
    </body>
</html>
