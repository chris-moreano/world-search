

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
	            	line = line.replaceAll("[^a-zA-Z0-9]"," ");
	                String[] components = line.split(" ");
	                
	              
	                if(components[0].equals("insert"))
	                {
	                    script.add(new Commands(components[0], Integer.parseInt(components[1]), 0));

	                }
	                
	                
	                else if(components[0].equals("deleteMin"))
	                {
	                    script.add(new Commands(components[0], Integer.parseInt(components[1]), Integer.parseInt(components[2])));

	                }
	                
	                
	               
	                else if(components[0].equals("decreaseKey"))
	                {
	                    script.add(new Commands(components[0], Integer.parseInt(components[1]),Integer.parseInt(components[2])));

	                }
	                
	                        
	                else if(components[0].equals("increase"))
	                {
	                    script.add(new Commands(components[0], Integer.parseInt(components[1]),Integer.parseInt(components[2])));

	                }
	                
	                
	                
	                else if(components[0].equals("delete"))
	                {
	                    script.add(new Commands(components[0], Integer.parseInt(components[1]), 0));

	                }
	                
	                else
	                	System.out.println("Unknown Command");
	                
	            }		
		}
		
		catch (IOException e)
		{
			e.printStackTrace();
		}
	}	
}
