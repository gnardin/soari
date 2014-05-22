#!/bin/bash
export FOREART_HOME=/data/workspace/forearttestbed
export SOARI_HOME=/data/workspace/soari

export CLASSPATH=.:$JAVA_HOME/lib/dt.jar:$JAVA_HOME/lib/tools.jar:$JAVA_HOME/jre/lib/rt.jar:$SOARI_HOME/lib/edu.stanford.smi.protegex.owl/*:$SOARI_HOME/lib/edu.standford.smi.protegex.owl.inference.pellet/*:$SOARI_HOME/lib/axis2-1.5.1/*:$SOARI_HOME/lib/hsqldb-1.8.0.8/*:$SOARI_HOME/lib/jade-3.5/*:$SOARI_HOME/lib/log4j-1.2.15/*:$SOARI_HOME/lib/protege-3.4.4/*:$SOARI_HOME/lib/repage/*:$SOARI_HOME/bin:$FOREART_HOME/lib/*:$FOREART_HOME/bin

if [ -z $1 ]
then
  $JAVA_HOME/bin/java -Xms1512m -Xmx1512m testbed.sim.Sim $FOREART_HOME/config/game-config-foreart.xml
else
  $JAVA_HOME/bin/java -Xms1512m -Xmx1512m testbed.sim.Sim $1
fi
