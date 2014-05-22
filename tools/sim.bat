@ECHO OFF
SET JAVA_HOME=C:\Java\jdk1.6.0_16
SET FOREART_HOME=D:\Education\Mestrado\workspace\FOReARTTestbed
SET OTSERVICES_HOME=D:\Education\Mestrado\workspace\OTServices

SET CLASSPATH=.;%JAVA_HOME%\lib\dt.jar;%JAVA_HOME%\lib\tools.jar;%JAVA_HOME%\jre\lib\rt.jar;%OTSERVICES_HOME%\lib\axis2-1.5.1\*;%OTSERVICES_HOME%\lib\edu.stanford.smi.protegex.owl\*;%OTSERVICES_HOME%\lib\edu.standford.smi.protegex.owl.inference.pellet\*;%OTSERVICES_HOME%\lib\hsqldb-1.8.0.8\*;%OTSERVICES_HOME%\lib\jade-3.5\*;%OTSERVICES_HOME%\lib\log4j-1.2.15\*;%OTSERVICES_HOME%\lib\protege-3.4.2\*;%OTSERVICES_HOME%\lib\repage\*;%OTSERVICES_HOME%\bin;%FOREART_HOME%\lib\*;%FOREART_HOME%\bin

IF "%1" == "" %JAVA_HOME%\bin\java -Xms1512m -Xmx1512m testbed.sim.Sim D:\Mestrado\workspace\FOReARTTestbed\config\game-config.xml
IF NOT "%1" == "" %JAVA_HOME%\bin\java -Xms1512 -Xmx1512m testbed.sim.Sim %1
