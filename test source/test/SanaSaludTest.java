package test;
import org.junit.Test;
import service.Paciente;
import service.SanaSalud;

import static org.junit.Assert.*;

/**
 * Clase usada para verificar que los métodos de la clase SanaSalud estén correctamente implementados.
 */
public class SanaSaludTest
{
    // -----------------------------------------------------------------
    // Atributos
    // -----------------------------------------------------------------

    /**
     * SanaSalud en la que se realizarán las pruebas.
     */
    private SanaSalud sanaSalud;

    // -----------------------------------------------------------------
    // Escenarios
    // -----------------------------------------------------------------

    /**
     * Escenario 1: Construye un nuevo sistema de salud vacío.
     */
    public void setupEscenario1( )
    {
        sanaSalud = new SanaSalud();
    }

    /**
     * Prueba 1: Verifica el método guardarEnSalaEspera. <br>
     * <b> Métodos a probar: </b> <br>
     * guardarEnSalaEspera <br>
     * darListaPacienteSalaEspera <br>
     * <b> Objetivo: </b> Probar que el método guardarEnSalaEsperan sea capaz de registrar un paciente en el sistema correctamente. <br>
     * <b> Resultados esperados: </b> <br>
     * 1. Al buscar (por posicion) un paciente previamente agregado, este no debe ser nulo <br>
     */
    @Test
    public void testIngresarPaciente( )
    {
        setupEscenario1( );

        sanaSalud.guardarEnSalaEspera(12345, "jean", 20, "m", "mz e");
        Paciente pacienteAgregado = sanaSalud.darListaPacienteSalaEspera().get(0);

        assertNotNull("El paciente no deberia ser nulo", pacienteAgregado);
    }

    /**
     * Prueba 2: Verifica el método buscarPacienteEnSalaEspera. <br>
     * <b> Métodos a probar: </b> <br>
     * buscarPacienteEnSalaEspera <br>
     * <b> Objetivo: </b> Probar que el método buscarPacienteEnSalaEspera sea capaz de encontrar pacientes registrados en el sistema. <br>
     * <b> Resultados esperados: </b> <br>
     * 1. Al buscar un paciente previamente agregado, se debe obtener la posición donde se encuentra en el arreglo. <br>
     * 2. Al buscar un huracán que no exista, la posición retornada debe ser -1.
     */
    @Test
    public void testBuscarPaciente( )
    {
        setupEscenario1( );

        sanaSalud.guardarEnSalaEspera(12345, "jean", 20, "m", "mz e");
        Paciente pacienteAgregado = sanaSalud.darListaPacienteSalaEspera().get(0);
        Paciente pacienteBuscado = sanaSalud.buscarPacienteEnSalaEspera(12345);
        Paciente pacienteNoExiste = sanaSalud.buscarPacienteEnSalaEspera(987695);

        assertEquals( "El paciente debería estar en la posición 0.", pacienteAgregado, pacienteBuscado);
        assertNull("No deberia haber encontrado un paciente", pacienteNoExiste);
    }
}
