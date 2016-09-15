import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import javax.net.ssl.*;
import java.io.IOException;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;

public class Teste 
{
	final static String requestUrl = "https://www.sipac.ufs.br/public/jsp/restaurante/form_saldo_resun.jsf";
	    
	public static void enableSSLSocket() throws KeyManagementException, NoSuchAlgorithmException 
	{
        HttpsURLConnection.setDefaultHostnameVerifier(new HostnameVerifier() 
        {
            public boolean verify(String hostname, SSLSession session) 
            {
                return true;
            }
        });
 
        SSLContext context = SSLContext.getInstance("TLS");
        context.init(null, new X509TrustManager[]{new X509TrustManager() 
        {
            public void checkClientTrusted(X509Certificate[] chain, String authType) throws CertificateException {}
 
            public void checkServerTrusted(X509Certificate[] chain, String authType) throws CertificateException {}
 
            public X509Certificate[] getAcceptedIssuers() 
            {
                return new X509Certificate[0];
            }
        }}, new SecureRandom());
        HttpsURLConnection.setDefaultSSLSocketFactory(context.getSocketFactory());
	}
	
	
	
    public static void main(String[] args) throws KeyManagementException, NoSuchAlgorithmException, IOException  
    {
		        
    	enableSSLSocket();   
    	String matricula = "201220002117";
		        
		Document document = Jsoup.connect(requestUrl)
			.data("j_id_jsp_1140961090_1","j_id_jsp_1140961090_1")
			.data("j_id_jsp_1140961090_1:informativo", matricula)
			.data("j_id_jsp_1140961090_1:j_id_jsp_1140961090_4","Consultar")
			.data("javax.faces.ViewState","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")
		    .post();
		
		Elements trs = document.select("table.formulario tr");
		String almoco = trs.get(2).select("td").last().text();
		String janta = trs.get(3).select("td").last().text();
		System.out.println("Almoco: "+almoco+" Janta: "+janta);
    }
}
 

