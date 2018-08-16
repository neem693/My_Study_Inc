class 이진논리연산자{
	public static void main(String[] args){
		int a= 7;
		int b= 5;
		
		System.out.printf("[%32s]\n",Integer.toBinaryString(a));
		System.out.printf("[%32s]\n",Integer.toBinaryString(b));
		System.out.printf("[%32s]\n",Integer.toBinaryString(a&b));
		System.out.printf("[%32s]\n",Integer.toBinaryString(a|b));
		System.out.printf("[%32s]\n",Integer.toBinaryString(a^b));
		
		int birthday = 0x19880815;
		int year = birthday >>> 16; 
		//이렇게 해도 상관이 없다. >>란 상관이 없다는 뜻.
		int month = birthday >> 8 & 0xff; 
		// & 한다는건 0x000000ff 랑 한다는 것을 의미한다. 결국 1이 되있는 값만 1로 and연산되서 나온다는 것 
		//다시 말해서 f는 1111을 의미한다. 0011 & 1111 = 0011이다.  즉, 0011 & 0xf = 0011이라는 것!!!!!!!!!!!!!
		int day = birthday & 0xff;
		System.out.printf("[%x]년\n",year);
		System.out.printf("[%02x]월\n",month);
		System.out.printf("[%02x]일\n",day);
		//08월을 소거하고 12월을 넣을라고 한다.
		
		//birthday = birthday & 0xffff00ff;
		birthday = birthday ^ 0x00000800; 
		// 1000 ^ 1000 = 0000
		// 0001 ^ 0000 = 0001
		// 1001 ^ 0000 = 1001
		birthday = birthday | 0x00001200;
		
		System.out.printf("%x",birthday);
	
	
	}
}
