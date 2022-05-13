import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.util.ArrayList;

public class XMLin {
    public static ArrayList<Weapons> XMLIn(String filepath) {
        ArrayList<Weapons> wep = new ArrayList<>();
        try {
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            DocumentBuilder db = dbf.newDocumentBuilder();
            Document doc = db.parse(filepath);
            Element rootElement = doc.getDocumentElement();
            NodeList childNodeList = rootElement.getChildNodes();
            Node node;
            for (int i = 0; i < childNodeList.getLength(); i++) {
                node = childNodeList.item(i);
                if (node.getNodeType() == Node.ELEMENT_NODE) {
                    NodeList childnodelist = node.getChildNodes();
                    String name = "", type = "", cost = "", time = "", upgradePath = "";
                    for (int j = 0; j < childnodelist.getLength(); j++) {
                        Node childnode = childnodelist.item(j);
                        if (childnode.getNodeType() == Node.ELEMENT_NODE) {
                            switch (childnode.getNodeName()) {
                                case "name" -> name = childnode.getTextContent();
                                case "type" -> type = childnode.getTextContent();
                                case "cost" -> cost = childnode.getTextContent();
                                case "time" -> time = childnode.getTextContent();
                                case "upgradePath" -> upgradePath = childnode.getTextContent();
                            }
                        }
                    }
                    wep.add(new Weapons(name, type, Integer.parseInt(cost), Integer.parseInt(time), UpgradePath.valueOf(upgradePath)));

                }
            }
        } catch (Exception e) {
            System.out.println("Hiba az XML fájl beolvasásakor");
        }
        return wep;
    }
}
