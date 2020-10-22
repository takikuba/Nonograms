import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class GameCreateNew extends JPanel {

    SceneManager sceneManager;
    NonogramBoard nonogramBoard;

    public GameCreateNew(SceneManager sceneManager){
        setSize(300, 400);
        setLayout(null);
        this.sceneManager = sceneManager;

        nonogramBoard = new NonogramBoard(this, false);

        JButton buttonCheck = new JButton("Create!");
        buttonCheck.setBounds(180, 300, 100, 20);
        buttonCheck.addActionListener((e) -> {
            createNew();
        });
        add(buttonCheck);
    }

    private void createNew() {
    }

}
