<%-- 
    Document   : adminPanel
    Created on : 6 avr. 2019, 19:19:57
    Author     : Rick
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
     String Btn1Name;
  if(request.getParameterValues("btn1") != null){
      if( request.getParameter("btn1")=="Start")
            Btn1Name = request.getParameter("Stop");
      Btn1Name = request.getParameter("Start");
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
    <body style="background-image: url('https://mdbootstrap.com/img/Photos/Others/images/31.jpg');background-size: cover; background-repeat:no-repeat; background-position: center center;">
        
        <div class="row">
            <div class="col-sm-6">
              <div class="card">
                <div class="card-body">
                  <h5 class="card-title">Lancer le chargement du calendrier des vols</h5>
                  <p class="card-text"></p>
                  <a href="/insertVol" >  <input  class="btn btn-success" id="btn1" button type="button" value="<%=Btn1Name%>" onclick="" ></a>
                </div>
              </div>
            </div>
            <div class="col-sm-6">
              <div class="card">
                <div class="card-body">
                  <h5 class="card-title">lancer le chargement des événements de vols</h5>
                  <p class="card-text"></p>
                  <a  href="/updateDetails">  <input  class="btn btn-success" id="btn2" button type="button" value="START" onclick="changeNameBtn2()" ></a>
                </div>
              </div>
            </div>
         </div>
    </body>
</html>
