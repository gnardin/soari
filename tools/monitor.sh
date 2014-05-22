#!/bin/bash

export CLASSPATH=$JAVA_HOME/lib/dt.jar:$JAVA_HOME/lib/tools.jar:$JAVA_HOME/jre/lib/rt.jar

$JAVA_HOME/bin/java -cp $CLASSPATH -jar ../lib/tcpmon.jar
