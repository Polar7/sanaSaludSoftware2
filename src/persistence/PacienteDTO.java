package persistence;

import java.io.Serializable;

/**
 * Clase DTO de un paciente
 */
public class PacienteDTO implements Dto, Serializable
{
    /**
     * Serializable de la clase
     */
    private static final long serialVersionUID = 568794L;

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
     * Construye una instacia de tipo DTO de un paciente
     * @param cedula Cedula del paciente. cedula > 0
     * @param nombre Nombre del paciente. nombre != null && nombre != "".
     * @param edad Edad del paciente. Edad > 16
     * @param sexo Sexo del paciente. sexo != null && sexo != "".
     * @param direccion Direccion del paciente. direccion != null && direccion != "".
     * @param observaciones Observaciones del paciente.
     */
    public PacienteDTO(double cedula, String nombre, int edad, String sexo,String direccion, String observaciones)
    {
        this.cedula = cedula;
        this.nombre = nombre;
        this.edad = edad;
        this.sexo = sexo;
        this.direccion = direccion;
        this.observaciones = observaciones;
    }

    /**
     * Crea una instrucción SQL para el paciente
     * @return La instrucción SQL
     */
    @Override
    public String insert()
    {
        String sql = "INSERT INTO public.pacientes(cedula, nombre, edad, sexo, direccion, observaciones) VALUES ("
                + cedula + ",'"
                + nombre.trim() + "',"
                + edad + ",'"
                + sexo.trim() + "','"
                + direccion.trim() + "','"
                + observaciones.trim() + "')";
        System.out.println(sql);

        return sql;
    }
}
