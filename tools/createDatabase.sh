#!/bin/bash

export CLASSPATH=$CLASSPATH:../lib/hsqldb-1.8.0.8/hsqldb.jar

$JAVA_HOME\bin\java -jar ../lib/hsqldb-1.8.0.8/hsqldb.jar --autoCommit --rcFile ./translationrepository.rc translation translationrepository.sql
