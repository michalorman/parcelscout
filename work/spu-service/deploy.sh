#!/bin/sh

mvn clean package && rm -rf -v ../tomcat-6.0.29-spu-8100/webapps/spu-service* && cp -v target/spu-service.war ../tomcat-6.0.29-spu-8100/webapps/
