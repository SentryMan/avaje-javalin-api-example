mvn clean package
java -jar -Dlogback.configurationFile=logback-local.xml -Dprofile=local -Xdebug -Xrunjdwp:transport=dt_socket,server=y,suspend=n,address=5005 --enable-preview target/avaje-javalin-1.0.0-SNAPSHOT.jar
