
public class Prime {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n,i;
		n=10; //number of terms
		int p=0;
		int num=2;
		System.out.println(" prime numbers are: ");
		while(p<n)
		{
		int f=0;
		 for(i=2;i<num;i++)
		 {
		  if(num%i==0)
		  {
		   f=1;
		   break;
		  }
		  System.out.println(i+"& "+num);
		 }
		 System.out.println("out of for loop" + num);
		if(f==0)
		{
		System.out.println(num+" ");
		p++;
		}
		num++;
		}
		}

	}


