@ECHO OFF

SET JAVA_HOME=/soft/jdk1.6.0_16
SET FOREART_HOME=/media/data/Projects/workspace/FOReARTTestbed
SET SOARI_HOME=/media/data/Projects/workspace/soari

CLASSPATH=.;$JAVA_HOME/lib/dt.jar;$JAVA_HOME/lib/tools.jar;$JAVA_HOME/jre/lib/rt.jar;$SOARI_HOME/lib/edu.stanford.smi.protegex.owl/*;$SOARI_HOME/lib/edu.standford.smi.protegex.owl.inference.pellet/*;$SOARI_HOME/lib/axis2-1.5.1/*;$SOARI_HOME/lib/hsqldb-1.8.0.8/*;$SOARI_HOME/lib/jade-3.5/*;$SOARI_HOME/lib/log4j-1.2.15/*;$SOARI_HOME/lib/protege-3.4.2/*;$SOARI_HOME/lib/repage/*;$SOARI_HOME/bin;$FOREART_HOME/lib/*;$FOREART_HOME/bin

$JAVA_HOME/bin/java -cp $CLASSPATH jade.Boot -port 5555 -gui LIARAgent:agents.jade.JADEAgent\("D:/Projects/workspace/soari" LIAR 100 20\) RepageAgent:agents.jade.JADEAgent\("D:/Projects/workspace/soari" REPAGE 100 450\)
