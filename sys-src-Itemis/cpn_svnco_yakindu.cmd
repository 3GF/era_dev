@echo off

set MODULES=BASE DAMOS SCT2

for %%M in (%MODULES%) do (
	cmd /D/C svn checkout http://svn.codespot.com/a/eclipselabs.org/yakindu/%%M/trunk yakindu_%%M_devT
)