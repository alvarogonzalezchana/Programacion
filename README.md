class Cliente:
    def __init__(self, nombre, email):     # Inicializa un nuevo cliente con nombre y email
        self.nombre = nombre
        self.email = email
        self.pedidos = []  # Lista para almacenar los pedidos del cliente

    def agregar_pedido(self, pedido):
        self.pedidos.append(pedido)

class Pedido:
    def __init__(self, cliente, productos):  # Inicializa un nuevo pedido asociado a un cliente y una lista de productos
        self.cliente = cliente
        self.cliente = cliente
        self.productos = productos
        self.numero_pedido = len(cliente.pedidos) + 1  # Número de pedido basado en la cantidad de pedidos
        cliente.agregar_pedido(self)  # Agregar el pedido a la lista del cliente

class Tienda:
    def __init__(self):
        self.clientes = []  # Lista para almacenar clientes
        self.productos = ["Producto A", "Producto B", "Producto C"]  # Lista de productos disponibles

    def registrar_cliente(self):
        nombre = input("Ingrese el nombre del cliente: ")
        email = input("Ingrese el email del cliente (debe ser único): ")
        
        # Verificar si el email ya está registrado
        if any(cliente.email == email for cliente in self.clientes):
            print("Error: El email ya está registrado.")
            return
        
        nuevo_cliente = Cliente(nombre, email)
        self.clientes.append(nuevo_cliente)
        print(f"Cliente '{nombre}' registrado con éxito.")

    def visualizar_clientes(self):
        if not self.clientes:
            print("No hay clientes registrados.")
            return
        
        print("Clientes registrados:")
        for cliente in self.clientes:
            print(f"- Nombre: {cliente.nombre}, Email: {cliente.email}")

    def buscar_cliente(self):   # Permite buscar un cliente por su email
        email = input("Ingrese el email del cliente a buscar: ")
        for cliente in self.clientes:
            if cliente.email == email:
                print(f"Cliente encontrado: Nombre: {cliente.nombre}, Email: {cliente.email}")
                return
        print("Cliente no encontrado.")

    def realizar_compra(self): # Permite a un cliente realizar una compra
        email = input("Ingrese el email del cliente que realiza la compra: ")
        # Busca al cliente por su email
        cliente = next((c for c in self.clientes if c.email == email), None)
        
        if not cliente:
            print("Cliente no encontrado.")
            return
        # Muestra los productos disponibles para la compra
        print("Productos disponibles:")
        for i, producto in enumerate(self.productos, start=1):
            print(f"{i}. {producto}")
         # Solicita al usuario que seleccione productos
        productos_seleccionados = input("Ingrese los números de los productos separados por comas: ")
        indices = [int(i.strip()) - 1 for i in productos_seleccionados.split(",") if i.strip().isdigit()]
        productos_comprados = [self.productos[i] for i in indices if 0 <= i < len(self.productos)]
        
        if productos_comprados:
            nuevo_pedido = Pedido(cliente, productos_comprados)
            print(f"Compra realizada con éxito. Número de pedido: {nuevo_pedido.numero_pedido}")
        else:
            print("No se seleccionaron productos válidos.")

    def seguimiento_compra(self):  # Permite al usuario hacer seguimiento de un pedido mediante su número
        numero_pedido = int(input("Ingrese el número de pedido: "))
        for cliente in self.clientes:
            for pedido in cliente.pedidos:
                if pedido.numero_pedido == numero_pedido:    # Muestra los detalles del pedido encontrado
                    print(f"Pedido encontrado:\nCliente: {cliente.nombre}\nProductos: {', '.join(pedido.productos)}")
                    return
        print("Pedido no encontrado.")

def mostrar_menu():
    print("\nSeleccione una opción:")
    print("1. Registrar cliente")
    print("2. Visualizar clientes registrados")
    print("3. Buscar cliente")
    print("4. Realizar compra")
    print("5. Seguimiento de compra")
    print("6. Salir")

def main(): # Función principal que ejecuta la aplicación
    tienda = Tienda()
    while True:
        mostrar_menu()
        opcion = input("Seleccione una opción (1-6): ")

        if opcion == '1':
            tienda.registrar_cliente()   # Registra un nuevo cliente
        elif opcion == '2':
            tienda.visualizar_clientes()  # Muestra la lista de clientes registrados
        elif opcion == '3':
            tienda.buscar_cliente()
        elif opcion == '4':
            tienda.realizar_compra()  # Permite a un cliente realizar una compra
        elif opcion == '5':
            tienda.seguimiento_compra()
        elif opcion == '6':
            print("Saliendo de la aplicación...")
            break
        else:
            print("Opción no válida. Intente de nuevo.")   # Manejo de opciones no válidas

if __name__ == "__main__":
    main()
