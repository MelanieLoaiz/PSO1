def ubicarReinasAleatoriamente(tablero):
    """
        tablero: List of 8 (0,0,0,0,0,0,0) tuples

    Returns el tablero con 8 reinas ubicadas aleatoriamente
    """
  
    "*** YOUR CODE HERE ***"
    tupla = tuple(random.randint(0, 7) for _ in range(8))
    #return tupla

    return tablero

#David
def contarCantidadAtaques(tablero):
	return contar_repeticiones_total(tablero)
def contar_repeticiones_total(tupla):
    elementos_unicos = set(tupla)
    repeticiones_total = 0
    for elemento in elementos_unicos:
        apariciones = tupla.count(elemento)
        if apariciones > 1:
            # Sumar las repeticiones adicionales de cada elemento
            repeticiones_total += (apariciones - 1)
    return repeticiones_total


def imprimirConFormato(tablero):
    print(tablero)

#Carlos
def listaEstadosSucesores(tablero):
    "*** CAMBIAR ***"
    listaSucesores = []
    for i in range(len(tablero)):
        for j in range(len(tablero)):
            if tablero[i] != j:
                tablero_temporal = tablero[:]
                tablero_temporal[i] = j
                listaSucesores.append(tablero_temporal)

    return listaSucesores
#Luis
def highestValuedSuccessorState(listaEstados):
    
    tablero_ganador = None
    
    menor_ataques = None

    for tablero in listaEstados:
        num_ataques = contarCantidadAtaques(tablero)
        if menor_ataques is None: 
            menor_ataques = num_ataques
            tablero_ganador = tablero
        elif num_ataques < menor_ataques:
            menor_ataques = num_ataques
            tablero_ganador = tablero
    
    return tablero_ganador

def hillClimbing(tablero):
    current = tablero[:]
    while True:
        neighbor = highestValuedSuccessorState(listaEstadosSucesores(current))
        if(contarCantidadAtaques(neighbor) >= contarCantidadAtaques(current)):
             return current
        current = neighbor[:]
    

if __name__ == '__main__':
    
    #tablero = [0,5,5,4,6,3,7,2]
    tablero = [0,0,0,0,0,0,0,0]

    #print(contarCantidadAtaques(tablero))

    imprimirConFormato(hillClimbing(tablero))

