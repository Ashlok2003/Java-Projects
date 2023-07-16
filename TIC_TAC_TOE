import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import java.util.stream.IntStream;

public class TicTacToe implements ActionListener {

    JLabel textField = new JLabel();
    JPanel title_panel = new JPanel();
    JButton button_panel = new JButton();
    JFrame frame = new JFrame("TIC-TAC-TOE");
    JButton[] buttons = new JButton[9]; // The buttons where we check marks
    Random random = new Random();
    boolean player1_turn = false;

    TicTacToe() {

        frame.setSize(500, 500);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());
        frame.getContentPane().setBackground(Color.BLACK);

        textField.setBackground(new Color(25, 25, 25));
        textField.setForeground(Color.white);
        textField.setFont(new Font("Ink Free", Font.BOLD, 50));
        textField.setHorizontalAlignment(JLabel.CENTER);
        textField.setText("TIC-TAC-TOE");
        textField.setOpaque(true);

        title_panel.setLayout(new BorderLayout());
        title_panel.setBounds(0, 0, 100, 100);

        button_panel.setLayout(new GridLayout(3, 3));
        button_panel.setBackground(Color.red);

        IntStream.range(0, 9).forEach(i -> {
            buttons[i] = new JButton();
            button_panel.add(buttons[i]);
            buttons[i].setFont(new Font("MV Boli", Font.BOLD, 120));
            buttons[i].setFocusable(false);
            buttons[i].addActionListener(this);

        });

        title_panel.add(textField);
        frame.add(title_panel, BorderLayout.NORTH);
        frame.add(button_panel);
        firstTurn();

    }

    @Override
    public void actionPerformed(ActionEvent ex) {
        for (int i = 0; i < 9; ++i) {
            if (ex.getSource() == buttons[i]) {
                if (player1_turn) {
                    if (buttons[i].getText().equals("")) {
                        buttons[i].setForeground(new Color(255, 0, 0));
                        buttons[i].setText("X");
                        player1_turn = false;
                        textField.setText("O's Turns");
                        check();
                    }
                } else {
                    if (buttons[i].getText().equals("")) {
                        buttons[i].setForeground(new Color(255, 0, 0));
                        buttons[i].setText("O");
                        player1_turn = true;
                        textField.setText("X's Turns");
                        check();
                    }
                }
            }
        }
    }

    // Method which determined whose turn is first
    public void firstTurn() {
        try {
            Thread.sleep(2000);

        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
        if (random.nextInt(2) == 0) {
            player1_turn = true;
            textField.setText("X Turn");
        } else {
            player1_turn = false;
            textField.setText("O Turn");
        }
    }

    public void check() {
        // Checking X winning Cases
        if (buttons[0].getText().equals("X") && buttons[1].getText().equals("X") && buttons[2].getText().equals("X")) {
            xWins(0, 1, 2);
        }
        if (buttons[3].getText().equals("X") && buttons[4].getText().equals("X") && buttons[5].getText().equals("X")) {
            xWins(3, 4, 5);
        }
        if (buttons[6].getText().equals("X") && buttons[7].getText().equals("X") && buttons[8].getText().equals("X")) {
            xWins(6, 7, 8);
        }
        if(buttons[0].getText().equals("X") && buttons[3].getText().equals("X") && buttons[6].getText().equals("X")) {
            xWins(0, 3, 6);
        }
        if(buttons[1].getText().equals("X") && buttons[4].getText().equals("X") && buttons[7].getText().equals("X")) {
            xWins(1, 4, 7);
        }
        if(buttons[2].getText().equals("X") && buttons[5].getText().equals("X") && buttons[8].getText().equals("X")) {
            xWins(2, 5, 8);
        }
        if(buttons[0].getText().equals("X") && buttons[4].getText().equals("X") && buttons[8].getText().equals("X")) {
            xWins(0, 4, 8);
        }
        if(buttons[2].getText().equals("X") && buttons[4].getText().equals("X") && buttons[6].getText().equals("X")) {
            xWins(2, 4, 6);
        }
        // Checking O winning Cases
        if (buttons[0].getText().equals("O") && buttons[1].getText().equals("O") && buttons[2].getText().equals("O")) {
            oWins(0, 1, 2);
        }
        if (buttons[3].getText().equals("O") && buttons[4].getText().equals("O") && buttons[5].getText().equals("O")) {
            oWins(3, 4, 5);
        }
        if (buttons[6].getText().equals("O") && buttons[7].getText().equals("O") && buttons[8].getText().equals("O")) {
            oWins(6, 7, 8);
        }
        if(buttons[0].getText().equals("O") && buttons[3].getText().equals("O") && buttons[6].getText().equals("O")) {
            oWins(0, 3, 6);
        }
        if(buttons[1].getText().equals("O") && buttons[4].getText().equals("O") && buttons[7].getText().equals("O")) {
            oWins(1, 4, 7);
        }
        if(buttons[2].getText().equals("O") && buttons[5].getText().equals("O") && buttons[8].getText().equals("O")) {
            oWins(2, 5, 8);
        }
        if(buttons[0].getText().equals("O") && buttons[4].getText().equals("O") && buttons[8].getText().equals("O")) {
            oWins(0, 4, 8);
        }
        if(buttons[2].getText().equals("O") && buttons[4].getText().equals("O") && buttons[6].getText().equals("O")) {
            oWins(2, 4, 6);
        }



    }

    public void xWins(int a, int b, int c) {
        buttons[a].setBackground(Color.green);
        buttons[b].setBackground(Color.green);
        buttons[c].setBackground(Color.green);

        IntStream.range(0,9)
                .forEach(i -> buttons[i].setEnabled(false));

        textField.setText("X wins");
    }

    public void oWins(int a, int b, int c) {
        buttons[a].setBackground(Color.green);
        buttons[b].setBackground(Color.green);
        buttons[c].setBackground(Color.green);

        IntStream.range(0,9)
                .forEach(i -> buttons[i].setEnabled(false));

        textField.setText("O wins");

    }
}

