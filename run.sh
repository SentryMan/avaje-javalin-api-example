mvn clean package && \
java -jar --enable-preview -Dprofile=local -Xdebug -Xrunjdwp:transport=dt_socket,server=y,suspend=n,address=8000 target/avaje-javalin-1.0.0-SNAPSHOT.jar
