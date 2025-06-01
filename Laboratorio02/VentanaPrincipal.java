//Keylor Castro, Laboratorio 02 - Curso de Programación I
package Laboratorio02;

import javax.swing.*;      // Importamos javax.swing para los componentes gráficos
import java.awt.*;         // Importamos java.awt para layouts
import java.awt.event.*;   // Importamos .event, para los eventos (como botones)
import java.io.*;          // Importamos .io para guardar y leer archivos

public class VentanaPrincipal extends JFrame {

    public VentanaPrincipal() {
        // Parte 1: Configurar la ventana
        setTitle("Formulario de Usuario");
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null); // Centrar la ventana

        // Parte 2: Crear la barra de menú
        JMenuBar barraMenu = new JMenuBar();
        JMenu menuArchivo = new JMenu("Archivo");
        JMenuItem itemNuevo = new JMenuItem("Nuevo");
        JMenuItem itemGuardar = new JMenuItem("Guardar");
        JMenuItem itemSalir = new JMenuItem("Salir");

        menuArchivo.add(itemNuevo);
        menuArchivo.add(itemGuardar);
        menuArchivo.add(itemSalir);
        barraMenu.add(menuArchivo);
        setJMenuBar(barraMenu);

        // Parte 3: Acción para "Salir"
        itemSalir.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        // Parte 4: Aquí empieza el formulario del usuario
        JPanel panelFormulario = new JPanel();
        panelFormulario.setLayout(new BoxLayout(panelFormulario, BoxLayout.Y_AXIS));
        panelFormulario.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        JLabel etiquetaNombre = new JLabel("Nombre:");
        JTextField campoNombre = new JTextField(20);

        JLabel etiquetaEmail = new JLabel("Email:");
        JTextField campoEmail = new JTextField(20);

        JLabel etiquetaTelefono = new JLabel("Telefono:");
        JTextField campoTelefono = new JTextField(20);

        JLabel etiquetaTipo = new JLabel("Tipo de usuario:");
        JComboBox<String> comboTipo = new JComboBox<>(new String[] {
            "", "Cliente", "Empleado", "Administrador"
        });

        JCheckBox checkTerminos = new JCheckBox("Aceptar terminos y condiciones");

        JButton btnGuardar = new JButton("Guardar");
        JButton btnLimpiar = new JButton("Limpiar");

        panelFormulario.add(etiquetaNombre);
        panelFormulario.add(campoNombre);
        panelFormulario.add(etiquetaEmail);
        panelFormulario.add(campoEmail);
        panelFormulario.add(etiquetaTelefono);
        panelFormulario.add(campoTelefono);
        panelFormulario.add(etiquetaTipo);
        panelFormulario.add(comboTipo);
        panelFormulario.add(checkTerminos);
        panelFormulario.add(Box.createRigidArea(new Dimension(0, 10)));
        panelFormulario.add(btnGuardar);
        panelFormulario.add(btnLimpiar);

        add(panelFormulario); // Agregar el formulario a la ventana

        // Parte 5: Funcionalidad del botón "Guardar"
        btnGuardar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String nombre = campoNombre.getText();
                String email = campoEmail.getText();
                String telefono = campoTelefono.getText();
                String tipo = (String) comboTipo.getSelectedItem();
                boolean acepta = checkTerminos.isSelected();

                // Validaciones básicas
                if (nombre.isEmpty() || email.isEmpty() || telefono.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Parece que olvidaste completar algo. Revisar nuevamente.");
                    return;
                }

                if (tipo == null || tipo.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Seleccione un tipo de usuario.");
                    return;
                }

                if (!acepta) {
                    JOptionPane.showMessageDialog(null, "Debe aceptar los términos y condiciones.");
                    return;
                }

                // Guardar los datos en archivo
                try (BufferedWriter writer = new BufferedWriter(new FileWriter("datos_usuario.txt"))) {
                    writer.write(nombre);
                    writer.newLine();
                    writer.write(email);
                    writer.newLine();
                    writer.write(telefono);
                    writer.newLine();
                    writer.write(tipo);
                    JOptionPane.showMessageDialog(null, "Datos guardados correctamente.");
                } catch (IOException ex) {
                    JOptionPane.showMessageDialog(null, "Error al guardar los datos.");
                    ex.printStackTrace();
                }
            }
        });

        // Parte 6.3: Botón "Limpiar"
        btnLimpiar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                campoNombre.setText("");
                campoEmail.setText("");
                campoTelefono.setText("");
                comboTipo.setSelectedIndex(0);
                checkTerminos.setSelected(false);
            }
        });

        // Parte 6.1 y 6.3 también aplica para el menú "Nuevo"
        itemNuevo.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                campoNombre.setText("");
                campoEmail.setText("");
                campoTelefono.setText("");
                comboTipo.setSelectedIndex(0);
                checkTerminos.setSelected(false);
            }
        });

        // Parte 6.5: Esta parte permiete cargar datos si el archivo ya existe
        File archivo = new File("datos_usuario.txt");
        if (archivo.exists()) {
            try (BufferedReader reader = new BufferedReader(new FileReader(archivo))) {
                campoNombre.setText(reader.readLine());
                campoEmail.setText(reader.readLine());
                campoTelefono.setText(reader.readLine());
                comboTipo.setSelectedItem(reader.readLine());
                checkTerminos.setSelected(true); // Marcamos términos como aceptados
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }

    // Método principal para ejecutar el programa
    public static void main(String[] args) {
        VentanaPrincipal ventana = new VentanaPrincipal();
        ventana.setVisible(true);
    }
}
