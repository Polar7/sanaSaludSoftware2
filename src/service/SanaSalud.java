package service;

import java.util.ArrayList;

/**
 * Clase que representa un sistema de salud para otorgar licencias. <br>
 */
public class SanaSalud
{
    // --------------------------------------------------------
    // Atributos
    // --------------------------------------------------------

    /**
     * Lista de pacientes en el consultorio
     */
    private ArrayList<Paciente> pacientesSalaEspera;

    /**
     * Construye el consultorio con una lista de pacientes vacía.
     * <b>post: </b> Se construyó un consultorio con la lista de pacientes vacía.
     */
    public SanaSalud()
    {
        pacientesSalaEspera = new ArrayList<Paciente>();
    }

    /**
     * Retorna la lista de pacientes en la sala de espera
     * <b>pre: </b> La lista de pacientes se encuentra inicializada.
     * @return La lista de pacientes
     */
    public ArrayList<Paciente> darListaPacienteSalaEspera()
    {
        return pacientesSalaEspera;
    }

    /**
     * Agrega un nuevo paciente a la lista de espera.
     * <b>pre: </b> La lista de pacientes se encuentra inicializada.
     * <b>post: </b> Se agregó un nuevo paciente a la lista de espera dados los parámetros.
     * @param cedula Cedula del paciente. cedula > 0
     * @param nombre Nombre del paciente. nombre != null && nombre != "".
     * @param edad Edad del paciente. Edad > 16
     * @param sexo Sexo del paciente. sexo != null && sexo != "".
     * @param direccion Direccion del paciente. direccion != null && direccion != "".
     */
    public void guardarEnSalaEspera(double cedula, String nombre, int edad, String sexo,String direccion)
    {
        Paciente persona = new Paciente( cedula,nombre,edad,sexo,direccion);
        pacientesSalaEspera.add(persona);
    }

    /**
     * Busca un paciente en la lista de espera, si lo encuentra lo retorna.
     * <b>pre: </b> La lista de pacientes se encuentra inicializada.
     * @param cedula Cedula del paciente. cedula > 0
     * @return El paciente buscado, si no existe retorna null.
     */
    public Paciente buscarPacienteEnSalaEspera(int cedula)
    {
        Paciente buscado = null;
        for (int i = 0; i < pacientesSalaEspera.size(); i++) {
            if (pacientesSalaEspera.get(i).getCedula() == cedula)
            {
                buscado = pacientesSalaEspera.get(i);
            }
        }
        return buscado;
    }

}
