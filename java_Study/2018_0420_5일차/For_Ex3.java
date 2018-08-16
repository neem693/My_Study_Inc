class For_Ex3
{
	public static void main(String[] args){
		//ABCD........Z
		for(int ch = 'A'; ch<='Z';ch++)
			System.out.printf("%c(%d)",ch,ch);
		
		System.out.println();

		for(int i =0; i<26;i++)
			System.out.printf("%c",'A'+i);
		System.out.println();

		for(int i =0; i<26;i++){
			if(i%2==0)
				System.out.printf("%c", 'A' + i);
			else
				System.out.printf("%c",'a'+i);
		}
		System.out.println();

	}
	
}