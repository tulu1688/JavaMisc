FROM tulu1688/alpine-jdk:base
MAINTAINER javaonfly
COPY target/Petstore-1.0-SNAPSHOT.jar /opt/lib/
ENTRYPOINT ["/usr/bin/java"]
CMD ["-jar", "/opt/lib/Petstore-1.0-SNAPSHOT.jar", "-Xmx512m", "-Duser.timezone=GMT", "-Dserver.port=9000"]
EXPOSE 9000
