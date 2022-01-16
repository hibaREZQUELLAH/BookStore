package webcatalog.eilco.servlet;

import java.io.IOException;
import java.util.Hashtable;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import webcatalog.eilco.beanuser.UserBeanRemote;
import webcatalog.eilco.models.Client;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("pages/login.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Client c = new Client();
		
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		
		
		try {
			  final Hashtable jndiProperties = new Hashtable();
			  jndiProperties.put(Context.URL_PKG_PREFIXES, "org.jboss.ejb.client.naming");
			  final Context context = new InitialContext(jndiProperties); 
			  final String appName = "WebCatalogEAR"; 
			  final String moduleName = "WebCatalogEJB"; 
			  final String beanName = "userBean"; 
			  final String viewClassName = UserBeanRemote.class.getName()+"?stateful"; 
			  UserBeanRemote remote = (UserBeanRemote)context.lookup("ejb:"+appName+"/"+moduleName+"/"+beanName+"!"+viewClassName); 
			  c = remote.login(email,password);
			  String destPage = "/pages/login.jsp";
			  
			  if(c != null) {
				  HttpSession session = request.getSession();
				  session.setAttribute("client", c);
				  destPage = "/pages/compte.jsp";
			  }
			  else {
				  String message = "Invalid email/password";
				  request.setAttribute("message", message);
			  }
			  
			  RequestDispatcher dispatcher = request.getRequestDispatcher(destPage);
	          dispatcher.forward(request, response);
		}
		
		catch (Exception e) { 
			 e.printStackTrace(); 
		}
		
	}

}
