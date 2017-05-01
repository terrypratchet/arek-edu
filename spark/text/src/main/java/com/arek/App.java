package com.arek;

import java.util.Arrays;

import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;

/**
 * Hello world!
 *
 */
public class App 
{
	//-Dmaster.url=local[2]
    public static void main( String[] args )
    {

		SparkConf sparkConf = new SparkConf().setAppName("first app");
		sparkConf.setMaster("local[2]");
		
		JavaSparkContext sc = new JavaSparkContext(sparkConf);
		
		JavaRDD<Integer> rdd = sc.parallelize(Arrays.asList(3,4,5,6,7), 4);
		
		
		
		
		int result = rdd.reduce((accum,n) -> (accum + n));
		System.out.println("result: " + result);
		while(true) ;
		
    }
}
