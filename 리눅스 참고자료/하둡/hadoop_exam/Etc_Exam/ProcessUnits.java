package hadoop; 

import java.util.*; 

import java.io.IOException; 
import java.io.IOException; 

import org.apache.hadoop.fs.Path; 
import org.apache.hadoop.conf.*; 
import org.apache.hadoop.io.*; 
import org.apache.hadoop.mapred.*; 
import org.apache.hadoop.util.*; 

public class ProcessUnits 
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
		 //     line = "1979   23   23   2   43   24   25   26   26   26   26   25   26  25"
         String lasttoken = null; 
         StringTokenizer s = new StringTokenizer(line," "); 
         String year = s.nextToken(); 
         
         while(s.hasMoreTokens())
            {
               lasttoken=s.nextToken();
            } 
            
         int avgprice = Integer.parseInt(lasttoken); 
         output.collect(new Text(year), new IntWritable(avgprice)); 
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
            int maxavg=30; 
            int val=Integer.MIN_VALUE; 
            
            while (values.hasNext()) 
            { 
               if((val=values.next().get())>maxavg) 
               { 
                  output.collect(key, new IntWritable(val)); 
               } 
            } 
 
         } 
   }  
   
   
   //Main function 
   public static void main(String args[])throws Exception 
   { 
      JobConf conf = new JobConf(ProcessUnits.class); 
      
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