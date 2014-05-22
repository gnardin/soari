#!/bin/bash

export JAVA_HOME=/soft/jdk1.6.0_16
export FOREART_HOME=/media/data/Projects/workspace/FOReARTTestbed
export SOARI_HOME=/media/data/Projects/workspace/soari

export CLASSPATH=.:$JAVA_HOME/lib/dt.jar:$JAVA_HOME/lib/tools.jar:$JAVA_HOME/jre/lib/rt.jar:$SOARI_HOME/lib/edu.stanford.smi.protegex.owl/*:$SOARI_HOME/lib/edu.standford.smi.protegex.owl.inference.pellet/*:$SOARI_HOME/lib/axis2-1.5.1/*:$SOARI_HOME/lib/hsqldb-1.8.0.8/*:$SOARI_HOME/lib/jade-3.5/*:$SOARI_HOME/lib/log4j-1.2.15/*:$SOARI_HOME/lib/protege-3.4.4/*:$SOARI_HOME/lib/repage/*:$SOARI_HOME/bin:$FOREART_HOME/lib/*:$FOREART_HOME/bin

$JAVA_HOME/bin/java -cp $CLASSPATH jade.Boot -port 5555 -gui LIARAgent:agents.jade.JADEAgent\("/media/data/Projects/workspace/soari" LIAR 10 20\) RepageAgent:agents.jade.JADEAgent\("/media/data/Projects/workspace/soari" REPAGE 720 20\) TypologyAgent:agents.jade.JADEAgent\("/media/data/Projects/workspace/soari" TYPOLOGY 10 450\)
