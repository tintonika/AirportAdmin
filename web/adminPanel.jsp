<%-- 
    Document   : adminPanel
    Created on : 6 avr. 2019, 19:19:57
    Author     : Rick
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    
    String numTel = (String)request.getAttribute("NUMTEL");
    
    
    
     String Btn1Name;
  if(request.getParameterValues("btn1") != null){
      if( request.getParameter("btn1")=="START")
            Btn1Name = request.getParameter("Stop");
      Btn1Name = request.getParameter("START");
  } else {
  Btn1Name = "Start";
  }
%>
<!DOCTYPE html>

<html>
    <jsp:include page="head.jsp" />
    <script>
        function changeNameBtn1() {
            if(document.getElementById('btn1').value=='START'){
                document.getElementById('btn1').value='STOP';
                document.getElementById('btn1').className='btn btn-danger';}
            else{
                document.getElementById('btn1').value='START';}
        }
        function changeNameBtn2() {
            if(document.getElementById('btn2').value=='START')
                document.getElementById('btn2').value='STOP';
                document.getElementById('btn2').className='btn btn-danger';}
            else
                document.getElementById('btn2').value='START';
        }
    </script>
    <body>
        
        <div class="row">
            <div class="col-sm-6">
              <div class="card m-3">
                <div class="card-body">
                  <h5 class="card-title">Lancer le chargement du calendrier des vols</h5>
                  <p class="card-text"></p>
                  <a href="/airportadmin/insertVol" >  
                      <input  class="btn btn-success" 
                              id="btn1" button 
                              type="button" 
                              value="<%=Btn1Name%>" 
                              onclick="" >
                  </a>
                </div>
              </div>
            </div>
            <div class="col-sm-6">
              <div class="card m-3">
                <div class="card-body">
                  <h5 class="card-title">Lancer le chargement des événements de vols</h5>
                  <p class="card-text"></p>
                  <a  href="/airportadmin/updateDetails"> 
                      <input  class="btn btn-success" 
                              id="btn2" button 
                              type="button" 
                              value="START" 
                              onclick="changeNameBtn2()" >
                  </a>
                </div>
              </div>
            </div>
                  <div class="col-sm-6">
              <div class="card m-3">
                <div class="card-body">
                  <h5 class="card-title">Supprimer les Inscriptions SMS</h5>
                  <p class="card-text"></p>
      
                  <a href="/airportadmin/supprimerInscriptionSMS" >  
                      <input class="btn btn-danger" 
                             id="" button 
                             type="button" 
                             value="Supprimer" 
                             onclick="" >
                  </a>
                </div>
              </div>
            </div>
         </div>
    </body>
</html>
