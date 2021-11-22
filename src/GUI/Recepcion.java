package GUI;

import controller.MainController;

import javax.swing.*;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Ventana para guardar un paciente
 */
public class Recepcion {

    /**
     *
     */
    public JPanel panelRegistrar;

    /**
     *
     */
    private JTextField nombre;

    /**
     *
     */
    private JTextField cedula;

    /**
     *
     */
    private JTextField edad;

    /**
     *
     */
    private JTextField sexo;

    /**
     *
     */
    private JTextField direccion;

    /**
     *
     */
    private JButton registrar;

    /**
     *
     */
    private JButton limpiar;

    /**
     *
     */
    private JButton refrescar;

    /**
     *
     */
    private JScrollBar scrollBar;

    /**
     *
     */
    private JList listaPacientes;

    /**
     * Construye la ventana de recepcion
     */
    public Recepcion() {

        registrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MainController.getInstance().guardarPaciente(cedula.getText(), nombre.getText(),edad.getText(), sexo.getText(), direccion.getText());
            }
        });
        refrescar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                listaPacientes.setListData(MainController.getInstance().darListaPacientesEspera().toArray( ) );
            }
        });
        limpiar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                nombre.setText("");
                cedula.setText("");
                edad.setText("");
                sexo.setText("");
                direccion.setText("");
            }
        });
    }
}
