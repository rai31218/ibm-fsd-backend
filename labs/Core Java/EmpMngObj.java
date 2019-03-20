package com.java.training;

public class EmpMngObj {

	public static void main(String[] args) {
		EmpManager[] emp= new EmpManager[4];
		//EmpManager[] empnew= new EmpManager[emp.length-1];
		emp[0]= new EmpManager(0, "Rudra", 15000);
		emp[1]= new EmpManager(2, "Ananda", 16000);
		emp[2]= new EmpManager(3, "Rai", 18000);
		emp[3]= new EmpManager(4, "Maria", 20000);
		
		for(int i=0;i<emp.length;i++)
		{
			//System.out.println(i);
			emp[i].showEmp();
		}
		
	/*	for(int i=0;i<emp.length;i++)
		{
			emp[i].updateEmp(30,"Abhi", 90000);
		} */
		
		System.out.println("Updation of first element");
		emp[0].updateEmp(1, "Pihu", 15000);
		for(int i=0;i<emp.length;i++)
		{
			//System.out.println(i);
			emp[i].showEmp();
		}
		
		System.out.println("Deletion:::::");
		for(int i=0;i<emp.length;i++)
		{
			if(emp[i].salary>= 16000)
				{
				System.out.println("Employee "+emp[i].name+ " has been deleted");
			      emp[i]=null;
			      emp[i]=emp[i+1];
			      emp[emp.length-1]=null;
			      //System.out.println(emp[i].name + emp[i].salary);
				}
			 //System.out.println(emp[i].name + emp[i].salary);
		}
		
	/*System.out.println("Deletion:::::");	
		for(int i=0,j=0;i<emp.length;i++)
		{
			if(i==1)
			{
				System.out.println("Employee "+emp[i].name+ " deleted");
				continue;
			}
			emp[j++]=emp[i];
			System.out.println(emp[i].id+" "+emp[i].name);	
		} 
		for(int i=0;i<emp.length;i++)
		{
			//System.out.println(i);
			emp[i].showEmp();
		} */
		
		Integer a= new Integer(120);
		int b;
		b=a;
		System.out.println(b);
		Integer c=b;
		System.out.println(c);
		
	}

}
