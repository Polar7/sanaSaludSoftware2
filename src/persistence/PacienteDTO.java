package persistence;

import service.Paciente;

import java.io.Serializable;

public class PacienteDTO implements Dto, Serializable
{
    /**
     * Serializable de la clase
     */
    private static final long serialVersionUID = 568794L;

    private double cedula;
    private String nombre;
    private int edad;
    private String sexo;
    private String direccion;
    private String observaciones;

    public PacienteDTO(double cedula, String nombre, int edad, String sexo,String direccion, String observaciones)
    {
        this.cedula = cedula;
        this.nombre = nombre;
        this.edad = edad;
        this.sexo = sexo;
        this.direccion = direccion;
        this.observaciones = observaciones;
    }

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
