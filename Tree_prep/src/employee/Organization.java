package employee;

public class Organization {
	
	public static void main(String args[]){
		
	 Employee ceo = new Employee(0,"John");
	 
	 Employee Celia = new Employee(1,"Celia");
	 Celia.setManager(ceo);
	 ceo.addSubordinates(Celia);
	 
	 Employee banu = new Employee(4,"banu");
	 banu.setManager(Celia);
	 Celia.addSubordinates(banu); 
	 
	 Employee Cherry = new Employee(5,"Cherry");
	 Cherry.setManager(Celia);
	 Celia.addSubordinates(Cherry);
	 
	 Employee Pawn = new Employee(10,"Pawn");
	 Pawn.setManager(banu);
	 banu.addSubordinates(Pawn);	 
	 
	 Employee Jack = new Employee(2,"Jack");
	 Jack.setManager(ceo);
	 ceo.addSubordinates(Jack);
	 
	 Employee Jill = new Employee(6,"Jill");
	 Jill.setManager(Jack);
	 Jack.addSubordinates(Jill);	 
	 
	 Employee Nirty = new Employee(3,"Nirty");
	 Nirty.setManager(ceo);
	 ceo.addSubordinates(Nirty);	 
	 
	 Employee Keith = new Employee(7,"Keith");
	 Keith.setManager(Nirty);
	 Nirty.addSubordinates(Keith); 
	 
	 Employee Mongo = new Employee(11,"Mongo");
	 Mongo.setManager(Keith);
	 Keith.addSubordinates(Mongo); 
	 
	 Employee Kin = new Employee(8,"Kin");
	 Kin.setManager(Nirty);
	 Nirty.addSubordinates(Kin); 
	
	 Employee DB = new Employee(12,"DB");
	 DB.setManager(Kin);
	 Kin.addSubordinates(DB); 
	 
	 Employee Kohln = new Employee(9,"Kohln");
	 Kohln.setManager(Nirty);
	 Nirty.addSubordinates(Kohln); 
	
	 Employee IWS = new Employee(13,"IWS");
	 IWS.setManager(Kohln);
	 Kohln.addSubordinates(IWS); 	 
		
	 ceo.printSubordinates();
	 System.out.println("___________________MANAGERS___________________");
	 
	 IWS.printManagers();
		
	}
}
