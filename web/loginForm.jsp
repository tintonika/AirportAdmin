<%-- 
    Document   : loginForm
    Created on : 6 avr. 2019, 19:12:35
    Author     : Rick
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
     <jsp:include page="head.jsp" /> 
    <body>
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
                    <form action="verifierDonnee" method="post" >
                    <div class="card wow fadeInCentre " >
                        <img class="images-responsive" src="images/Logo.png" width="100" height="150"> 
                      <div class="card-body">
                          
                              <!--Body-->
                                <div class="md-form">
                                  <i class="fas fa-user prefix white-text active"></i>
                                  <input type="text" id="form3" name="nom" class="white-text form-control">
                                  <label for="form3" class="active">Nom utilisateur</label>
                                </div>
                                <div class="md-form">
                                  <i class="fas fa-lock prefix white-text active"></i>
                                  <input type="password" id="form4" name="password" class="white-text form-control">
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
