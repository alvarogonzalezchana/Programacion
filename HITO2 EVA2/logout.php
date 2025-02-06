<?php
// Inicio la sesión para acceder a las variables de sesión
session_start();
// Destruyo la sesión actual para cerrar sesión
session_destroy();
// Redirijo al usuario a la página de inicio
header("Location: index.php");
// Termino la ejecución del script para evitar cualquier código adicional
exit();
?>