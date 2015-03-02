FROM ubuntu:14.04

#Set working directory
WORKDIR /play_docker_project

#Copy the files
ADD my-app /usr/src/

RUN DEBIAN_FRONTEND=noninteractive apt-get -y install software-properties-common

RUN \
  echo oracle-java8-installer shared/accepted-oracle-license-v1-1 select true | debconf-set-selections && \
  add-apt-repository -y ppa:webupd8team/java && \
  apt-get update && \
  apt-get install -y oracle-java8-installer && \
  rm -rf /var/lib/apt/lists/* && \
  rm -rf /var/cache/oracle-jdk8-installer

RUN \
  wget https://dl.bintray.com/sbt/debian/sbt-0.13.6.deb && \
  dpkg -i sbt-0.13.6.deb && \
  apt-get update && \
  sudo apt-get install -y sbt

ENV JAVA_HOME /usr/lib/jvm/java-8-oracle

EXPOSE 9217

CMD \
  cd ../usr/src && \
  sbt "~run 9217"   




