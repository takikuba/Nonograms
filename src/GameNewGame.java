import javax.swing.*;
import java.awt.*;

public class GameNewGame extends JPanel {

    SceneManager sceneManager;
    NonogramBoard nonogramBoard;
    long timeStart = System.nanoTime();
    long timeEnd;

    public GameNewGame(SceneManager sceneManager){
        setSize(300, 400);
        setLayout(null);
        setBackground(Color.CYAN);
        this.sceneManager = sceneManager;

        nonogramBoard = new NonogramBoard(this, true);

        JButton buttonCheck = new JButton("Check!");
        buttonCheck.setBounds(180, 300, 100, 20);
        buttonCheck.addActionListener((e) -> {
            endGame(checkCorrect());
        });
        add(buttonCheck);

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
        System.out.println(isCorrect);
        return isCorrect;
    }
}
