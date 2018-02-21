FROM ubuntu:16.04

# Install Java
RUN apt-get update && \
    apt-get upgrade -y && \
    apt-get install -y  software-properties-common && \
    add-apt-repository ppa:webupd8team/java -y && \
    apt-get update && \
    echo oracle-java7-installer shared/accepted-oracle-license-v1-1 select true | /usr/bin/debconf-set-selections && \
    apt-get install -y oracle-java8-installer && \
    apt-get clean

# Add the JAR and a way to execute it
COPY sbt/target/scala-2.11/sample.jar /usr/share/java/sample.jar
COPY run-jar.sh /usr/local/bin/run-jar

# Run the API
CMD while [ 1 ]; do :; done
