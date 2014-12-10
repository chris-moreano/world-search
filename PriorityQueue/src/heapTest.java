
/**
 * 
 */
public class heapTest {
 
    /**
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Heap<Integer> hp = new Heap<Integer>();
		TextReader temp = new TextReader("input.txt");
		ScriptReader temp2 = new ScriptReader("script.txt");

		// FETCH NUMBERS FROM input.txt
		for( int i = 0 ; i < temp.numeros.size();i++)
		{
			hp.insert(temp.numeros.get(i));
		}
		
		System.out.println(hp);

		//System.out.println(temp2.script.size());
		for( int i = 0; i < temp2.script.size(); i++)
		{
			int node,delta;
			
			System.out.println( i + " " + temp2.script.get(i).getParam() + " " + temp2.script.get(i).getParamTwo());
		// FETCH INSTRUCTIONS FROM script.txt
			if((temp2.script.get(i).getCMD()).equals("insert"))
			{
				if(isNumeric(temp2.script.get(i).getParam()))
				{
					hp.insert( Integer.parseInt(temp2.script.get(i).getParam()));
					System.out.println(hp);

				}
				
				//else
				//	System.out.println(temp2.script.get(i).getParam() + " is not an integer");
					
			}
			

			if((temp2.script.get(i).getCMD()).equals("decreaseKey"))
			{
				if(isNumeric(temp2.script.get(i).getParam()) && isNumeric(temp2.script.get(i).getParamTwo()))
				{
					node = Integer.parseInt(temp2.script.get(i).getParam());
					delta = Integer.parseInt(temp2.script.get(i).getParamTwo());
					hp.decreaseKey(node, delta);
					System.out.println(hp);

				}
			}
			
			
			
			if((temp2.script.get(i).getCMD()).equals("increaseKey"))
			{
				if(isNumeric(temp2.script.get(i).getParam()) && isNumeric(temp2.script.get(i).getParamTwo()))
				{
					node = Integer.parseInt(temp2.script.get(i).getParam());
					delta = Integer.parseInt(temp2.script.get(i).getParamTwo());
					hp.increaseKey(node, delta);
					System.out.println(hp);
				}
			}
			
			if((temp2.script.get(i).getCMD()).equals("deleteMin"))
			{
				hp.deleteMin();
				System.out.println(hp);

			}

			if((temp2.script.get(i).getCMD()).equals("delete"))
			{
				if(isNumeric(temp2.script.get(i).getParam()))
				{
					node = Integer.parseInt(temp2.script.get(i).getParam());
					hp.delete(node);
					System.out.println(hp);

				}
				
				//else
				//	System.out.println(temp2.script.get(i).getParam() + " is not an integer");
					
			}			
			//System.out.println(hp);

		}
		//System.out.println(hp);

		/*
		System.out.println("Build Heap");
		System.out.println(hp);

		System.out.println("Inserting 130");
		hp.insert(130);
		System.out.println(hp);

		System.out.println("DecreaseKey(12,1)");
		hp.decreaseKey(12,1);
		System.out.println(hp);
		
		System.out.println("IncreaseKey(12,1");
		hp.increaseKey(12,1);
		System.out.println(hp);
		
		System.out.println("Delete(13");
		hp.delete(13);
		System.out.println(hp);

		System.out.println("Delete Min");
		hp.deleteMin();
		System.out.println(hp);
		
		System.out.println("Delete Min");
		hp.deleteMin();
		System.out.println(hp);
		*/

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