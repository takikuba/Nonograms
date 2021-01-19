package game;

import javax.swing.*;
import java.awt.*;

public class GameNewGame extends JPanel {

    SceneManager sceneManager;
    NonogramBoard nonogramBoard;
    long timeStart = System.nanoTime();
    long timeEnd;
    Image image;

    public GameNewGame(SceneManager sceneManager){
        image = new ImageIcon("res\\menuBackground.png").getImage();
        setSize(300, 400);
        setLayout(null);
        setBackground(Color.CYAN);
        this.sceneManager = sceneManager;

        nonogramBoard = new NonogramBoard(this, true);

        JButton buttonCheck = new MyButton("Check", 19);
        buttonCheck.setBounds(100, 320, 100, 20);
        buttonCheck.addActionListener((e) -> endGame(checkCorrect()));
        add(buttonCheck);

        JButton buttonBack = new ButtonBack(sceneManager);
        add(buttonBack);

    }

    private void endGame(boolean checkCorrect) {
        if(checkCorrect){
            timeEnd = System.nanoTime();
            JOptionPane.showMessageDialog(this, "Win! " + (timeEnd - timeStart)/1e9);
            sceneManager.setNewComponent(new MenuScreen(sceneManager));
        } else {
            JOptionPane.showMessageDialog(this, "Lose!");
        }
    }

    private boolean checkCorrect() {
        boolean isCorrect = true;
        int var;
        for( int i = 0; i < 5; i++){
            for(int j = 0; j < 5; j++){
                var = (nonogramBoard.gridGame[i][j].getBackground().equals(Color.BLACK) ? 1 : 0);
                if(var != nonogramBoard.nonogram.clickedButton[i][j]){
                    isCorrect = false;
                    break;
                }
            }
        }
        return isCorrect;
    }
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(image, -10, -35, null);
    }
}
