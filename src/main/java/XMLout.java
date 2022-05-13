import org.w3c.dom.Document;
import org.w3c.dom.Element;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.FileOutputStream;
import java.util.ArrayList;

public class XMLout {
    public void XMLOut(String filepath, ArrayList<Weapons> order){
        try {
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            DocumentBuilder db = dbf.newDocumentBuilder();
            Document doc = db.newDocument();

            Element rootElement = doc.createElement("Orders");
            doc.appendChild(rootElement);

            for(int i=0;i< order.size();i++){
                Element newOrder=doc.createElement("n");
                rootElement.appendChild(newOrder);

                Element nameElement= doc.createElement("name");
                nameElement.setTextContent(order.get(i).getName());
                newOrder.appendChild(nameElement);

                Element typeElement= doc.createElement("type");
                typeElement.setTextContent(order.get(i).getType());
                newOrder.appendChild(typeElement);

                Element costElement= doc.createElement("cost");
                costElement.setTextContent(order.get(i).getCost().toString());
                newOrder.appendChild(costElement);

                Element timeElement= doc.createElement("time");
                timeElement.setTextContent(order.get(i).getTime().toString());
                newOrder.appendChild(timeElement);

                Element upgradeElement= doc.createElement("upgradePath");
                upgradeElement.setTextContent(order.get(i).getUpgradePath().toString());
                newOrder.appendChild(upgradeElement);

                TransformerFactory tf = TransformerFactory.newInstance();
                Transformer transformer = tf.newTransformer();

                DOMSource src = new DOMSource(doc);
                StreamResult res = new StreamResult(new FileOutputStream(filepath));

                transformer.setOutputProperty(OutputKeys.INDENT, "yes");
                transformer.transform(src, res);

            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
