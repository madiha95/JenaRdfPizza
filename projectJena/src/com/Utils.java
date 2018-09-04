package com;

import java.io.FileNotFoundException;

import org.apache.jena.ontology.OntModel;
import org.apache.jena.sparql.pfunction.library.str;
import org.eclipse.jdt.internal.compiler.ast.ThisReference;


public class Utils {
	
	
	public static final String NBR_INSTANCE = "nombre instance";
	public static final String NBR_CLASS = "nombre class";
	public static final String NBR_SUB_CLASS = "nombre sub class";
	
	public static final String ObjectProperty = "ObjectProperty";
	public static final String DatatypeProperty = "DatatypeProperty";
	
	public static final String SymmetricProperty = "SymmetricProperty";
	public static final String TransitiveProperty = "TransitiveProperty";
	public static final String FunctionalProperty = "FunctionalProperty";
	public static final String InverseFunctionalProperty = "InverseFunctionalProperty";
	public static final String AssertedObject="AssertionDobject";
	public static final String SubObjects="HeritageDObject";
	
	public static final String SymmetricDataProperty = "SymmetricDataProperty";
	public static final String TransitiveDataProperty = "TransitiveDataProperty";
	public static final String FunctionalDataProperty = "FunctionalDataProperty";
	public static final String InverseFunctionalDataProperty = "InverseFunctionalDataProperty";
	public static final String AssertedData="AssertionData";
	public static final String SubData="HeritageData";
	
}
