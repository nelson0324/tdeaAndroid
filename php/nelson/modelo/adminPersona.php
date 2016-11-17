<?php
$option = isset($_REQUEST["opcion"])?$_REQUEST["opcion"]:"insertar";
 $nombre = isset($_REQUEST["nombre"])?$_REQUEST["nombre"]:"juan";
 $edad = isset($_REQUEST["edad"])?$_REQUEST["edad"]:"30";
 $peso = isset($_REQUEST["peso"])?$_REQUEST["peso"]:"70,5";
 $estatura = isset($_REQUEST["estatura"])?$_REQUEST["estatura"]:"1,80";
 $sexo = isset($_REQUEST["sexo"])?$_REQUEST["sexo"]:"masculino";
 $bebe = isset($_REQUEST["bebe"])?$_REQUEST["bebe"]:"1";
 $fuma = isset($_REQUEST["fuma"])?$_REQUEST["fuma"]:"1";
 
 
 include_once "../controlador/conexion.php";

 $db = new Conexion();
  
 $db = $db->conectar();

 if($option === "insertar"){
 
 include_once "persona.php";
 $persona = new Persona();
 
 $operacion = $persona->insertar($db, $nombre,$edad, $peso,$estatura,$sexo,$bebe,$fuma);
 echo $operacion;
 
 }
 