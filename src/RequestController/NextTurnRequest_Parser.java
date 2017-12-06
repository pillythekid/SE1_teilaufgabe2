package RequestController;


import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;

public class NextTurnRequest_Parser {
    public static void main(String[]args){
        int X;
        int Y;
        String mtrnr = null;
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        try {

            DocumentBuilder builder = factory.newDocumentBuilder();
            Document doc = builder.parse("NextTurnrequest.xml");

            NodeList mtrnrlist = doc.getElementsByTagName("mtrnr");
            if (mtrnrlist.getLength()==1) {
                Node mtrnrN = mtrnrlist.item(0);
                Element mtrnrE = (Element) mtrnrN;
                mtrnr = mtrnrE.getTextContent();
            } else throw new RuntimeException("ERROR: value incorrect.");
            NodeList Xlist = doc.getElementsByTagName("X");
            if (Xlist.getLength()==1) {
                Node Xnode = Xlist.item(0);
                Element Xelement = (Element) Xnode;
                String Xstring = Xelement.getTextContent();
                X = Integer.parseInt(Xstring);
            } else throw new RuntimeException("ERROR: value incorrect.");
            NodeList Ylist = doc.getElementsByTagName("Y");
            if (Ylist.getLength()==1) {
                Node Ynode = Ylist.item(0);
                Element Yelement = (Element) Ynode;
                String Ystring = Yelement.getTextContent();
                Y = Integer.parseInt(Ystring);
            } else throw new RuntimeException("ERROR: value incorrect.");

        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}
