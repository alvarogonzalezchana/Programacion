<?php
require 'config/db.php';

if ($_SERVER['REQUEST_METHOD'] == 'POST') {
    $nombre = $_POST['nombre'];
    $apellidos = $_POST['apellidos'];
    $correo = $_POST['correo'];
    $edad = $_POST['edad'];
    $plan_base = $_POST['plan_base'];
    $paquete_adicional = $_POST['paquete_adicional'];
    $duracion = $_POST['duracion'];

    // Validaciones
    if (empty($nombre) || empty($apellidos) || empty($correo) || empty($edad) || empty($plan_base) || empty($duracion)) {
        $message = "Todos los campos son obligatorios.";
    } elseif (!filter_var($correo, FILTER_VALIDATE_EMAIL)) {
        $message = "El correo electrónico no es válido.";
    } elseif ($edad < 18 && $paquete_adicional !== 'Infantil') {
        $message = "Los usuarios menores de 18 años solo pueden contratar el Pack Infantil.";
    } elseif ($plan_base === 'Básico' && $paquete_adicional !== NULL) {
        $message = "Los usuarios del Plan Básico solo pueden seleccionar un paquete adicional.";
    } elseif ($paquete_adicional === 'Deporte' && $duracion !== 'Anual') {
        $message = "El Pack Deporte solo puede ser contratado si la duración de la suscripción es de 1 año.";
    } else {
        // Insertar en la base de datos
        $stmt = $pdo->prepare("INSERT INTO usuarios (nombre, apellidos, correo, edad, plan_base, paquete_adicional, duracion) VALUES (?, ?, ?, ?, ?, ?, ?)");
        if ($stmt->execute([$nombre, $apellidos, $correo, $edad, $plan_base, $paquete_adicional, $duracion])) {
            $message = "Usuario registrado con éxito.";
        } else {
            $message = "Error al registrar el usuario: " . htmlspecialchars($stmt->errorInfo()[2]);
        }
    }
}
?>

<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="styles.css">
    <title>Registro de Usuario</title>
</head>
<body>
    <h1>Registro de Usuario</h1>
    <form method="POST" id="registroForm">
        <input type="text" name="nombre" placeholder="Nombre" required>
        <input type="text" name="apellidos" placeholder="Apellidos" required>
        <input type="email" name="correo" placeholder="Correo Electrónico" required>
        <input type="number" name="edad " placeholder="Edad" required>
        
        <select name="plan_base" required>
            <option value="">Selecciona un Plan Base</option>
            <option value="Básico">Básico</option>
            <option value="Estándar">Estándar</option>
            <option value="Premium">Premium</option>
        </select>
        
        <select name="paquete_adicional">
            <option value="">Selecciona un Paquete Adicional</option>
            <option value="Deporte">Deporte</option>
            <option value="Cine">Cine</option>
            <option value="Infantil">Infantil</option>
        </select>
        
        <select name="duracion" required>
            <option value="">Selecciona la Duración</option>
            <option value="Mensual">Mensual</option>
            <option value="Anual">Anual</option>
        </select>
        
        <button type="submit">Registrar Usuario</button>
    </form>
    <?php if ($message): ?>
        <p><?php echo htmlspecialchars($message); ?></p>
    <?php endif; ?>
    <script src="script.js"></script>
</body>
</html>