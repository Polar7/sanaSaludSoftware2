package GUI;

import controller.MainController;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Asignar {
    private JTextField cedula;
    private JButton buscarUsuario;
    private JTextField nombre;
    private JTextField opto;
    private JTextField oto;
    private JTextField psico;
    private JTextField gene;
    private JLabel Cedulalab;
    public JPanel panelAsignar;

    public Asignar() {
        buscarUsuario.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    MainController.getInstance().verificarPaciente(Integer.parseInt(cedula.getText()));
                    nombre.setText(MainController.getInstance().verificarPaciente(Integer.parseInt(cedula.getText())).getNombre());
                } catch (Exception ex) {
                    System.out.println(ex.getMessage());
                    nombre.setText("");
                }
            }
        });
    }
}
