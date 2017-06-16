package Helper_Classes;

import java.io.File;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class CreateXml {

	public static void CreateXMLFile(List<Location> locations) {

		try {
			DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder docBuilder = docFactory.newDocumentBuilder();

			Document doc = docBuilder.newDocument();
			Element rootElemnt = doc.createElement("locations");
			doc.appendChild(rootElemnt);

			//
			for (Location loc : locations) {
				Element location = doc.createElement("location");
				rootElemnt.appendChild(location);

				Element zipCode = doc.createElement("zipCode");
				zipCode.appendChild(doc.createTextNode("" + loc.ZipCode));
				location.appendChild(zipCode);

				Element city = doc.createElement("city");
				city.appendChild(doc.createTextNode(loc.City));
				location.appendChild(city);

				Element zone = doc.createElement("zone");
				zone.appendChild(doc.createTextNode(loc.Zone));
				location.appendChild(zone);
			}

			TransformerFactory transformerFactory = TransformerFactory.newInstance();
			Transformer transformer = transformerFactory.newTransformer();
			DOMSource source = new DOMSource(doc);
			StreamResult result = new StreamResult(new File("src/Helper_Classes/XMLOutput.xml"));

			transformer.transform(source, result);

			System.out.println("XML file created");

		} catch (Exception ex) {
		}
	}
}
