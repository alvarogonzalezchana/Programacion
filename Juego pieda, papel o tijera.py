import random  # Importa el módulo random para generar números aleatorios

def jugar():
    opciones = {1: "Piedra", 2: "Papel", 3: "Tijera"}  # Diccionario de opciones
    usuario_ganadas = 0  # Contador de victorias del usuario
    maquina_ganadas = 0  # Contador de victorias de la máquina

    while usuario_ganadas < 3 and maquina_ganadas < 3:  # El juego continúa hasta que uno gane 3 veces
        print("Seleccione una opción:")
        print("1 - Piedra")
        print("2 - Papel")
        print("3 - Tijera")
        
        while True:
            try:
                usuario = int(input("Ingrese su elección (1-3): "))  # Solicita la elección del usuario
                if usuario in opciones:
                    break  # Sale del bucle si la opción es válida
                else:
                    print("Opción no válida. Intente de nuevo.")
            except ValueError:
                print("Entrada no válida. Intente de nuevo.")
        
        maquina = random.randint(1, 3)  # Genera una elección aleatoria para la máquina
        print(f"Usted eligió: {opciones[usuario]}")
        print(f"La máquina eligió: {opciones[maquina]}")

        # Determina el resultado del juego
        if usuario == maquina:
            print("Empate!")
        elif (usuario == 1 and maquina == 3) or (usuario == 2 and maquina == 1) or (usuario == 3 and maquina == 2):
            print("¡Usted ganó!")
            usuario_ganadas += 1  # Incrementa el contador de victorias del usuario
        else:
            print("¡La máquina ganó!")
            maquina_ganadas += 1  # Incrementa el contador de victorias de la máquina

    print("Juego terminado.")
    print(f"Usted ganó {usuario_ganadas} veces, la máquina ganó {maquina_ganadas} veces.")

jugar()  # Llama a la función para iniciar el juego1
