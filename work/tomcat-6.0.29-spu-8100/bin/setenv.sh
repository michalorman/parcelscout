#!/bin/sh

JAVA_HOME=/usr/lib64/jvm/java
JRE_HOME=$JAVA_HOME
JAVA_OPTS='-Xms256m -Xmx512m -XX:+CMSClassUnloadingEnabled -XX:MaxPermSize=512m'