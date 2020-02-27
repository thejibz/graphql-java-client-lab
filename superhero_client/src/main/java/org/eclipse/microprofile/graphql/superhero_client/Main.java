/*
 * Copyright (c) 2019 Contributors to the Eclipse Foundation
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.eclipse.microprofile.graphql.superhero_client;

import org.eclipse.microprofile.graphql.superhero_client.SuperHeroAPI.GQLClient;
import org.eclipse.microprofile.graphql.superhero_client.SuperHeroAPI.Operations;
import org.eclipse.microprofile.graphql.superhero_client.SuperHeroAPI.QueryQuery;
import org.eclipse.microprofile.graphql.superhero_client.SuperHeroAPI.QueryResponse;
import org.eclipse.microprofile.graphql.superhero_client.SuperHeroAPI.SuperHeroQueryDefinition;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Main {
    private static final Logger LOGGER = LoggerFactory.getLogger(Main.class);

    public static void main(String[] args) throws Exception {

        testFork();
    }

    public static void testFork() throws Exception {
        QueryQuery.AllHeroesInArgumentsDefinition searchArgs = s -> s.city("Los Angeles, CA");

        SuperHeroQueryDefinition queryArgs = q -> q
                .currentLocation()
                .name()
                .superPowers()
                .teamAffiliations(tA -> tA
                        .name()
                        .members(m -> m.name())
                );

        QueryQuery query = Operations.query(q -> q
                .allHeroesIn(searchArgs, queryArgs)
        );


        GQLClient client = new GQLClient(() -> "http://localhost:8080/graphql");
        QueryResponse response = client.execute(query);

        LOGGER.info(response.getData().getAllHeroesIn().get(0).getName());
        LOGGER.info(response.prettyPrintJson());
    }
}

