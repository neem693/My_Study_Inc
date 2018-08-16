import java.io.FileReader;

class While_Ex2
{
	public static void main(String [] args)throws Exception
	
	//FileNotFoundException이 발생한 다는 건 해당 파일이 없어지면 어떻게 할래? 라고 물어보는 것과 같다.
	{
		int count=0;
		int alpha_upper_count = 0;//대문자 갯수 저장변수
		int alpha_lower_count = 0;//소문자 갯수 저장변수
		int number_count = 0; //숫자 갯수 저장변수
		int hangul_count=0;
		FileReader fr = new FileReader("While_Ex2.java");
		
		while(true)
		{
			int readChar = fr.read();
			if(readChar == -1)break;
			System.out.printf("%c",readChar);
			count++;
			if(readChar >=65 && readChar <=90)
				alpha_upper_count++;
			if(readChar>=61 && readChar <= 122)
				alpha_lower_count++;
			if(readChar>=48 && readChar <= 57)
				number_count++;
			if((readChar & 0x8000) == 0x8000)
				hangul_count++;
		}
		
		fr.close(); 
		System.out.println();
		//책을 빌려왔으면 빌려왔던 것과 같이 이것도 또한 해당 하는 자원을 반납해야 하는 과정을 거쳐야 한다. 따라서 무조건 이 파일 close를 해야 한다. 그렇지 않으면 다른 사람이 해당 리소스를 사용하지 못한다.
		System.out.printf("총 문자 수 : %d\n",count);
		System.out.printf("총 소문자 수 : %d\n",alpha_lower_count);
		System.out.printf("총 대문자 수 : %d\n",alpha_upper_count);
		System.out.printf("총 숫자 수 : %d\n",number_count);
		System.out.printf("총 한글 수 : %d\n",hangul_count);
		

		
	}
}