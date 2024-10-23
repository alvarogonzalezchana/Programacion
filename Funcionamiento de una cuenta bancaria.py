def main():
    # Solicita el saldo inicial de la cuenta
    while True:
        try:
            saldo = float(input("Ingrese el saldo inicial de la cuenta: "))  # Pide el saldo inicial
            if saldo >= 0:
                break  # Sale del bucle si el saldo es válido
            else:
                print("El saldo no puede ser negativo. Intente de nuevo.")
        except ValueError:
            print("Entrada no válida. Intente de nuevo.")  # Maneja entradas no válidas

    # Menú de opciones para el usuario
    while True:
        print("\nMenú:")
        print("1 - Ingresar dinero")
        print("2 - Retirar dinero")
        print("3 - Mostrar saldo")
        print("4 - Salir")
        
        opcion = input("Seleccione una opción: ")  # Solicita la opción del usuario
        
        if opcion == '1':
            # Opción para ingresar dinero
            while True:
                try:
                    ingreso = float(input("Ingrese la cantidad a ingresar: "))  # Pide la cantidad a ingresar
                    if ingreso >= 0:
                        saldo += ingreso  # Suma el ingreso al saldo
                        print(f"Nuevo saldo: {saldo}")  # Muestra el nuevo saldo
                        break  # Sale del bucle si el ingreso es válido
                    else:
                        print("No se pueden ingresar cantidades negativas.")
                except ValueError:
                    print("Entrada no válida. Intente de nuevo.")  # Maneja entradas no válidas
        
        elif opcion == '2':
            # Opción para retirar dinero
            while True:
                try:
                    retiro = float(input("Ingrese la cantidad a retirar: "))  # Pide la cantidad a retirar
                    if retiro < 0:
                        print("No se pueden retirar cantidades negativas.")
                    elif retiro > saldo:
                        print("No se puede retirar más de lo que tiene en la cuenta.")
                    else:
                        saldo -= retiro  # Resta el retiro del saldo
                        print(f"Nuevo saldo: {saldo}")  # Muestra el nuevo saldo
                        break  # Sale del bucle si el retiro es válido
                except ValueError:
                    print("Entrada no válida. Intente de nuevo.")  # Maneja entradas no válidas
        
        elif opcion == '3':
            # Opción para mostrar el saldo
            print(f"Saldo actual: {saldo}")  # Muestra el saldo actual
        
        elif opcion == '4':
            print("Saliendo del programa.")  # Mensaje de salida
            break  # Sale del bucle y termina el programa
        
        else:
            print("Opción no válida. Intente de nuevo.")  # Mensaje de error para opción no válida

# Llama a la función principal para iniciar el programa
main()