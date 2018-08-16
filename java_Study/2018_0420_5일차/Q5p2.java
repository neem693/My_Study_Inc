class Q5p2{
	public static void main(String [] args){
		for(int i=0; i<26; i++){
			if((i)%3==0)
				System.out.printf("%c",'A' + i);
			else
				System.out.printf("%c",'a'+i);
			
		}
		System.out.println();
	}
}