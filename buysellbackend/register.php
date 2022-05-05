<?php

$con=new mysqli("localhost","root","","ap1");
$st_check=$con->prepare("select * from user where email=?");
$st_check->bind_param("s", $_GET["email"]);
$st_check->execute();
$rs=$st_check->get_result();
if($rs->num_rows==0)
{
$st=$con->prepare("insert into user values(?,?,?,?)");
$st->bind_param("ssss", $_GET["email"],$_GET["password"],$_GET["name"],$_GET["address"]);
$st->execute();
echo "0";
}
else
    echo "1";
?>