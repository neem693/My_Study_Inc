package myutil;

public class AdvanceCalc extends BaseCalc{
	
	
	public int hap(int n) {
		
		int sum =0;
		for(int i =0;i<=n;i++) {
			sum = super.plus(sum, i);
		}
		return sum;
	}
	
	public int pow(int m,int n) {
		
		int result =1;
		for(int i =0;i<n;i++) {
			result = super.multiply(result, m);
		}
		
		
		return result;
	}
	

}
