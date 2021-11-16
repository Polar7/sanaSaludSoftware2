package test;
import org.junit.Before;
import org.junit.Test;
import service.Paciente;

import static org.junit.Assert.*;

public class PacienteTest
{
    // -----------------------------------------------------------------
    // Atributos
    // -----------------------------------------------------------------

    /**
     * Paciente en el que se realizarán las pruebas.
     */
    private Paciente paciente;

    // -----------------------------------------------------------------
    // Escenarios
    // -----------------------------------------------------------------

    /**
     * Crea una instancia de la clase Paciente. Este método se ejecuta antes de cada método de prueba.
     */
    @Before
    public void setupEscenario1( )
    {
        paciente = new Paciente( 12345, "Jean", 20, "Masculino", "mi casa" );
    }

    /**
     * Crea una instancia de la clase Paciente con otras propiedades.
     */
    public void setupEscenario2( )
    {
        paciente = new Paciente( 98765, "Michell", 34, "Femenino", "mi otra casa" );
    }

    // -----------------------------------------------------------------
    // Métodos de prueba
    // -----------------------------------------------------------------
    /**
     * <b>Prueba 1</b> : verifica el método constructor de la clase Paciente.<br>
     * <b>Métodos a probar: </b><br>
     * Paciente<br>
     * getCedula<br>
     * getNombre<br>
     * getEdad<br>
     * getSexo<br>
     * getDireccion<br>
     * <b>Casos de prueba:</b><br>
     * 1. Se crea el paciente 1 correctamente.
     * 2. Se crea el paciente 2 correctamente.
     */
    @Test
    public void testPaciente( )
    {
        // Caso de prueba 1

        assertEquals( "La cedula del paciente no corresponde", 12345, paciente.getCedula( ) );
        assertEquals( "El nombre del paciente no corresponde", paciente.getNombre( ), "Jean" );
        assertEquals( "La edad del paciente no es correcta", 20, paciente.getEdad( ));
        assertEquals( "El sexo del paciente no corresponde", paciente.getSexo( ), "Masculino" );
        assertEquals( "La direccion del paciente no corresponde", paciente.getDireccion( ), "mi casa" );


        // Caso de prueba 2
        setupEscenario2( );
        //        paciente = new Paciente( 98765, "Michell", 34, "Femenino", "mi otra casa" );

        assertEquals( "La cedula del paciente no corresponde", 98765, paciente.getCedula( ) );
        assertEquals( "El nombre del paciente no corresponde", paciente.getNombre( ), "Michell" );
        assertEquals( "La edad del paciente no es correcta", 34, paciente.getEdad( ));
        assertEquals( "El sexo del paciente no corresponde", paciente.getSexo( ), "Femenino" );
        assertEquals( "La direccion del paciente no corresponde", paciente.getDireccion( ), "mi otra casa" );

    }
}
