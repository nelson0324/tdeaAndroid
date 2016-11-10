<?php
class Conexion {
	
	
	public function __construct(){}
	public function __destruct(){}
	public function conectar(){
		include_once "config.php";
		$db=null;
		TRY{
		$db = new PDO("mysql:host=".HOST.":3306;dbname".DATA_BASE.";charset=utf8",USUARIO,CLAVE);
		$db->setAttribute(PDO::ATTR_ERRMODE, PDO::ERRMODE_EXCEPTION);
		}
		catch(PDOException $ex){
			
			echo $ex->getMessage();
		}
		
		return $db;
		
	}

}
