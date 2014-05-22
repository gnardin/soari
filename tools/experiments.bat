SET CLASSPATH=%CLASSPATH%;D:\Education\Mestrado\workspace\FOReARTTestbed\lib\*;D:\Education\Mestrado\workspace\OTServices\lib\*;D:\Education\Mestrado\workspace\FOReARTTestbed\bin;D:\Education\Mestrado\workspace\OTServices\bin

FOR %%i IN (01 02 03 04 05 06 07 08 09 10) DO %JAVA_HOME%\bin\java -Xmx1024m testbed.sim.Sim D:\Education\Mestrado\workspace\FOReARTTestbed\config\ARTLIAR\game-config_ARTliar_%%i.xml

FOR %%i IN (01 02 03 04 05 06 07 08 09 10) DO %JAVA_HOME%\bin\java -Xmx1024m testbed.sim.Sim D:\Education\Mestrado\workspace\FOReARTTestbed\config\ARTMixedLIAR\game-config_ARTmixedliar_%%i.xml

FOR %%i IN (01 02 03 04 05 06 07 08 09 10) DO %JAVA_HOME%\bin\java -Xmx1024m testbed.sim.Sim D:\Education\Mestrado\workspace\FOReARTTestbed\config\ARTMixedRepage\game-config_ARTmixedrepage_%%i.xml

FOR %%i IN (01 02 03 04 05 06 07 08 09 10) DO %JAVA_HOME%\bin\java -Xmx1024m testbed.sim.Sim D:\Education\Mestrado\workspace\FOReARTTestbed\config\ARTRepage\game-config_ARTrepage_%%i.xml

REM FOR %%i IN (01 02 03 04 05 06 07 08 09 10) DO %JAVA_HOME%\bin\java -Xmx1024m testbed.sim.Sim D:\Education\Mestrado\workspace\FOReARTTestbed\config\FOReARTLIAR\game-config_FOReARTliar_%%i.xml

REM FOR %%i IN (01 02 03 04 05 06 07 08 09 10) DO %JAVA_HOME%\bin\java -Xmx1024m testbed.sim.Sim D:\Education\Mestrado\workspace\FOReARTTestbed\config\FOReARTMixedLIAR\game-config_FOReARTmixedliar_%%i.xml

REM FOR %%i IN (01 02 03 04 05 06 07 08 09 10) DO %JAVA_HOME%\bin\java -Xmx1024m testbed.sim.Sim D:\Education\Mestrado\workspace\FOReARTTestbed\config\FOReARTMixedRepage\game-config_FOReARTmixedrepage_%%i.xml

REM FOR %%i IN (01 02 03 04 05 06 07 08 09 10) DO %JAVA_HOME%\bin\java -Xmx1024m testbed.sim.Sim D:\Education\Mestrado\workspace\FOReARTTestbed\config\FOReARTRepage\game-config_FOReARTrepage_%%i.xml