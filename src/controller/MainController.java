package controller;

import GUI.Menu;
import persistence.DataSource;
import persistence.PacienteDAO;
import persistence.PacienteDTO;
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
    private Paciente paciente;

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


    public void guardarPaciente(String cedula, String nombre, String edad, String sexo, String direccion)
    {
        try
        {
            if(nombre.equals("") || sexo.equals("") || direccion.equals(""))
            {
                throw new Exception();
            }
            sanaSalud.guardarEnSalaEspera(Integer.parseInt(cedula),nombre,Integer.parseInt(edad),sexo,direccion);
            menu.openSeLogroIngresar();
        } catch (Exception exception) {
            menu.openErrorAlIngresar();
        }
    }

    public Paciente verificarPaciente(int cedula) throws Exception {
        paciente = sanaSalud.buscarPacienteEnSalaEspera(cedula);

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


    public String comprobarOptometria()  {
        String mensaje = "";

        if(paciente.getOptometria() == false)
        {
            mensaje = "No aprobado";
        }else
        {
            mensaje = "Aprobado";
        }

        return mensaje;
    }

    public String comprobarGeneral()  {
        String mensaje = "";

        if(paciente.getGeneral() == false)
        {
            mensaje = "No aprobado";
        }else
        {
            mensaje = "Aprobado";
        }

        return mensaje;
    }

    public String comprobarOtorrino()  {
        String mensaje = "";

        if(paciente.getOtorrino() == false)
        {
            mensaje = "No aprobado";
        }else
        {
            mensaje = "Aprobado";
        }

        return mensaje;
    }

    public String comprobarPsicologia() {
        String mensaje = "";

        if(paciente.getPsicologia() == false)
        {
            mensaje = "No aprobado";
        }else
        {
            mensaje = "Aprobado";
        }

        return mensaje;
    }

    public boolean mereceLicencia()
    {
        return paciente.mereceLicencia();
    }

    public void otorgarLicencia()
    {
        PacienteDTO pacienteDto = new PacienteDTO(paciente.getCedula(), paciente.getNombre(), paciente.getEdad(), paciente.getSexo(), paciente.getDireccion(), paciente.getObservaciones());
        PacienteDAO pacienteDao = new PacienteDAO();

        String sql = pacienteDao.insert(pacienteDto);

        boolean sentinel = DataSource.getInstance().runExecuteUpdate(sql);

        if(sentinel)
        {
            menu.openOtorgarLicencia("¡Se ha otorgado la licencia satisfactoriamente!");
        }
        else
        {
            menu.openOtorgarLicencia("¡Ha ocurrido un problema con el servidor y no se ha otorgado la licencia!");
        }

    }

    public void registrarExamen(String unidad, boolean aprobo, String historia)
    {
        switch (unidad){
            case "Optometria" -> paciente.setOptometria(aprobo);
            case "Otorrinolaringologia" -> paciente.setOtorrino(aprobo);
            case "Psicologia" -> paciente.setPsicologia(aprobo);
            case "General" -> paciente.setGeneral(aprobo);
        }
        paciente.añadirHistoria(historia);

        menu.openExamenCursado();
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
