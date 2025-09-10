@echo off
echo Setting up JBang PATH for current session...
set PATH=%PATH%;C:\jbang\jbang\bin
echo JBang PATH added successfully!
echo Testing JBang...
jbang --version
echo.
echo JBang is now ready to use in this session!
echo For permanent setup, the PATH has already been added to your user environment variables.
echo Just restart your Command Prompt for it to work automatically.
pause