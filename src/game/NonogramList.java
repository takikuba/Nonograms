package game;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
import java.util.ArrayList;

public class NonogramList {

    ArrayList<Nonogram> listNonogram = new ArrayList<>();

    public NonogramList() {
        NodeList nodeList = getNonogramsData();
        for (int i = 0; i < nodeList.getLength(); i++) {
            Node node = nodeList.item(i);
            if (node.getNodeType() == Node.ELEMENT_NODE) {
                Element element = (Element) node;
                Nonogram nonogram = new Nonogram();
                nonogram.numbers = changeToNumbers(element.getElementsByTagName("buttons").item(0).getTextContent());
                nonogram.clickedButton = changeToButtons(element.getElementsByTagName("buttons").item(0).getTextContent());
                listNonogram.add(nonogram);
            }
        }

    }

    public int getLength() {
        return listNonogram.size() - 1;
    }

    public Nonogram getFirst() {
        return listNonogram.get(0);
    }

    public Nonogram getRandom() {
        int val = (int) (Math.random() * getLength());
        return listNonogram.get(val);
    }

    public int[][] testChangeToNumbers(String str){
        return changeToNumbers(str);
    }

    private int[][] changeToNumbers(String str) {
        int[][] retval = new int[8][8];
        int[][] tab = new int[5][5];

        int index = 0;
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                tab[i][j] = Character.getNumericValue(str.charAt(index));
                index++;
            }
        }

        for (int i = 0; i < 5; i++) {
            System.arraycopy(tab[i], 0, retval[i + 3], 3, 5);
        }

        int[][] odpowiedzi = changeForNumbers(tab);

        for (int i = 3; i < 8; i++) {
            for (int j = 0; j < 3; j++) {
                retval[i][j] = odpowiedzi[j][i - 3];
            }
        }

        for (int i = 0; i < 3; i++) {
            System.arraycopy(odpowiedzi[i], 5, retval[i], 3, 5);
        }
        return retval;
    }

    private int[][] changeForNumbers(int[][] clickedButton) {
        int[][] odpowiedzi = new int[3][10];
        int count = 0;
        int countX = 0;
        int countY = 0;

        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                if (clickedButton[i][j] == 1) {
                    count++;
                } else {
                    if (count != 0) {
                        odpowiedzi[countX][countY] = count;
                        count = 0;
                        countX++;
                    }
                }
            }
            if (count != 0) {
                odpowiedzi[countX][countY] = count;
                count = 0;
            }
            countX = 0;
            countY++;
        }

        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                if (clickedButton[j][i] == 1) {
                    count++;
                } else {
                    if (count != 0) {
                        odpowiedzi[countX][countY] = count;
                        count = 0;
                        countX++;
                    }
                }
            }
            if (count != 0) {
                odpowiedzi[countX][countY] = count;
                count = 0;
            }
            countX = 0;
            countY++;
        }
        return odpowiedzi;
    }

    private int[][] changeToButtons(String str) {
        int[][] retval = new int[5][5];
        int index = 0;
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                retval[i][j] = Character.getNumericValue(str.charAt(index));
                index++;
            }
        }
        return retval;
    }

    private NodeList getNonogramsData() {
        try {
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            DocumentBuilder db = dbf.newDocumentBuilder();
            Document doc = db.parse(new File("res\\nonograms.xml"));
            return doc.getElementsByTagName("nonogram");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

}
