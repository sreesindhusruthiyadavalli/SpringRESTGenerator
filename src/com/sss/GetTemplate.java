package com.sss;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class GetTemplate {
	
	public void getTemp(String httpMethod, String reqBody, String comment, String path, String returnType, String methodName, String[] params,
			String[] pathvars) throws IOException{
		
		
		String file_name = "GETtemplate.txt";
		BufferedReader br = new BufferedReader(new FileReader(file_name));
		BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("getouput.txt"));
		String st;
		while((st = br.readLine()) != null){
			if(httpMethod.equalsIgnoreCase("POST")){
				if(st.indexOf("RequestMethod.GET") != 1){
					st = st.replace("RequestMethod.GET", "RequestMethod.POST");
				}
				
				if(st.indexOf("reqbody") != -1){
					st = st.replace("reqbody", reqBody);
				}
			}
			else if(httpMethod.equalsIgnoreCase("GET")){
				if(st.indexOf("reqbody") != -1){
					st = st.replaceAll(".*$", "");
				} 
			}
			
			
			if(st.indexOf("comment") != -1){
				st= st.replace("comment", comment);
				
			}
			if(st.indexOf("path") != -1){
				st = st.replace("path", path);
			}
			
			if(st.indexOf("returnType") != -1){
				st = st.replace("returnType", returnType);
			}
			
			if(st.indexOf("methodName") != -1){
				st = st.replace("methodName", methodName);
			}
			
			if(st.indexOf("param") != -1){
				if(params != null){
				String l = "";
				for(int k= 0 ; k < params.length; k++){
					l = l + st;
					l = l.replace("param", params[k])  + ",";
					
				}
				
				st = l.substring(0,l.lastIndexOf(","));	
				}
				else{
					st = st.replaceAll(".*$", "");
				}
				
			}
			
			if(st.indexOf("Pathvar") != -1){
				if(pathvars != null){
				String l = "";
				for(int k= 0 ; k < pathvars.length; k++){
					l = l + st;
					l = l.replace("Pathvar", pathvars[k])  + ",";
					
				}
				
				st = l.substring(0,l.lastIndexOf(","));	
				}
				else{
					st = st.replaceAll(".*$", "");
				}
				
			}
	          
			if(!st.equalsIgnoreCase("")){
				bufferedWriter.write(st.trim());
				bufferedWriter.newLine();
			}
		}	
		br.close();
		bufferedWriter.close();
		
		
	}

}
