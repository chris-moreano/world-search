

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class ScriptReader {


	public ArrayList<Commands> script = new ArrayList<Commands>(); 	// STORE NUMBERS FROM FILES HERE
	
	public ScriptReader (String filename)
	{
		File f = new File(filename);
		
		try(BufferedReader reader = new BufferedReader(new FileReader(f));)
		{
			
	           String line = null;
	           
	            while ((line = reader.readLine()) != null) 
	            {
	            	// Strip everything thats not a char or number
	            	// i.e... ( , ) 
	            	line = line.replaceAll("[^a-zA-Z0-9]"," ");
	                String[] components = line.split(" ");
	                
	              
	                if(components[0].equals("insert"))
	                {
	                    script.add(new Commands(components[0],components[1]));
	                }
	                
	                 if(components[0].equals("decreaseKey"))
	                {
	                    script.add(new Commands(components[0], components[1],components[2]));

	                }
	                 
	                  if(components[0].equals("increaseKey"))
		                {
		                    script.add(new Commands(components[0],components[1],components[2]));

		                }
	                
	                 if(components[0].equals("deleteMin"))
	                {
	                    script.add(new Commands(components[0]));
	                }
	                
	              
	                 if(components[0].equals("delete"))
	                {
	                    script.add(new Commands(components[0], components[1]));
	                }
	               
	                
	            }		
		}
		
		catch (IOException e)
		{
			e.printStackTrace();
		}
		

	}

	 public static boolean isNumeric(String s) 
	 	{  
		 	if(true == s.matches("\\d+"))
		 		return true; 
		 	else
		 		System.out.println(s + " is not a number");
		 		return false;
	    }  

		
}
