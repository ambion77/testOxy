
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.security.Security;


public class JavaHttps {
	public static void main(String[] args) {

		  
		  String url    =  "https://unipass.customs.go.kr:38010/ext/rest/expDclrNoPrExpFfmnBrkdQry/retrieveExpDclrNoPrExpFfmnBrkd?crkyCn=s240z166u002h262f000u080w0&expDclrNo=120101500914619";
		  
		  String responseMessage =  "";
		  
		  InputStream is   =  null;
		   InputStreamReader isr =  null;
		   BufferedReader br  =  null;
		   
		   StringBuffer sb = new StringBuffer();
		  //�� �κ��� https�κ��Դϴ�.***************************
		  System.setProperty ( "java.protocol.handler.pkgs","com.sun.net.ssl.internal.www.protocol");
		  
		  com.sun.net.ssl.internal.ssl.Provider provider = new com.sun.net.ssl.internal.ssl.Provider();
		  
		  Security.addProvider(provider);
		  //*****************************************************
		  
		  
		  try{
		  
		   URL httpsUrl  =  new URL(url);
		   
		   URLConnection conn =  httpsUrl.openConnection();
		   
		  
		   conn.setUseCaches(false);
		   
		   conn.setConnectTimeout(40000);
		   
		   
		   conn.setDoOutput(true);//post ��� ����
		   
		   conn.connect();
		   
		   responseMessage    = conn.getHeaderField(0);
		   
		 
		   
		   System.out.println(responseMessage);
		   // HTTP/1.1 200 OK ������ http ��� ��� �ڵ尡 ��µ˴ϴ�.
		   
		   is = conn.getInputStream();
		   isr = new InputStreamReader(is);
		   br = new BufferedReader(isr);
		    
		    String line = null;
		    while((line=br.readLine()) != null){
		          sb.append(line);
		    }
		    System.out.println(sb.toString());
		    //html �κ� ���
		    
		   
		  }catch(Exception e){
		   e.printStackTrace();
		  }
	}
}