package com.sss;

import java.io.IOException;

public class Generate2 {

	public static void main(String[] args) throws IOException {
		
		
		 System.out.println("Reading http method");
	      
	     ReadProp rp = new ReadProp();
	     String httpMethod = rp.getProps("Httpcall");
	     String reqParams = rp.getProps("RequestParams");
	     String pathVars = rp.getProps("PathVar");
	     String reqBody = null;
	     GetTemplate gt  = new GetTemplate();
	          	  
	     if(httpMethod.equalsIgnoreCase("POST")){
	    		  reqBody = rp.getProps("RequestBody");
	    		  
	      }
	    	  
    	  if((reqParams != null) && (pathVars != null))
    		  gt.getTemp(httpMethod,reqBody, rp.getProps("comment"), rp.getProps("path"), rp.getProps("returnType"),
    				  rp.getProps("methodName"), reqParams.split(","), pathVars.split(","));
		  else if((reqParams == null) && (pathVars != null)){
			  gt.getTemp(httpMethod,reqBody, rp.getProps("comment"), rp.getProps("path"), rp.getProps("returnType"),
    				  rp.getProps("methodName"), null, pathVars.split(","));
		  }
		  else if((reqParams == null) && (pathVars == null)){
			  gt.getTemp(httpMethod,reqBody, rp.getProps("comment"), rp.getProps("path"), rp.getProps("returnType"),
    				  rp.getProps("methodName"), null, null);
		  }
 		  
		
	    }
		


}	
	

