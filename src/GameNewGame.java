import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class GameNewGame extends JComponent {
    SceneManager sceneManager;
    Nonogram nonogram;
    List<JButton> gridNumber;
    JButton[][] gridGame = new JButton[5][5];

    public GameNewGame(){
        setSize(300, 400);
        setLayout(new BorderLayout());
        setBackground(Color.CYAN);

    }

    public GameNewGame(SceneManager sceneManager){
        setSize(300, 400);
        setLayout(null);
        this.sceneManager = sceneManager;

        makeCanvas();

        JButton buttonCheck = new JButton("Check!");
        buttonCheck.setBounds(180, 300, 100, 20);
        buttonCheck.addActionListener((e) -> {
            endGame(checkCorrect());
        });
        add(buttonCheck);

    }

    private void endGame(boolean checkCorrect) {
        if(checkCorrect){
            JOptionPane.showMessageDialog(this, "Win!");
        } else {
            JOptionPane.showMessageDialog(this, "Lose!");
        }
    }

    private boolean checkCorrect() {
        boolean isCorrect = true;
        int var;
        for( int i = 0; i < 5; i++){
            for(int j = 0; j < 5; j++){
                var = (gridGame[i][j].getBackground().equals(Color.BLACK) ? 1 : 0);
                if(var != nonogram.clickedButton[i][j]){
                    isCorrect = false;
                    break;
                }
            }
        }
        System.out.println(isCorrect);
        return isCorrect;
    }

    private void makeNumberCanvas() {
        nonogram = new Nonogram();
        Panel panel = new Panel();
        panel.setBackground(Color.GRAY);
        panel.setLayout(new GridLayout(8, 8));
        panel.setBounds(40, 40, 160, 160);
        gridNumber = new ArrayList<>();
        for( int i = 0; i < 8; i++){
            for(int j = 0; j < 8; j++){
                JButton button;
                if(nonogram.numbers[i][j] == 1){
                    button = new JButton("one", new ImageIcon("C:\\Users\\Kuba\\Desktop\\SemestrV\\IO\\Nanogramy\\res\\one.jpg"));
                } else{
                    button = new JButton();
                }
                button.setBackground(Color.lightGray);
                gridNumber.add(button);
            }
        }
        for(JButton button: gridNumber){
            panel.add(button);
        }
        add(panel);
        setBackground(Color.lightGray);
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
        add(panel);
        makeNumberCanvas();
    }

}
