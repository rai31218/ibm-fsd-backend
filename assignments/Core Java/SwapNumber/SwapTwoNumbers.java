
public class SwapTwoNumbers {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a=3,b=9, temp;
		System.out.println(a+ " " +b);
		temp=a;
		a=b;
		b=temp;
		System.out.println(a+ " " +b);
		
		a=a+b;
		b=a-b;
		a=a-b;
		System.out.println(a + " "+b);
		

	}

}
