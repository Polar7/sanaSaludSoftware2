package GUI;

import controller.MainController;
import service.Paciente;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Ventana para verificar el estado de los examenes y otorgar licencia
 */
public class Asignar {

    /**
     * Campo de texto para la cedula del paciente
     */
    private JTextField cedula;

    /**
     * Boton para buscar un paciente
     */
    private JButton buscarUsuario;

    /**
     * Campo de texto para el nombre del paciente
     */
    private JTextField nombre;

    /**
     * Campo de texto para el estado del examen de optometría.
     */
    private JTextField opto;

    /**
     * Campo de texto para el estado del examen de otorrinolaringología
     */
    private JTextField oto;

    /**
     * Campo de texto para el estado del examen de psicología.
     */
    private JTextField psico;

    /**
     * Campo de texto para el estado del examen general.
     */
    private JTextField gene;

    /**
     * Label para la cedula
     */
    private JLabel Cedulalab;

    /**
     * Panel de la ventana
     */
    public JPanel panelAsignar;

    /**
     * Boton para aprobar la licencia
     */
    private JButton otorgarLicenciaButton;

    /**
     * Construye la ventana de asignaciones
     */
    public Asignar() {
        otorgarLicenciaButton.setEnabled(false);
        buscarUsuario.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    Paciente actual = MainController.getInstance().verificarPaciente(Integer.parseInt(cedula.getText()));
                    nombre.setText(actual.getNombre());
                    opto.setText(MainController.getInstance().comprobarOptometria());
                    psico.setText(MainController.getInstance().comprobarPsicologia());
                    gene.setText(MainController.getInstance().comprobarGeneral());
                    oto.setText(MainController.getInstance().comprobarOtorrino());
                    if(MainController.getInstance().mereceLicencia())
                    {
                        otorgarLicenciaButton.setEnabled(true);
                    }
                } catch (Exception ex) {
                    System.out.println(ex.getMessage());
                    nombre.setText("");
                    opto.setText("");
                    psico.setText("");
                    gene.setText("");
                    oto.setText("");
                }
            }
        });
        otorgarLicenciaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                MainController.getInstance().otorgarLicencia();
            }
        });
    }
}
