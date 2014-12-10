
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
		//ScriptReader temp2 = new ScriptReader("script.txt");

		// FETCH NUMBERS FROM input.txt
		for( int i = 0 ; i < temp.numeros.size();i++)
		{
			hp.insert(temp.numeros.get(i));
		}
		
		
		
		/*
		//System.out.println(temp2.script.size());
		for( int i = 0; i < temp2.script.size(); i++)
		{
		// FETCH INSTRUCTIONS FROM script.txt
			if((temp2.script.get(i).getCMD()).equals("insert"))
			{
				hp.insert(temp2.script.get(i).getParam());
			}
		}
		*/
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


    }
 
}