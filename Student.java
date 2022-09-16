 public class Student{
		//set Methods - setters
		//get Methods - getters
	private String name;
	private String StudyClass;
	private int rollno;
	private double percentage;   
	
	//void changeStudyClass(String sc){
		void setStudyClass(String sc){
        StudyClass = sc;
	}
	void setName(String n){
		name = n;
	}
	void setRollno(int r){
		rollno = r;
	}
	void setPercentage(double p){
		percentage = p;
	}
	
	String getName(){
		return name;
}
	String getStudyClass(){
		return StudyClass;
	}
	int getRollno(){
		return rollno;
	}
}
