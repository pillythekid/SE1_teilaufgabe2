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

public class xmlParser {
    public static void main(String[]args){
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        try {
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document doc = builder.parse("RegisterNewPlayerRequest.xml");
            NodeList playerlist = doc.getElementsByTagName("mtrnr");
            if (playerlist.getLength()!=1) System.out.println("player not registered please check your register request applictaion again.");
            else {
                Node p = playerlist.item(0);
                if (p.getNodeType()==Node.ELEMENT_NODE){
                    Element player = (Element) p;
                    String mtrnr = player.getAttribute("mtrnr");
                }
            }
           /* for (int i=0; i<playerlist.getLength();i++){
                Node p = playerlist.item(i);
                if (p.getNodeType()==Node.ELEMENT_NODE){
                    Element player = (Element) p;
                    String mtrnr = player.getAttribute("mtrnr");
                }
            } */

        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
