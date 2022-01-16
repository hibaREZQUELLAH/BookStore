package webcatalog.eilco.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import webcatalog.eilco.beancatalog.accesCatalogueBeanRemote;
import webcatalog.eilco.dto.PanierItem;

/**
 * Servlet implementation class PanierServlet
 */
@WebServlet("/panier")
public class PanierServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PanierServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String action = request.getParameter("action");
		if(action == null) {
			doGet_DisplayCart(request, response);
		}
		else {
			if(action.equalsIgnoreCase("buy")) {
				doGet_Buy(request, response);
			}
			else if(action.equalsIgnoreCase("remove")) {
				doGet_Remove(request,response);
			}
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	
	
	//display the cart page
	protected void doGet_DisplayCart(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getRequestDispatcher("pages/panier.jsp").forward(request, response);
	}
	
	
	// add the product to cart
	protected void doGet_Buy(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		
		
		try {
			final Hashtable jndiProperties = new Hashtable();
			jndiProperties.put(Context.URL_PKG_PREFIXES, "org.jboss.ejb.client.naming");
			final Context context = new InitialContext(jndiProperties);
			final String appName = "WebCatalogEAR";
			final String moduleName = "WebCatalogEJB";
			final String beanName = "accessCatalog";
			final String viewClassName = accesCatalogueBeanRemote.class.getName();
			accesCatalogueBeanRemote remote = (accesCatalogueBeanRemote)context.lookup("ejb:"+appName+"/"+moduleName+"/"+beanName+"!"+viewClassName);
			
			if (session.getAttribute("cart") == null) {
				List<PanierItem> cart = new ArrayList<PanierItem>();
				cart.add(new PanierItem(remote.find(Integer.valueOf(request.getParameter("id"))),1));
				session.setAttribute("cart", cart);
			} 
			else {
				List<PanierItem> cart = (List<PanierItem>) session.getAttribute("cart");
				int index = isExisting(Integer.valueOf(request.getParameter("id")), cart);
				if (index == -1) {
					cart.add(new PanierItem(remote.find(Integer.valueOf(request.getParameter("id"))),1));
				} else {
					int quantity = cart.get(index).getQuantite() + 1;
					cart.get(index).setQuantite(quantity);
				}
				session.setAttribute("cart", cart);
			}
			
			response.sendRedirect("panier");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	//remove the product from cart
	protected void doGet_Remove(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		List<PanierItem> cart = (List<PanierItem>) session.getAttribute("cart");
		int index = isExisting(Integer.valueOf(request.getParameter("id")), cart);
		cart.remove(index);
		session.setAttribute("cart", cart);
		response.sendRedirect(request.getContextPath() + "/pages/panier.jsp");
	}
	
	// check if product exist in the cart
	private int isExisting(int id, List<PanierItem> cart) {
		for (int i = 0; i < cart.size(); i++) {
			if(cart.get(i).getProduit().getId() == id) {
				return i;
			}
		}
		return -1;
	}

}
