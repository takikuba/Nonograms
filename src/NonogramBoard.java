import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class NonogramBoard {
    Nonogram nonogram;
    List<JButton> gridNumber;
    JButton[][] gridGame = new JButton[5][5];
    JPanel panelBoard;
    boolean makeNumber;

    public NonogramBoard(JPanel panelBoard, boolean makeNumber){
        if(makeNumber){
            nonogram = new DrawNonogram();
        }
        this.panelBoard = panelBoard;
        this.makeNumber = makeNumber;
        makeCanvas();
    }

    private void makeNumberCanvas() {
        Panel panel = new Panel();
        panel.setBackground(Color.GRAY);
        panel.setLayout(new GridLayout(8, 8));
        panel.setBounds(40, 40, 160, 160);
        gridNumber = new ArrayList<>();
        for( int i = 0; i < 8; i++){
            for(int j = 0; j < 8; j++){
                JButton button;
                String text = String.valueOf(nonogram.numbers[i][j]);
                button = new JButton(!text.equals("0") ? text : "");
                button.setFont(new Font("Arial", Font.PLAIN, 15));
                button.setMargin(new Insets(0,0,0,0));
                button.setBackground(Color.lightGray);
                button.setEnabled(false);
                gridNumber.add(button);
            }
        }
        for(JButton button: gridNumber){
            panel.add(button);
        }
        panelBoard.add(panel);
        panelBoard.setBackground(Color.lightGray);
    }

    private void makeCanvas() {
        Panel panel = new Panel();
        panel.setBackground(Color.GRAY);
        panel.setLayout(new GridLayout(5, 5));
        panel.setBounds(100, 100,100, 100);
        for( int i = 0; i < 5; i++){
            for(int j = 0; j < 5; j++){
                JButton button = new JButton();
                button.setBackground(Color.WHITE);
                button.addActionListener((e) ->{
                    if( button.getBackground() == Color.BLACK)  button.setBackground(Color.WHITE);
                    else button.setBackground(Color.BLACK);
                });
                gridGame[i][j] = button;
            }
        }

        for(JButton[] button: gridGame){
            for(JButton jButton: button){
                panel.add(jButton);
            }
        }
        panelBoard.add(panel);
        if(makeNumber) makeNumberCanvas();
    }

}
