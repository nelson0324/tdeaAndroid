<?php

class Persona{
public function __construct(){}
public function __destruct(){}
public function insertar($db,$nombre,$edad,$peso,$estatura,$sexo,$bebe,$fuma){
	
	try{
			$sql="insert into tblpersona(nombre,edad,peso,estatura,sexo,bebe,fuma)
			values(:nombre,:edad,:peso,:estatura,:sexo,:bebe,:fuma)";
			$ejecutar = $db->prepare($sql);
			$resultado=$ejecutar->execute(array(":nombre"=>$nombre,":edad"=>$edad,":peso"=>$peso,":estatura"=>$estatura,":sexo"=>$sexo,":bebe"=>$bebe,":fuma"=>$fuma));
		if($resultado)
			return "Isertado";
		else
			return "No insertado";
	}catch(PDOExecption $ex){
		echo "Error :".$ex->getMessage();
	}
	
}
}