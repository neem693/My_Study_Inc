package com.ic.mymapreducer;

import java.io.IOException;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

public class CountMapper extends Mapper<LongWritable, Text, Text, IntWritable> {
	private final static IntWritable one = new IntWritable(1);

	@Override
	public void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {
		String line = value.toString();
		String [] lines = line.split(" ");
		for(String key_str : lines){
		   context.write(new Text(key_str),one);
		}
		/*if (line.startsWith("S")) {
			String scenarioName = line.split(" ")[4];
			context.write(new Text(scenarioName), one);
		} else {
		}*/
	}
}
