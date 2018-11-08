call runcrud.bat
if "%ERRORLEVEL%" == "0"
echo.
echo runcrud.bat not started

start chrome "http://localhost:8080/crud/v1/task/getTasks"