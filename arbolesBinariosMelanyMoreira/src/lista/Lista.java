package lista;
import java.util.ArrayList;
import java.util.List;
public class Lista{
	//---------------------------
	//Atributos
	//---------------------------
    Nodo primero;
    Nodo ultimo;
	Nodo actual;
	Nodo nodoAnterior;
	//--------------------------
	// Variables globales
	//--------------------------
	int contador=1;
	//----------------------------------------
	//Constructor cuando no pasamos parametros
	//-----------------------------------------
    public Lista() {
        primero = null;
        ultimo= null;
    }
    
    //--------------------------------------------------------
    //Constructor sobrecargado, pasamos como parametro un nodo
    //--------------------------------------------------------
    public Lista(Nodo nodoIngresado) {
    	primero=nodoIngresado;
    	ultimo=primero;
    }    
    //------------------------------------------------------------
    //Método que me permite retornar si la LIsta está vaciá o no 
    //------------------------------------------------------------
    public boolean estaVacia() {
        return primero == null;
    }
    //-------------------------------------------------
    //Permite ingresar un nodo a la lista, pero como parametro pasamos un objeto de tipo Dato
    //Luego al objeto dato lo pasamos como atributos al objeto nuevo nodo para así poder insertar
    //el nuevo nodo
    //-------------------------------------------------
    public void insertar(Datos datos) {
        Nodo nuevoNodo = new Nodo(datos);
        //----------------------------------------------------------
        //Caso base cuando solo tenemos un nodo en la lista
        //----------------------------------------------------------
        if (estaVacia()) {
            primero = nuevoNodo;
            ultimo= nuevoNodo;
        } else {
            ultimo.setSiguienteNodo(nuevoNodo);
            nuevoNodo.setAnterior(ultimo);
            ultimo = nuevoNodo;
        }
    }
    //Me retorna la lista para poder usarla como una array list
    public List<Datos> getNodos() {
        List<Datos> listaNodos = new ArrayList<>();
        Nodo actual = primero;
        
        while (actual != null) {
            listaNodos.add(actual.getDatos());
            actual = actual.getSiguienteNodo();
        }        
        return listaNodos;
    }
    //---------------------------------
    //Métodos getters y setters 
    //---------------------------------
    public Nodo getPrimero() {
		return primero;
	}
	public void setPrimero(Nodo primero) {
		this.primero = primero;
	}
	public Nodo getUltimo() {
		return ultimo;
	}
	public void setUltimo(Nodo ultimo) {
		this.ultimo = ultimo;
	}
	public Nodo getActual() {
		return actual;
	}
	public void setActual(Nodo actual) {
		this.actual = actual;
	}
	public Nodo getNodoAnterior() {
		return nodoAnterior;
	}
	public void setNodoAnterior(Nodo nodoAnterior) {
		this.nodoAnterior = nodoAnterior;
	}
	public int getContador() {
		return contador;
	}
	public void setContador(int contador) {
		this.contador = contador;
	}
	//-----------------------------------------------------
	//Muestra todos los nodos de la lista por consola
	//No retorna nada porque muestra un mensaje 
	//-----------------------------------------------------
	public void mostrar() {
        if (estaVacia()) {
            System.out.println("La lista está vacía");
        } else {        	
            for(actual=primero;actual!=null; actual=actual.getSiguienteNodo()) {            	
            		System.out.println("----------------------------------------------");
            		System.out.println("                  Persona#"+contador);
            		System.out.println("----------------------------------------------");
		            Datos datos = actual.getDatos();
		            System.out.println("Nombre: " + datos.getNombre());
		            System.out.println("Apellido: " + datos.getApellido());
		            System.out.println("Color de carro: " + datos.getColorCarro());
		            System.out.println("Modelo: " + datos.getModelo());
		            System.out.println("Cédula: " + datos.getCedula());
		            contador=contador+1;
            }
        }
    }
  //-------------------------------------------------------
  //Busqueda secuencial solo para consola, se puede usar este metodo o el nuevo "binario"
	//Retorna el nodo buscado si es que lo encuentra y retorna null si no lo encuentra
  //-------------------------------------------------------
    public Nodo buscar(Nodo nodoBuscar) {
    	if(estaVacia()) {
    		System.out.println("La lista se encuentra Vacía");
    	}
    	else {
    		for(actual=primero; actual!=null; actual=actual.getSiguienteNodo()) {
    			if(nodoBuscar.getCedula()==actual.getCedula()) {
    				return actual;
    			}
    		}    		
    	}
		return null;
    }
    //-----------------------------------------
    //Muestra el nodo encontrado, pasando un nodo y mostrando los atributos del nodo pasado
    //No retorna nada porque muestra un mensaje 
    //-----------------------------------------
    void mostrarNodoEncontrado(Nodo nodo) {
        Datos datos = nodo.getDatos();
    	System.out.println("----------------------------------------------");
		System.out.println("                Persona["+datos.getCedula()+"]");
		System.out.println("----------------------------------------------");
        System.out.println("Nombre: " + datos.getNombre());
        System.out.println("Apellido: " + datos.getApellido());
        System.out.println("Color de la persona: " + datos.getColorCarro());
        System.out.println("Estado Civil: " + datos.getModelo());
        System.out.println("Cédula: " + datos.getCedula());
    }
    //----------------------------------------------------------------
    //Me permite retornar la cantidad de nodos de personas en la lista
    //valor a retornar tipo int 
    //----------------------------------------------------------------
    int sizeLista() {
    	contador=0;
		for(actual=primero; actual!=null; actual=actual.getSiguienteNodo()) {
			contador=contador+1;
		} 
		return contador;
    }
    //--------------------------------------------------
    //Permite eliminar un nodo, primero llamo al metodo buscar para saber si existe en la lista 
    //y como el metodo buscar me retorna un null o un nodo, puedo validar para poder eliminar ese nodo a eliminar
    //--------------------------------------------------
	public void eliminarNodo(Nodo nodoEliminar ) {
		Nodo nodoBuscado = nodoEliminar;
	    Nodo nodoEncontrado = buscar(nodoBuscado);
	    if (nodoEncontrado != null) {
	        Nodo actual = primero;
	        Nodo anterior = null;

	        // Búsqueda del nodo y del anterior
	        while (actual != null && actual != nodoEncontrado) {
	            anterior = actual;
	            actual = actual.getSiguienteNodo();
	        }

	        // Enlace del nodo anterior con el siguiente
	        if (actual == primero) {
	            primero = actual.getSiguienteNodo();
	        } else {
	            anterior.setSiguienteNodo(actual.getSiguienteNodo());
	        }
	        System.out.println("Se eliminó correctamente el nodo");
	    } else {
	        System.out.println("No se encontró el nodo");
	    }
	}
	//------------------------------------------------------------
	//Muestra todos los nodos de la lista y valida si está vacía
	//por consola
	//------------------------------------------------------------
	public void mostrarLista() {
	    if (estaVacia()) {
	        System.out.println("La lista está vacía");	      
	    } else {
	        int contador = 1;
	        Nodo actual = ultimo; // Comenzar desde el último nodo
	        while (actual != null) {
	            System.out.println("----------------------------------------------");
	            System.out.println("                  Persona #" + contador);
	            System.out.println("----------------------------------------------");
	            Datos datos = actual.getDatos();
	            System.out.println("Nombre: " + datos.getNombre());
	            System.out.println("Apellido: " + datos.getApellido());
	            System.out.println("Color de carro: " + datos.getColorCarro());
	            System.out.println("Modelo: " + datos.getModelo());
	            System.out.println("Cédula: " + datos.getCedula());
	            contador++;
	            actual = actual.getAnterior(); // Mover al nodo anterior
	        }
	    }
	}
	//----------------------------------------------------------------
	//Búsqueda binaria
	//----------------------------------------------------------------
	public Nodo busquedaBinaria(String nombreBuscar) {
		//Creo una lista donde obtengo todos los nodos 
	    List<Datos> listaNodos = getNodos();
	    int inicio = 0;
	    int fin = listaNodos.size() - 1;
	    while (inicio <= fin) {
	        int medio = inicio + (fin - inicio) / 2;
	        Datos datoMedio = listaNodos.get(medio);
	        int comparacion = nombreBuscar.compareTo(datoMedio.getNombre());
	        if (comparacion == 0) {
	            // Se encontró una coincidencia, devolver el nodo correspondiente
	            return encontrarNodoPorDatos(datoMedio);
	        } else if (comparacion > 0) {
	            fin = medio - 1; // Buscar en la mitad superior
	        } else {
	            inicio = medio + 1; // Buscar en la mitad inferior
	        }
	    }
	    return null; // No se encontró ninguna coincidencia
	}
	private Nodo encontrarNodoPorDatos(Datos datos) {
	    Nodo actual = primero;
	    while (actual != null) {
	        if (actual.getDatos().equals(datos)) {
	            return actual; // Se encontró el nodo con los datos correspondientes
	        }
	        actual = actual.getSiguienteNodo();
	    }
	    return null; // No se encontró el nodo con los datos correspondientes
	}
}

