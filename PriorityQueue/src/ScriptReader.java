

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
	                String[] components = line.split(" ");
	                
	                if(components[0].equals("insert"))
	                {
	                    script.add(new Commands(components[0], Integer.parseInt(components[1]), 0));

	                }
	                
	                /*
	                if(components[0].equals("decrease"))
	                {
	                    script.add(new Commands(components[0], Integer.parseInt(components[1]), 0));

	                }
	                */
	            }		
		}
		
		catch (IOException e)
		{
			e.printStackTrace();
		}
	}	
}
