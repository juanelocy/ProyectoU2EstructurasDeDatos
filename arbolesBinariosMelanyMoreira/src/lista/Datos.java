package lista;

public class Datos {
	//------------------------------------------------------
	//				Atributos de la clase
	//------------------------------------------------------
	String nombre;
	String apellido;
	String color;
	String modelo;
	Integer cedula;
	//------------------------------------------------------
	// 					Constructor Vacio
	//------------------------------------------------------
	public Datos() {
		nombre=null;
		apellido=null;
		color=null;
		modelo=null;
		cedula=null;
	}
	//------------------------------------------------------
	// 					Constructor sobre cargado
	//------------------------------------------------------
	public Datos(String nombre, String apellido, String colorCarro, String modelo, Integer cedula) {
		this.nombre = nombre;
		this.apellido = apellido;
		this.color= colorCarro;
		this.modelo= modelo;		
		this.cedula=cedula;
	}
	public Datos(Integer cedula) {
		nombre=null;
		apellido=null;
		color=null;
		modelo=null;
		this.cedula=cedula;
	}
	public Datos(String nombre) {
		this.nombre=nombre;
		apellido=null;
		color=null;
		modelo=null;
		cedula=null;
	}
	//------------------------------------------------------
	// 					GETTERS Y SETTERS
	//------------------------------------------------------
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public String getColorCarro() {
		return color;
	}
	public void setColorCarro(String colorCarro) {
		this.color = colorCarro;
	}
	public String getModelo() {
		return modelo;
	}
	public void setModelo(String modelo) {
		this.modelo = modelo;
	}
	
	public Integer getCedula() {
		return cedula;
	}
	public void setCedula(Integer cedula) {
		this.cedula = cedula;
	}	
}
