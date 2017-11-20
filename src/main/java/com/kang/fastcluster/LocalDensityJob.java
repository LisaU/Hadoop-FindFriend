/**
 * 
 */
package com.kang.fastcluster;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.conf.Configured;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.DoubleWritable;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.SequenceFileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.SequenceFileOutputFormat;
import org.apache.hadoop.util.GenericOptionsParser;
import org.apache.hadoop.util.Tool;
import org.apache.hadoop.util.ToolRunner;

import com.kang.fastcluster.mr.LocalDensityMapper;
import com.kang.fastcluster.mr.LocalDensityReducer;
import com.kang.util.HUtils;


/**
 * 
 * 输入为 <key,value>--> <distance,<id_i,id_j>>
 *  <距离，<向量i编号，向量j编号>>
 *  
 *  Mapper：
 *  输出向量i编号，1
 *      向量j编号,1
 *  Reducer:
 *  输出
 *     向量i编号，局部密度
 *     有些向量是没有局部密度的，当某个向量距离其他点的距离全部都大于给定阈值dc时就会发生
 */
public class LocalDensityJob extends Configured implements Tool {

	/**
	 * @param args
	 * @throws Exception
	 * method: gaussian,cutoff
	 */
	public static void main(String[] args) throws Exception {
		ToolRunner.run(HUtils.getConf(), new LocalDensityJob(), args);
	}

	public int run(String[] args) throws Exception {

		Configuration conf = HUtils.getConf();
		String[] otherArgs = new GenericOptionsParser(conf, args)
				.getRemainingArgs();//初始化命令行参数
		if (otherArgs.length != 5) {//要求参数个数必须符合要求
			System.err
					.println("Usage: com.kang.fast_cluster.LocalDensityJob <in> <out> <dc> <method> <num_reducer>");
			System.exit(4);
		}
		conf.set("METHOD", otherArgs[3]);//设置密度计算方法
		conf.setDouble("DC", Double.parseDouble(otherArgs[2]));//设置距离阀值
		Job job = Job.getInstance(conf,
				"Count the near neighours with a given dc(distance):"
						+ otherArgs[2]);
		job.setJarByClass(LocalDensityJob.class);
		job.setMapperClass(LocalDensityMapper.class);
		job.setCombinerClass(LocalDensityReducer.class);
		job.setReducerClass(LocalDensityReducer.class);
		
		job.setNumReduceTasks(Integer.parseInt(otherArgs[4]));//设置reduce个数
		
		job.setOutputKeyClass(IntWritable.class);
		job.setOutputValueClass(DoubleWritable.class);
		
		job.setOutputFormatClass(SequenceFileOutputFormat.class);
		job.setInputFormatClass(SequenceFileInputFormat.class);
		
		SequenceFileInputFormat.addInputPath(job, new Path(otherArgs[0]));

		SequenceFileOutputFormat.setOutputPath(job, new Path(otherArgs[1]));
		FileSystem.get(conf).delete(new Path(otherArgs[1]), true);
		return job.waitForCompletion(true) ? 0 : 1;

	}

}
