<?php

?>

<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="styles.css">
    <title>StreamWeb - Página de Inicio</title>
</head>
<body>
    <main>
        <h1>Bienvenido a StreamWeb</h1>
        <p>Esta es una plataforma para gestionar usuarios de manera eficiente. Puedes registrar nuevos usuarios y gestionar la lista existente.</p>
    </main>
    <header>
        <nav>
            <ul>
                <li><a href="register.php">Registrar Usuario</a></li>
                <li><a href="manage.php">Gestionar Usuarios</a></li>
            </ul>
        </nav>
    </header>
    <main>
        <section>
            <h2>Planes y Paquetes</h2>
            <h3>Planes Base</h3>
            <ul>
                <li><strong>Básico</strong> (1 dispositivo) - 9,99 €</li>
                <li><strong>Estándar</strong> (2 dispositivos) - 13,99 €</li>
                <li><strong>Premium</strong> (4 dispositivos) - 17,99 €</li>
            </ul>
            <h3>Paquetes Adicionales</h3>
            <ul>
                <li><strong>Deporte</strong> - 6,99 €</li>
                <li><strong>Cine</strong> - 7,99 €</li>
                <li><strong>Infantil</strong> - 4,99 €</li>
            </ul>
        </section>
    </main>

    <footer>
        <p>&copy; <?php echo date("Y"); ?> StreamWeb. Todos los derechos reservados.</p>
    </footer>
</body>
</html>