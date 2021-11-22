package GUI;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Ventana principal de la aplicación.
 */
public class Menu {

    /**
     * Boton para abrir la ventana de examenes
     */
    private JButton examenes;

    /**
     * Boton para abrir la ventana de asignaciones
     */
    private JButton asignaciones;

    /**
     * Boton para abrir la ventana de recepcion
     */
    private JButton recepcion;

    /**
     * Panel de la ventana principal
     */
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

    /**
     * Lanza una ventana mostrando un error al buscar un paciente
     */
    public void openNoExiste()
    {
        JOptionPane.showMessageDialog( null, "El paciente con la cedula proporcionada no existe", "Error", JOptionPane.ERROR_MESSAGE );
    }

    /**
     * Lanza una ventana mostrando un error al guardar un paciente
     * @param mensaje Mensaje de error
     */
    public void openErrorAlIngresar(String mensaje)
    {
        JOptionPane.showMessageDialog( null, mensaje, "Error", JOptionPane.ERROR_MESSAGE );
    }

    /**
     * Lanza una ventana con la confirmación de guardado del paciente
     */
    public void openSeLogroIngresar()
    {
        JOptionPane.showMessageDialog( null, "Se ha ingresado satisfactoriamente al paciente", "Ingreso correcto", JOptionPane.INFORMATION_MESSAGE );
    }

    /**
     * Lanza una ventana con la confirmacion del guardado en la base de datos
     * @param mensaje Mensaje a mostrar.
     */
    public void openOtorgarLicencia(String mensaje)
    {
        JOptionPane.showMessageDialog( null, mensaje, "Guardar en base de datos", JOptionPane.INFORMATION_MESSAGE);
    }

    /**
     * Lanza una ventana con un mensaje de examen
     */
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


    /**
     * Lanza la ventana principal
     */
    void openMenu() {
        JFrame frame = new JFrame("Sana Salud");
        frame.setContentPane(menu);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
