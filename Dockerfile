FROM ubuntu:14.04

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

RUN apt-get install -y wget git

ENV JAVA_HOME /usr/lib/jvm/java-8-oracle

RUN apt-get install unzip

EXPOSE 9217

RUN \
  cd ../usr/src && \
  git clone https://github.com/AMileikis/play-scala-docker.git && \
  cd play-scala-docker/my-app && \
  sbt dist

RUN mkdir -p /usr/src/play-scala-docker/app

RUN cp /usr/src/play-scala-docker/my-app/target/universal/my-app-1.0.0-SNAPSHOT.zip /usr/src/play-scala-docker/app

RUN cd /usr/src/play-scala-docker/app && \
    unzip my-app-1.0.0-SNAPSHOT.zip 

CMD /usr/src/play-scala-docker/app/my-app-1.0.0-SNAPSHOT/bin/my-app -Dhttp.port=9217

