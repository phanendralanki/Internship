<%-- 
    Document   : register
    Created on : 09-Nov-2022, 9:36:51 pm
    Author     : phane
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Register here</title>
        <link rel="stylesheet" href="css/register.css">
    </head>
    <script>
        function validate()
        {
            var user_name = doucment.form.user_name.value;
            var user_email = document.form.user_email.value;
            var mobile = document.form.mobile.value;
            var user_password = document.form.user_password.value;
            var cpassword = document.form.cpassword.value;
            
            if(user_name===null || user_name===""){
                alert("your name can't be blank");
                return false;
            }
            else if(user_email===null || email===""){
                alert("Email can't be blank");
                return false;
            }
            else if(mobile===null || mobile===""){
                alert("mobile number can't be empty");
                return false;
            }
            else if(user_password.length<8){
                alert("password must be atleast 8 characters");
                return false;
            }
            else if(user_password!==cpassword){
                alert("passwords should be match");
                return false;
            }
        }
    </script>
    <body>
         <div class="container">
        <div class="header">
            <h2>Register Here</h2>
        </div>
             <form action="registerservlet" class="form" id="form"  name="form" method="post" onsubmit="return validate()">
            <div class="field">
                <label for="username">UserName</label>
                <input type="text" name="user_name" id="uname" placeholder="Enter your name"> <br>
                <span class="material-icons success">*</span>
                <span class="material-icons error">!</span>
                <small>Error message</small>
            </div>
            <div class="field">
                <label for="email">Email</label>
                <input type="email" name="user_email" id="email" placeholder="Email@gmail.com"><br>
                <span class="material-icons success">*</span>
                <span class="material-icons error">!</span>
                <small>Error message</small>
            </div>
            <div class="field">
                <label for="mobile number">Mobile Number</label>
                <input type="number" name="mobile" id="phone" placeholder="Enter your Phone Number"><br>
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
            <div class="field">
                <label for="confirm password">Confirm password</label>
                <input type="password" name="cpassword" id="cpassword" placeholder="Enter password again"><br>
                <span class="material-icons success">*</span>
                <span class="material-icons error">!</span>
                <small>Error message</small>
            </div>
            <div class="field">
                <input type="checkbox" name="agree" id="tc" class="terms">
                <label for="terms">I agree to terms and conditions</label><br><br>
                <small>Error message</small>
                
            </div>
            <div class="field">
                <input type="submit" value="submit" class="button">
            </div>
            <div class="loginform">
                <a href="login.jsp">If you're already registered</a>
            </div>

           
        </form>
             
              

    </div>
    </body>
</html>
