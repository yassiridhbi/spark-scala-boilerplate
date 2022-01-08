FROM amazoncorretto:8 AS builder
WORKDIR builder

RUN yum update -y \
    && yum install -y wget \
    && yum install -y tar.x86_64 \
    && yum install -y gzip

RUN wget --no-verbose -O /builder/spark-3.1.2-bin-hadoop3.2.tgz https://archive.apache.org/dist/spark/spark-3.1.2/spark-3.1.2-bin-hadoop3.2.tgz \
    && tar -zxvf /builder/spark-3.1.2-bin-hadoop3.2.tgz

FROM amazoncorretto:8
WORKDIR app

COPY --from=builder /builder/spark-3.1.2-bin-hadoop3.2 /app/spark
COPY target/scala-2.12/boilerplate.jar /app/

ENV SPARK_DIST_CLASSPATH \
/app/boilerplate.jar

CMD /app/spark/bin/spark-submit --master local[*] --class com.boilerplate.MainApp boilerplate.jar
