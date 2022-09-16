public class CarPojo{
	public String name;
	public long price;
	public int millage;
	public int carCapacity;
	
	public CarPojo(){
	}
	
	//setters
	void setName(String nam){
		name = nam;
	}
	void setPrice(long mrp){
		price = mrp;
	}
	void setMillage(int mil){
		millage = mil;
	}
	void setCarCapacity(int liters){
		carCapacity = liters;
	}
	
	//getters
	public String getName(){
		return name;
	}
	public long getPrice(){
		return price;
	}
	public int getMillage(){
		return millage;
	}
	public int getCarCapacity(){
		return carCapacity;
	}
}