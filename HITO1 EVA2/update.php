<?php
include 'db.php';

if (isset($_GET['id'])) {
    $id = $_GET['id'];
    $result = $conn->query("SELECT * FROM users WHERE id = $id");
    $user = $result->fetch_assoc();
}

if ($_SERVER["REQUEST_METHOD"] == "POST") {
    $name = $_POST['name'];
    $email = $_POST['email'];
    $age = $_POST['age'];
    $base_plan = $_POST['base_plan'];
    $additional_package = $_POST['additional_package'];
    $subscription_duration = $_POST['subscription_duration'];

    // Validaciones similares a las de registro

    // Actualizar en la base de datos
    $stmt = $conn->prepare("UPDATE users SET name=?, email=?, age=?, base_plan=?, additional_package=?, subscription_duration=? WHERE id=?");
    $stmt->bind_param("ssisssi", $name, $email, $age, $base_plan, $additional_package, $subscription_duration, $id);
    if ($stmt->execute()) {
        $success = "Usuario actualizado con éxito.";
        header("Location: manage.php");
    } else {
        $error = "Error al actualizar el usuario.";
    }
    $stmt->close();
}
?>

<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <title>Actualizar Usuario</title>
    <link rel="stylesheet" href="styles.css">
</head>
<body>
    <h1>Actualizar Usuario</h1>
    <form method="POST" action="update.php?id=<?php echo $id; ?>">
        <input type="text" name="name" value="<?php echo $user['name']; ?>" required>
        <input type="email" name="email" value="<?php echo $user['email']; ?>" required>
        <input type="number" name="age" value="<?php echo $user['age']; ?>" required>
        <select name="base_plan" required>
            <option value="Básico" <?php if($user['base_plan'] == 'Básico') echo 'selected'; ?>>Básico</option>
            <option value="Estándar" <?php if($user['base_plan'] == 'Estándar') echo 'selected'; ?>>Estándar</option>
            <option value="Premium" <?php if($user['base_plan'] == 'Premium') echo 'selected'; ?>>Premium</option>
        </select>
        <select name="additional_package">
            <option value="" <?php if($user['additional_package'] == '') echo 'selected'; ?>>Ninguno</option>
            <option value="Deporte" <?php if($user['additional_package'] == 'Deporte') echo 'selected'; ?>>Deporte</option>
            <option value="Cine" <?php if($user['additional_package'] == 'Cine') echo 'selected'; ?>>Cine</option>
            <option value="Infantil" <?php if($user['additional_package'] == 'Infantil') echo 'selected'; ?>>Infantil</option>
        </select>
        <select name="subscription_duration" required>
            <option value="Mensual" <?php if($user['subscription_duration'] == 'Mensual') echo 'selected'; ?>>Mensual</option>
            <option value="Anual" <?php if($user['subscription_duration'] == 'Anual') echo 'selected'; ?>>Anual</option>
        </select>
        <button type="submit">Actualizar Usuario</button>
    </form>
    <?php if (isset($error)) echo "<p class='error'>$error</p>"; ?>
    <?php if (isset($success)) echo "<p class='success'>$success</p>"; ?>
</body>
</html>