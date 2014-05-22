#!/bin/bash
export JAVA_HOME=/soft/jdk1.6.0_16

export FOREART_HOME=/media/data/Projects/workspace/FOReARTTestbed
export SOARI_HOME=/media/data/Projects/workspace/soari

export CLASSPATH=.:$JAVA_HOME/lib/dt.jar:$JAVA_HOME/lib/tools.jar:$JAVA_HOME/jre/lib/rt.jar:$SOARI_HOME/lib/edu.stanford.smi.protegex.owl/*:$SOARI_HOME/lib/edu.standford.smi.protegex.owl.inference.pellet/*:$SOARI_HOME/lib/axis2-1.5.1/*:$SOARI_HOME/lib/hsqldb-1.8.0.8/*:$SOARI_HOME/lib/jade-3.5/*:$SOARI_HOME/lib/log4j-1.2.15/*:$SOARI_HOME/lib/protege-3.4.4/*:$SOARI_HOME/lib/repage/*:$SOARI_HOME/bin:$FOREART_HOME/lib/*:$FOREART_HOME/bin

#for i in 01 02 03 04 05 06 07 08 09 10
#do
#$JAVA_HOME/bin/java -Xmx1024m testbed.sim.Sim /media/data/Projects/workspace/FOReARTTestbed/config/cheater100/ARTLIAR/game-config_ARTliar_$i.xml
#done

#for i in 01 02 03 04 05 06 07 08 09 10
#do
#$JAVA_HOME/bin/java -Xmx1024m testbed.sim.Sim /media/data/Projects/workspace/FOReARTTestbed/config/cheater100/ARTRepage/game-config_ARTrepage_$i.xml
#done

#for i in 01 02 03 04 05 06 07 08 09 10
#do
#$JAVA_HOME/bin/java -Xmx1024m testbed.sim.Sim /media/data/Projects/workspace/FOReARTTestbed/config/cheater100/ARTTypology/game-config_ARTtypology_$i.xml
#done

#for i in 01 02 03 04 05 06 07 08 09 10
#do
#$JAVA_HOME/bin/java -Xmx1024m testbed.sim.Sim /media/data/Projects/workspace/FOReARTTestbed/config/cheater100/ARTMixedLIAR/game-config_ARTmixedliar_$i.xml
#done

#for i in 01 02 03 04 05 06 07 08 09 10
#do
#$JAVA_HOME/bin/java -Xmx1024m testbed.sim.Sim /media/data/Projects/workspace/FOReARTTestbed/config/cheater100/ARTMixedRepage/game-config_ARTmixedrepage_$i.xml
#done

#for i in 01 02 03 04 05 06 07 08 09 10
#do
#$JAVA_HOME/bin/java -Xmx1024m testbed.sim.Sim /media/data/Projects/workspace/FOReARTTestbed/config/cheater100/ARTMixedTypology/game-config_ARTmixedtypology_$i.xml
#done

for i in 01 02 03 04 05 06 07 08 09 10
do
$JAVA_HOME/bin/java -Xmx1024m testbed.sim.Sim /media/data/Projects/workspace/FOReARTTestbed/config/cheater100/FOReARTLIAR/game-config_FOReARTliar_$i.xml
done

for i in 01 02 03 04 05 06 07 08 09 10
do
$JAVA_HOME/bin/java -Xmx1024m testbed.sim.Sim /media/data/Projects/workspace/FOReARTTestbed/config/cheater100/FOReARTRepage/game-config_FOReARTrepage_$i.xml
done

for i in 01 02 03 04 05 06 07 08 09 10
do
$JAVA_HOME/bin/java -Xmx1024m testbed.sim.Sim /media/data/Projects/workspace/FOReARTTestbed/config/cheater100/FOReARTTypology/game-config_FOReARTtypology_$i.xml
done

for i in 01 02 03 04 05 06 07 08 09 10
do
$JAVA_HOME/bin/java -Xmx1024m testbed.sim.Sim /media/data/Projects/workspace/FOReARTTestbed/config/cheater100/FOReARTMixedLIAR/game-config_FOReARTmixedliar_$i.xml
done

for i in 01 02 03 04 05 06 07 08 09 10
do
$JAVA_HOME/bin/java -Xmx1024m testbed.sim.Sim /media/data/Projects/workspace/FOReARTTestbed/config/cheater100/FOReARTMixedRepage/game-config_FOReARTmixedrepage_$i.xml
done

for i in 01 02 03 04 05 06 07 08 09 10
do
$JAVA_HOME/bin/java -Xmx1024m testbed.sim.Sim /media/data/Projects/workspace/FOReARTTestbed/config/cheater100/FOReARTMixedTypology/game-config_FOReARTmixedtypology_$i.xml
done
