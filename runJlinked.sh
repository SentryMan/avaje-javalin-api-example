mvnd clean package -P jlink
./target/jlink-image/bin/java  -Dconfig.profiles=local -Xdebug -Xrunjdwp:transport=dt_socket,server=y,suspend=n,address=5005 -m avaje.javalin.example/com.jojo.javalin.api.JavalinAPI
