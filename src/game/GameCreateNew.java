package game;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.xml.sax.SAXException;

import javax.swing.*;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class GameCreateNew extends JPanel {

    SceneManager sceneManager;
    NonogramBoard nonogramBoard;
    Image image;
    String stringClickedButton;
    int[][] clickedButton = new int[5][5];

    public GameCreateNew(SceneManager sceneManager){
        image = new ImageIcon("res\\menuBackground.png").getImage();

        setSize(300, 400);
        setLayout(null);
        this.sceneManager = sceneManager;

        nonogramBoard = new NonogramBoard(this, false);
        add(new ButtonBack(sceneManager));
        JButton buttonCheck = new MyButton("Create!", 20);
        buttonCheck.setBounds(180, 300, 100, 20);
        buttonCheck.addActionListener((e) -> {
            createNew();
            sceneManager.setNewComponent(new MenuScreen(sceneManager));
        });
        add(buttonCheck);
    }

    private void createNew() {
        int var;
        for(int i = 0; i < 5; i++){
            for( int j = 0; j < 5; j++){
                var = nonogramBoard.gridGame[i][j].getBackground() == Color.BLACK ? 1 : 0;
                clickedButton[i][j] = (var);
                if (stringClickedButton == null)
                    stringClickedButton = String.valueOf(var);
                else
                    stringClickedButton += String.valueOf(var);
            }
        }
        addToXML();
    }

    private void addToXML() {
        try {
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            DocumentBuilder db = dbf.newDocumentBuilder();
            Document document = db.parse(new File("res\\nonograms.xml"));

            Element nonograms = (Element) document.getElementsByTagName("nonograms").item(0);
            if(nonograms == null){
                nonograms = document.createElement("nonograms");
            }
            Element nonogram = document.createElement("nonogram");
            nonograms.appendChild(nonogram);

            Element elementButtons = document.createElement("buttons");
            elementButtons.appendChild(document.createTextNode(stringClickedButton));
            nonogram.appendChild(elementButtons);

            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");
            DOMSource domSource = new DOMSource(document);
            StreamResult streamResult = new StreamResult(new File("res\\nonograms.xml"));
            transformer.transform(domSource, streamResult);

        } catch (ParserConfigurationException | SAXException | IOException | TransformerException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(image, -10, -35, null);
    }

}
