package com.codeschool;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.Scanner;

public class Story implements ActionListener {
    private JPanel Story;
    private JButton backButton;
    private JTextPane stories;

    private File file=new File("/Users/arpine/IdeaProjects/bank_calculator_loan/src/com/codeschool/story.txt");

    public JPanel getStory() {
        return Story;
    }

    public Story() {
        backButton.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Calculator calculator=new Calculator();
    }

    public void writer(String string) {
        try {
            FileWriter fw = new FileWriter(file, true);
            PrintWriter pw = new PrintWriter(fw);
            pw.println(string);
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

        stories.setText(texts);
    }
}

