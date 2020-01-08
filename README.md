# microprofile-graphql-client
Maven plugin to generate a MicroProfile GraphQL client in Java

# Steps to build & run locally
1. graphql-spqr ```mvn clean install``` to install the graphql-spqr version "1.0-microprofile-proto" locally
2. superhero_server ``mvn clean install -Pthorntail`` to start the superhero graphql server using thorntail
3. superhero_client ```mvn clean install exec:java``` to run the superhero client Main class

