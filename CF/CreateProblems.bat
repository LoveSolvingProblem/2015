:: Ref
:: http://www.robvanderwoude.com/batchfiles.php
:: http://www.robvanderwoude.com/battech.php
@ECHO OFF
SET /P ID="Contest Id: "
MKDIR %ID%
SET SOURCE=Library\Template.java
SET TARGETPRE=%ID%\P%ID%
:: COPY %SOURCE% %TARGETPRE%A.java
:: COPY %SOURCE% %TARGETPRE%B.java
:: COPY %SOURCE% %TARGETPRE%C.java
:: COPY %SOURCE% %TARGETPRE%D.java
:: COPY %SOURCE% %TARGETPRE%E.java
:: powershell -Command "(gc %TARGETPRE%A.java) -replace 'public class Template', 'public class P%ID%A' | Out-File %TARGETPRE%A.java"
FOR %%A IN (A B C D E) DO (
	COPY %SOURCE% %TARGETPRE%%%A.java
	powershell -Command "(gc %TARGETPRE%%%A.java) -replace 'public class Template', 'public class P%ID%%%A' | Out-File %TARGETPRE%%%A.java"
)
SET /P ID="Enter to exit"
