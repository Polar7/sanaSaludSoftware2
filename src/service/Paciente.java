package service;

public class Paciente
{
    private double cedula;
    private String nombre;
    private int edad;
    private String sexo;
    private String direccion;
    private String observaciones;
    private Boolean optometria;
    private Boolean otorrino;
    private Boolean psicologia;
    private Boolean general;

    public Paciente(double cedula, String nombre, int edad, String sexo, String direccion)
    {
        this.cedula = cedula;
        this.nombre = nombre;
        this.edad = edad;
        this.sexo = sexo;
        this.direccion = direccion;
        this.observaciones = "";
        this.optometria = false;
        this.otorrino = false;
        this.psicologia = false;
        this.general = false;
    }

    public double getCedula()
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

    public Boolean getOptometria() {
        return optometria;
    }

    public void setOptometria(Boolean optometria) {
        this.optometria = optometria;
    }

    public Boolean getOtorrino() {
        return otorrino;
    }

    public void setOtorrino(Boolean otorrino) {
        this.otorrino = otorrino;
    }

    public Boolean getPsicologia() {
        return psicologia;
    }

    public void setPsicologia(Boolean psicologia) {
        this.psicologia = psicologia;
    }

    public Boolean getGeneral() {
        return general;
    }

    public void setGeneral(Boolean general) {
        this.general = general;
    }

    public boolean mereceLicencia()
    {
        if(optometria && general && psicologia && otorrino)
        {
            return true;
        }
        return false;
    }

    public void añadirHistoria(String historia)
    {
        if(historia.equals(""))
        {

        }else
        {
            observaciones += " - " + historia ;
        }
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
