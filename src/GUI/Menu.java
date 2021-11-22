package GUI;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Menu {
    private JButton examenes;
    private JButton asignaciones;
    private JButton recepcion;
    private JPanel menu;

    /**
     * Construye la interfaz principal del aplicativo
     */
    public Menu() {
        openMenu();
        examenes.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                openExamenes();
            }
        });
        recepcion.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                openRecepcion();
            }
        });
        asignaciones.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                openAsignar();
            }
        });
    }

    public void openNoExiste()
    {
        JOptionPane.showMessageDialog( null, "El paciente con la cedula proporcionada no existe", "Error", JOptionPane.ERROR_MESSAGE );
    }

    public void openErrorAlIngresar()
    {
        JOptionPane.showMessageDialog( null, "Debes ingresar datos validos", "Error", JOptionPane.ERROR_MESSAGE );
    }

    public void openSeLogroIngresar()
    {
        JOptionPane.showMessageDialog( null, "Se ha ingresado satisfactoriamente al paciente", "Ingreso correcto", JOptionPane.INFORMATION_MESSAGE );
    }

    public void openOtorgarLicencia(String mensaje)
    {
        JOptionPane.showMessageDialog( null, mensaje, "Guardar en base de datos", JOptionPane.INFORMATION_MESSAGE);
    }

    public void openExamenCursado()
    {
        JOptionPane.showMessageDialog( null, "Se ha registrado el resultado de tu examen", "Examen cursado", JOptionPane.INFORMATION_MESSAGE);
    }

    /**
     * Lanza la ventana de Examenes
     */
    void openExamenes(){
        JFrame frame = new JFrame("Examenes");
        frame.setContentPane(new Examenes().panelExamenes);
        frame.pack();
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    /**
     * Lanza la ventana de Asignacion
     */
    void openAsignar(){
        JFrame frame = new JFrame("Asignar");
        frame.setContentPane(new Asignar().panelAsignar);
        frame.pack();
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    /**
     * Lanza la ventana de recepcion
     */
    void openRecepcion(){
        JFrame frame = new JFrame("Recepcion");
        frame.setContentPane(new Recepcion().panelRegistrar);
        frame.pack();
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }


    void openMenu() {
        JFrame frame = new JFrame("Sana Salud");
        frame.setContentPane(menu);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
