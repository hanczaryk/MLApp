package servlets;

import java.io.IOException;
import java.net.InetAddress;
import java.nio.charset.Charset;
import java.util.Vector;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/MLVectorParam")
public class MLVectorParam extends HttpServlet {
	private Vector v = new Vector();
	private AtomicInteger vacounter = new AtomicInteger();

	private static String componentName = "servlets";
	private static Logger logger = Logger.getLogger(componentName);
	private static String className = MLVectorParam.class.getName();
	private static final long serialVersionUID = 1L;

	public MLVectorParam() {
		super();
	}

	public void init() throws ServletException {
		
	}
	
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		    String myaction = request.getParameter("myaction");
			String str1 = InetAddress.getLocalHost().getHostName();
			String ses1 = request.getSession().getId();
		    String tempS = "";
            
		    int vvalue = 0;            
		    vvalue = vacounter.addAndGet(1);

		    String methodName = "doGet"; logger.logp(Level.FINE, className, methodName,"doGet "+ses1+" "+vvalue+" myaction="+myaction);

		    if (myaction.equals("add")) {
		     //Add 1MB to Vector
		     byte b[] = new byte[1048576];
		     v.add(b);
		     logger.logp(Level.FINE, className, methodName,"added 1MB to vector");
		    } else if (myaction.equals("removeLast")) {
			 //Remove 1MB element from Vector
			 v.remove(v.size()-1);	
			 logger.logp(Level.FINE, className, methodName,"removed 1MB element from vector");
		    } else if (myaction.equals("removeAll")) {
			 //Remove all elements from Vector
			 v.removeAllElements();		 
			 logger.logp(Level.FINE, className, methodName,"removed all elements from vector");
		    }

		     
			response.setContentType("text/html");

			tempS = tempS + "<html><body><center><h1>MLVector</h1></center><hr>";
			tempS = tempS + v.size();
			tempS = tempS + "<hr><center>"+str1+"  "+ses1+"  "+"</center><hr></body></html>";

			try {
				response.getOutputStream().write(tempS.getBytes(Charset.forName("UTF-8")));
			} catch (Exception e) {
				response.getOutputStream().print("Something went wrong! : " + e.getMessage());
				return;
			}		      
			      
	}

	public void destroy() {	

	}
	
}
