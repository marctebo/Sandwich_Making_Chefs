/*SYSC 3303 Assignment 2: Table Class
 * Marc teBoekhorst
 * 100925246
 */
import java.util.ArrayList;

public class Table {
	
	private ArrayList<Ingredients> contents = null;
	private boolean empty = true;
	private int sandwiches = 0;
	
	/**
	 * Puts a list of two ingredients onto the table. This method
	 * returns when an item has been placed in the box
	 * @param items Ingredients being put on table
	 */
	public synchronized void put(ArrayList<Ingredients> items){
		while(!empty){
			try{
				wait();
			}
			catch(InterruptedException e){
				return;
			}
		}
		contents = items;
		empty = false;
		notifyAll();
	}
	
	/**
	 * Gets the ingredients from the table. This method returns
	 * once the ingredients have been removed from the table
	 * @param the ingredient that the chef owns
	 * @return Ingredients being removed from table.
	 */
	public synchronized ArrayList<Ingredients> get(Ingredients i){
		while(empty || contents.contains(i)){
			try{
				wait();
			}
			catch(InterruptedException e){
				return null;
			}
		}
		ArrayList<Ingredients> items = contents;
		contents = null;
		empty = true;
		notifyAll();
		return items;
	}
	
	public synchronized void sandwichCreated(){
		sandwiches++;
	}
	public int getSandwiches(){
		return sandwiches;
	}
}
