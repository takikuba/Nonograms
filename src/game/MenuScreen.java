package game;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

class MenuScreen extends JPanel {
    private JButton buttonStartGame;
    private JButton buttonCreateNew;
    private JButton buttonExit;
    private Image image;

    public MenuScreen(SceneManager sceneManager) {

        image = new ImageIcon("res\\menuBackground.png").getImage();

        setBounds(0, 0, 300, 400);
        setBorder(new EmptyBorder(10, 10, 10, 10));
        setLayout(new GridBagLayout());

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridwidth = GridBagConstraints.REMAINDER;
        gbc.anchor = GridBagConstraints.NORTH;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.fill = GridBagConstraints.HORIZONTAL;

        buttonStartGame = new MyButton("New Game");
        buttonStartGame.addActionListener((e) -> sceneManager.setNewComponent(new GameNewGame(sceneManager)));

        buttonCreateNew = new MyButton("Create");
        buttonCreateNew.addActionListener((e) -> sceneManager.setNewComponent(new GameCreateNew(sceneManager)));

        buttonExit = new MyButton("Exit");
        buttonExit.addActionListener((e) -> System.exit(0));

        JPanel buttons = new JPanel(new GridBagLayout());
        buttons.add(buttonStartGame, gbc);
        buttons.add(buttonCreateNew, gbc);
        buttons.add(buttonExit, gbc);
        buttons.setOpaque(false);

        gbc.weighty = 1;
        add(buttons, gbc);
        sceneManager.getScreen().getContentPane().add(this);
        sceneManager.getScreen().repaint();
        sceneManager.getScreen().setVisible(true);
        sceneManager.getScreen().revalidate();
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(image, -10, -35, null);
    }
}