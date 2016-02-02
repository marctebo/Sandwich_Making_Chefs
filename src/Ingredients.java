public enum Ingredients {

	BREAD("Bread"),P_BUTTER("Peanut Butter"),JAM("Jam");
	
	private final String name;
	
	private Ingredients(String name){
		this.name = name;
	}
	public String getName(){
		return name;
	}
}
