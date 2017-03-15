public class SonicSD {
	
	private SDBehavior sdb;
	
	void setSDBehavior (SDBehavior sdb){
		this.sdb = sdb;
	}
	
	void actionRecipe(){
		initSD();
		performFunc();
		disableSD();
	}
	void initSD(){
		System.out.println("Sonice starting ...");
	}
	void disableSD(){
		System.out.println("Sonice closing ...");
	}
	
	void performFunc(){
		sdb.Perform();
	}
}
