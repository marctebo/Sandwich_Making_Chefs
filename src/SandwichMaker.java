
public class SandwichMaker {
	
	public static void main(String args[]){
		Thread agent,chef1,chef2,chef3;
		Table table;
		
		table = new Table();
		Chef c1 = new Chef(table,Ingredients.BREAD);
		Chef c2 = new Chef(table,Ingredients.P_BUTTER);
		Chef c3 = new Chef(table,Ingredients.JAM);
		
		agent = new Thread((new Agent(table)),"Agent");
		chef1 = new Thread(c1, "Chef 1");
		chef2 = new Thread(c2, "Chef 2");
		chef3 = new Thread(c3, "Chef 3");
		
		System.out.println(chef1.getName()+ " has an infinite supply of " + c1.getItem().getName());
		System.out.println(chef2.getName()+ " has an infinite supply of " + c2.getItem().getName());
		System.out.println(chef3.getName()+ " has an infinite supply of " + c3.getItem().getName()+ "\n");
		
		agent.start();
		chef1.start();
		chef2.start();
		chef3.start();
	}
	
}
