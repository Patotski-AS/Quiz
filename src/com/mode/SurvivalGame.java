package com.mode;

import com.frame.GameFrame;
import com.frame.MainMenuFrame;

import java.awt.event.ActionEvent;


/**
 * логика :
 * -игра на выживание - не правильно ответил - проиграл
 * -нужно ли добавлчть колисество жизней?
 * <p>
 * Вопросы выгружать из файла  в очередь в нужнои количестве
 * перемешать их и доствать с удалением
 */


public class SurvivalGame extends GameFrame {

    @Override
    public void actionPerformed(ActionEvent e) {

        buttonA.setEnabled(false);
        buttonB.setEnabled(false);
        buttonC.setEnabled(false);
        buttonD.setEnabled(false);

        if (e.getSource() == buttonA) {
            answer = "A";
            if (answer.equals(questions[index].getCorrectAnswer())) {
                numberLives--;
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
            GameFrame gameFrame = new SurvivalGame();
        }
        if (e.getSource() == buttonToMenu) {
            frame.dispose();
            MainMenuFrame mainMenuFrame = new MainMenuFrame();
        }
    }


}
