package GUI;

import controller.MainController;
import service.Paciente;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Examenes {
    private JTextField cedula;
    private JTextField paciente;
    private JButton registrar;
    private JButton buscar;
    private JComboBox estado;
    private JComboBox area;
    private JTextArea historia;
    public JPanel panelExamenes;

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
