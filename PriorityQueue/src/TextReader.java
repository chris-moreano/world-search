

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class TextReader {

	public ArrayList<Integer> numeros = new ArrayList<Integer>(); 	// STORE NUMBERS FROM FILES HERE
	
	public TextReader (String filename)
	{
		File f = new File(filename);
		
		try(BufferedReader reader = new BufferedReader(new FileReader(f));)
		{
			String line = reader.readLine();		// READ WHOLE LINE
			String [] temp = line.split("\\s+");	// SPLIT STRING INTO SUBSTRINGS INTO AN ARRAY
			
			for(int i = 0; i < temp.length;i++)
			{
				// USE REGULAR EXPRESSION TO CHECK FOR INTEGER
				// IF FOUND , ADD TO ARRAYLIST
				if(temp[i].matches("-?\\d+"))
				{
					numeros.add(Integer.parseInt(temp[i]));
				}	
				else{
					System.out.println("Non-Integer Found @ index " + i);
				}
			}
			
			// ITERATE THROUGH ARRAYLIST
			 /// for ( int nm : numeros ) 
			    //  System.out.println( nm );
					
		}
		
		catch (IOException e)
		{
			e.printStackTrace();
		}
	}
}
