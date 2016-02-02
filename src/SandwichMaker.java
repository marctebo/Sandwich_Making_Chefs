
public class SandwichMaker {
	
	public static void main(String args[]){
		Thread agent,chef1,chef2,chef3;
		Table table;
		
		table = new Table();
		
		agent = new Thread((new Agent(table)),"Agent");
		chef1 = new Thread((new Chef(table,Ingredients.BREAD)), "Chef 1");
		chef2 = new Thread((new Chef(table,Ingredients.P_BUTTER)), "Chef 2");
		chef3 = new Thread((new Chef(table,Ingredients.JAM)), "Chef 3");
		
		agent.start();
		chef1.start();
		chef2.start();
		chef3.start();
	}
	
}
