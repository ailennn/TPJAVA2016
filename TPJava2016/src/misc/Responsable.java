package misc;

public class Responsable {
	
	private String nombre;
	private long dni;
	private float sueldoFijo;
	
	public Responsable(String nombre, long dni, float sueldoFijo) {
		super();
		this.nombre = nombre;
		this.dni = dni;
		this.sueldoFijo = sueldoFijo;
	}
	//GETTERS & SETTERS
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public long getDni() {
		return dni;
	}
	public void setDni(long dni) {
		this.dni = dni;
	}
	public float getSueldoFijo() {
		return sueldoFijo;
	}
	public void setSueldoFijo(float sueldoFijo) {
		this.sueldoFijo = sueldoFijo;
	}
	
}
