package persistence;

import service.Paciente;

import java.io.Serializable;

public class PacienteDTO implements Dto, Serializable
{
    /**
     * Serializable de la clase
     */
    private static final long serialVersionUID = 568794L;

    private int cedula;
    private String nombre;
    private int edad;
    private String sexo;
    private String direccion;
    private String observaciones;

    public PacienteDTO(int cedula, String nombre, int edad, String sexo,String direccion)
    {
        this.cedula = cedula;
        this.nombre = nombre;
        this.edad = edad;
        this.sexo = sexo;
        this.direccion = direccion;
        this.observaciones = "";
    }

    @Override
    public String insert()
    {
        String sql = "INSERT INTO public.record(cedula, nombre, edad, sexo, direccion, observaciones) VALUES ("
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
