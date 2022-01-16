package webcatalog.eilco.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Hashtable;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import webcatalog.eilco.beancatalog.accesCatalogueBeanRemote;
import webcatalog.eilco.models.Categorie;

/**
 * Servlet implementation class CategorieServlet
 */
@WebServlet("/categories")
public class CategorieServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public CategorieServlet() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ArrayList<Categorie> categories = new ArrayList();
		
		try {
			final Hashtable jndiProperties = new Hashtable();
			jndiProperties.put(Context.URL_PKG_PREFIXES, "org.jboss.ejb.client.naming");
			final Context context = new InitialContext(jndiProperties);
			final String appName = "WebCatalogEAR";
			final String moduleName = "WebCatalogEJB";
			final String beanName = "accessCatalog";
			final String viewClassName = accesCatalogueBeanRemote.class.getName();
			accesCatalogueBeanRemote remote = (accesCatalogueBeanRemote)context.lookup("ejb:"+appName+"/"+moduleName+"/"+beanName+"!"+viewClassName);
			categories = remote.getListCategories();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		request.setAttribute("categories",categories);
		RequestDispatcher dispatcher = request.getRequestDispatcher("pages/categories.jsp");
		dispatcher.forward(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
