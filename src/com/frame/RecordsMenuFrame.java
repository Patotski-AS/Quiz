package com.frame;

import com.quiz.Scores;
import com.quiz.Settings;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class RecordsMenuFrame extends JFrame implements ActionListener {
    List<Scores> scores = Settings.scoresReader();

    private final JFrame frame;
    private final JButton buttonToMenu = new JButton();

    public RecordsMenuFrame() {
        frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(650, 650);
        frame.getContentPane().setBackground(new Color(50, 50, 50));
        frame.setLayout(null);
        frame.setResizable(false);
        frame.setVisible(true);

        JLabel header = new JLabel("Records");


        JLabel rec1 = new JLabel(scores.get(0).getName() );
        JLabel rec2 = new JLabel(scores.get(1).getName() );
        JLabel rec3 = new JLabel(scores.get(2).getName() );
        JLabel rec4 = new JLabel(scores.get(3).getName() );
        JLabel rec5 = new JLabel(scores.get(4).getName() );

        JLabel rec6 = new JLabel(String.valueOf(scores.get(0).getScore()));
        JLabel rec7 = new JLabel(String.valueOf(scores.get(1).getScore()));
        JLabel rec8 = new JLabel(String.valueOf(scores.get(2).getScore()));
        JLabel rec9 = new JLabel(String.valueOf(scores.get(3).getScore()));
        JLabel rec10 = new JLabel(String.valueOf(scores.get(4).getScore()));

        JLabel[] names = {rec1, rec2, rec3, rec4, rec5};

        JLabel[] names2 = {rec6, rec7, rec8, rec9, rec10};


        int y = 30;
        for (JLabel j : names) {
            j.setBounds(50, y += 75, 300, 75);
            j.setFont(new Font("Courier", Font.BOLD, 20));
            j.setVisible(true);

            j.setBackground(new Color(234, 118, 118));
            j.setForeground(new Color(219, 206, 206));
            frame.add(j);
        }

        y = 30;
        for (JLabel j : names2) {
            j.setBounds(370, y += 75, 250, 75);
            j.setFont(new Font("Courier", Font.BOLD, 20));
            j.setVisible(true);

            j.setBackground(new Color(234, 118, 118));
            j.setForeground(new Color(219, 206, 206));
            frame.add(j);
        }

        header.setBounds(250, 25, 300, 50);
        header.setFont(new Font("Courier", Font.BOLD, 35));
        header.setVisible(true);
        header.setBackground(new Color(234, 118, 118));
        header.setForeground(new Color(219, 206, 206));
        frame.add(header);

        buttonToMenu.setBounds(225, 550, 200, 50);
        buttonToMenu.setFont(new Font("Ink Free", Font.BOLD, 25));
        buttonToMenu.setFocusable(false);
        buttonToMenu.addActionListener(this);
        buttonToMenu.setText("Back to Menu");
        buttonToMenu.setBackground(new Color(170, 66, 66));
        buttonToMenu.setForeground(new Color(219, 206, 206));
        buttonToMenu.setEnabled(true);
        buttonToMenu.setVisible(true);

        frame.add(buttonToMenu);
    }


    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == buttonToMenu) {
            frame.dispose();
            new MainMenuFrame();
        }


    }
}
