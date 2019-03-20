package com.java.training;

public class ContractorObj {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Contractor cont1=new Contractor("XYZ","Bangalore",87, 40000);
		cont1.showContractor();
// try to access the set get method
		Contractor cont2=new Contractor();
		cont2.setConid(3);
		cont2.setWage(45000);
		System.out.println("   ");
		cont2.showContractor();
		
		
		
		Employee emp1=new Employee(11,"debo","Haltu",23,"FSD",30000);
		emp1.showEmp();
		Employee emp2=new Employee();

	}

}
