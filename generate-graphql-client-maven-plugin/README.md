# Test
In a directory containing a pom.xml: 

``mvn org.eclipse.microprofile.graphql:generate -DpathToSchema=src/main/resources/superhero.json -DlicenseHeaderFilePath=src/main/resources/License.erb -DoutputPackageName=titi -DoutputDirPath=tutu``

If plugin groupId in .m2/settings.xml, short way available:

``mvn generate-graphql-client:generate -DpathToSchema=src/main/resources/superhero.json -DlicenseHeaderFilePath=src/main/resources/License.erb -DoutputPackageName=titi -DoutputDirPath=tutu``