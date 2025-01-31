<?php
include 'db.php';

if (isset($_GET['id'])) {
    $id = $_GET['id'];

    // Obtener datos del usuario
    $stmt = $conn->prepare("SELECT * FROM usuarios WHERE id = ?");
    $stmt->execute([$id]);
    $usuario = $stmt->fetch(PDO::FETCH_ASSOC);

    if (!$usuario) {
        die("Usuario no encontrado.");
    }
}

if ($_SERVER['REQUEST_METHOD'] === 'POST') {
    $id = $_POST['id'];
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

    // Actualizar usuario
    $sql = "UPDATE usuarios SET nombre = ?, apellidos = ?, email = ?, edad = ?, plan_base = ?, duracion = ?, paquetes = ? WHERE id = ?";
    $stmt = $conn->prepare($sql);
    $stmt->execute([$nombre, $apellidos, $email, $edad, $plan_base, $duracion, $paquetes, $id]);

    header('Location: index.php');
}
?>

<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Editar Usuario</title>
    <link rel="stylesheet" href="assets/styles.css">
</head>
<body>
    <h1>Editar Usuario</h1>
    <form action="editar.php" method="POST">
        <input type="hidden" name="id" value="<?= $usuario['id'] ?>">
        
        <label>Nombre:</label>
        <input type="text" name="nombre" value="<?= $usuario['nombre'] ?>" required>
        
        <label>Apellidos:</label>
        <input type="text" name="apellidos" value="<?= $usuario['apellidos'] ?>" required>
        
        <label>Email:</label>
        <input type="email" name="email" value="<?= $usuario['email'] ?>" required>
        
        <label>Edad:</label>
        <input type="number" name="edad" value="<?= $usuario['edad'] ?>" min="1" required>
        
        <label>Plan Base:</label>
        <select name="plan_base" required>
            <option value="Básico" <?= $usuario['plan_base'] === 'Básico' ? 'selected' : '' ?>>Básico</option>
            <option value="Estándar" <?= $usuario['plan_base'] === 'Estándar' ? 'selected' : '' ?>>Estándar</option>
            <option value="Premium" <?= $usuario['plan_base'] === 'Premium' ? 'selected' : '' ?>>Premium</option>
        </select>
        
        <label>Duración:</label>
        <select name="duracion" required>
            <option value="mensual" <?= $usuario['duracion'] === 'mensual' ? 'selected' : '' ?>>Mensual</option>
            <option value="anual" <?= $usuario['duracion'] === 'anual' ? 'selected' : '' ?>>Anual</option>
        </select>
        
        <label>Paquetes:</label>
        <?php
        $paquetesSeleccionados = explode(',', $usuario['paquetes']);
        ?>
        <select name="paquetes[]" multiple>
            <option value="Deporte" <?= in_array('Deporte', $paquetesSeleccionados) ? 'selected' : '' ?>>Deporte</option>
            <option value="Cine" <?= in_array('Cine', $paquetesSeleccionados) ? 'selected' : '' ?>>Cine</option>
            <option value="Infantil" <?= in_array('Infantil', $paquetesSeleccionados) ? 'selected' : '' ?>>Infantil</option>
        </select>
        
        <button type="submit">Guardar Cambios</button>
    </form>
</body>
</html>
