package controller;

import GUI.Menu;
import service.Paciente;
import service.SanaSalud;

import java.util.ArrayList;

public class MainController
{
    /**
     * Guarda la referencia al controlador principal
     */
    private static MainController mainController = null;


    private SanaSalud sanaSalud;
    private Menu menu;

    private MainController (SanaSalud pSanaSalud, Menu pMenu)
    {
        sanaSalud = pSanaSalud;
        menu = pMenu;
    }

    /**
     * Devuelve la refencia del controlador, si no está creada la construye
     * @return La instancia del controlador
     */
    public static MainController getInstance()
    {
        if (mainController == null)
        {
            SanaSalud logic = new SanaSalud();
            Menu gui = new Menu();
            mainController = new MainController(logic, gui);
        }
        return mainController;
    }


    public void guardarPaciente(int cedula, String nombre, int edad, String sexo, String direccion)
    {
        sanaSalud.guardarEnSalaEspera(cedula,nombre,edad,sexo,direccion);
    }

    public Paciente verificarPaciente(int cedula) throws Exception {
        Paciente paciente = sanaSalud.buscarPacienteEnSalaEspera(cedula);

        if(paciente == null)
        {
            menu.openNoExiste();
            throw new Exception("No existe paciente");
        }
        else
        {
            return paciente;
        }
    }

    public ArrayList<Paciente> darListaPacientesEspera()
    {
        return sanaSalud.darListaPacienteSalaEspera();
    }

    /**
     * Metodo principal que inicia la aplicacion
     * @param args En este caso no son necesarios.
     */
    public static void main (String[] args)
    {
        MainController controller = getInstance();
    }
}
