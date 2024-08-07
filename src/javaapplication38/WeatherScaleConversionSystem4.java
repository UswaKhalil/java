/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package javaapplication38;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class WeatherScaleConversionSystem4 {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(ConversionSelectionScreen::new);
    }
}

class ConversionSelectionScreen extends JFrame implements ActionListener {

    private JRadioButton cToF, cToK, kToC, kToF, fToC, fToK;
    private JButton submitButton;

    public ConversionSelectionScreen() {
        setTitle("Weather Scale Conversion System");
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel mainPanel = new JPanel(new BorderLayout(10, 10));
        mainPanel.setBorder(new EmptyBorder(10, 10, 10, 10));
        mainPanel.setBackground(Color.PINK);

        JLabel titleLabel = new JLabel("Please Select Appropriate Option", JLabel.CENTER);
        titleLabel.setFont(new Font("Serif", Font.BOLD, 20));
        mainPanel.add(titleLabel, BorderLayout.NORTH);

        JPanel optionsPanel = new JPanel(new GridLayout(6, 1, 8, 8));
        optionsPanel.setBackground(Color.WHITE);
        ButtonGroup group = new ButtonGroup();

        cToF = new JRadioButton("Celsius to Fahrenheit");
        cToF.setFont(new Font("SansSerif", Font.PLAIN, 16));
        cToF.setFocusPainted(false);
        group.add(cToF);
        optionsPanel.add(cToF);

        cToK = new JRadioButton("Celsius to Kelvin");
        cToK.setFont(new Font("SansSerif", Font.PLAIN, 16));
        cToK.setFocusPainted(false);
        group.add(cToK);
        optionsPanel.add(cToK);

        kToC = new JRadioButton("Kelvin to Celsius");
        kToC.setFont(new Font("SansSerif", Font.PLAIN, 16));
        kToC.setFocusPainted(false);
        group.add(kToC);
        optionsPanel.add(kToC);

        kToF = new JRadioButton("Kelvin to Fahrenheit");
        kToF.setFont(new Font("SansSerif", Font.PLAIN, 16));
        kToF.setFocusPainted(false);
        group.add(kToF);
        optionsPanel.add(kToF);
  
        fToC = new JRadioButton("Fahrenheit to Celsius");
        fToC.setFont(new Font("SansSerif", Font.PLAIN, 16));
        fToC.setFocusPainted(false);
        group.add(fToC);
        optionsPanel.add(fToC);

        fToK = new JRadioButton("Fahrenheit to Kelvin");
        fToK.setFont(new Font("SansSerif", Font.PLAIN, 16));
        fToK.setFocusPainted(false);
        group.add(fToK);
        optionsPanel.add(fToK);

        mainPanel.add(optionsPanel, BorderLayout.CENTER);

        submitButton = new JButton("Submit");
        submitButton.setFont(new Font("Serif", Font.BOLD, 18));
        submitButton.setBackground(new Color(70, 130, 180));
        submitButton.setForeground(Color.WHITE);
        submitButton.setFocusPainted(false);
        submitButton.addActionListener(this);
        mainPanel.add(submitButton, BorderLayout.SOUTH);

        add(mainPanel);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (cToF.isSelected()) {
            new ConversionScreen("Celsius to Fahrenheit");
        } else if (cToK.isSelected()) {
            new ConversionScreen("Celsius to Kelvin");
        } else if (kToC.isSelected()) {
            new ConversionScreen("Kelvin to Celsius");
        } else if (kToF.isSelected()) {
            new ConversionScreen("Kelvin to Fahrenheit");
        } else if (fToC.isSelected()) {
            new ConversionScreen("Fahrenheit to Celsius");
        } else if (fToK.isSelected()) {
            new ConversionScreen("Fahrenheit to Kelvin");
        }
        dispose();
    }
}

class ConversionScreen extends JFrame implements ActionListener {

    private JTextField inputField, resultField;
    private JLabel inputLabel, resultLabel;
    private JButton saveButton, convertButton, returnButton;
    private String conversionType;

    public ConversionScreen(String conversionType) {
        this.conversionType = conversionType;

        setTitle("Weather Scale Conversion System");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel mainPanel = new JPanel(new BorderLayout(10, 10));
        mainPanel.setBorder(new EmptyBorder(10, 10, 10, 10));
        mainPanel.setBackground(Color.LIGHT_GRAY);

        inputLabel = new JLabel("Please Enter Temperatue", JLabel.CENTER);
        inputLabel.setFont(new Font("Serif", Font.BOLD, 20));
        mainPanel.add(inputLabel, BorderLayout.NORTH);

        JPanel inputPanel = new JPanel(new GridLayout(2, 2, 5, 5));
        inputPanel.setBackground(Color.WHITE);

        inputField = new JTextField();
        inputField.setFont(new Font("SansSerif", Font.PLAIN, 16));
        inputPanel.add(new JLabel(conversionType.split(" ")[0] + ":", JLabel.RIGHT));
        inputPanel.add(inputField);

        resultLabel = new JLabel("", JLabel.RIGHT);
        inputPanel.add(resultLabel);

        resultField = new JTextField();
        resultField.setFont(new Font("SansSerif", Font.PLAIN, 16));
        resultField.setEditable(false);
        inputPanel.add(resultField);

        mainPanel.add(inputPanel, BorderLayout.CENTER);

        JPanel buttonPanel = new JPanel(new GridLayout(1, 3, 5, 5));
        buttonPanel.setBackground(Color.WHITE);

        convertButton = new JButton("Convert");
        convertButton.setFont(new Font("Serif", Font.BOLD, 18));
        convertButton.setBackground(new Color(255, 182, 193));
        convertButton.setForeground(Color.BLACK);
        convertButton.setFocusPainted(false);
        convertButton.addActionListener(this);
        buttonPanel.add(convertButton);

        saveButton = new JButton("Save");
        saveButton.setFont(new Font("Serif", Font.BOLD, 18));
        saveButton.setBackground(new Color(255, 182, 193));
        saveButton.setForeground(Color.BLACK);
        saveButton.setFocusPainted(false);
        saveButton.addActionListener(this);
        buttonPanel.add(saveButton);

        returnButton = new JButton("Return");
        returnButton.setFont(new Font("Serif", Font.BOLD, 18));
        returnButton.setBackground(new Color(255, 182, 193));
        returnButton.setForeground(Color.BLACK);
        returnButton.setFocusPainted(false);
        returnButton.addActionListener(this);
        buttonPanel.add(returnButton);

        mainPanel.add(buttonPanel, BorderLayout.SOUTH);

        add(mainPanel);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == convertButton) {
            double inputTemperature = Double.parseDouble(inputField.getText());
            double resultTemperature = convertTemperature(inputTemperature, conversionType);
            resultField.setText(String.format("%.2f", resultTemperature));
            resultLabel.setText(conversionType.split("to")[1].trim() + " = ");
        } else if (e.getSource() == saveButton) {
            try (BufferedWriter writer = new BufferedWriter(new FileWriter("Data_history.txt", true))) {
                writer.write("Conversion: " + conversionType + ", Input: " + inputField.getText() + ", Output: " + resultField.getText() + "\n");
                JOptionPane.showMessageDialog(this, "Conversion saved to file!");
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(this, "Error saving to file!");
            }
        } else if (e.getSource() == returnButton) {
            new ConversionSelectionScreen();
            dispose();
        }
    }

    private double convertTemperature(double temp, String conversionType) {
        switch (conversionType) {
            case "Celsius to Fahrenheit":
                return (temp * 9 / 5) + 32;
            case "Celsius to Kelvin":
                return temp + 273.15;
            case "Kelvin to Celsius":
                return temp - 273.15;
            case "Kelvin to Fahrenheit":
                return (temp - 273.15) * 9 / 5 + 32;
            case "Fahrenheit to Celsius":
                return (temp - 32) * 5 / 9;
            case "Fahrenheit to Kelvin":
                return (temp - 32) * 5 / 9 + 273.15;
            default:
                return 0;
        }
    }
}
