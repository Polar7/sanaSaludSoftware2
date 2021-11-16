package service;

import java.util.List;

public class SanaSalud
{
    private static List<Paciente> pacientesalaEspera;

    //internal static List<Paciente> PacienteSalaEspera { get => pacientesalaEspera; set => pacientesalaEspera = value; }

    public static List<Paciente> darListaPacienteSalaEspera()
    {
        return pacientesalaEspera;
    }

    public static void cambiarListaPacienteSalaEspera(List<Paciente> nuevaLista)
    {
        pacientesalaEspera = nuevaLista;
    }

    public void guardarsalaespera(int cedula, String nombre, int edad, String sexo,String direccion)
    {
        Paciente persona = new Paciente( cedula,nombre,edad,sexo,direccion);
        pacientesalaEspera.add(persona);
    }


}
