package com.frame;

import com.mode.SurvivalGame;
import com.mode.TimerGame;
import com.quiz.Settings;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainMenuFrame extends JFrame implements ActionListener {
    private final Settings settings = Settings.readSettings();
    private final JFrame frame;

    private final JButton buttonA = new JButton();
    private final JButton buttonB = new JButton();
    private final JButton buttonC = new JButton();
    private final JButton buttonD = new JButton();

    public MainMenuFrame() {
        frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(650, 650);
        frame.getContentPane().setBackground(new Color(50, 50, 50));
        frame.setLayout(null);
        frame.setResizable(false);
        frame.setVisible(true);

        buttonA.setBounds(200, 100, 300, 90);
        buttonA.setFont(new Font("Courier", Font.BOLD, 35));
        buttonA.setFocusable(false);
        buttonA.addActionListener(this);
        buttonA.setBackground(new Color(219, 206, 206));
        buttonA.setForeground(new Color(95, 51, 51));
        buttonA.setText("START GAME");

        buttonB.setBounds(200, 200, 300, 90);
        buttonB.setFont(new Font("Courier", Font.BOLD, 35));
        buttonB.setFocusable(false);
        buttonB.addActionListener(this);
        buttonB.setBackground(new Color(219, 206, 206));
        buttonB.setForeground(new Color(95, 51, 51));
        buttonB.setText("RECORDS");

        buttonC.setBounds(200, 300, 300, 90);
        buttonC.setFont(new Font("Courier", Font.BOLD, 35));
        buttonC.setFocusable(false);
        buttonC.addActionListener(this);
        buttonC.setBackground(new Color(219, 206, 206));
        buttonC.setForeground(new Color(95, 51, 51));
        buttonC.setText("SETTINGS");

        buttonD.setBounds(200, 400, 300, 90);
        buttonD.setFont(new Font("Courier", Font.BOLD, 35));
        buttonD.setFocusable(false);
        buttonD.addActionListener(this);
        buttonD.setBackground(new Color(219, 206, 206));
        buttonD.setForeground(new Color(95, 51, 51));
        buttonD.setText("EXIT");

        JLabel text = new JLabel("QUIZ FOR MASHA");
        text.setFont(new Font("Courier", Font.BOLD, 35));
        text.setVisible(true);

        text.setAlignmentX(JTextField.CENTER);
        text.setBackground(new Color(50, 50, 50));
        text.setForeground(new Color(219, 206, 206));
        text.setBounds(200, 25, 350, 50);
        frame.add(text);

        frame.add(buttonA);
        frame.add(buttonB);
        frame.add(buttonC);
        frame.add(buttonD);


    }


    @Override
    public void actionPerformed(ActionEvent e) {
        //режимы игры
        if (e.getSource() == buttonA) {
            frame.dispose();
            switch (settings.getModeGame()) {
                case ("Timer"):
                     new TimerGame();
                    break;
                case ("Survival"):
                    new SurvivalGame();
                    break;
            }

        }
        if (e.getSource() == buttonB) {
            //ОТКРЫВАЕМ ОКНО РЕКОРДОВ
            frame.dispose();
             new RecordsMenuFrame();
        }
        //настройки
        if (e.getSource() == buttonC) {
            frame.dispose();
             new SettingsFrame();
        }
        //выход
        if (e.getSource() == buttonD) {
            System.exit(0);
        }
    }
}
