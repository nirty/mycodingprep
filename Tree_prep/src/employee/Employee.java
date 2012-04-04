package employee;

import java.util.ArrayList;

public class Employee {
	
	Integer empId;
	String name;
	Employee manager;
	Integer age;
	ArrayList<Employee> subordinates_list = new ArrayList<Employee>();
	

	Employee(Integer employeeid,String employeename){
		this.empId = employeeid;
		this.name = employeename;
	}
	
	public Integer getEmpId() {
		return empId;
	}

	public void setEmpId(Integer empId) {
		this.empId = empId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Employee getManager() {
		return manager;
	}

	public void setManager(Employee managerI) {
		this.manager = managerI;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}
	
	public void addSubordinates(Employee sub){
		this.subordinates_list.add(sub);
	}	
	
	public ArrayList<Employee> getSubordinates(){
		return this.subordinates_list;
	}	
	
	public void printSubordinates() {		
		ArrayList<Employee> subs = new ArrayList<Employee>();
		subs.addAll(subordinates_list);		
		for(int i=0;i<subs.size();i++){
			Employee e = subs.get(i);
			System.out.println(e.name);
			subs.addAll(e.getSubordinates());			
		}		
	}
	
	public void printManagers(){
		Employee e = this.getManager();
		while(e!=null){
			System.out.println(e.getName());
			e = e.getManager();
		}
	}
}
