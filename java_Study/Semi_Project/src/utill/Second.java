package utill;

public class Second {
	
	long standard_current_time;
	long current_time;
	
	
	public Second() {
		// TODO Auto-generated constructor stub
	}
	
	public int out_second(){
		current_time = System.currentTimeMillis();
		int result = (int)(current_time - this.standard_current_time);
		return result/10;
	}
	
	public void reset() {
		this.standard_current_time = System.currentTimeMillis();
		
	}

}
