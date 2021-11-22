package GUI;

import controller.MainController;
import service.Paciente;

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
    private JButton otorgarLicenciaButton;

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
