package hadoop; 

import java.util.*; 

import java.io.IOException; 
import java.io.IOException; 

import org.apache.hadoop.fs.Path; 
import org.apache.hadoop.conf.*; 
import org.apache.hadoop.io.*; 
import org.apache.hadoop.mapred.*; 
import org.apache.hadoop.util.*; 

public class ProcessUnits2 
{ 
   //Mapper class 
   public static class E_EMapper extends MapReduceBase implements 
   Mapper<LongWritable ,/*Input key Type */ 
   Text,                /*Input value Type*/ 
   Text,                /*Output key Type*/ 
   IntWritable>        /*Output value Type*/ 
   { 

      //splitting
	  /*
	  1  1979   23   23   2   43   24   25   26   26   26   26   25   26  25 
	  2	 1980   26   27   28  28   28   30   31   31   31   30   30   30  29 
	  3	 1981   31   32   32  32   33   34   35   36   36   34   34   34  34 
	  4	 1984   39   38   39  39   39   41   42   43   40   39   38   38  40 
	  5	 1985   38   39   39  39   39   41   41   41   00   40   39   39  45
	  */

      
      //Map function 
      public void map(LongWritable key, Text value, 
      OutputCollector<Text, IntWritable> output,   
      Reporter reporter) throws IOException 
      { 
         // key   value
         //  1    1979   23   23   2   43   24   25   26   26   26   26   25   26  25 

         String line = value.toString(); 
		 //                     1   2    3    4    5   6    7    8    9    10   11  12   avg
		 //     line = "1979   23   23   2   43   24   25   26   26   26   26   25   26  25"
		 //     line = "1980   26   27   28  28   28   30   31   31   31   30   30   30  29"
		 //     line = "1981   31   32   32  32   33   34   35   36   36   34   34   34  34"
		 //     line = "1984   39   38   39  39   39   41   42   43   40   39   38   38  40"
		 //     line = "1985   38   39   39  39   39   41   41   41   00   40   39   39  45"

         StringTokenizer s = new StringTokenizer(line," "); 
         String year = s.nextToken(); 
         int month = 1;
         while(s.hasMoreTokens())
         {
			   String str_month = s.nextToken();
			   String monthKey = String.format("month%02d",month);
			   int    int_month = Integer.parseInt(str_month);
			   output.collect(new Text(monthKey), new IntWritable(int_month)); 
               month++;
			   if(month>12)break;
         } 
         // map result
		 /*

              month_01,month_02,month_03,month_04,month_05,month_06,month_07,month_08,month_09,month_10,month_11,month_12
			  month_01,month_02,month_03,month_04,month_05,month_06,month_07,month_08,month_09,month_10,month_11,month_12
			  month_01,month_02,month_03,month_04,month_05,month_06,month_07,month_08,month_09,month_10,month_11,month_12
			  month_01,month_02,month_03,month_04,month_05,month_06,month_07,month_08,month_09,month_10,month_11,month_12
			  month_01,month_02,month_03,month_04,month_05,month_06,month_07,month_08,month_09,month_10,month_11,month_12

              map result=> shuffle

		        key    value 
              month_01,23
              month_01,26
			  month_01,31
			  month_01,39
			  month_01,38

              month_02,23
			  month_02,27
			  month_02,32
			  month_02,38
			  month_02,39



		 */
			


      } 
   } 
   
   
   //Reducer class 
   public static class E_EReduce extends MapReduceBase implements 
   Reducer< Text, IntWritable, Text, IntWritable > 
   {  
   
      //Reduce function 
      public void reduce( Text key, Iterator <IntWritable> values, 
         OutputCollector<Text, IntWritable> output, Reporter reporter) throws IOException 
         { 

            /*
			         month_01
                     key    value 
					  month_01,23
					  month_01,26
					  month_01,31
					  month_01,39
					  month_01,38
			*/

            //key = "month_01"
            //values = [23,26,31,39,38];
            
            int sum=0;
            int val=Integer.MIN_VALUE; 
            
            while (values.hasNext()) 
            { 
                val=values.next().get();
				sum = sum + val;
            } 
			output.collect(key, new IntWritable(sum)); 
 
         } 
   }  
   
   
   //Main function 
   public static void main(String args[])throws Exception 
   { 
      JobConf conf = new JobConf(ProcessUnits2.class); 
      
      conf.setJobName("max_eletricityunits"); 
      conf.setOutputKeyClass(Text.class);
      conf.setOutputValueClass(IntWritable.class); 
      conf.setMapperClass(E_EMapper.class); 
      conf.setCombinerClass(E_EReduce.class); 
      conf.setReducerClass(E_EReduce.class); 
      conf.setInputFormat(TextInputFormat.class); 
      conf.setOutputFormat(TextOutputFormat.class); 
      
      FileInputFormat.setInputPaths(conf, new Path(args[0])); 
      FileOutputFormat.setOutputPath(conf, new Path(args[1])); 
      
      JobClient.runJob(conf); 
   } 
} 