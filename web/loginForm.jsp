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
        <title>Login Form</title>
    </head>
    <body style="background-image: url('https://mdbootstrap.com/img/Photos/Others/images/31.jpg');background-size: cover; background-repeat:no-repeat; background-position: center center;" >
        <header>
            
        </header>
        <!-- Full Page Intro -->
        <div class="vuew">
                <!--Grid row-->
                <div class="row">
                  <!--Grid column-->
                  <div class="col-md-3"></div>
                  <div class="col-md-6 col-xl-5 mb-4">
                    <!--Form-->
                    <form action="verifierDonnee" type="post">
                    <div class="card wow fadeInCentre">
                      <div class="card-body">
                          
                              <!--Body-->
                                <div class="md-form">
                                  <i class="fas fa-user prefix white-text active"></i>
                                  <input type="text" id="form3" class="white-text form-control">
                                  <label for="form3" class="active">Nom utilisateur</label>
                                </div>
                                <div class="md-form">
                                  <i class="fas fa-lock prefix white-text active"></i>
                                  <input type="password" id="form4" class="white-text form-control">
                                  <label for="form4">Password</label>
                                </div>
                                <div class="text-center mt-4">
                                  <button class="btn btn-primery">Entrer</button>
                                  <hr class="hr-light mb-3 mt-4">

                                </div>
                        
                      </div>
                    </div>
                    </form>

                    <!--/.Form-->
                  </div>
                  <div class="col-md-3"></div>
                  <!--Grid column-->
                </div>
                <!--Grid row-->
              
          <!-- Full Page Intro -->
        </div>
    </body>
</html>
