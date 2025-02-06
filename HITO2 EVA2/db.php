<?php
$host = 'localhost';
$db = 'task_manager';
$user = 'root'; // Cambia esto según tu configuración
$pass = 'curso'; // Cambia esto según tu configuración

try {
    $pdo = new PDO("mysql:host=$host;dbname=$db", $user, $pass);
    $pdo->setAttribute(PDO::ATTR_ERRMODE, PDO::ERRMODE_EXCEPTION);
} catch (PDOException $e) {
    echo "Connection failed: " . $e->getMessage();
}
?>