def mostrar_cuadrado(lado):
    # Función para mostrar un cuadrado en pantalla
    for _ in range(lado):
        print('* ' * lado)  # Imprime una línea de asteriscos

def mostrar_rectangulo(base, altura):
    # Función para mostrar un rectángulo en pantalla
    for _ in range(altura):
        print('* ' * base)  # Imprime una línea de asteriscos

def calcular_area_perimetro_cuadrado(lado):
    # Calcula el área y el perímetro de un cuadrado
    area = lado ** 2
    perimetro = lado * 4
    return area, perimetro

def calcular_area_perimetro_rectangulo(base, altura):
    # Calcula el área y el perímetro de un rectángulo
    area = base * altura
    perimetro = 2 * (base + altura)
    return area, perimetro

while True:
    # Menú principal
    print("Menú:")
    print("1 - Cuadrado")
    print("2 - Rectángulo")
    print("3 - Salir")
    
    opcion = input("Seleccione una opción: ")
    
    if opcion == '1':
        lado = float(input("Ingrese el lado del cuadrado: "))
        mostrar_cuadrado(int(lado))  # Muestra el cuadrado
        area, perimetro = calcular_area_perimetro_cuadrado(lado)  # Calcula área y perímetro
        print(f"Área: {area}, Perímetro: {perimetro}")
        
    elif opcion == '2':
        base = float(input("Ingrese la base del rectángulo: "))
        altura = float(input("Ingrese la altura del rectángulo: "))
        mostrar_rectangulo(int(base), int(altura))  # Muestra el rectángulo
        area, perimetro = calcular_area_perimetro_rectangulo(base, altura)  # Calcula área y perímetro
        print(f"Área: {area}, Perímetro: {perimetro}")
        
    elif opcion == '3':
        print("Saliendo del programa.")
        break  # Sale del bucle y termina el programa
        
    else:
        print("Opción no válida. Intente de nuevo.")  # Mensaje de error para opción no válida