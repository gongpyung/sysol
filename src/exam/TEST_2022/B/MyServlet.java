package exam.TEST_2022.B;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Enumeration;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.eclipse.jetty.client.HttpClient;
import org.eclipse.jetty.client.api.ContentResponse;
import org.eclipse.jetty.http.HttpMethod;

import com.google.gson.Gson;

import exam.spUtil;

public class MyServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) {
		System.out.println("--------------------------------------------------");
		int serverPort = req.getLocalPort();
		
		System.out.println("[GET] [ req.getRequestURL() : " + req.getRequestURL() + " ]");
		// Path Parsing 贸府
		String path = req.getServletPath().substring(1);
		String[] pathArr = path.split("/");
		String cmd = pathArr[0];
		
		// URL Query Param
		for (String key : req.getParameterMap().keySet()) {
			System.out.println("[GET] [ req.getParameter(" + key + ") : " + req.getParameter(key) + " ]");
		}
		
		// Header
		Enumeration<String> headerNames = req.getHeaderNames();
		while (headerNames.hasMoreElements()) {
			String headerName = headerNames.nextElement();
			System.out.println(headerName + " : " + req.getHeader(headerName));
		}
		System.out.println("--------------------------------------------------");
		
	}
	
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		System.out.println("--------------------------------------------------");
		int serverPort = req.getLocalPort();
		
		System.out.println("[GET] [ req.getRequestURL() : " + req.getRequestURL() + " ]");
		// Path Parsing 贸府
		String path = req.getServletPath().substring(1);
		String[] pathArr = path.split("/");
		String cmd = pathArr[0];
		
		// URL Query Param
		for (String key : req.getParameterMap().keySet()) {
			System.out.println("[GET] [ req.getParameter(" + key + ") : " + req.getParameter(key) + " ]");
		}
		
		// Header
		Enumeration<String> headerNames = req.getHeaderNames();
		while (headerNames.hasMoreElements()) {
			String headerName = headerNames.nextElement();
			System.out.println(headerName + " : " + req.getHeader(headerName));
		}
		System.out.println("--------------------------------------------------");
		
	}
	
	
	// 览翠 json 基敲
	public static void writeRes(HttpServletResponse res, Map<String, Object> resMap) throws IOException {
		Gson gson = new Gson();
		res.getWriter().write(gson.toJson(resMap));
		res.getWriter().flush();
	}
	
	public String jsonParamToString(HttpServletRequest req) throws IOException {
		BufferedReader input = new BufferedReader(new InputStreamReader(req.getInputStream()));
		StringBuffer sb = new StringBuffer();
		String buffer;
		while ((buffer = input.readLine()) != null) {
			sb.append(buffer.trim());
		}
		input.close();
		return sb.toString();
	}
	
	// http client request 基敲
	public static void httpClientSend() {
		String uuid = UUID.randomUUID().toString();
		HttpClient httpClient = new HttpClient();
		try {
			httpClient.start();
			ContentResponse contentRes = httpClient.newRequest("http://127.0.0.1:8090/GETHEADER").method(HttpMethod.GET).header("trace", uuid).send();
			System.out.println("contentRes.getHeaders() : " + contentRes.getHeaders());
			httpClient.stop();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
