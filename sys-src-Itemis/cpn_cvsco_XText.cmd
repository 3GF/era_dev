@echo off

set CVSROOT=:pserver:anonymous@dev.eclipse.org:/cvsroot/modeling
set MODULES=org.eclipse.tmf

for %%M in (%MODULES%) do (
	cmd /D/C cvs checkout %%M
)

pause