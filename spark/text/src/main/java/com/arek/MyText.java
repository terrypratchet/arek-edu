package com.arek;

import java.util.Arrays;

import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaPairRDD;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;

import scala.Tuple2;

public class MyText {

		//-Dmaster.url=local[2]
	    public static void main( String[] args )
	    {

			SparkConf sparkConf = new SparkConf().setAppName("first app");
			sparkConf.setMaster("local[2]");
			
			JavaSparkContext sc = new JavaSparkContext(sparkConf);
			
			JavaRDD<String> lines = sc.textFile("data/const.txt");
			
	
			JavaRDD<String> words =
			    lines.flatMap(line -> Arrays.asList(line.split(" ")).iterator());
			JavaPairRDD<String, Integer> pairs = words.mapToPair(w -> new Tuple2<String, Integer>(w, 1));
			JavaPairRDD<String, Integer> counts =
			    pairs
			         .reduceByKey((x, y) -> x+y);
			
			JavaPairRDD<Integer, String>  sorted = counts.mapToPair(x->x.swap()).sortByKey(false);
			
			;
			
			System.out.println("counts:" + sorted.take(10));
			
			
			/*
			JavaRDD<String> words = rdd.flatMap( line -> (Arrays.asList(line.split(" ")).iterator()));
			Map<String, Long> countByValues = words.countByValue();
			
			
			
			//worlds.sortBy(pair -> pair., false, 2);
			
			System.out.println("worlds: " + countByValues);
			
			
			
			
			long lines = rdd.count();
			
			
			
			System.out.println("lines: " + lines); */;
	    }

}
