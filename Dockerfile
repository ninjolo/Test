FROM maven:3.5.2-jdk-8-alpine

LABEL maintainer "mr.ghea@gmail.com"

ENV WORKDIR /usr/app
RUN mkdir "$WORKDIR"
WORKDIR $WORKDIR

COPY pom.xml .
COPY lib/ lib/
COPY src/ src/

RUN mvn clean install
RUN mv target/Test-1.0-SNAPSHOT.jar ./Test-1.0-SNAPSHOT.jar \
  && rm -rf target/ \
  && rm -rf pom.xml \
  && rm -rf lib/ \
  && rm -rf logs/ \
  && rm -rf src/

COPY start-test.sh /usr/local/bin/start-test.sh
RUN chmod a+x /usr/local/bin/start-test.sh

ENTRYPOINT ["start-test.sh"]
