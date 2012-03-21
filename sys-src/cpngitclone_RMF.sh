#!/bin/bash

GITROOT=git://git.eclipse.org/gitroot/rmf
GITREPS="org.eclipse.modeling.rmf.core.git org.eclipse.modeling.rmf.core.reqif10.git org.eclipse.modeling.rmf.core.rif11.git org.eclipse.modeling.rmf.core.rif12.git org.eclipse.modeling.rmf.pror.reqif10.git"

for iter in $GITREPS
do
	git clone $GITROOT/$iter
done
