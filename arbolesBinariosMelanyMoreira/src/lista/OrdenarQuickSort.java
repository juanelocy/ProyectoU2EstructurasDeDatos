package lista;

public class OrdenarQuickSort {
    public static void ordenarPorNombre(Lista lista) {
        if (lista.estaVacia()) {
            System.out.println("La lista está vacía");
            return;
        }

        quickSort(lista, lista.getPrimero(), lista.getUltimo());
    }
    private static void quickSort(Lista lista, Nodo izquierda, Nodo derecha) {
        if (izquierda == null || derecha == null || izquierda == derecha) {
            return;
        }

        Nodo pivot = partition(lista, izquierda, derecha);

        if (pivot != null) {
            quickSort(lista, izquierda, pivot.getAnterior());
            quickSort(lista, pivot.getSiguienteNodo(), derecha);
        }
    }

    private static Nodo partition(Lista lista, Nodo izquierda, Nodo derecha) {
        Datos pivot = izquierda.getDatos();
        Nodo i = izquierda;
        Nodo j = derecha;

        while (i != j) {
            while (i != j && i != null && i.getDatos().getNombre().compareToIgnoreCase(pivot.getNombre()) <= 0) {
                i = i.getSiguienteNodo();
            }

            while (i != j && j != null && j.getDatos().getNombre().compareToIgnoreCase(pivot.getNombre()) > 0) {
                j = j.getAnterior();
            }

            if (i != null && j != null && i != j) {
                intercambiarDatos(i, j);
            }
        }

        if (i != null && izquierda != null && i != izquierda) {
            intercambiarDatos(izquierda, i);
        }

        return i;
    }
    private static void intercambiarDatos(Nodo nodo1, Nodo nodo2) {
        Datos temp = nodo1.getDatos();
        nodo1.setDatos(nodo2.getDatos());
        nodo2.setDatos(temp);
    }
}
