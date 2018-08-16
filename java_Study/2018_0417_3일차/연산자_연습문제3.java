import java.util.Scanner;
class 연산자_연습문제3
{
   public static void main(String[] args) 
   {
      Scanner scan = new Scanner(System.in);
      double ki = 162.54;
      double ki1 = ki;

   double count_12;
   double count_254;

   count_254 = ki/2.54;
   //ki = ki % 2.54;
//흠? 이렇게 안해도 되잖아요 ㅎㅎ
   count_12 = (ki/2.54)/12.0; //12를 곱하는게 아니라 /12로 나눠야죠!
//2.54로 바꿔야 되고
   System.out.printf("%.2f(cm)의 값은 다음과 같다\n",ki1);
   System.out.printf("%f피트\n",count_12);//이 부분이 틀렸어요. %d로 했으니 안나오죠.
   System.out.printf("%.5f인치이다\n",count_254);
   }
}