package com.java.training;

public class EmployeeObj {

	public static void main(String[] args) {
		
		Person emp1=new Employee(10,"debo","Haltu",23,"FSD",30000);
	//Person emp1=new Employee("debo","Haltu",23,"FSD",30000);//not allowed as Person doesn't know about appraise and showEmp;
		//emp1.showEmp();
		Employee emp2=new Employee();
		//emp1.appraise();
		//emp1.inheritable();
		//emp1.sayHello();
		
//		//emp2.id=2;
//		emp2.age=24;
//		emp2.dept="Sales Force";
//		emp2.salary=30000;
		
// try- Reference object
// try-with reference object call same method from different class		
		
		//emp1.setAge(40);
		//emp1.showEmp();
		//emp2.showEmp();
		
		emp2.updateEmp(3, 30, "Managerial", 50000);
		emp2.showEmp();
		
		//Employee.print(emp2); */
		emp2.defaultTest();
		
	}

}
