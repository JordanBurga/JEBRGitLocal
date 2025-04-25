/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package jbgitlocal;

import javax.swing.*;
/**
 *
 * @author User
 */
public class JBgitlocal {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Calculadora de Propinas 2.0");
            frame.setSize(350, 400);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setLocationRelativeTo(null);
            frame.setLayout(null);

            // Monto de la cuenta
            JLabel lblMonto = new JLabel("Monto de la cuenta:");
            lblMonto.setBounds(20, 20, 200, 25);
            frame.add(lblMonto);

            JTextField txtMonto = new JTextField();
            txtMonto.setBounds(20, 45, 290, 25);
            frame.add(txtMonto);

            // Porcentaje de propina
            JLabel lblPorcentaje = new JLabel("Selecciona o escribe el porcentaje de propina:");
            lblPorcentaje.setBounds(20, 80, 300, 25);
            frame.add(lblPorcentaje);

            JComboBox<String> comboPorcentaje = new JComboBox<>(new String[]{"10%", "15%", "20%", "Otro..."});
            comboPorcentaje.setBounds(20, 105, 290, 25);
            frame.add(comboPorcentaje);

            JTextField txtPorcentajePersonalizado = new JTextField();
            txtPorcentajePersonalizado.setBounds(20, 135, 290, 25);
            txtPorcentajePersonalizado.setVisible(false);
            frame.add(txtPorcentajePersonalizado);

            // Número de personas
            JLabel lblPersonas = new JLabel("¿Entre cuántas personas dividir?");
            lblPersonas.setBounds(20, 170, 300, 25);
            frame.add(lblPersonas);

            JTextField txtPersonas = new JTextField("1");
            txtPersonas.setBounds(20, 195, 290, 25);
            frame.add(txtPersonas);

            // Botón calcular
            JButton btnCalcular = new JButton("Calcular");
            btnCalcular.setBounds(20, 230, 290, 35);
            frame.add(btnCalcular);

            // Resultados
            JLabel lblResultado = new JLabel("<html><b>Total a pagar:</b> $0.00<br><b>Propina:</b> $0.00<br><b>Total por persona:</b> $0.00</html>");
            lblResultado.setBounds(20, 280, 300, 60);
            frame.add(lblResultado);

            // Mostrar campo personalizado si se selecciona "Otro..."
            comboPorcentaje.addActionListener(e -> {
                boolean mostrarCampo = comboPorcentaje.getSelectedItem().toString().equals("Otro...");
                txtPorcentajePersonalizado.setVisible(mostrarCampo);
            });

            // Acción del botón
            btnCalcular.addActionListener(e -> {
                try {
                    double monto = Double.parseDouble(txtMonto.getText());
                    int porcentaje;

                    if (comboPorcentaje.getSelectedItem().toString().equals("Otro...")) {
                        porcentaje = Integer.parseInt(txtPorcentajePersonalizado.getText());
                    } else {
                        porcentaje = Integer.parseInt(comboPorcentaje.getSelectedItem().toString().replace("%", ""));
                    }

                    int personas = Integer.parseInt(txtPersonas.getText());
                    if (personas <= 0) throw new NumberFormatException();

                    double propina = monto * porcentaje / 100;
                    double total = monto + propina;
                    double porPersona = total / personas;

                    lblResultado.setText(String.format("<html><b>Total a pagar:</b> $%.2f<br><b>Propina:</b> $%.2f<br><b>Total por persona:</b> $%.2f</html>",
                            total, propina, porPersona));
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(frame, "Por favor ingresa valores numéricos válidos.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            });

            frame.setVisible(true);
        });
    }
    
}
