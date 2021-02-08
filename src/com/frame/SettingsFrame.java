package com.frame;

import com.quiz.Settings;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.util.Objects;

public class SettingsFrame extends JFrame implements ActionListener {
    private final Settings settings = new Settings();
    private final JFrame frame = new JFrame();

    private final JButton saveButton;
    private final JButton noSaveButton;

    private final JTextField textField = new JTextField("Enter name");

    private final JComboBox<? extends String> themeChoose;
    private final JComboBox<? extends String> questionsCountChoose;

    private final JRadioButton timeChallenge;
    private final JRadioButton survivalChallenge;

    private final JRadioButton button_Easy;
    private final JRadioButton button_Normal;
    private final JRadioButton button_Hard;

    public SettingsFrame() {
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(650, 650);
        frame.getContentPane().setBackground(new Color(50, 50, 50));
        frame.setLayout(null);
        frame.setResizable(false);
        frame.setVisible(true);

        //определить перечень тем
        String[] themes = {"JAVA", "JAVA-1", "Test"};
        themeChoose = new JComboBox<>(themes);
        themeChoose.setFont(new Font("Courier", Font.BOLD, 25));
        themeChoose.setBackground(new Color(219, 206, 206));
        themeChoose.setForeground(new Color(95, 51, 51));
        themeChoose.setBounds(345, 150, 270, 50);
        themeChoose.addActionListener(this);
        themeChoose.setSelectedIndex(0);
        themeChoose.setVisible(true);
        themeChoose.setFocusable(true);
        ((JLabel) themeChoose.getRenderer()).setHorizontalAlignment(JLabel.CENTER);


        button_Easy = new JRadioButton("Easy");
        button_Easy.addActionListener(this);
        button_Easy.setBounds(205, 450, 130, 50);
        button_Easy.setBackground(new Color(219, 206, 206));
        button_Easy.setForeground(new Color(95, 51, 51));
        button_Easy.setFont(new Font("Courier", Font.BOLD, 25));

        button_Normal = new JRadioButton("Normal");
        button_Normal.setSelected(true);
        button_Normal.addActionListener(this);
        button_Normal.setBounds(345, 450, 130, 50);
        button_Normal.setBackground(new Color(219, 206, 206));
        button_Normal.setForeground(new Color(95, 51, 51));
        button_Normal.setFont(new Font("Courier", Font.BOLD, 25));

        button_Hard = new JRadioButton("Hard");
        button_Hard.addActionListener(this);
        button_Hard.setBounds(485, 450, 130, 50);
        button_Hard.setBackground(new Color(219, 206, 206));
        button_Hard.setForeground(new Color(95, 51, 51));
        button_Hard.setFont(new Font("Courier", Font.BOLD, 25));

        ButtonGroup buttonGroupDifficulty = new ButtonGroup();
        buttonGroupDifficulty.add(button_Easy);
        buttonGroupDifficulty.add(button_Normal);
        buttonGroupDifficulty.add(button_Hard);

        //определить кол-во вопросов
        String[] count = {"5", "10", "15", "20"};
        questionsCountChoose = new JComboBox<>(count);
        questionsCountChoose.setFont(new Font("Courier", Font.BOLD, 25));
        questionsCountChoose.setBackground(new Color(219, 206, 206));
        questionsCountChoose.setForeground(new Color(95, 51, 51));
        questionsCountChoose.setBounds(345, 250, 270, 50);
        questionsCountChoose.addActionListener(this);
        questionsCountChoose.setSelectedIndex(0);
        questionsCountChoose.setVisible(true);
        ((JLabel) questionsCountChoose.getRenderer()).setHorizontalAlignment(JLabel.CENTER);

        JTextArea text = new JTextArea("Write Your name");
        JTextArea text2 = new JTextArea("Theme");
        JTextArea text3 = new JTextArea("Questions Count");
        JTextArea[] jTextAreas = {text, text2, text3};

        for (JTextArea j : jTextAreas) {
            j.setFont(new Font("Courier", Font.BOLD, 25));
            j.setVisible(true);
            j.setFont(new Font("Courier", Font.BOLD, 25));
            j.setAlignmentX(JTextField.CENTER);
            j.setBackground(new Color(50, 50, 50));
            j.setForeground(new Color(219, 206, 206));
            j.setCaretColor(Color.white);
            j.setEditable(false);
            frame.add(j);
        }
//
        text.setBounds(15, 50, 300, 100);
        text2.setBounds(15, 150, 300, 100);
        text3.setBounds(15, 250, 300, 100);

        timeChallenge = new JRadioButton("Timer");
        timeChallenge.addActionListener(this);
        timeChallenge.setSelected(true);
        timeChallenge.setBounds(345, 350, 130, 50);
        timeChallenge.setBackground(new Color(219, 206, 206));
        timeChallenge.setForeground(new Color(95, 51, 51));
        timeChallenge.setFont(new Font("Courier", Font.BOLD, 25));

        survivalChallenge = new JRadioButton("Survival");
        survivalChallenge.addActionListener(this);
        survivalChallenge.setBounds(485, 350, 130, 50);
        survivalChallenge.setBackground(new Color(219, 206, 206));
        survivalChallenge.setForeground(new Color(95, 51, 51));
        survivalChallenge.setFont(new Font("Courier", Font.BOLD, 25));

        ButtonGroup buttonGroup = new ButtonGroup();
        buttonGroup.add(timeChallenge);
        buttonGroup.add(survivalChallenge);

        textField.setBounds(345, 50, 270, 50);
        textField.setFont(new Font("Courier", Font.BOLD, 35));
        textField.setBackground(new Color(219, 206, 206));
        textField.setForeground(new Color(95, 51, 51));
        textField.setPreferredSize(new Dimension(250, 40));
        textField.setFont(new Font("Consolas", Font.PLAIN, 35));
        textField.setForeground(new Color(219, 206, 206));
        textField.setBackground(Color.black);
        textField.setCaretColor(Color.white);
        textField.setHorizontalAlignment(JLabel.CENTER);

        textField.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                textField.setText("");
            }

            @Override
            public void focusLost(FocusEvent e) {
            }
        });

        saveButton = new JButton("Save and exit");
        saveButton.setBounds(120, 550, 150, 50);
        saveButton.setFont(new Font("Courier", Font.BOLD, 15));
        saveButton.setFocusable(false);
        saveButton.addActionListener(this);
        saveButton.setBackground(new Color(50, 50, 50));
        saveButton.setForeground(new Color(219, 206, 206));

        noSaveButton = new JButton("Back");
        noSaveButton.setBounds(430, 550, 150, 50);
        noSaveButton.setFont(new Font("Courier", Font.BOLD, 15));
        noSaveButton.setFocusable(false);
        noSaveButton.addActionListener(this);
        noSaveButton.setBackground(new Color(50, 50, 50));
        noSaveButton.setForeground(new Color(219, 206, 206));

        frame.add(textField);
        frame.add(themeChoose);
        frame.add(questionsCountChoose);
        frame.add(saveButton);
        frame.add(noSaveButton);
        frame.add(timeChallenge);
        frame.add(survivalChallenge);
        frame.add(button_Easy);
        frame.add(button_Normal);
        frame.add(button_Hard);
    }
//

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == themeChoose) {
            if (Objects.requireNonNull(themeChoose.getSelectedItem()).equals("JAVA"))
                settings.setFileQuestion("JAVA.json");
            if (themeChoose.getSelectedItem().equals("SCIENCE"))
                settings.setFileQuestion("questions.json");
            if (themeChoose.getSelectedItem().equals("JAVA-1"))
                settings.setFileQuestion("JAVA-1.json");
            // сохраняем в файл наш выбор темы
        }
        if (e.getSource() == questionsCountChoose) {
            // сохраняем в файл наш выбор темы
            settings.setTotal_questions(Integer.parseInt(Objects.requireNonNull(questionsCountChoose.getSelectedItem()).toString()));
        }
        //df/
        if (e.getSource() == saveButton) {
            // сохраняем в файл наш выбор имени  и го в меню
            frame.dispose();
            settings.setName(textField.getText());
            Settings.settingsWriter(settings); //сохраняем настройки в settings.json
            new MainMenuFrame();
        }
        if (e.getSource() == noSaveButton) {
            // Домой без сохранения
            frame.dispose();
            new MainMenuFrame();
        }
        if (e.getSource() == timeChallenge) {
            settings.setModeGame(timeChallenge.getText());
            // Выбран режим по времени
        }
        if (e.getSource() == survivalChallenge) {
            settings.setModeGame(survivalChallenge.getText());
            // Выбран режим выживания
        }
        if (e.getSource() == button_Easy) {
            settings.setSeconds(60);
            settings.setNumberLives(4);
            // легкая сложность
        }

        if (e.getSource() == button_Normal) {
            settings.setSeconds(40);
            settings.setNumberLives(2);
            // нормальная сложность
        }

        if (e.getSource() == button_Hard) {
            settings.setSeconds(20);
            settings.setNumberLives(0);
            // сложная сложность
        }
    }
}
