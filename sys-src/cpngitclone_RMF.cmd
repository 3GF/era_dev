@echo off

set GITROOT=git://git.eclipse.org/gitroot/rmf
set GITREPS=org.eclipse.modeling.rmf.core.git org.eclipse.modeling.rmf.core.reqif10.git org.eclipse.modeling.rmf.core.rif11.git org.eclipse.modeling.rmf.core.rif12.git org.eclipse.modeling.rmf.pror.reqif10.git

for %%R in (%GITREPS%) do (
	cmd /D/C git clone %GITROOT%/%%R
)

pause