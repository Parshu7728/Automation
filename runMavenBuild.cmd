@echo off
SETLOCAL

:: Set project directory explicitly
cd /d "E:\AutomationAGC\Automation"

echo 🔍 Checking for pom.xml in %CD%...
IF EXIST "pom.xml" (
    echo ✅ pom.xml found.
    echo 🚀 Running: mvn clean install
    mvn clean install
) ELSE (
    echo ❌ pom.xml not found in %CD%
    echo Please check the path or your Maven project setup.
)

ENDLOCAL
pause
