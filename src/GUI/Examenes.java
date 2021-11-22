package GUI;

import controller.MainController;
import service.Paciente;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Ventana para tomar los examenes
 */
public class Examenes {

    /**
     * Campo de texto para la cedula del paciente
     */
    private JTextField cedula;

    /**
     * Campo de texto para el nombre del paciente
     */
    private JTextField paciente;

    /**
     * Boton para registrar el resultado del examen.
     */
    private JButton registrar;

    /**
     * Boton para buscar el paciente
     */
    private JButton buscar;

    /**
     * Caja de opciones para el estado de los examenes
     */
    private JComboBox estado;

    /**
     * Caja de opciones con las zonas del laboratorio
     */
    private JComboBox area;

    /**
     * Área de texto para las observaciones al paciente
     */
    private JTextArea historia;

    /**
     * Panel de la ventana
     */
    public JPanel panelExamenes;

    /**
     * Construye la ventana de examenes
     */
    public Examenes() {
        registrar.setEnabled(false);
        buscar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    Paciente actual = MainController.getInstance().verificarPaciente(Integer.parseInt(cedula.getText()));
                    paciente.setText(actual.getNombre());
                    registrar.setEnabled(true);
                } catch (Exception ex) {
                    System.out.println(ex.getMessage());
                    paciente.setText("");
                }
            }
        });
        registrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    boolean aprobo = false;
                    Paciente actual = MainController.getInstance().verificarPaciente(Integer.parseInt(cedula.getText()));

                    if(estado.getSelectedItem().toString().equals("Aprobado"))
                    {
                        aprobo = true;
                    }

                    MainController.getInstance().registrarExamen(area.getSelectedItem().toString(), aprobo, historia.getText());

                    historia.setText("");
                } catch (Exception ex) {
                    System.out.println(ex.getMessage());
                }
            }
        });
    }
}
