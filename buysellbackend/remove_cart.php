<?php

$con=new mysqli("localhost","root","","ap1");
$st_check=$con->prepare("delete from cart where email=?");
$st_check->bind_param("s", $_GET["email"]);
$st_check->execute();
?>