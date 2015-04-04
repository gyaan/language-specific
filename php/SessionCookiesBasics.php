<?php
/**
 * Created by JetBrains PhpStorm.
 * User: gyani
 * Date: 4/4/15
 * Time: 2:22 PM
 * To change this template use File | Settings | File Templates.
 */

//set path for session
echo session_save_path('/home/gyani/');

//start a session
session_start();

//assign values to session
$_SESSION['abc']= "session values";

//display values to session
echo $_SESSION['abc'];

//unset individual session values
unset($_SESSION['abc']);

//unset all session values;
session_unset();

//distroy session
session_destroy();


//value wont' be available here
echo $_SESSION['abc'];


//set cookies setcookie(name, value, expire, path, domain, secure, httponly);
setcookie("testCookies","gyani");

echo "gyani".$_COOKIE['testCookies'];

//unset cookies with past expire time
setcookie("testCookies"," ",time()-3000);


//will add here more details