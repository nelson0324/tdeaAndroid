<?php
include_once "controlador/conexion.php";
$db = new Conexion();
$db=$db->conectar();

if($db <> null){
	echo "Conectado";
}

