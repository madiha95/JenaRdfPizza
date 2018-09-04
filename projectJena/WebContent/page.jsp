<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<style>
	#un, #deux, #trois, #quatre {
				width:600px;
				height:600px;
				float:right;
			}
			#un {background-color:red;}
			#deux {background-color:green;}
			#trois {background-color:yellow;}
			#quatre {background-color:white;}
			#parent {
				width:1200px;
				height:1200px;
				margin:auto;
			}
		#p
			{
			  font-size: 48px;
			  text-shadow: -1px -1px #f00, 1px 1px #a00, -3px 0 4px #000;
			  font-family:"Segoe print", Arial, Helvetica, sans-serif;
			  color: #dd0000;
			  padding:64px 0 0 0;
			  margin:16px auto;
			  font-weight:lighter;
			  -moz-box-shadow:none;  
			  -webkit-box-shadow: none;  
			  box-shadow:none;  
			  text-align:center;
			  display:block;
			  min-height:172px;
			  min-width:800;
			  max-height:172px;
			  max-width:800px;  
			  
			}

</style>
</head>
<body>
<p id="p">Statistiques de l'ontologie Pizza.owl.xml:</p>
<%
int classes = (int) request.getAttribute("classes");
int individuals = (int) request.getAttribute("individuals");
//getSubClass
int nbr_instance=(int) request.getAttribute("instances");
int nbreclasses=(int) request.getAttribute("nbreclasses");
int nmbresubclasses=(int) request.getAttribute("nmbresubclasses");
//Object_Propreties
int FunctionalProperty=(int) request.getAttribute("FunctionalProperty");
int TransitiveProperty=(int) request.getAttribute("TransitiveProperty");
int InverseFunctionalProperty=(int) request.getAttribute("InverseFunctionalProperty");
int SymmetricProperty=(int) request.getAttribute("SymmetricProperty");
int AssertedObject=(int) request.getAttribute("AssertedObject");
int SubObjects=(int) request.getAttribute("SubObjects");

int otherObject=(int) request.getAttribute("otherObject");
////Data_Propreties
int FunctionalDataProperty=(int) request.getAttribute("FunctionalDataProperty");
int TransitiveDataProperty=(int) request.getAttribute("TransitiveDataProperty");
int InverseFunctionalDataProperty=(int) request.getAttribute("InverseFunctionalDataProperty");
int SymmetricDataProperty=(int) request.getAttribute("SymmetricDataProperty");
int AssertedData=(int) request.getAttribute("AssertedData");
int SubData=(int) request.getAttribute("SubData");
int otherData=(int) request.getAttribute("otherData");
%>
<div id="parent">
<div id="un">
<ul>
<li>Nombres des classes :</li>
<li>
<ul>
<li>Le nombre de classe: <%= nbreclasses %></li>
<li>Le nombre d'individu: <%= individuals %></li>
<li>Le nombre de cas d'héritage: <%= nmbresubclasses%></li>
<li>Le nombre d'instance :<%= nbr_instance %></li>
</ul>
</li>
</ul>
</div>
<div id="deux">
<ul>
<li>Nombre d’Object Properties:</li>
<li>
<ul>
<li>Le nombre des fonctions proprety <%= FunctionalProperty %></li>
<li>Le nombre des proprietes transitive <%= TransitiveProperty %></li>
<li>le nombre des  des fonctions inverse <%= InverseFunctionalProperty %></li>
<li>Le nombre des propieté symetriques<%= SymmetricProperty %></li>
<li>Le nombre des assertions pour les propriétés d'objets <%= AssertedObject%></li>
<li>Le nombre des cas d'heritage <%=SubObjects %></li>
</ul>
</li>
</ul>
</div>
<div id="trois">
<ul>
<li>Nombre de Data Type Properties</li>
<li>
<ul>

<li>Le nombre des proprites de type data</li>
<li>Le nombre des fonctions data proprety <%= FunctionalDataProperty %></li>
<li>Le nombre des proprietes data transitive<%= TransitiveDataProperty %></li>
<li>Le nombre des  des fonctions data inverse <%= InverseFunctionalDataProperty %></li>
<li>Le nombre des propieté data symétriques <%= SymmetricDataProperty %></li>
<li>Le nombre des assertions pour les propriétés d'objets <%= AssertedObject%></li>
<li>Le nombre des cas d'heritage <%=SubData %></li>

</ul>
</li>
</ul>
</div>
<div id="quatre">
<p>
<a href="graphe.jsp">Presentation de l'ontologie en graphe cliquez ici: </a>
</p>


</div>
</div>
</body>
</html>