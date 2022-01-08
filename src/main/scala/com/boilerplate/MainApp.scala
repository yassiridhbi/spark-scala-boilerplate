package com.boilerplate

import com.boilerplate.utils.SparkApp
import com.typesafe.scalalogging.LazyLogging
import org.apache.spark.sql.SparkSession

object MainApp extends SparkApp with LazyLogging {
  def main(args: Array[String]): Unit = {
    implicit val spark: SparkSession = buildSparkSession("app").getOrCreate()
    val df = spark.emptyDataFrame
    logger.info(f"${df.count}")
  }
}
