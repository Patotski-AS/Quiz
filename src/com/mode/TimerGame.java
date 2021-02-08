package com.mode;

import com.frame.GameFrame;
import com.frame.MainMenuFrame;

import java.awt.event.ActionEvent;

public class TimerGame extends GameFrame {

    @Override
    public void actionPerformed(ActionEvent e) {

        buttonA.setEnabled(false);
        buttonB.setEnabled(false);
        buttonC.setEnabled(false);
        buttonD.setEnabled(false);

        if (e.getSource() == buttonA) {
            answer = "A";
            if (answer.equals(questions[index].getCorrectAnswer())) {
                correct_guesses++;
            }
            displayAnswer();
        }
        if (e.getSource() == buttonB) {
            answer = "B";
            if (answer.equals(questions[index].getCorrectAnswer())) {
                correct_guesses++;
            }
            displayAnswer();
        }
        if (e.getSource() == buttonC) {
            answer = "C";
            if (answer.equals(questions[index].getCorrectAnswer())) {
                correct_guesses++;
            }
            displayAnswer();
        }
        if (e.getSource() == buttonD) {
            answer = "D";
            if (answer.equals(questions[index].getCorrectAnswer())) {
                correct_guesses++;
            }
            displayAnswer();
        }

        if (e.getSource() == buttonRepeat) {
            frame.dispose();
            new TimerGame();
        }
        if (e.getSource() == buttonToMenu) {
            frame.dispose();
            new MainMenuFrame();
        }
    }
}
