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

public class PlayerDataRequest_Parser {
    public static void main(String[]args){
        String[] info = null;
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        try {

            DocumentBuilder builder = factory.newDocumentBuilder();
            Document doc = builder.parse("PlayerDataRequest.xml");

            NodeList infolist = doc.getElementsByTagName("info");
            info = new String[infolist.getLength()];
            for (int i = 0; i<infolist.getLength(); i++) {
                Node infoN = infolist.item(i);
                if (infoN.getNodeType()==Node.ELEMENT_NODE) {
                    Element infoE = (Element) infoN;
                    info[i] = infoE.getTextContent();
                }
            }
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
