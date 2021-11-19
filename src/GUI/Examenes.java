package GUI;

import controller.MainController;

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
        buscar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    MainController.getInstance().verificarPaciente(Integer.parseInt(cedula.getText()));
                    paciente.setText(MainController.getInstance().verificarPaciente(Integer.parseInt(cedula.getText())).getNombre());
                } catch (Exception ex) {
                    System.out.println(ex.getMessage());
                    paciente.setText("");
                }
            }
        });
    }
}
