#!/usr/bin/env bash
mvn clean package
java --module-path ./target/modules -Dconfig.profiles=local -Xdebug -Xrunjdwp:transport=dt_socket,server=y,suspend=n,address=5005 -m avaje.javalin.example/com.jojo.javalin.api.JavalinAPI
