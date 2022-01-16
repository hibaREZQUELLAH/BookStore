package webcatalog.eilco.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Hashtable;
import java.util.List;
import java.util.Random;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


import webcatalog.eilco.beancommande.gestionCommandeBeanRemote;
import webcatalog.eilco.dto.PanierItem;
import webcatalog.eilco.models.Client;
import webcatalog.eilco.models.Commande;
import webcatalog.eilco.models.LigneCommande;

/**
 * Servlet implementation class CommandeServlet
 */
@WebServlet("/commande")
public class CommandeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CommandeServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		Client client = (Client) session.getAttribute("client");
	
		if(client != null) {
			try {
				final Hashtable jndiProperties = new Hashtable();
				jndiProperties.put(Context.URL_PKG_PREFIXES, "org.jboss.ejb.client.naming");
				final Context context = new InitialContext(jndiProperties);
				final String appName = "WebCatalogEAR";
				final String moduleName = "WebCatalogEJB";
				final String beanName = "beanCommande";
				final String viewClassName = gestionCommandeBeanRemote.class.getName()+"?stateful";
				gestionCommandeBeanRemote remote = (gestionCommandeBeanRemote)context.lookup("ejb:"+appName+"/"+moduleName+"/"+beanName+"!"+viewClassName);
				
				List<PanierItem> panier = (ArrayList<PanierItem>) session.getAttribute("cart");
				Commande commande = new Commande();
				int a = generateRandomIntIntRange(1,2000);
				commande.setNumero(a);
				commande.setDate_creation(new Date());
				commande.setClient(client);
				
				List<LigneCommande> lignesCommande = new ArrayList<>();
			
				if(!panier.isEmpty()) {
					for (PanierItem item : panier) {
						LigneCommande ligne = new LigneCommande();
			            ligne.setDesignation(item.getProduit().getNom());
			            ligne.setQuantite(item.getQuantite());
			            ligne.setPrix_unitaire(item.getProduit().getPrix());
			            ligne.setCommande(commande);
			            lignesCommande.add(ligne);
			        }
				}
				
				commande.setLignesCommande(lignesCommande);
				Commande c = remote.validerCommande(commande);
				session.setAttribute("commande", c);
				response.sendRedirect(request.getContextPath() + "/pages/commande.jsp");
				
				
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		else {
			response.sendRedirect("login");
		}
		
	}
	
	public static int generateRandomIntIntRange(int min, int max) {
	    Random r = new Random();
	    return r.nextInt((max - min) + 1) + min;
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
