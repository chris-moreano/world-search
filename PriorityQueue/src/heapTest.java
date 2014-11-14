import java.util.Scanner;


public class heapTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Heap<Integer> hp = new Heap<Integer>();
		Scanner sc = new Scanner( System.in);
		System.out.println("Enter next int or 'done'");
		String line = sc.next();
		while(!line.equals("done"))
		{
			hp.inser(Integer.parseInt(line));
			System.out.println(hp);
			System.out.println("Enter next int or 'done'");
			line = sc.next();
		}
		
		while(!hp.isEmpty())
		{
			int max = hp.delete();
			System.out.println(max +" " + hp);
		}
	}

}
