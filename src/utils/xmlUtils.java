package utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;

public class xmlUtils {
	
	private static String filepath;
	
	static{
		filepath=xmlUtils.class.getClassLoader().getResource("userXml.xml").getPath();//获取文件位置
	}

	public static Document getDocument() throws DocumentException{
		 SAXReader reader = new SAXReader();
	     Document document = reader.read(new File(filepath));
	     
	     return document;
	     
	}
	
	public static void write2Document(Document doc) throws IOException{
		 OutputFormat format = OutputFormat.createPrettyPrint();
		 format.setEncoding("UTF-8");//设置字符，避免中文乱码
		 XMLWriter writer = new XMLWriter(new FileOutputStream(filepath),format);
	     writer.write(doc);
	     writer.close();

	}
}
