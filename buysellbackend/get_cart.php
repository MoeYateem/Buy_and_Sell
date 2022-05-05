<?php

$con=new mysqli("localhost","root","","ap1");
$st_check=$con->prepare("select name,price,email from cart inner join instruments "
        . "on instruments.name=cart.item_name where email=?");
$st_check->bind_param("s", $_GET["email"]);
$st_check->execute();
$rs=$st_check->get_result();
$arr=array();
while($row=$rs->fetch_assoc())
{
    array_push($arr, $row);
}

echo json_encode($arr);
?>