<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <!DOCTYPE html>
<!---Coding By CoderGirl | www.codinglabweb.com--->
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <meta http-equiv="X-UA-Compatible" content="ie=edge">
  <!--<title>Login & Registration Form | CoderGirl</title>-->
  <!---Custom CSS File--->
<style>
     <%@ include file="style.css"%>
</style>
</head>
<body>
  <div class="container">
    <input type="checkbox" id="check">
    <div class="login form">
      <header>Login</header>
      <form method="post" action="LoginServlet">
        <input type="text" name="username" placeholder="Enter your pseudo" required="required">
        <input type="password" name="password" placeholder="Enter your password" required="required">
        <a href="#">Forgot password?</a>
        <input type="submit" class="button" value="Login">
      </form>
      <div class="signup">
        <span class="signup">Don't have an account?
         <label for="check">Signup</label>
        </span>
      </div>
    </div>
    <div class="registration form">
      <header>Signup</header>
      <form method="post" action="Register">
        <input type="text" name="username" placeholder="Enter your pseudo" required="required">
        <input type="password" name="password" placeholder="Create a password" required="required">
        <input type="password" name="password" placeholder="Confirm your password" required="required">
        <input type="submit" class="button" value="Signup">
      </form>
      <div class="signup">
        <span class="signup">Already have an account?
         <label for="check">Login</label>
        </span>
      </div>
    </div>
  </div>
</body>
</html>