package arboles;

public class Datos {
	//------------------------------------------------------
	//				Atributos de la clase
	//------------------------------------------------------
	String nombre;
	String apellido;
	String color;
	String estado;
	Integer cedula;
	//------------------------------------------------------
	// 					Constructor Vacio
	//------------------------------------------------------
	public Datos() {
		nombre=null;
		apellido=null;
		color=null;
		estado=null;
		cedula=null;
	}
	//------------------------------------------------------
	// 					Constructor sobre cargado
	//------------------------------------------------------
	public Datos(String nombre, String apellido, String color, String estado, Integer cedula) {
		this.nombre = nombre;
		this.apellido = apellido;
		this.color= color;
		this.estado= estado;		
		this.cedula=cedula;
	}
	public Datos(Integer cedula) {
		nombre=null;
		apellido=null;
		color=null;
		estado=null;
		this.cedula=cedula;
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
	public String getColor() {
		return color;
	}
	public void setColor(String colorCarro) {
		this.color = colorCarro;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	public Integer getCedula() {
		return cedula;
	}
	public void setCedula(Integer cedula) {
		this.cedula = cedula;
	}
}
