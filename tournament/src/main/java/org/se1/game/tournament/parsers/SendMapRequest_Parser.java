package org.se1.game.tournament.parsers;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;

public class SendMapRequest_Parser {
    public static void main(String[]args){
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        String mtrnr = null;
        int [][] _map = new int[4][8];
        int [] _start = new int[2];
        int [] _castle = null;


        try {

            DocumentBuilder builder = factory.newDocumentBuilder();
            Document doc = builder.parse("SendMapRequest.xml");

            NodeList mtrnrlist = doc.getElementsByTagName("mtrnr"); // ONLY ONE MTRNR
            Node mtrnrN = mtrnrlist.item(0);
            Element mtrnrE = (Element) mtrnrN;
            mtrnr = mtrnrE.getTextContent();

            NodeList regionlist = doc.getElementsByTagName("region"); // LIST OF A TO H
            if (regionlist.getLength()==8) {
                for (int i=0; i<regionlist.getLength();i++){
                    Node r = regionlist.item(i); //EACH NODE OF A TO H IS ITERATED
                    if (r.getNodeType()==Node.ELEMENT_NODE){
                        Element rE = (Element) r; //A TO H CASTING TO ELEMENT
                        //String rID = rE.getAttribute("id"); //WE GET THE STRINGS OF A TO H, never used tho but for keepers sake I leave it here
                        NodeList fieldlist = rE.getChildNodes(); //WE MAKE A LIST OF THE FIELDS 1 TO 4
                        if (fieldlist.getLength() == 4) {
                            for (int n = 0; n < fieldlist.getLength(); n++) {
                                Node f = fieldlist.item(n); //EACH NODE OF 1 TO 4 IS ITERATED
                                if (f.getNodeType() == Node.ELEMENT_NODE) {
                                    Element fE = (Element) f;  //1 TO 4 CASTING TO ELEMENT
                                    String fVAL = fE.getTextContent();
                                    int _fVAL = Integer.parseInt(fVAL);
                                    _map[n][i]=_fVAL;
                                }
                            }
                        } else {
                            System.out.println("map does not respond to norm. please resend your request");
                            break;
                        }
                    }
                }
            } else System.out.println("map does not respond to norm. please resend your request");

            NodeList poslist = doc.getElementsByTagName("position"); //LIST OF ALL POSITIONS
            if (poslist.getLength()==2){
                _castle = new int[2];
                for (int i=0; i<2;i++){
                    Node pos = regionlist.item(i); //POS IS NOW EITHER CASTLE OR START
                    if (pos.getNodeType()==Node.ELEMENT_NODE){
                        Element posE = (Element) pos; //POS IS NOW AN ELEMENT
                        NodeList coordinatelist = posE.getChildNodes(); //WE MAKE A LIST OF X,Y AND CONTENT
                        if (coordinatelist.getLength() == 3) {
                            Node settingN = regionlist.item(0);
                            Element settingE = (Element) settingN;
                            String setting = settingE.getTagName();
                            for (int n = 1; n < coordinatelist.getLength(); n++) {
                                Node coordN = regionlist.item(n);
                                if (coordN.getNodeType()==Node.ELEMENT_NODE){
                                    Element coordE = (Element) coordN;
                                    String coord = coordE.getTextContent();
                                    int coordinate = Integer.parseInt(coord);
                                    if (setting == "castle"){
                                        _castle[n-1]=coordinate;
                                    } else if (setting == "start"){
                                        _start[n-1]=coordinate;
                                    } else {
                                        System.out.println("position does not respond to norm. please resend your request");
                                        break;
                                    }
                                }
                            }
                        } else {
                            System.out.println("position does not respond to norm. please resend your request");
                            break;
                        }
                    }
                }
            } else if (poslist.getLength()==1){
                Node pos = regionlist.item(0); //POS IS NOW CASTLE AND START
                Element posE = (Element) pos; //POS IS NOW AN ELEMENT
                NodeList coordinatelist = posE.getChildNodes(); //WE MAKE A LIST OF X,Y AND CONTENT
                    Node settingN = regionlist.item(0);
                    Element settingE = (Element) settingN;
                    if (settingE.getTagName() == "castlestarter"){
                        Node XN = regionlist.item(1);
                        Node YN = regionlist.item(2);
                        String XS = XN.getTextContent();
                        int X = Integer.parseInt(XS);
                        String YS = YN.getTextContent();
                        int Y = Integer.parseInt(YS);
                        _start[0]=X;
                        _start[1]=Y;
                    }
            } else System.out.println("position does not respond to norm. please resend your request");

        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        }

    }
}
