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
            JFrame frame = new JFrame("Calculadora de Propinas");
            frame.setSize(300, 250);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setLocationRelativeTo(null);
            frame.setLayout(null);

            JLabel lblMonto = new JLabel("Monto de la cuenta:");
            lblMonto.setBounds(20, 20, 150, 25);
            frame.add(lblMonto);

            JTextField txtMonto = new JTextField();
            txtMonto.setBounds(20, 45, 240, 25);
            frame.add(txtMonto);

            JLabel lblPorcentaje = new JLabel("Porcentaje de propina:");
            lblPorcentaje.setBounds(20, 80, 200, 25);
            frame.add(lblPorcentaje);

            JComboBox<String> comboPorcentaje = new JComboBox<>(new String[]{"10%", "15%", "20%"});
            comboPorcentaje.setBounds(20, 105, 240, 25);
            frame.add(comboPorcentaje);

            JButton btnCalcular = new JButton("Calcular");
            btnCalcular.setBounds(20, 140, 240, 30);
            frame.add(btnCalcular);

            JLabel lblResultado = new JLabel("Total a pagar: $0.00");
            lblResultado.setBounds(20, 180, 240, 25);
            frame.add(lblResultado);

            btnCalcular.addActionListener(e -> {
                try {
                    double monto = Double.parseDouble(txtMonto.getText());
                    String porcentajeStr = comboPorcentaje.getSelectedItem().toString();
                    int porcentaje = Integer.parseInt(porcentajeStr.replace("%", ""));
                    double propina = monto * porcentaje / 100;
                    double total = monto + propina;
                    lblResultado.setText("Total a pagar: $" + String.format("%.2f", total));
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(frame, "Por favor ingresa un monto válido.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            });

            frame.setVisible(true);
        });
    }
    
}
