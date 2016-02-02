import java.util.ArrayList;

/*SYSC 3303 Assignment 2: Chef Class
 * Marc teBoekhorst
 * 100925246
 */
public class Chef implements Runnable{
	
	private Table table;
	private Ingredients item;
	private ArrayList<Ingredients> missingItems;
	
	public Chef(Table table,Ingredients item){
		this.table = table;
		this.item = item;
	}
	/**
	 * Chefs function to run. Makes sandwiches until 20 sandwiches are created then quits his job.
	 */
	public void run(){
		while(true){
			missingItems = table.get(item);
			System.out.println(Thread.currentThread().getName() + " created a sandwich using missing items: "
					+ missingItems.get(0).getName() + " and " + missingItems.get(1).getName());
			table.sandwichCreated();
			try{
				Thread.sleep(300);
				}
			catch(InterruptedException e){};
			System.out.println(table.getSandwiches() + " sandwich(es) made and consumed\n");
		}
	}

}
