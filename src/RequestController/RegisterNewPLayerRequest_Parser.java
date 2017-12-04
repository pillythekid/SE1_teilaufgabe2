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

public class RegisterNewPLayerRequest_Parser {
    public static void main(String[]args){
        String mtrnr = null;
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        try {
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document doc = builder.parse("RegisterNewPLayerRequest.xml");
            NodeList playerlist = doc.getElementsByTagName("mtrnr");
            for (int i=0; i<playerlist.getLength();i++){
                Node p = playerlist.item(i);
                if (p.getNodeType()==Node.ELEMENT_NODE){
                    Element player = (Element) p;
                    mtrnr = player.getTextContent();
                }
            }
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
