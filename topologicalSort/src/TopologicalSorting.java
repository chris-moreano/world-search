import java.io.BufferedReader;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;



public class TopologicalSorting {

	/*
	 *DAG stored as an Adjacency List
	 */
	private HashMap<String,LinkedList<String>>  inputDAG = new HashMap<String,LinkedList<String>>(); 
	
	/*
	 * Count of in-coming edges for a node
	 */
	private HashMap<String,Integer>  fanInCount = new HashMap<String,Integer> ();
	public String finalOutput = " ";

	/*
	 * Class entry point
	 */
	public static void main(String[] args) {
		
		String inputFile = "input3.txt";		
		TopologicalSorting inst = new TopologicalSorting();
		LinkedList<String> rootNodes = inst.createDAG(inputFile);
		inst.sortDAG(rootNodes);
	}
	
	
	/*
	 * This function reads the DAG structure from the input file into an Adjacency List (Parent: Children list). 
	 * A vertex u is called a parent of a vertex v if there is a directed edge from u to v. 
	 * It also determines the root nodes by counting the number of in-coming edges.
	 */
	public LinkedList<String> createDAG(String fileName)
	{
		LinkedList<String> rootNodes = null;

		try{
			BufferedReader  fR = new BufferedReader( new FileReader(fileName));
			String line;
			while( (line = fR.readLine()) != null)
			{
				String[] toks = line.split(" ");
				String parentNode = toks[0];
				LinkedList<String> childrenList;
				
				if(inputDAG.containsKey(parentNode))
				{
					//System.out.println(parentNode);
					childrenList = inputDAG.get(parentNode);
					
				}else{
					
					childrenList = new LinkedList<String>();
					inputDAG.put(parentNode, childrenList);
				}
				
				
				
				for(int i = 1 ; i < toks.length; i++)
				{
					childrenList.add(toks[i]);
					
					if(fanInCount.containsKey(toks[i]))
					{
						fanInCount.put(toks[i], new Integer((fanInCount.get(toks[i])).intValue()+1));
						
					}else{
						
						fanInCount.put(toks[i], new Integer(1));
					}
				}
			}
			
			/*
			 * We know that none of the root nodes appear in the children list of the 
			 * nodes, and therefore are not present in fanInCount HashMap 
			 */
			rootNodes = new LinkedList<String>();
			Iterator<String> keyItr = inputDAG.keySet().iterator();
			//System.out.print("Root Nodes: ");
			while(keyItr.hasNext())
			{
				String key = keyItr.next();
				if(!fanInCount.containsKey(key)){
					rootNodes.add(key);
					//System.out.print(key+", ");
				}
			}
			System.out.println();
			
		}catch(Exception e) // catch all types of exceptions
		{
			e.printStackTrace();
		}	
		if(rootNodes.size()==0 )
		{
			System.out.println("The DAG has Cycles");
			System.exit(-1);
		}
		return rootNodes;
	}
	
	
	/*
	 * This function performs a topological sorting of the DAG. 
	 * It also detects if the DAG has a cycle.
	 */
	public void sortDAG(LinkedList<String> rootNodes)
	{
		LinkedList<String>  sortedList = new LinkedList<String>();
		while(!rootNodes.isEmpty())
		{
			String root = rootNodes.remove();
			sortedList.add(root);
			LinkedList<String> childrenList = inputDAG.get(root);
			if(childrenList != null)
			{
				Iterator<String> childItr = childrenList.iterator();
				while(childItr.hasNext())
				{
					String child = childItr.next();
					int newFanIn = fanInCount.get(child).intValue()-1;
					if(newFanIn == 0) {
						rootNodes.add(child);
						fanInCount.remove(child);
					}else{
						fanInCount.put(child, new Integer(newFanIn));
					}
				}
			}
			
		}
		
		if(fanInCount.size() > 0 )
			 System.out.println("DAG has a Cycles");
		else{
			//System.out.println("Sorted DAG: ");
			//int i = 0;
			while(sortedList.size() > 0)
			{
				//finalOutput  = finalOutput + sortedList.remove();
			  System.out.print(sortedList.remove() + " ");
				//i++;
				//System.out.println(finalOutput);
			}
			
			//System.out.println(finalOutput);
		}
		
	}
}