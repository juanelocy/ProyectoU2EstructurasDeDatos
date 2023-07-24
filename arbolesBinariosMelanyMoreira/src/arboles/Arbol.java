package arboles;

public class Arbol {
	Nodo raiz;
	int contadorPersonasInOrden=0;
	//----------------------------------------------
	//        Constructores de la clase
	//----------------------------------------------
	public Arbol() {
		raiz=null;
	}
	public Arbol(Nodo nodo) {
		raiz=nodo;
	}
	//----------------------------------------------
	//       Operaciones para insertar los nodos
	//----------------------------------------------
	public boolean ArbolVacio() {
		if(raiz==null) {
			return true;
		}
		return false;
	}
	public void insertar(Datos dato) {
	    if (ArbolVacio()) {
	        Nodo nodo = new Nodo(dato);
	        raiz = nodo;
	    } else {
	        Nodo nodoNuevo = new Nodo(dato);
	        Nodo padre = null;
	        Nodo actual = raiz;
	        
	        while (actual != null) {
	            padre = actual;
	            actual = (nodoNuevo.getDato().getCedula() < actual.getDato().getCedula()) ? actual.getIzquierda() : actual.getDerecha();
	        }	        
	        if (nodoNuevo.getDato().getCedula() < padre.getDato().getCedula()) {
	            padre.setIzquierda(nodoNuevo);
	        } else {
	            padre.setDerecha(nodoNuevo);
	        }        
	        nodoNuevo.setPadre(padre);
	    }
	}
	//-----------------------------------------------------------
	//                     Mostrar el árbol in-orden
	//-----------------------------------------------------------
	public void mostrarInOrden(Nodo nodo) {
	    if (nodo != null) {
	        mostrarInOrden(nodo.getIzquierda());    // Recorro el subárbol izquierdo
	        System.out.println(nodo.getDato().getCedula());
	        System.out.println(nodo.getDato().getNombre());
	        System.out.println(nodo.getDato().getApellido());
	        System.out.println(nodo.getDato().getColor());
	        System.out.println(nodo.getDato().getEstado());
	        System.out.println("-----------------------------------------");
	        mostrarInOrden(nodo.getDerecha());      // Recorro el subárbol derecho
	    }
	}
	
    //--------------------------------------------------------
    //Buscar nodo que recibe un paremetro Datos 
    //--------------------------------------------------------
	public Nodo buscarNodoPorCedula(Nodo raiz, Integer cedulaBuscar) {
	    Nodo actual = raiz;

	    while (actual != null) {
	        Datos datosActual = actual.getDato();
	        // Realizar la comparación con la cédula para determinar en qué dirección seguir
	        int cedulaActual = datosActual.getCedula();
	        if (cedulaActual == cedulaBuscar) {
	            // Se encontró el nodo con la cédula buscada
	            return actual;
	        } else if (cedulaActual > cedulaBuscar) {
	            // Si la cédula actual es mayor, buscar en el subárbol izquierdo
	            actual = actual.getIzquierda();
	        } else {
	            // Si la cédula actual es menor, buscar en el subárbol derecho
	            actual = actual.getDerecha();
	        }
	    }

	    // Si no se encontró el nodo con la cédula buscada, devolver null
	    return null;
	}

	//-----------------------------------------------------------
	//                     Mostrar el árbol post-orden
	//-----------------------------------------------------------
	public void mostrarPostOrden(Nodo nodo) {
	    if (nodo != null) {
	        mostrarPostOrden(nodo.getIzquierda());    // Recorro el subárbol izquierdo
	        mostrarPostOrden(nodo.getDerecha());      // Recorro el subárbol derecho
	        System.out.println(nodo.getDato().getCedula());
	        System.out.println(nodo.getDato().getNombre());
	        System.out.println(nodo.getDato().getApellido());
	        System.out.println(nodo.getDato().getColor());
	        System.out.println(nodo.getDato().getEstado());
	        System.out.println("-----------------------------------------");
	    }
	}
	//-----------------------------------------------------------
	//                     Mostrar el árbol pre-orden
	//-----------------------------------------------------------
	public void mostrarPreOrden(Nodo nodo) {
	    if (nodo != null) {
	        System.out.println(nodo.getDato().getCedula());
	        System.out.println(nodo.getDato().getNombre());
	        System.out.println(nodo.getDato().getApellido());
	        System.out.println(nodo.getDato().getColor());
	        System.out.println(nodo.getDato().getEstado());
	        System.out.println("-----------------------------------------");	     
	        mostrarPreOrden(nodo.getIzquierda());    // Recorro el subárbol izquierdo
	        mostrarPreOrden(nodo.getDerecha());      // Recorro el subárbol derecho
	    }
	}
	//---------------------------------------------------------------
	//Número total de personas
	//---------------------------------------------------------------
	int  totalNodos=0;
	public int numNodos(Nodo nodo) {
	    if (nodo != null) {
	        numNodos(nodo.getIzquierda());    // Recorro el subárbol izquierdo	        
	        totalNodos=totalNodos+1;
	        numNodos(nodo.getDerecha());      // Recorro el subárbol derecho
	    }
	    return totalNodos;
	}
	//--------------------------------------------------------
	//Metodo que permite Contar Hojas y llama a el metodo recursivo contar hojas
	//--------------------------------------------------------
    public int contarHojas() {
        return contarHojasRecursivo(raiz);
    }
	//-----------------------------------------------------------------------
	//Contar Hojas Recursivo donde primero me compara si el árbol está vacío
	//-----------------------------------------------------------------------
    private int contarHojasRecursivo(Nodo nodo) {
        // Si el nodo es nulo, no hay hojas, retorna 0
        if (nodo == null) {
            return 0;
        }                   
        if (nodo.getIzquierda() == null && nodo.getDerecha() == null) {
            return 1;
        }      
        return contarHojasRecursivo(nodo.getIzquierda()) + contarHojasRecursivo(nodo.getDerecha());
    }          
	public Nodo getRaiz() {
		return raiz;
	}
	public void setRaiz(Nodo raiz) {
		this.raiz = raiz;
	}
	
}
