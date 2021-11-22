package service;

/**
 * Clase que representa un paciente. <br>
 */
public class Paciente
{
    // --------------------------------------------------------
    // Atributos
    // --------------------------------------------------------

    /**
     * Cedula del paciente
     */
    private double cedula;

    /**
     * Nombre del paciente
     */
    private String nombre;

    /**
     * Edad del paciente
     */
    private int edad;

    /**
     * Sexo del paciente
     */
    private String sexo;

    /**
     * Direccion del paciente
     */
    private String direccion;

    /**
     * Observaciones del paciente
     */
    private String observaciones;

    /**
     * Indica si aprobó el examen de optometria
     */
    private Boolean optometria;

    /**
     * Indica si aprobó el examen de otorrinologia
     */
    private Boolean otorrino;

    /**
     * Indica si aprobó el examen de psicologia
     */
    private Boolean psicologia;

    /**
     * Indica si aprobó el examen general
     */
    private Boolean general;

    // -----------------------------------------------------------------
    // Constructores
    // -----------------------------------------------------------------

    /**
     * Construye un nuevo paciente con los valores dados por parámetro. <br>
     * <b>post: </b> Se construyó un paciente con los parámetros indicados.
     * @param cedula Cedula del paciente. cedula > 0
     * @param nombre Nombre del paciente. nombre != null && nombre != "".
     * @param edad Edad del paciente. Edad > 16
     * @param sexo Sexo del paciente. sexo != null && sexo != "".
     * @param direccion Direccion del paciente. direccion != null && direccion != "".
     */
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
        verificarInvariante();
    }

    // -----------------------------------------------------------------
    // Métodos
    // -----------------------------------------------------------------

    /**
     * Retorna la cedula del paciente
     * @return Cedula del paciente
     */
    public double getCedula()
    {
        return cedula;
    }

    /**
     * Retorna el nombre del paciente
     * @return Nombre del paciente
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Retorna la edad del paciente
     * @return Edad del paciente
     */
    public int getEdad() {
        return edad;
    }

    /**
     * Retorna el sexo del paciente
     * @return Sexo del paciente
     */
    public String getSexo() {
        return sexo;
    }

    /**
     * Retorna la dirección del paciente
     * @return Direccion del paciente
     */
    public String getDireccion() {
        return direccion;
    }

    /**
     * Retorna las observaciones del paciente
     * @return Observaciones del paciente
     */
    public String getObservaciones() {
        return observaciones;
    }

    /**
     * Retorna el estado del examen de optometría
     * @return true si aprobó, false de lo contrario
     */
    public Boolean getOptometria() {
        return optometria;
    }

    /**
     * Cambia el estado del examen de optometría
     * <b>post: </b> Se cambió estado recibido por parámetro
     * @param optometria Estado del examen
     */
    public void setOptometria(Boolean optometria) {
        this.optometria = optometria;
    }

    /**
     * Retorna el estado del examen de otorrinolaringología
     * @return true si aprobó, false de lo contrario
     */
    public Boolean getOtorrino() {
        return otorrino;
    }

    /**
     * Cambia el estado del examen de otorrinolaringología
     * <b>post: </b> Se cambió estado recibido por parámetro
     * @param otorrino Estado del examen
     */
    public void setOtorrino(Boolean otorrino) {
        this.otorrino = otorrino;
    }

    /**
     * Retorna el estado del examen de psicología
     * @return true si aprobó, false de lo contrario
     */
    public Boolean getPsicologia() {
        return psicologia;
    }

    /**
     * Cambia el estado del examen de optometría
     * <b>post: </b> Se cambió estado recibido por parámetro
     * @param psicologia Estado del examen
     */
    public void setPsicologia(Boolean psicologia) {
        this.psicologia = psicologia;
    }

    /**
     * Retorna el estado del examen general
     * @return true si aprobó, false de lo contrario
     */
    public Boolean getGeneral() {
        return general;
    }

    /**
     * Cambia el estado del examen de optometría
     * <b>post: </b> Se cambió estado recibido por parámetro
     * @param general Estado del examen
     */
    public void setGeneral(Boolean general) {
        this.general = general;
    }

    /**
     * Retorna si se merece la licencia de conducción.
     * @return true si aprobó todos los exámenes, false de lo contrario
     */
    public boolean mereceLicencia()
    {
        if(optometria && general && psicologia && otorrino)
        {
            return true;
        }
        return false;
    }

    /**
     * Añade una nueva observacion a la historia del paciente. <br>
     * <b>post: </b> Se añadió una nueva observacion recibida por parámetro.
     * @param historia Observacion nueva del paciente
     */
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
     * Retorna una cadena con el nombre del paciente. <br>
     * @return Retorna la representación del paciente en una cadena de caracteres.
     */
    public String toString( )
    {
        return nombre + "-" + cedula;
    }

    /**
     * Verifica el invariante de la clase. <br>
     */
    private void verificarInvariante()
    {
        assert nombre != null && !nombre.equals("") : "El nombre es invalido";
        assert cedula > 0 : "La cedula no puede ser negativa";
        assert direccion != null && !direccion.equals("") : "La direccion es invalida";
        assert edad >= 16 : "La edad debe ser mayor a 16";
        assert sexo != null && !sexo.equals("") : "El sexo es invalido";
    }
}
