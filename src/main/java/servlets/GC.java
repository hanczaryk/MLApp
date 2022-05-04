package servlets;

import java.io.IOException;
import java.nio.charset.Charset;
import java.sql.*;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

@WebServlet("/GC")
public class GC extends HttpServlet {
	private static String componentName = "servlets";
	private static Logger logger = Logger.getLogger(componentName);
	private static String className = GC.class.getName();

	private static final long serialVersionUID = 1L;
	DataSource ds = null;
	Connection conn = null;
	
	public GC() {
		super();
	}

	public void init() throws ServletException {
		
	}
	
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		        String tempS="";
				response.setContentType("text/html");
			      
			    tempS = tempS + "<html><body><center><h1>GC</h1></center><hr></body></html>";
                System.gc();
                Runtime.getRuntime().gc();
                
			    try {
				        response.getOutputStream().write(tempS.getBytes(Charset.forName("UTF-8")));
				} catch (Exception e) {
					response.getOutputStream().print(
							"Something went wrong! : " + e.getMessage());
					return;
				}		      		      
	}

	public void destroy() {	

	}
}
