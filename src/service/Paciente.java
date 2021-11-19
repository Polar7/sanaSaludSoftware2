package service;

public class Paciente
{
    private int cedula;
    private String nombre;
    private int edad;
    private String sexo;
    private String direccion;
    private String observaciones;
    private Boolean a;
    private Boolean b;
    private Boolean c;
    private Boolean d;

    public Paciente(int cedula, String nombre, int edad, String sexo, String direccion)
    {
        this.cedula = cedula;
        this.nombre = nombre;
        this.edad = edad;
        this.sexo = sexo;
        this.direccion = direccion;
        this.observaciones = "";
        this.a = false;
        this.b = false;
        this.c = false;
        this.d = false;
    }

    public int getCedula()
    {
        return cedula;
    }

    public void setCedula(int pcedula)
    {
        cedula = pcedula;

    }

    public String getNombre() {
        return nombre;
    }

    public int getEdad() {
        return edad;
    }

    public String getSexo() {
        return sexo;
    }

    public String getDireccion() {
        return direccion;
    }

    public String getObservaciones() {
        return observaciones;
    }

    /**
     * Retorna una cadena con el nombre del paciente
     * @return Retorna la representación del paciente en una cadena de caracteres.
     */
    public String toString( )
    {
        return nombre + "-" + cedula;
    }
}
