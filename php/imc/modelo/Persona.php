<?php

class Persona {
	
	
	public function __construct(){}
	public function __destruct(){}
	public function insertar($db, $nombre, $edad, $estatura, $sexo,$peso,$bebe, $fuma ){
		
		try{
			
			$sql ="Insert into tblpersona(nombre,edad,peso, estatura,sexo,bebe,fuma) values(:nombre,:edad,:peso,:estatura,:sexo,:bebe,:fuma)";
			$db->prepare($sql);
			$resultado=$db->execute(array(":nombre"=>$nombre,":edad"=>$edad,":peso"=>$peso,":estatura"=>$estatura,":sexo"=>$sexo,":bebe"=>$bebe,":fuma"=>$fuma));
			if($resultado){
				
				return "Insertado";
			}else{
				
				return "No Insertado";
			}
			
		}catch(PDOException $ex){
			
			echo "Error al insertado".$ex;
		}
				
	}
}