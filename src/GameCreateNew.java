import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class GameCreateNew extends JPanel {

    public GameCreateNew(SceneManager sceneManager){

    }

    public GameCreateNew(){
        setSize(300, 400);
        setLayout(null);
        setBackground(Color.CYAN);
        makeCanvas();
    }

    private void makeCanvas() {
        Panel panel = new Panel();
        panel.setBackground(Color.GRAY);
        panel.setLayout(new GridLayout(5, 5));
        panel.setBounds(100, 100, 200, 200);
        List<JButton> gameGrid = new ArrayList<>();
        for(int i = 0; i < 25; i++){
            JButton button = new JButton();
            button.addActionListener((e) -> button.setBackground(Color.BLACK));
            gameGrid.add(button);
        }
        for(JButton button: gameGrid){
            panel.add(button);
        }
        add(panel);
        setBackground(Color.lightGray);
    }
}
