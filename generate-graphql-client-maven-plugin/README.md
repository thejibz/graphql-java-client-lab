# Test
In a directory containing a pom.xml: 

``mvn org.eclipse.microprofile.graphql:generate-graphql-client-maven-plugin:1.0.0-SNAPSHOT:dependency-counter  -Dscope=test``

If groupId in .m2/settings.xml, short way available:

``mvn generate-graphql-client:dependency-counter -Dscope=test``