package com.boilerplate.utils

import org.apache.spark.SparkConf
import org.apache.spark.sql.SparkSession

trait SparkApp {

  def buildSparkSession(appName: String): SparkSession.Builder = {
    // Spark Configuration
    val sparkConf = new SparkConf()
    sparkConf.set("spark.sql.sources.partitionOverwriteMode", "dynamic")

    val builder: SparkSession.Builder = SparkSession
      .builder()
      .config(sparkConf)
      .appName(appName)
    builder
  }

}
