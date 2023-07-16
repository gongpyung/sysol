package exam.TEST_2022.A;

import java.util.List;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.ServerConnector;
import org.eclipse.jetty.servlet.ServletHandler;

import exam.spUtil;

public class RunManager {

	public static Proxy proxyInfo;
	
	public static void main(String[] args) throws Exception {
		proxyInfo = spUtil.jsonFileToObject(args[0], Proxy.class);
		
		Server server = new Server();
		
		// connector
		ServerConnector http = new ServerConnector(server);
		http.setHost("127.0.0.1");
		http.setPort(proxyInfo.getPort());
		server.addConnector(http);
		
		// Handler
		ServletHandler servletHander = new ServletHandler();
		servletHander.addServletWithMapping(MyServlet.class, "/");
		server.setHandler(servletHander);
		
		server.start();
		server.join();

	}

}

class Proxy {
	int port;
	List<Route> routes;
	
	public int getPort() {
		return port;
	}
	public void setPort(int port) {
		this.port = port;
	}
	public List<Route> getRoutes() {
		return routes;
	}
	public void setRoutes(List<Route> routes) {
		this.routes = routes;
	}
}

class Route {
	String pathPrefix;
	String url;
	
	public String getPathPrefix() {
		return pathPrefix;
	}
	public void setPathPrefix(String pathPrefix) {
		this.pathPrefix = pathPrefix;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
}
