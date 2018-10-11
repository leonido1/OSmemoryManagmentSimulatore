

import classes.BestMemoryManager;
import classes.FirstMemoryManager;
import classes.PagingMemoryManager;
import classes.WorstMemoryManager;
import interfaces.MemoryStateFinder;

public class test {

	public static void main(String[] args) {

		String id = "319574059";
		float timeInterval = (float) 0.5;
		
		MemoryStateFinder finder = new FirstMemoryManager((float) timeInterval);
		
		System.out.println("------first------");
		System.out.println(finder.memoryInGivenTime(id, 10, 3, (float) 24.5));
		
		finder = new BestMemoryManager(timeInterval);
		System.out.println("------best-------");
		System.out.println(finder.memoryInGivenTime(id, 10, 3, (float) 24.5));
		
		System.out.println("----worst----");
		finder = new WorstMemoryManager(timeInterval);
		System.out.println(finder.memoryInGivenTime(id, 10, 3, (float) 24.5));
		
		System.out.println("----paged----");
		finder = new PagingMemoryManager(timeInterval);
		System.out.println(finder.memoryInGivenTime(id, 10, 3, (float) 24.5));
		
		
		
	}

}
