package test;

import java.io.UnsupportedEncodingException;

public class Test {
public static void main(String[] args) throws Exception {
	System.out.println("\"Kony@123\"".getBytes("UTF-16LE"));
	System.out.println(javax.xml.bind.DatatypeConverter.printBase64Binary("\"KonyBipin@PH#8374277755\"".getBytes("UTF-16LE")));
	System.out.println(javax.xml.bind.DatatypeConverter.printBase64Binary("Kony@123".getBytes("UTF-16LE")));
	String newPass = javax.xml.bind.DatatypeConverter.printBase64Binary(('"'+"Jfi8ZH8#k"+'"').getBytes("UTF-16LE"));
	System.out.println(newPass);
}
}
