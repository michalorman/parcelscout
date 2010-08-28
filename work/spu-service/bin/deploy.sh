#!/bin/sh

TOMCAT_VERSION="6.0.29-spu-8100"
TOMCAT="../tomcat-${TOMCAT_VERSION}"
APP_NAME="spu-service"

$TOMCAT/bin/shutdown.sh
mvn clean package; rm -r -v $TOMCAT/webapps/$APP_NAME*; cp -v target/$APP_NAME.war $TOMCAT/webapps/
$TOMCAT/bin/startup.sh
