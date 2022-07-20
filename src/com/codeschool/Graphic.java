package com.codeschool;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Graphic implements ActionListener {
    private JPanel graphic;
    private JTextPane graphics;
    private JButton backButton;


    private File file = new File("/Users/arpine/IdeaProjects/bank_calculator_loan/src/com/codeschool/graphic.txt");

    public Graphic() {
        backButton.addActionListener(this);
    }

    public JPanel getGraphic() {
        return graphic;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Calculator calculator=new Calculator();
    }

    public void writer(JLabel monthlyPayment, JTextField year) {
        DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
        LocalDateTime myDateObj = LocalDateTime.now();
        String formattedDate = myDateObj.format(myFormatObj);

        int year1 = myDateObj.getYear();
        int month = myDateObj.getMonthValue();

        try {
            FileWriter fw = new FileWriter(file, true);
            PrintWriter pw = new PrintWriter(fw);
            pw.println("Start: " + formattedDate);
            while (month != myDateObj.getMonthValue() || year1 != myDateObj.getYear() + Integer.parseInt(year.getText())) {
                pw.println(month + "-" + year1 + ": " + monthlyPayment.getText());
                if (month == 12) {
                    year1++;
                    month = 0;
                }
                month++;
            }
            pw.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
    public void reader() {
        String texts = "";
        try {
            Scanner sc = new Scanner(file);
            while (sc.hasNextLine()) {
                texts = texts.concat(sc.nextLine() + "\n");
            }
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        }

        graphics.setText(texts);
    }
}
