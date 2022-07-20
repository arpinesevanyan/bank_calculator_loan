package com.codeschool;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Calculator extends JFrame implements ActionListener {
    private JPanel main;
    private JLabel MonthlyPayment;

    private JTextField amount;
    private JTextField parcent;
    private JTextField year;

    private JButton calculateButton;
    private JButton clearButton;
    private JButton storyButton;
    private JButton graphicButton;

    private Story story;
    private Graphic graphic;

    public Calculator() {
        this.setContentPane(main);
        this.setTitle("Loan Calculator");
        this.setVisible(true);
        this.setBounds(600, 300, 500, 500);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        graphic = new Graphic();
        story = new Story();

        calculateButton.addActionListener(this);
        clearButton.addActionListener(this);
        storyButton.addActionListener(this);
        graphicButton.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==calculateButton){
            int value=(Integer.valueOf(amount.getText())
                    + (Integer.valueOf(amount.getText()) / 100 *
                    Integer.parseInt(year.getText())))
                    / (Integer.parseInt(parcent.getText()) * 12);

            MonthlyPayment.setText(String.valueOf(value));

            DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
            LocalDateTime myDateObj = LocalDateTime.now();
            String formattedDate = myDateObj.format(myFormatObj);

            String text = formattedDate + "\n" + "Loan Ammount: " + amount.getText()
                    + "\n" + "Percent: " + parcent.getText()
                    + "\n" + "Cout of Year: " + year.getText()
                    + "\n" + "Monthly Payment: " + MonthlyPayment.getText() + "\n";

            story.writer(text);
            graphic.writer(MonthlyPayment, year);
        } else if(e.getSource()==clearButton){

            amount.setText(null);
            year.setText(null);
            parcent.setText(null);
            MonthlyPayment.setText("MonthlyPayment");

        } else if(e.getSource()==storyButton){

            this.setContentPane(story.getStory());
            this.setTitle("Story");
            this.setVisible(true);
            this.setBounds(600, 300, 500, 500);
            this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            story.reader();
        } else if (e.getSource() == graphicButton ) {  //mtnuma graph page

            this.setContentPane(graphic.getGraphic());
            this.setTitle("Graph");
            this.setVisible(true);
            this.setBounds(600, 300, 500, 500);
            this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            graphic.reader();
        }
    }
}
