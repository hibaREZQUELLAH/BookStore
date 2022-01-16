package webcatalog.eilco.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Hashtable;

import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonArrayBuilder;
import javax.json.JsonObjectBuilder;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import webcatalog.eilco.beancatalog.accesCatalogueBeanRemote;
import webcatalog.eilco.models.Produit;

/**
 * Servlet implementation class ProduitServlet
 */
@WebServlet("/produits/*")
public class ProduitServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProduitServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ArrayList<Produit> produits = new ArrayList();
		
		try {
			final Hashtable jndiProperties = new Hashtable();
			jndiProperties.put(Context.URL_PKG_PREFIXES, "org.jboss.ejb.client.naming");
			final Context context = new InitialContext(jndiProperties);
			final String appName = "WebCatalogEAR";
			final String moduleName = "WebCatalogEJB";
			final String beanName = "accessCatalog";
			final String viewClassName = accesCatalogueBeanRemote.class.getName();
			accesCatalogueBeanRemote remote = (accesCatalogueBeanRemote)context.lookup("ejb:"+appName+"/"+moduleName+"/"+beanName+"!"+viewClassName);
			String pathInfo = request.getPathInfo();
			int id = Integer.valueOf(pathInfo.substring(1));
			produits = remote.getListProduits(id);
			JsonArrayBuilder kvArrBld = Json.createArrayBuilder();
			JsonObjectBuilder jsonBuilder = Json.createObjectBuilder();
			for (Produit produit : produits) {
				jsonBuilder.add("id", produit.getId());
				jsonBuilder.add("nom", produit.getNom());
				jsonBuilder.add("description", produit.getDescription());
				jsonBuilder.add("prix", produit.getPrix());
				jsonBuilder.add("categorie", produit.getCategorie().getNom());
				kvArrBld.add(jsonBuilder);
			}
			
			JsonArray contactsArr = kvArrBld.build();
			
			response.getWriter().println(contactsArr);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
