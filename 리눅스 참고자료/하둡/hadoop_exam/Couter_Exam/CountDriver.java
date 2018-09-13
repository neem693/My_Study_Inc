package com.ic.mymapreducer;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.conf.Configured;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.input.TextInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;
import org.apache.hadoop.util.Tool;
import org.apache.hadoop.util.ToolRunner;

public class CountDriver extends Configured implements Tool{
	/*public static void main(String[] args) throws IOException, InterruptedException, ClassNotFoundException {
		Configuration conf = new Configuration();
		if (args.length != 2) {
			System.out.println("Usage : java CountDriver <in> <out>");
			System.exit(2);
		}
		Job job = new Job(conf, "scenario count");
		job.setJarByClass(CountDriver.class);
		job.setMapperClass(CountMapper.class);
		job.setInputFormatClass(TextInputFormat.class);
		FileInputFormat.addInputPath(job, new Path(args[0]));
		job.setReducerClass(CountReducer.class);
		job.setOutputKeyClass(Text.class);
		job.setOutputValueClass(IntWritable.class);
		FileOutputFormat.setOutputPath(job, new Path(args[1]));
		job.waitForCompletion(true);
	}*/
	public static void main(String[] args) throws Exception {
	     int res = ToolRunner.run(new Configuration(), new CountDriver(), args);
	     System.exit(res);
	  }

	  public int run(String[] args) throws Exception
	  {

	    // Configuration processed by ToolRunner 
	    Configuration conf = getConf();
	    Job job = new Job(conf, "My Job");

	    job.setJarByClass(CountDriver.class);
		job.setMapperClass(CountMapper.class);
		job.setInputFormatClass(TextInputFormat.class);
		FileInputFormat.addInputPath(job, new Path(args[0]));
		job.setReducerClass(CountReducer.class);
		job.setOutputKeyClass(Text.class);
		job.setOutputValueClass(IntWritable.class);
		FileOutputFormat.setOutputPath(job, new Path(args[1]));

	    return job.waitForCompletion(true) ? 0 : 1;
	  }
	
	
	
	
}
