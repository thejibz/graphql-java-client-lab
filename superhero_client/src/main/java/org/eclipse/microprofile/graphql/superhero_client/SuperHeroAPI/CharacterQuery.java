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

package org.eclipse.microprofile.graphql.superhero_client.SuperHeroAPI;

import com.shopify.graphql.support.AbstractQuery;

/**
 * 
 */
public class CharacterQuery extends AbstractQuery<CharacterQuery> {
    CharacterQuery(StringBuilder _queryBuilder) {
        super(_queryBuilder);

        startField("__typename");
    }

    public CharacterQuery name() {
        startField("name");

        return this;
    }

    public CharacterQuery onSidekick(org.eclipse.microprofile.graphql.superhero_client.SuperHeroAPI.SidekickQueryDefinition queryDef) {
        startInlineFragment("Sidekick");
        queryDef.define(new org.eclipse.microprofile.graphql.superhero_client.SuperHeroAPI.SidekickQuery(_queryBuilder));
        _queryBuilder.append('}');
        return this;
    }

    public CharacterQuery onSuperHero(org.eclipse.microprofile.graphql.superhero_client.SuperHeroAPI.SuperHeroQueryDefinition queryDef) {
        startInlineFragment("SuperHero");
        queryDef.define(new org.eclipse.microprofile.graphql.superhero_client.SuperHeroAPI.SuperHeroQuery(_queryBuilder));
        _queryBuilder.append('}');
        return this;
    }
}
