<?php

$con=new mysqli("localhost","root","","ap1");
$st=$con->prepare("select * from instruments where type=?");
$st->bind_param("s", $_GET["type"]);
$st->execute();
$rs=$st->get_result();
$arr =array();
while($row=$rs->fetch_assoc())
{
    array_push($arr, $row);  
}

echo json_encode($arr);