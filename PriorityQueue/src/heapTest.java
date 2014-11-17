

 
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
		
		
		
		//System.out.println(temp2.script.size());
		for( int i = 0; i < temp2.script.size(); i++)
		{
		// FETCH INSTRUCTIONS FROM script.txt
			if((temp2.script.get(i).getCMD()).equals("insert"))
			{
				hp.insert(temp2.script.get(i).getParam());
			}
		}
		
		
		System.out.println(hp);
        

    }
 
}