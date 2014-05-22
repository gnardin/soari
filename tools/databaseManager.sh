#!/bin/bash

export CLASSPATH=$CLASSPATH:../lib/hsqldb-1.8.0.8/hsqldb.jar

$JAVA_HOME/bin/java org.hsqldb.util.DatabaseManagerSwing
