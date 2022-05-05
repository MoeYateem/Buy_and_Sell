<?php

$con=new mysqli("localhost","root","","ap1");
$st_check=$con->prepare("insert into cart values(?,?)");
$st_check->bind_param("ss", $_GET["email"],$_GET["item_name"]);
$st_check->execute();
?>