package file_io;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Random;

public class File_io {

   public static void main(String[] args) throws Exception {
      // TODO Auto-generated method stub
//
//      InputStream is = new FileInputStream("src/main/OX문제.txt");
//
//      InputStreamReader isr = new InputStreamReader(is);
//
//      BufferedReader br = new BufferedReader(isr);

      Random r1 = new Random();
      ArrayList<String> quiz = new ArrayList<String>();

      String[][] data = new String[16][3];
      
      String read = "1$$색의 삼원색은 빨강, 초록, 파랑 이다 $$O";
      data[0] = read.split("\\$\\$");

//      for (int i = 0;; i++) {
//
//         // int ch = isr.read();
//         String readStr = br.readLine();
//         data[i] = readStr.split("$$");
//         // quiz.add(readStr);
//         if (readStr == null)
//            ;
//         break;
//      }

      // System.out.println(readStr);

      // String readStr = br.readLine().trim();
      // if(readStr==null);

      // String [] data = readStr.split("$$");

      // int u = quiz.size();
      // for (int k = 0; k < u-1; k++) {
      // int max = quiz.size()-1;
      // int r = r1.nextInt(max);
      // System.out.println(quiz.get(r));
      // quiz.remove(r);
      //
      // return;
      // }

      for (int i = 0; i < data.length; i++)
         for (int j = 0; j < 3; j++) {
            System.out.printf("%s번: %s 정답:%s", data[i][j], data[i][j], data[i][j]);
            System.out.println();
         }

   }
}