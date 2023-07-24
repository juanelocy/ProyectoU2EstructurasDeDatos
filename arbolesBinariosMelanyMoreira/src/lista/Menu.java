package lista;
import java.util.Scanner;
public class Menu {
    void menu(Lista lista) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("---------------------------------------------");
        System.out.println("          Menú principal ");
        System.out.println("---------------------------------------------");
        System.out.println("Presione 1..............Para añadir nuevos clientes");
        System.out.println("Presione 2..............Para buscar clientes");
        System.out.println("Presione 3..............Para ver cuántos clientes hay");
        System.out.println("Presione 4..............Para mostrar lista de clientes");
        System.out.println("Presione 5..............Para Eliminar cliente");
        System.out.println("Presione 6..............Para ordenar con QuickSort");
        System.out.println("Presione 7..............Para salir");
        System.out.print("Ingrese su opción: ");
        int opcion = scanner.nextInt();
        switch (opcion) {
            case 1:
                System.out.println("---------------------------------------------");
                System.out.println("             Ingreso de clientes");
                System.out.println("---------------------------------------------");
                System.out.println("Cuántos clientes desea ingresar?");
                int cantidadClientes = scanner.nextInt();
                scanner.nextLine();
                for (int i = 1; i <= cantidadClientes; i++) {
                    System.out.println("---------------------------------------------");
                    System.out.println("             Cliente #" + i);
                    System.out.println("---------------------------------------------");
                    System.out.println("Ingrese el nombre del cliente:");
                    String nombre = scanner.nextLine();
                    System.out.println("Ingrese el apellido del cliente:");
                    String apellido = scanner.nextLine();
                    System.out.println("Ingrese el color del cliente:");
                    String colorCarro = scanner.nextLine();
                    System.out.println("Ingrese su estado civil:");
                    String modelo = scanner.nextLine();                  
                    System.out.println("Ingrese su número de cédula:");
                    Integer cedula = scanner.nextInt();
                    scanner.nextLine();
                    Datos datos = new Datos(nombre, apellido, colorCarro, modelo, cedula);                 
                    lista.insertar(datos);
                }                
                System.out.println("---------------------------------------------");
                System.out.println("    Se ingresaron correctamente los clientes");
                System.out.println("---------------------------------------------");
                menu(lista);
                break;
            case 2:
                System.out.println("---------------------------------------------");
                System.out.println("              BUSCAR CLIENTES");
                System.out.println("---------------------------------------------");
                System.out.println("Ingrese el número de cédula:");          
                Integer cedulaBuscar = scanner.nextInt();
                Datos datosBuscar = new Datos(cedulaBuscar);
                Nodo nodoBuscar= new Nodo(datosBuscar);
                nodoBuscar=lista.buscar(nodoBuscar);
                if(nodoBuscar==null) {
                	System.out.println("--------------------------------------------");
                	System.out.println("No existe cliente con ese numero de cédula");
                	System.out.println("--------------------------------------------");                	
                }
                else {
                	lista.mostrarNodoEncontrado(nodoBuscar);
                }
                menu(lista);
            	break;
            case 3:
                System.out.println("---------------------------------------------");
                System.out.println("              Cantidad clientes");
                System.out.println("---------------------------------------------");
                lista.sizeLista();
            	break;      
            case 4:
                System.out.println("---------------------------------------------");
                System.out.println("         Lista de clientes");
                System.out.println("---------------------------------------------");
                lista.mostrar();
                menu(lista);
                break;
            case 5:
                System.out.println("---------------------------------------------");
                System.out.println("     Eliminar Cliente con numero de cédula");
                System.out.println("---------------------------------------------");
                System.out.println("Ingrese el número de cédula:");          
                Integer cedulaBuscar2 = scanner.nextInt();
                Datos datosBuscar2 = new Datos(cedulaBuscar2);
                Nodo nodoBuscar2= new Nodo(datosBuscar2);
                nodoBuscar=lista.buscar(nodoBuscar2);
                if(nodoBuscar==null) {
                	System.out.println("--------------------------------------------");
                	System.out.println("No existe cliente con ese numero de cédula");
                	System.out.println("--------------------------------------------");                	
                }
                else {
                	lista.eliminarNodo(nodoBuscar2);
                }
                menu(lista);
                break;   
            case 6:
                System.out.println("---------------------------------------------");
                System.out.println("          Ordenando nodo por Nombres");
                System.out.println("---------------------------------------------");
                OrdenarQuickSort.ordenarPorNombre(lista);
                lista.mostrarLista();
                menu(lista);
                break;
            case 7:
                System.out.println("---------------------------------------------");
                System.out.println("         Muchas gracias por su visita");
                System.out.println("---------------------------------------------");
                break;               
            default:
                System.out.println("Opción no válida");
                menu(lista);
                break;
        }
        scanner.close();
    }
}