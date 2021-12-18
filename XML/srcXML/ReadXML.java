import java.io.IOException;
import java.util.Calendar;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.xml.sax.SAXException;
public class ReadXML 
{
	Document doc;
	XPath xpath;
	public ReadXML(String url) 
	{
		DocumentBuilderFactory domFactory = DocumentBuilderFactory.newInstance();
        domFactory.setNamespaceAware(true);
        DocumentBuilder builder = null;
        /*
        System.setProperty("proxySet", "true");
        System.setProperty("http.proxyHost", "203.185.131.3");
        System.setProperty("http.proxyPort", "8080");
        */
		try {
			builder = domFactory.newDocumentBuilder();
		} catch (ParserConfigurationException e1) {
			e1.printStackTrace();
		}
		try {
			doc = builder.parse(url);
		} catch (SAXException e1) {
			e1.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		XPathFactory factory = XPathFactory.newInstance();
        xpath = factory.newXPath();   
	}
	public NodeList XPathRead(String condition)
    {
		NodeList roadNodes = null;
		try {
			//XPathExpression expr = xpath.compile("/report/data/link/text()");
			XPathExpression exprRoad = (XPathExpression) xpath.compile(condition);
			Object resultRoad = exprRoad.evaluate(doc, XPathConstants.NODESET);
			roadNodes = (NodeList) resultRoad;
			/*
			for (int i = 0; i < roadNodes.getLength(); i++) 
	        {
	            Node textNode = roadNodes.item(i);
	            //System.out.print(textNode.getParentNode().getNodeName()+" = ");
	            System.out.println(textNode.getNodeValue());
	        }
	        */
		} catch (XPathExpressionException e) {
			e.printStackTrace();
		}
		return roadNodes;
    }
	public static void main(String[] args) {
		Calendar rightNow = Calendar.getInstance();
		long a = rightNow.getTimeInMillis();
		
		ReadXML RXML = new ReadXML("XML\\TableMap.xml"); 
		
		rightNow = Calendar.getInstance();
		long b = rightNow.getTimeInMillis()-a;
		System.out.println("Load Time Process : "+b);
		
		rightNow = Calendar.getInstance();
		a = rightNow.getTimeInMillis();
		
		NodeList roadNodes = RXML.XPathRead("//mainroad/text()");
		
		rightNow = Calendar.getInstance();
		b = rightNow.getTimeInMillis()-a;
		System.out.println("XPathRead Time Process : "+b);
		
		/*
		for (int i = 0; i < roadNodes.getLength(); i++)
        {
            Node textNode = roadNodes.item(i);
            //System.out.print(textNode.getParentNode().getNodeName()+" = ");
            System.out.println(textNode.getNodeValue());
        }
        */
	}
}