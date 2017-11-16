import java.net.MalformedURLException;
import java.net.URL;
import java.net.UnknownHostException;
import java.security.Security;
import java.security.cert.Certificate;
import java.io.*;


import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;



public class HttpsClient{

   public static void main(String[] args)
   {
        //new HttpsClient().testIt();
	   new HttpsClient().test();
   }
   
   private void test(){
	   String urlString = "https://unipass.customs.go.kr:38010/ext/rest/expDclrNoPrExpFfmnBrkdQry/retrieveExpDclrNoPrExpFfmnBrkd?crkyCn=s240z166u002h262f000u080w0&expDclrNo=120101500914619";
       URL url;
       //HttpsURL surl;
	try {
		url = new URL ("https://unipass.customs.go.kr:38010/ext/rest/expDclrNoPrExpFfmnBrkdQry/retrieveExpDclrNoPrExpFfmnBrkd?crkyCn=s240z166u002h262f000u080w0&expDclrNo=120101500914619");
		//surl = new HttpsURL("https://unipass.customs.go.kr:38010/ext/rest/expDclrNoPrExpFfmnBrkdQry/retrieveExpDclrNoPrExpFfmnBrkd?crkyCn=s240z166u002h262f000u080w0&expDclrNo=120101500914619"); 
 
       Security.addProvider (new com.sun.net.ssl.internal.ssl.Provider ());
 
       SSLSocketFactory factory = (SSLSocketFactory) SSLSocketFactory.getDefault ();
       SSLSocket socket;
       PrintWriter out;
       BufferedReader in;
       String line;
		try {
			socket = (SSLSocket) factory.createSocket (url.getHost (), 443);
			out = new PrintWriter (new OutputStreamWriter (socket.getOutputStream ()));
			out.println ("POST " + urlString + " HTTP/1.1");
			out.println ();
			out.flush ();
			in = new BufferedReader (new InputStreamReader (socket.getInputStream ()));
			while ((line = in.readLine ()) != null) {
				System.out.println (line);
			}
			
			out.close ();
			in.close ();
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	//}catch(URIException e){	
	//	e.printStackTrace();
	} catch (MalformedURLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
   }

   private void testIt(){

      String https_url = "https://www.google.com/";
      URL url;
      try {

	     url = new URL(https_url);
	     HttpsURLConnection con = (HttpsURLConnection)url.openConnection();

	     //dumpl all cert info
	     //print_https_cert(con);

	     //dump all the content
	     print_content(con);

      } catch (MalformedURLException e) {
	     e.printStackTrace();
      } catch (IOException e) {
	     e.printStackTrace();
      }

   }
/*
   private void print_https_cert(HttpsURLConnection con){

    if(con!=null){

      try {

	System.out.println("Response Code : " + con.getResponseCode());
	System.out.println("Cipher Suite : " + con.getCipherSuite());
	System.out.println("\n");

	Certificate[] certs = con.getServerCertificates();
	for (int i = 0; i < certs.length; i++) {
		
	//}
	//for(Certificate cert : certs){
	   System.out.println("Cert Type : " + certs[i].getType());
	   System.out.println("Cert Hash Code : " + certs[i].hashCode());
	   System.out.println("Cert Public Key Algorithm : "
                                    + certs[i].getPublicKey().getAlgorithm());
	   System.out.println("Cert Public Key Format : "
                                    + certs[i].getPublicKey().getFormat());
	   System.out.println("\n");
	}

	} catch (SSLPeerUnverifiedException e) {
		e.printStackTrace();
	} catch (IOException e){
		e.printStackTrace();
	}

     }

   }
*/
   private void print_content(HttpsURLConnection con){
	if(con!=null){

	try {

	   System.out.println("****** Content of the URL ********");
	   BufferedReader br =
		new BufferedReader(
			new InputStreamReader(con.getInputStream()));

	   String input;

	   while ((input = br.readLine()) != null){
	      System.out.println(input);
	   }
	   br.close();

	} catch (IOException e) {
	   e.printStackTrace();
	}

       }

   }

}