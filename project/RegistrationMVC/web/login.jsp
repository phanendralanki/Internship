<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" href="css/register.css">
    </head>
    <body>
        
         <div class="container">
        <div class="header">
            <h2>Login Here</h2>
        </div>
             <!--To check the database connectivity-->
             
             
             
             <form action="LoginServlet" class="form" id="form"  name="form" method="post" onsubmit="return validate()">
              <div class="field">
                <label for="email">Email</label>
                <input type="email" name="user_email" id="email" placeholder="Email@gmail.com"><br>
                <span class="material-icons success">*</span>
                <span class="material-icons error">!</span>
                <small>Error message</small>
            </div>
              <div class="field">
                <label for="password">Password</label>
                <input type="password" name="user_password" id="password" placeholder="Enter your password"><br>
                <span class="material-icons success">*</span>
                <span class="material-icons error">!</span>
                <small>Error message</small>
            </div>
                  <div class="loginform">
                <a href="register.jsp">If you don't have an account</a> 
            </div>
                 <br>
                 <div class="change">
                     <a href="forgotPassword.jsp">Forget Password?</a>
                 </div> <br>
                 <div class="field">
                <input type="submit" value="submit" class="button">
            </div>
           
             </form>
     </div>
   </body>
</html>
