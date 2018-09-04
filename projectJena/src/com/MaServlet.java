package com;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.io.InputStream;
//import java.lang.*;




import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.Part;





/**
 * Servlet implementation class index
 */
@WebServlet("/MaServlet")
public class MaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MaServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		ServletContext context = this.getServletContext();
		String fullPath = context.getRealPath("/WEB-INF/pizza.owl.xml");
		MaClasse.load(fullPath);

	    PrintWriter out = response.getWriter();
	    
	   /* out.println("<ul>");
	    out.println("<li> Nombre de class :"+MaClasse.getAllClass().size()+"</li>");
	    out.println("<li> Nombre d'indivual :"+MaClasse.listIndividuals().size()+"</li>");
	    // getSubClass
	    out.println("<li> Nombre cas héritage :"+ MaClasse.getSubClass().get(Utils.NBR_INSTANCE)+"</li>");
	    out.println("<li> Nombre cas héritage :"+ MaClasse.getSubClass().get(Utils.NBR_CLASS)+"</li>");
	    out.println("<li> Nombre cas héritage :"+ MaClasse.getSubClass().get(Utils.NBR_SUB_CLASS)+"</li>");
	    
	    //getNbrPropreties
	    out.println("<li> data type  propreite :"+  MaClasse.getNbrProperties().get(Utils.DatatypeProperty)+"</li>");
	    out.println("<li> Nombre de propreite :"+  MaClasse.getNbrProperties().get(Utils.ObjectProperty)+"</li>");
	    out.println("<li> Nombre de propreite :"+  MaClasse.getNbrProperties().get(Utils.FunctionalProperty)+"</li>");
	    out.println("<li> data type  propreite :"+  MaClasse.getNbrProperties().get(Utils.TransitiveProperty)+"</li>");
	    out.println("<li> data type  propreite :"+  MaClasse.getNbrProperties().get(Utils.InverseFunctionalProperty)+"</li>");
	    out.println("<li> data type  propreite :"+  MaClasse.getNbrProperties().get(Utils.SymmetricProperty)+"</li>"); 
	    out.println("<li> data type  propreite :"+  MaClasse.getNbrProperties().get("other")+"</li>");
	    //
	    out.println("</ul>");*/
	    /**  collaboration entre servelet et jsp **/
	    //  getAllClass
	    request.setAttribute("classes", MaClasse.getAllClass().size());
	    // ListIndividuals
	    request.setAttribute("individuals",MaClasse.listIndividuals().size());
	    //getSubClass 
	    request.setAttribute("instances",MaClasse.getSubClass().get(Utils.NBR_INSTANCE));
	    request.setAttribute("nbreclasses",MaClasse.getSubClass().get(Utils.NBR_CLASS));
	    request.setAttribute("nmbresubclasses",MaClasse.getSubClass().get(Utils.NBR_SUB_CLASS));
	    //getNbrPropreties
	    //request.setAttribute("DatatypeProperty", MaClasse.getNbrProperties().get(Utils.DatatypeProperty));
	    //request.setAttribute("ObjectProperty", MaClasse.getNbrProperties().get(Utils.ObjectProperty));
	    request.setAttribute("FunctionalProperty", MaClasse.getNbrProperties().get(Utils.FunctionalProperty));
	    request.setAttribute("TransitiveProperty", MaClasse.getNbrProperties().get(Utils.TransitiveProperty));
	    request.setAttribute("InverseFunctionalProperty", MaClasse.getNbrProperties().get(Utils.InverseFunctionalProperty));
	    request.setAttribute("SymmetricProperty", MaClasse.getNbrProperties().get(Utils.SymmetricProperty));
	    request.setAttribute("AssertedObject", MaClasse.getNbrProperties().get(Utils.AssertedObject));
	    request.setAttribute("SubData", MaClasse.getNbrProperties().get(Utils.SubData));
	    request.setAttribute("otherObject", MaClasse.getNbrProperties().get("otherObject")); 
	    
	    /////////////////////
	    request.setAttribute("FunctionalDataProperty", MaClasse.getNbrProperties().get(Utils.FunctionalDataProperty));
	    request.setAttribute("TransitiveDataProperty", MaClasse.getNbrProperties().get(Utils.TransitiveDataProperty));
	    request.setAttribute("InverseFunctionalDataProperty", MaClasse.getNbrProperties().get(Utils.InverseFunctionalDataProperty));
	    request.setAttribute("SymmetricDataProperty", MaClasse.getNbrProperties().get(Utils.SymmetricDataProperty));
	    request.setAttribute("AssertedData", MaClasse.getNbrProperties().get(Utils.AssertedData));
	    request.setAttribute("SubObjects", MaClasse.getNbrProperties().get(Utils.SubObjects));
	    request.setAttribute("otherData", MaClasse.getNbrProperties().get("otherData")); 
	    ///////////////////////////////////////////////
	    
	    
	    request.getRequestDispatcher("page.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	
	
	
}
