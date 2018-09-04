<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<style>
img{ 
  background-color:#fafbfc; 
  border:1px solid #b0b0b0; 
  margin:0 0 10px 10px; 
  padding:5px; 
  height: 500px;
  width: 500px;
  
}


}
</style>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<p> <img src=<%=request.getContextPath() + "../grapheProtege.jpg"%> alt="img"/>

</p>
<p>Pour avoir le graphe en entier partez sur ce lien : </p>
<a href="http://visualdataweb.de/webvowl/#file=pizza.owl.xml">Graphe Entier </a>

</body>
</html>