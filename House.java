class House{
	String houseNumber;
	double areaInSquareFeet;
	String paint;
	int numberOfRooms;
	
	void setHouseNumber(String Dn){
		houseNumber = Dn;
	}
	void setAreaInSquareFeets(double area){
		areaInSquareFeet = area;
	}
	void setPaint(String paint){
		paint = paint;
	}
	void setNumberOfRooms(int nOfRooms){
		numberOfRooms = nOfRooms;
	}
	String getHouseNumber(){
		return houseNumber;
	}
	double getAreaInSquareFeet(){
		return areaInSquareFeet;
	}
	String getPaint(){
		return paint;
	}
	int getnumberOFRooms(){
		return numberOfRooms;
	}
}