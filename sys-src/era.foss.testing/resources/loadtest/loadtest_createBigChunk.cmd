@echo off

FOR /L %%I IN (100000,1,150000) DO (
echo INFO: %%I 1>&2
echo    ^<specObjects iD="%%I_so" type="//@coreContent/@specTypes.0"^>
echo      ^<values xsi:type="era.foss.erf:AttributeValueSimple" iD="%%I_vA" definition="//@coreContent/@specTypes.0/@specAttributes.0" theValue="%%I"/^>
echo      ^<values xsi:type="era.foss.erf:AttributeValueSimple" iD="%%I_vB" definition="//@coreContent/@specTypes.0/@specAttributes.1" theValue="lol"/^>
echo    ^</specObjects^>
)
