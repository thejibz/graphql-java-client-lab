# Test
In a directory containing a pom.xml: 

``mvn org.eclipse.microprofile.graphql:generate -DpathToSchema=src/main/resources/superhero.json -DlicenseHeaderFilePath=src/main/resources/License.erb -DoutputPackageName=com.myapp.superhero -DoutputDirPath=target/DTO``

If plugin groupId in .m2/settings.xml, short way available:

``mvn generate-graphql-client:generate -DpathToSchema=src/main/resources/superhero.json -DlicenseHeaderFilePath=src/main/resources/License.erb -DoutputPackageName=com.myapp.superhero -DoutputDirPath=target/DTO``

# TODO
* Use ruby generator for the GQLClient.java file too
    * Add tokenized package name to the file (like it is done for DTO files)