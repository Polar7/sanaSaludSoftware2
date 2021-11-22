package service;

import java.util.ArrayList;

public class SanaSalud
{
    private ArrayList<Paciente> pacientesSalaEspera;


    public SanaSalud()
    {
        pacientesSalaEspera = new ArrayList<Paciente>();
    }


    public  ArrayList<Paciente> darListaPacienteSalaEspera()
    {
        return pacientesSalaEspera;
    }

    public void cambiarListaPacienteSalaEspera(ArrayList<Paciente> nuevaLista)
    {
        pacientesSalaEspera = nuevaLista;
    }

    public void guardarEnSalaEspera(int cedula, String nombre, int edad, String sexo,String direccion)
    {
        Paciente persona = new Paciente( cedula,nombre,edad,sexo,direccion);
        pacientesSalaEspera.add(persona);
    }

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
