package com;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import javax.websocket.OnClose;

import org.apache.jena.ontology.DatatypeProperty;
import org.apache.jena.ontology.Individual;
import org.apache.jena.ontology.ObjectProperty;
import org.apache.jena.ontology.OntClass;
import org.apache.jena.ontology.OntModel;
import org.apache.jena.ontology.OntModelSpec;
import org.apache.jena.ontology.OntProperty;
import org.apache.jena.rdf.model.ModelFactory;
import org.apache.jena.rdf.model.Resource;
import org.apache.jena.util.FileManager;
import org.apache.jena.vocabulary.OWL;
import org.apache.jena.vocabulary.OWL2;

import com.Utils;
import com.sun.javafx.collections.MappingChange.Map;
public class MaClasse {

    public static OntModel model;
    

    public static void load(String ontologyInFile) throws FileNotFoundException {

         model = ModelFactory.createOntologyModel(OntModelSpec.OWL_DL_MEM,null); 
        model.read(new FileInputStream(ontologyInFile), null); 
        
    }
    
    
    // function  return all class from owl file
    public static List<String> getAllClass(){
    List<String>  list = new ArrayList<>();
    if (model != null) {
		Iterator<?> iterator = model.listClasses();
		while (iterator.hasNext()) {
			OntClass ontClass = (OntClass) iterator.next();
			if (ontClass.getURI() != null) {
				list.add(ontClass.getURI().toString());
			}
			
		}
	}
    	return list;
    }
    
    // function return number of subClass & list instance
    public static HashMap<String, Integer> getSubClass(){
    	int nbrSubClass = 0;
    	int nbrInstance = 0;
    	int nbrclass = 0;
    	HashMap<String, Integer> map = new HashMap<>();
    	
        if (model != null) {
    		Iterator<?> iterator = model.listClasses();
    		while (iterator.hasNext()) {
    			OntClass ontClass = (OntClass) iterator.next();
    			if (ontClass.getURI() != null) {
        			nbrclass++;
    			}
    			Iterator <?>instances = ontClass.listInstances(); 
    			while (instances.hasNext()) {
					if (instances.next() != null) {
						nbrInstance++;
					}
				}
    			
					Iterator <?> ListsubClass = ontClass.listSubClasses();
					while (ListsubClass.hasNext()) {
						OntClass oc  = (OntClass) ListsubClass.next();
						nbrSubClass++;
					}
				
    	
    		}
    		map.put(Utils.NBR_INSTANCE, nbrInstance);
    		map.put(Utils.NBR_CLASS, nbrclass);
    		map.put(Utils.NBR_SUB_CLASS, nbrSubClass);
    		
    	}
    	
    	return map;
	    /**List<String> = new ArrayList<Map<String, Integer>>();
	    while (request.next())
	    {
	        Map<String, String> verify = new HashMap<String, String>();
	        verify.put("beneficiaryID",request.getInteger("nbrSubClass"));
	        verify.put("scheme", request.getInteger("nbrInstance"));
	        verify.put("aadhaar",request.getInteger("nbrclass"));
	       
	        results.add(verify);
	    }
	     request.setAttribute("verify", results);
	     **/
    	
    }
    /**
    
    public static String getClassHirarchy(String uriClass){
    	String str = "";
    	if (uriClass != null) {
			OntClass ontClass = model.getOntClass(uriClass);
			if (ontClass.getSuperClass() != null) {
				str = ontClass.getSuperClass().toString()+" \n";
			}
			if (ontClass.getSubClass() != null) {
				str += ontClass.getSubClass().toString();
			}
			

		}
    	return str;
    } **/
    
    //function_retrun_number_of_propreties_(dataType,object,.....)
    public static HashMap<String, Integer> getNbrProperties(){
    	 HashMap<String, Integer> map = new HashMap<>();

    	int symetricObjectPropreties = 0;
    	int functionalObjectPropreties = 0;
    	int transitiveObjectPropreties = 0;
    	int inversalObjectPropreties = 0;
    	int otherObjectpropreties = 0;
    	int countObject = 0;
    	int symetricDataPropreties=0;
    	int functionalDataPropreties=0;
    	int inversalDataPropreties=0;
    	int transitiveDataPropreties = 0;
    	int otherDataPropreties=0;
    	int assero=0;
    	int asserd=0;
    	int objsubpro=0;
    	int subprod=0;
    	int countData=0;
    	// count_of_object_propreties :
    	Iterator <?>listObjectProperties = model.listObjectProperties();
    	while (listObjectProperties.hasNext()) {
    		countObject ++;
			OntProperty ontProperty = (OntProperty) listObjectProperties.next();
			if (ontProperty.isSymmetricProperty()) {
				symetricObjectPropreties++;
			}else if (ontProperty.isFunctionalProperty()) {
				functionalObjectPropreties++;
			}else if (ontProperty.isTransitiveProperty()) {
				transitiveObjectPropreties++;
			}else if (ontProperty.isInverseFunctionalProperty()) {
				inversalObjectPropreties++;
			}else{
				otherObjectpropreties++;
			}
		}
    	//assertion d'objet 
		
			  Iterator<?> asseroprop = model.listObjectProperties();
			  while(asseroprop.hasNext()){
				 ObjectProperty asseropropr = (ObjectProperty)asseroprop.next();
				String opropertyName = asseropropr.getLocalName();
				if(asseropropr.getDomain()!=null && asseropropr.getRange()!=null) ++assero;
			  }			  
			  
    	// count_of_data_propreties :
    	
    	Iterator <?> listDataPropreties=model.listDatatypeProperties();
    	while(listDataPropreties.hasNext())
    	{	countData++;
    		DatatypeProperty DataOntProperty = (DatatypeProperty)listDataPropreties.next();
			if (DataOntProperty.isSymmetricProperty()) {
				symetricDataPropreties++;
			}else if (DataOntProperty.isFunctionalProperty()) {
				functionalDataPropreties++;
			}else if (DataOntProperty.isTransitiveProperty()) {
				transitiveDataPropreties++;
			}else if (DataOntProperty.isInverseFunctionalProperty()) {
				inversalDataPropreties++;
			}else{
				otherDataPropreties++;
    		
    	}}
    	//assertion Data
    	  Iterator<?> asserdprop = model.listDatatypeProperties();					  
		  while(asserdprop.hasNext()){
		    DatatypeProperty asserdpropr = (DatatypeProperty)asserdprop.next();
			String dpropertyName = asserdpropr.getLocalName();
			if(asserdpropr.getDomain()!=null && asserdpropr.getRange()!=null) ++asserd;
		  }
		  //
    	
    	//les_heritages 
    	// ObjectHéritages
    	ArrayList<String> list = new ArrayList<String>();
		  Iterator<?> prop1 = model.listObjectProperties();
		  while(prop1.hasNext()){
		  ObjectProperty propr1 = (ObjectProperty)prop1.next();
		  Iterator<?> get =  propr1.listSubProperties();
		  while(get.hasNext()){
			  OntProperty ontprop = (OntProperty)get.next();
			  String gets = ontprop.getLocalName();
			  list.add(gets);
		  }objsubpro = list.size();
		  }					  
		  
        
     // DataHéritages
		  ArrayList<String> dhlist = new ArrayList<String>();
		  Iterator<?> dhprop = model.listDatatypeProperties();
		  while(dhprop.hasNext()){
		  DatatypeProperty dhpropr = (DatatypeProperty)dhprop.next();
		  Iterator <?> dhget =  dhpropr.listSubProperties();					  
		  while(dhget.hasNext()){
			  OntProperty dhontprop = (OntProperty)dhget.next();
			  String dhgets = dhontprop.getLocalName();
			  dhlist.add(dhgets);
			  
		  } subprod = dhlist.size();
		  }
		  					
		  map.put("count", countData+countObject);
    	//Object_Propreties 
    	map.put(Utils.FunctionalProperty, functionalObjectPropreties);
    	map.put(Utils.TransitiveProperty, transitiveObjectPropreties);
    	map.put(Utils.InverseFunctionalProperty, inversalObjectPropreties);
    	map.put(Utils.SymmetricProperty, symetricObjectPropreties);
    	map.put(Utils.AssertedObject, assero);
    	map.put(Utils.SubData, subprod);
    	map.put("otherObject", otherObjectpropreties);
    	
    	//Data_Propreties 
    	map.put(Utils.SymmetricDataProperty, symetricDataPropreties);
    	map.put(Utils.FunctionalDataProperty, functionalDataPropreties);
    	map.put(Utils.TransitiveDataProperty,transitiveDataPropreties);
    	map.put(Utils.InverseFunctionalDataProperty, inversalDataPropreties);
    	map.put(Utils.AssertedData, asserd);
    	map.put(Utils.SubObjects, objsubpro);
    	map.put("otherData", otherDataPropreties);
    	
    	map.put(Utils.AssertedData,asserd);
    	return map;
    }

    
    
    public static List<String> listIndividuals(){
    	List<String> list = new ArrayList<>();
    	if(model != null){
    		Iterator <?> individuals = model.listIndividuals();
    		while (individuals.hasNext()) {
				Individual individual = (Individual) individuals.next();
				if (individual.getLocalName() != null) {
					list.add(individual.getLocalName().toString());
				}
				
			}
    	}
    	return list;
    }
    
//    public static void run(String ontologyInFile) {
//
//        model = ModelFactory.createOntologyModel(OntModelSpec.OWL_DL_MEM_RULE_INF, null);
//        InputStream ontologyIn = FileManager.get().open(ontologyInFile);
//
//        loadModel(model, ontologyIn);
//    }
//
//
//    /** 
//     * @param m
//     * @param ontologyIn */
//    protected static void loadModel(OntModel m, InputStream ontologyIn) {
//        try {
//             m.read(ontologyIn, "RDF/XML");
//        } catch (Exception e) {
//            System.out.println(e.getMessage());
//        }
//
//    }

}