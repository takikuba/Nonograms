import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Nonogram {

    int id;
    int[][] numbers = new int[8][8];
    int[][] clickedButton = new int[5][5];

    public Nonogram(){}

    public Nonogram(int id, int[][] numbers, int[][] clickedButton){
        this.id = id;
        this.numbers = numbers;
        this.clickedButton = clickedButton;
    }
}

class DrawNonogram extends Nonogram{

    public DrawNonogram(){
        Nonogram nonogram = new NonogramList().getRandom();
        this.id = nonogram.id;
        this.clickedButton = nonogram.clickedButton;
        this.numbers = nonogram.numbers;
    }

}

class NonogramList {

    List<Nonogram> listNonogram = new ArrayList();
    Nonogram[] nonograms;

    public NonogramList(){
        NodeList nodeList = getNonogramsData();
        for( int i = 0; i < nodeList.getLength(); i++ ){
            Node node = nodeList.item(i);
            if( node.getNodeType() == Node.ELEMENT_NODE){
                Element element = (Element) node;
                Nonogram nonogram = new Nonogram();
                nonogram.id = Integer.parseInt(element.getElementsByTagName("id").item(0).getTextContent());
                nonogram.numbers = changeToNumbers(element.getElementsByTagName("numbers").item(0).getTextContent());
                nonogram.clickedButton = changeToButtons(element.getElementsByTagName("buttons").item(0).getTextContent());
                System.out.println(nonogram.id + " " + Arrays.deepToString(nonogram.numbers) + " " + Arrays.deepToString(nonogram.clickedButton));
                listNonogram.add(nonogram);
            }
        }

    }
    private void makeArray(){
        int index = 0;
        nonograms = new Nonogram[listNonogram.size()];
        for(Nonogram nonogram: listNonogram){
            nonograms[index] = nonogram;
            index++;
        }
    }

    public int getLength() {
        return listNonogram.size()-1;
    }

    public Nonogram getRandom(){
        int val = (int)(Math.random() * getLength());
        System.out.println(val);
        return listNonogram.get(val);
    }

    private int[][] changeToNumbers(String str){
        int[][] retval = new int[8][8];
        int index = 0;
        for( int i = 0; i < 8; i++){
            for( int j = 0; j < 8; j++){
                retval[i][j] = Character.getNumericValue(str.charAt(index));
                index++;
            }
        }
        return retval;
    }

    private int[][] changeToButtons(String str){
        int[][] retval = new int[5][5];
        int index = 0;
        for( int i = 0; i < 5; i++){
            for( int j = 0; j < 5; j++){
                retval[i][j] = Character.getNumericValue(str.charAt(index));
                index++;
            }
        }
        return retval;
    }

    private NodeList getNonogramsData(){
        try {
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            DocumentBuilder db = dbf.newDocumentBuilder();
            Document doc = db.parse(new File("res\\nonograms.xml"));
            return doc.getElementsByTagName("nonogram");
        } catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

}
