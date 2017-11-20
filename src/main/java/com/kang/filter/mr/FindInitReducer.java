/**
 * 
 */
package com.kang.filter.mr;

import java.io.IOException;

import org.apache.hadoop.io.DoubleWritable;
import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.mapreduce.Reducer;

import com.kang.filter.FilterCounter;
import com.kang.util.HUtils;

/**
 * reduce方法
 */
public class FindInitReducer extends Reducer<DoubleWritable, NullWritable, DoubleWritable, NullWritable> {

	private long records = 0L;
	
	@Override
	public void reduce(DoubleWritable key, Iterable<NullWritable> values, Context cxt)throws InterruptedException,IOException{
		records++;
		cxt.getCounter(FilterCounter.REDUCE_COUNTER).increment(1);
		cxt.write(key, NullWritable.get());
	}
	
	@Override
	public void cleanup(Context cxt){
		System.out.println("reducer counters:"+records);
		cxt.getConfiguration().setLong(HUtils.REDUCE_COUNTER2, records);
		cxt.getConfiguration().setLong(HUtils.REDUCE_COUNTER, 
				cxt.getCounter(FilterCounter.REDUCE_COUNTER).getValue());
	}
}
