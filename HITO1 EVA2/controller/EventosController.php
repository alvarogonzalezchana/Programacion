<?php

class UsuariosController {
    private $db;

    public function __construct($dbConnection) {
        $this->db = $dbConnection;
    }
    
    public function listarUsuarios() {
        // Lógica para obtener la lista de usuarios
        $usuarios = [];
        try {
            $stmt = $this->db->prepare("SELECT id, nombre, apellidos, correo, edad, plan_base, paquete_adicional, duracion FROM usuarios");
            $stmt->execute();
            $usuarios = $stmt->fetchAll(PDO::FETCH_ASSOC);
        } catch (PDOException $e) {
            // Manejo de errores
            echo "Error al obtener usuarios: " . $e->getMessage();
        }
        
        return $usuarios;
    }
}

// Ejemplo de uso
try {
    // Establecer conexión a la base de datos
    $dbConnection = new PDO('mysql:host=localhost;dbname=tu_base_de_datos', 'tu_usuario', 'tu_contraseña');
    $dbConnection->setAttribute(PDO::ATTR_ERRMODE, PDO::ERRMODE_EXCEPTION);

    $usuariosController = new UsuariosController($dbConnection);
    $usuarios = $usuariosController->listarUsuarios();

    // Mostrar la lista de usuarios
    print_r($usuarios);
} catch (PDOException $e) {
    echo "Error de conexión: " . $e->getMessage();
}
?>