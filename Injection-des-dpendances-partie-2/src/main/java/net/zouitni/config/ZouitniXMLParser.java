package net.zouitni.config;

import org.w3c.dom.Node;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import java.io.File;
import java.util.Map;

// Exemple de parser XML pour lire la configuration
public class ZouitniXMLParser {
    public static Map<String, String> parseXML(String filePath) throws JAXBException {
        JAXBContext context = JAXBContext.newInstance(ZouitniBeansConfig.class);
        return context.createUnmarshaller().unmarshal((Node) new File(filePath), ZouitniBeansConfig.class).getValue().getBeans();
    }
}
