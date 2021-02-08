package com.frame;
// ---------------------------- Main ----------------------------

// ---------------------------- Quiz ----------------------------

import com.mode.SurvivalGame;
import com.quiz.Question;
import com.quiz.Scores;
import com.quiz.Settings;

import javax.swing.*;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;
import java.util.List;

public abstract class GameFrame implements ActionListener {
    protected final Settings settings = Settings.readSettings();
    protected final Question[] questions = randomQuestions();

    protected String answer;
    protected int index;
    protected int correct_guesses = 0;
    protected int seconds = settings.getSeconds();
    protected int numberLives = settings.getNumberLives();

    protected final JFrame frame = new JFrame();
    protected final JTextField textField = new JTextField();

    protected final JTextPane textarea = new JTextPane();

    protected final JButton buttonA = new JButton();
    protected final JButton buttonB = new JButton();
    protected final JButton buttonC = new JButton();
    protected final JButton buttonD = new JButton();
    protected final JButton buttonRepeat = new JButton();
    protected final JButton buttonToMenu = new JButton();

    protected final JTextArea answer_labelA = new JTextArea();
    protected final JTextArea answer_labelB = new JTextArea();
    protected final JTextArea answer_labelC = new JTextArea();
    protected final JTextArea answer_labelD = new JTextArea();

    protected final JLabel seconds_left = new JLabel();
    protected final JTextField number_right = new JTextField();
    protected final JTextField percentage = new JTextField();
    protected final JLabel lives_left = new JLabel();


    private final Timer timer = new Timer(1000, e -> {
        seconds--;
        seconds_left.setText("Time left: " + String.valueOf(seconds));
        if (seconds <= 0) {
            displayAnswer();
        }
    });

    private Question[] randomQuestions() {
        Random random = new Random();
        List<Question> allQuestions = settings.questionReader();
        Set<Question> questions = new HashSet<>();
        while (questions.size() < settings.getTotal_questions()) {
            questions.add(allQuestions.get(random.nextInt(settings.getTotal_questions())));
        }
        return questions.toArray(new Question[0]);
    }

    public GameFrame() {
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(650, 650);
        frame.getContentPane().setBackground(new Color(50, 50, 50));
        frame.setLayout(null);
        frame.setResizable(false);

        textField.setBounds(0, 0, 650, 50);
        textField.setBackground(new Color(234, 69, 69));
        textField.setForeground(new Color(219, 206, 206));
        textField.setFont(new Font("Courier", Font.BOLD, 30));
        textField.setBorder(BorderFactory.createBevelBorder(1));
        textField.setHorizontalAlignment(JTextField.CENTER);
        textField.setEditable(false);

        textarea.setBounds(10, 50, 600, 80);
        textarea.setBackground(new Color(170, 66, 66));
        textarea.setForeground(new Color(219, 206, 206));
        textarea.setFont(new Font("Courier", Font.BOLD, 15));
        textarea.setBorder(BorderFactory.createBevelBorder(1));
        textarea.setEditable(false);
        StyledDocument doc = textarea.getStyledDocument();
        SimpleAttributeSet center = new SimpleAttributeSet();
        StyleConstants.setAlignment(center, StyleConstants.ALIGN_CENTER);
        doc.setParagraphAttributes(10, doc.getLength() - 1, center, false);

        JButton[] jButtons = {buttonA, buttonB, buttonC, buttonD};
for (JButton j: jButtons)
{
    j.setBackground(new Color(170, 66, 66));
    j.setForeground(new Color(219, 206, 206));

}
        buttonA.setBounds(10, 150, 100, 100);
        buttonA.setFont(new Font("Courier", Font.BOLD, 25));
        buttonA.setFocusable(false);
        buttonA.addActionListener(this);
        buttonA.setText("A");

        buttonB.setBounds(10, 250, 100, 100);
        buttonB.setFont(new Font("Courier", Font.BOLD, 25));
        buttonB.setFocusable(false);
        buttonB.addActionListener(this);
        buttonB.setText("B");

        buttonC.setBounds(10, 350, 100, 100);
        buttonC.setFont(new Font("Courier", Font.BOLD, 25));
        buttonC.setFocusable(false);
        buttonC.addActionListener(this);
        buttonC.setText("C");

        buttonD.setBounds(10, 450, 100, 100);
        buttonD.setFont(new Font("Courier", Font.BOLD, 25));
        buttonD.setFocusable(false);
        buttonD.addActionListener(this);
        buttonD.setText("D");


        buttonRepeat.setBounds(100, 550, 200, 50);

        buttonRepeat.setFont(new Font("Courier", Font.BOLD, 25));
        buttonRepeat.setFocusable(false);
        buttonRepeat.addActionListener(this);
        buttonRepeat.setText("Repeat");
        buttonRepeat.setBackground(new Color(170, 66, 66));
        buttonRepeat.setForeground(new Color(219, 206, 206));


        buttonToMenu.setBounds(325, 550, 200, 50);

        buttonToMenu.setFont(new Font("Courier", Font.BOLD, 25));
        buttonToMenu.setFocusable(false);
        buttonToMenu.addActionListener(this);
        buttonToMenu.setText("Back to Menu");
        buttonToMenu.setBackground(new Color(170, 66, 66));
        buttonToMenu.setForeground(new Color(219, 206, 206));



        answer_labelA.setBounds(125, 150, 500, 99);
        answer_labelA.setBackground(new Color(68, 67, 67));
        answer_labelA.setForeground(new Color(25, 255, 0));
        answer_labelA.setFont(new Font("Courier", Font.PLAIN, 15));
        answer_labelA.setLineWrap(true);
        answer_labelA.setWrapStyleWord(true);

        answer_labelB.setBounds(125, 250, 500, 99);
        answer_labelB.setBackground(new Color(68, 67, 67));
        answer_labelB.setForeground(new Color(25, 255, 0));
        answer_labelB.setFont(new Font("Courier", Font.PLAIN, 15));
        answer_labelB.setLineWrap(true);
        answer_labelB.setWrapStyleWord(true);


        answer_labelC.setBounds(125, 350, 500, 99);
        answer_labelC.setBackground(new Color(68, 67, 67));
        answer_labelC.setForeground(new Color(25, 255, 0));
        answer_labelC.setFont(new Font("Courier", Font.PLAIN, 15));
        answer_labelC.setLineWrap(true);
        answer_labelC.setWrapStyleWord(true);

        answer_labelD.setBounds(125, 450, 500, 99);
        answer_labelD.setBackground(new Color(68, 67, 67));
        answer_labelD.setForeground(new Color(25, 255, 0));
        answer_labelD.setFont(new Font("Courier", Font.PLAIN, 15));
        answer_labelD.setLineWrap(true);
        answer_labelD.setWrapStyleWord(true);

        seconds_left.setBounds(450, 550, 150, 50);
        seconds_left.setBackground(new Color(25, 25, 25));
        seconds_left.setForeground(new Color(255, 0, 0));
        seconds_left.setFont(new Font("Courier", Font.BOLD, 15));
        seconds_left.setBorder(BorderFactory.createBevelBorder(1));
        seconds_left.setOpaque(true);
        seconds_left.setHorizontalAlignment(JTextField.CENTER);
        seconds_left.setText(String.valueOf(seconds));


        lives_left.setVisible(this instanceof SurvivalGame);

        lives_left.setBounds(50, 550, 150, 50);
        lives_left.setBackground(new Color(25, 25, 25));
        lives_left.setForeground(new Color(255, 0, 0));
        lives_left.setFont(new Font("Courier", Font.BOLD, 15));
        lives_left.setBorder(BorderFactory.createBevelBorder(1));
        lives_left.setOpaque(true);
        lives_left.setHorizontalAlignment(JTextField.CENTER);
        lives_left.setText("LIVES: " +String.valueOf(numberLives));


        JLabel time_label = new JLabel();
        time_label.setBounds(535, 475, 100, 25);
        time_label.setBackground(new Color(50, 50, 50));
        time_label.setForeground(new Color(255, 0, 0));
        time_label.setFont(new Font("Courier", Font.PLAIN, 16));
        time_label.setHorizontalAlignment(JTextField.CENTER);


        number_right.setBounds(225, 225, 200, 100);
        number_right.setBackground(new Color(219, 206, 206));
        number_right.setForeground(new Color(234, 69, 69));
        number_right.setFont(new Font("Courier", Font.BOLD, 50));
        number_right.setBorder(BorderFactory.createBevelBorder(1));
        number_right.setHorizontalAlignment(JTextField.CENTER);
        number_right.setEditable(false);

        percentage.setBounds(225, 325, 200, 100);
        percentage.setBackground(new Color(234, 69, 69));
        percentage.setForeground(new Color(219, 206, 206));
        percentage.setFont(new Font("Courier", Font.BOLD, 50));
        percentage.setBorder(BorderFactory.createBevelBorder(1));
        percentage.setHorizontalAlignment(JTextField.CENTER);
        percentage.setEditable(false);

        frame.add(time_label);
        frame.add(seconds_left);
        frame.add(answer_labelA);
        frame.add(answer_labelB);
        frame.add(answer_labelC);
        frame.add(answer_labelD);
        frame.add(buttonA);
        frame.add(buttonB);
        frame.add(buttonC);
        frame.add(buttonD);
        frame.add(buttonRepeat);
        frame.add(buttonToMenu);
        frame.add(textarea);
        frame.add(textField);
        frame.add(lives_left);
        frame.setVisible(true);

        buttonToMenu.setEnabled(false);
        buttonRepeat.setEnabled(false);
        buttonRepeat.setVisible(false);
        buttonToMenu.setVisible(false);

        nextQuestion();
    }

    private void nextQuestion() {

        if (index >= settings.getTotal_questions() || numberLives < 0) {
            results();
        } else {
            textField.setText("Question " + (index + 1));
            textarea.setText(questions[index].getQuestion());
            answer_labelA.setText(questions[index].getAnswerOptions()[0]);
            answer_labelB.setText(questions[index].getAnswerOptions()[1]);
            answer_labelC.setText(questions[index].getAnswerOptions()[2]);
            answer_labelD.setText(questions[index].getAnswerOptions()[3]);
            timer.start();
        }
    }

    public void displayAnswer() {

        timer.stop();

        buttonA.setEnabled(false);
        buttonB.setEnabled(false);
        buttonC.setEnabled(false);
        buttonD.setEnabled(false);

        if (!questions[index].getCorrectAnswer().equals("A"))
            answer_labelA.setForeground(new Color(255, 0, 0));
        if (!questions[index].getCorrectAnswer().equals("B"))
            answer_labelB.setForeground(new Color(255, 0, 0));
        if (!questions[index].getCorrectAnswer().equals("C"))
            answer_labelC.setForeground(new Color(255, 0, 0));
        if (!questions[index].getCorrectAnswer().equals("D"))
            answer_labelD.setForeground(new Color(255, 0, 0));

        Timer pause = new Timer(1000, e -> {

            answer_labelA.setForeground(new Color(25, 255, 0));
            answer_labelB.setForeground(new Color(25, 255, 0));
            answer_labelC.setForeground(new Color(25, 255, 0));
            answer_labelD.setForeground(new Color(25, 255, 0));

            answer = " ";
            seconds = settings.getSeconds();

            seconds_left.setText("Time left: " + String.valueOf(seconds));

            lives_left.setText("LIVES: "+ String.valueOf(numberLives));


            buttonA.setEnabled(true);
            buttonB.setEnabled(true);
            buttonC.setEnabled(true);
            buttonD.setEnabled(true);

            index++;
            nextQuestion();
        });
        pause.setRepeats(false);
        pause.start();
    }

    public void results() {

        buttonA.setEnabled(false);
        buttonB.setEnabled(false);
        buttonC.setEnabled(false);
        buttonD.setEnabled(false);
        buttonToMenu.setEnabled(true);
        buttonRepeat.setEnabled(true);
        buttonRepeat.setVisible(true);
        buttonToMenu.setVisible(true);

        int result = (int) ((correct_guesses / (double) settings.getTotal_questions()) * 100);

        textField.setText("RESULTS!");
        textarea.setText("");
        answer_labelA.setText("");
        answer_labelB.setText("");
        answer_labelC.setText("");
        answer_labelD.setText("");

        number_right.setText("(" + correct_guesses + "/" + settings.getTotal_questions() + ")");
        percentage.setText(result + "%");

        frame.add(number_right);
        frame.add(percentage);

        Settings.scoresWriter(new Scores(settings.getName(), "", correct_guesses * 100));
    }
}
