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
 * Servlet implementation class UserServlet
 */
@WebServlet("/register")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String destination = "pages/inscription.jsp";
		request.getRequestDispatcher(destination).forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		Client c = new Client();
		
		String nom = request.getParameter("nom");
		String prenom = request.getParameter("prenom");
		String email = request.getParameter("email");
		String tele = request.getParameter("tel");
		String pays = request.getParameter("pays");
		String adresse = request.getParameter("adresse");
		String password = request.getParameter("password");		
		String fulladresse = adresse + "," + pays;
		
		
		 try { 
			  final Hashtable jndiProperties = new Hashtable();
			  jndiProperties.put(Context.URL_PKG_PREFIXES, "org.jboss.ejb.client.naming");
			  final Context context = new InitialContext(jndiProperties); 
			  final String appName = "WebCatalogEAR"; 
			  final String moduleName = "WebCatalogEJB"; 
			  final String beanName = "userBean"; 
			  final String viewClassName = UserBeanRemote.class.getName()+"?stateful"; 
			  UserBeanRemote remote = (UserBeanRemote)context.lookup("ejb:"+appName+"/"+moduleName+"/"+beanName+"!"+viewClassName); 
			  c = remote.register(nom, prenom, email, tele,fulladresse, password);
			  String destPage = "/pages/inscription.jsp";
			  
			  if(c == null) {
				  String message = "Email exist,veuillez essayer avec un autre!";
				  request.setAttribute("message", message);
			  }
			  else {
				  session.setAttribute("client",c);
				  destPage = "/pages/compte.jsp";
			  }
			  
			  RequestDispatcher dispatcher = request.getRequestDispatcher(destPage);
	          dispatcher.forward(request, response);
		  } 
		 catch (Exception e) { 
			 e.printStackTrace(); 
		 }
	}
}
