package controller;

import GUI.Menu;
import persistence.DataSource;
import persistence.PacienteDAO;
import persistence.PacienteDTO;
import service.Paciente;
import service.SanaSalud;

import java.util.ArrayList;

/**
 * Clase que representa el controlador principal de la aplicacion
 */
public class MainController
{
    // --------------------------------------------------------
    // Atributos
    // --------------------------------------------------------

    /**
     * Guarda la referencia al controlador principal
     */
    private static MainController mainController = null;

    /**
     * Sistema de salud de la aplicacion
     */
    private SanaSalud sanaSalud;

    /**
     * Interfaz grafica principal de la aplicacion
     */
    private Menu menu;

    /**
     * Un paciente en el sistema de salud
     */
    private Paciente paciente;

    // -----------------------------------------------------------------
    // Constructores
    // -----------------------------------------------------------------

    /**
     * Construye el controlador principal con las dos capas de la aplicación recibidas por parámetro
     * <b>post: </b> Se construyó un paciente con los parámetros indicados.
     * @param pSanaSalud Sistema de salud de la aplicación. pSanaSalud != null
     * @param pMenu Interfaz principal de la aplicación. pMenu != null
     */
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


    /**
     * Guarda un paciente en la lista de espera con sus ventanas de confirmación.
     * <b>post: </b> Se guardó un paciente en la lista de espera
     * @param cedula Cedula del paciente. cedula > 0
     * @param nombre Nombre del paciente. nombre != null && nombre != "".
     * @param edad Edad del paciente. Edad > 16
     * @param sexo Sexo del paciente. sexo != null && sexo != "".
     * @param direccion Dirección del paciente. dirección != null && dirección != "".
     * @throws Exception Si la cédula o edad no son números
     * @throws AssertionError Si algún parámetro viola la invariante de la clase Paciente
     */
    public void guardarPaciente(String cedula, String nombre, String edad, String sexo, String direccion)
    {
        try
        {
            sanaSalud.guardarEnSalaEspera(Integer.parseInt(cedula),nombre,Integer.parseInt(edad),sexo,direccion);
            menu.openSeLogroIngresar();
        } catch (Exception exception) {
            menu.openErrorAlIngresar("La cédula o edad deben ser números");
        } catch (AssertionError assertionError)
        {
            menu.openErrorAlIngresar(assertionError.getMessage());
        }
    }

    /**
     * Busca un paciente en la lista de espera.
     * @param cedula Cédula del paciente.
     * @return El paciente buscado, null si no lo encuentra
     * @throws Exception Si el paciente buscado no existe
     */
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

    /**
     * Retorna la lista de pacientes en la sala de espera
     * @return La lista de pacientes en la sala de espera.
     */
    public ArrayList<Paciente> darListaPacientesEspera()
    {
        return sanaSalud.darListaPacienteSalaEspera();
    }


    /**
     * Comprueba si aprobó o no el examen de optometría.
     * @return Una cadena de texto indicando el estado del examen.
     */
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

    /**
     * Comprueba si aprobó o no el examen general.
     * @return Una cadena de texto indicando el estado del examen.
     */
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

    /**
     * Comprueba si aprobó o no el examen de otorrinolaringología.
     * @return Una cadena de texto indicando el estado del examen.
     */
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

    /**
     * Comprueba si aprobó o no el examen de psicología.
     * @return Una cadena de texto indicando el estado del examen.
     */
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

    /**
     * Verifica si el paciente merece la aprobación de la licencia. <br>
     * @return True si aprobó todos los examenes, false de lo contario.
     */
    public boolean mereceLicencia()
    {
        return paciente.mereceLicencia();
    }

    /**
     * Otorga la aprobacion de la licencia de conduccion. <br>
     * Este registro se guarda en una base de datos.
     * Se muestra una ventana de confirmación.
     * <b>post: </b> Se guardó el registro del paciente en la base de datos.
     * @throws Exception Si ocurre un problema al guardar en la base de datos.
     */
    public void otorgarLicencia()
    {
        try
        {
            PacienteDTO pacienteDto = new PacienteDTO(paciente.getCedula(), paciente.getNombre(), paciente.getEdad(), paciente.getSexo(), paciente.getDireccion(), paciente.getObservaciones());
            PacienteDAO pacienteDao = new PacienteDAO();

            String sql = pacienteDao.insert(pacienteDto);

            boolean sentinel = DataSource.getInstance().runExecuteUpdate(sql);

            if(sentinel)
            {
                menu.openOtorgarLicencia("¡Se ha guardado la aprobación de la licencia en el sistema satisfactoriamente!");
            }
            else
            {
                menu.openOtorgarLicencia("¡Ha ocurrido un problema con el servidor y no se ha guardado la licencia!");
            }
        } catch (Exception exception)
        {
            menu.openOtorgarLicencia("¡Ha ocurrido un problema con el servidor y no se ha guardado la licencia!");
        }

    }

    /**
     * Registra la aprobación o no de un examen. <br>
     * @param unidad Unidad donde se hizo el examen.
     * @param aprobo Estado del examen hecho.
     * @param historia Observaciones hechas en el examen.
     */
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
