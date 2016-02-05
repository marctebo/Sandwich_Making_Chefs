import java.util.ArrayList;
import java.util.Random;

/*SYSC 3303 Assignment 2: Agent Class
 * Marc teBoekhorst
 * 100925246
 */
public class Agent implements Runnable{
	
	private Table table;
	private ArrayList<Ingredients> items;
	private Ingredients[] ingredients = {Ingredients.P_BUTTER, Ingredients.BREAD, Ingredients.JAM};
	private final int maxSW = 20;	//max sandwiches to make
	
	public Agent(Table table){
		this.table = table;
	}
	
	/**
	 * Agents function to run. Selects two items at random and puts them on the table.  Does this 20 times
	 */
	public void run(){
		Random rand = new Random();
		for(int i = 0; i < maxSW; i++){
			items = new ArrayList<Ingredients>();
			while(items.size()< 2){
				Ingredients j = ingredients[rand.nextInt(3)];
				if(!items.contains(j)){
					items.add(j);
				}
			}
			table.put(items);
			System.out.println(Thread.currentThread().getName()+ " put " + items.get(0).getName() 
					+ " and " + items.get(1).getName() + " on the table.");
			
			try{
				Thread.sleep(1000);
			}
			catch(InterruptedException e){}
		}
		System.exit(1);
	}

}
