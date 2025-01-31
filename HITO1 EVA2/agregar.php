<?php
include 'db.php';

if ($_SERVER['REQUEST_METHOD'] === 'POST') {
    $nombre = $_POST['nombre'];
    $apellidos = $_POST['apellidos'];
    $email = $_POST['email'];
    $edad = $_POST['edad'];
    $plan_base = $_POST['plan_base'];
    $duracion = $_POST['duracion'];
    $paquetes = isset($_POST['paquetes']) ? implode(',', $_POST['paquetes']) : '';

    // Validaciones
    if ($edad < 18 && $paquetes !== 'Infantil') {
        die("Error: Usuarios menores de 18 años solo pueden elegir el paquete Infantil.");
    }
    if ($plan_base === 'Básico' && count(explode(',', $paquetes)) > 1) {
        die("Error: Usuarios con el plan Básico solo pueden elegir un paquete adicional.");
    }
    if (strpos($paquetes, 'Deporte') !== false && $duracion !== 'anual') {
        die("Error: El paquete Deporte solo puede ser contratado con suscripción anual.");
    }

    // Insertar en la base de datos
    $sql = "INSERT INTO usuarios (nombre, apellidos, email, edad, plan_base, duracion, paquetes) 
            VALUES (?, ?, ?, ?, ?, ?, ?)";
    $stmt = $conn->prepare($sql);
    $stmt->execute([$nombre, $apellidos, $email, $edad, $plan_base, $duracion, $paquetes]);

    header('Location: index.php');
}
?>
