<?php
session_start();
require 'db.php';

if (!isset($_SESSION['user_id'])) {
    header("Location: login.php");
    exit();
}

if ($_SERVER['REQUEST_METHOD'] == 'POST') {
    $task = $_POST['task'];
    $userId = $_SESSION['user_id'];

    $stmt = $pdo->prepare("INSERT INTO tasks (user_id, task) VALUES (?, ?)");
    $stmt->execute([$userId, $task]);
}

$stmt = $pdo->prepare("SELECT * FROM tasks WHERE user_id = ?");
$stmt->execute([$_SESSION['user_id']]);
$tasks = $stmt->fetchAll();
?>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <title>Tareas</title>
    <link rel="stylesheet" href="style.css">
</head>
<body>
    <h1>Tareas</h1>
    <form method="POST">
        <input type="text" name="task" placeholder="Nueva tarea" required>
        <button type="submit">Agregar Tarea</button>
    </form>
    <h2>Tareas Pendientes</h2>
    <ul>
        <?php foreach ($tasks as $task): ?>
            <li><?php echo htmlspecialchars($task['task']); ?></li>
        <?php endforeach; ?>
    </ul>
    <a href="logout.php">Cerrar Sesión</a>
</body>
</html>