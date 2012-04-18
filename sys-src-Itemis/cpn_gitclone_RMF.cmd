@echo off

rem READ: https://bugs.eclipse.org/bugs/show_bug.cgi?id=370542
set GITROOT=git://git.eclipse.org/gitroot/rmf
set GITREPS=org.eclipse.rmf.git

for %%R in (%GITREPS%) do (
	cmd /D/C git clone %GITROOT%/%%R
)

pause