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
public class SuperHeroQuery extends AbstractQuery<SuperHeroQuery> {
    SuperHeroQuery(StringBuilder _queryBuilder) {
        super(_queryBuilder);
    }

    public SuperHeroQuery currentLocation() {
        startField("currentLocation");

        return this;
    }

    public SuperHeroQuery equipment(ItemQueryDefinition queryDef) {
        startField("equipment");

        _queryBuilder.append('{');
        queryDef.define(new ItemQuery(_queryBuilder));
        _queryBuilder.append('}');

        return this;
    }

    public SuperHeroQuery name() {
        startField("name");

        return this;
    }

    public SuperHeroQuery primaryLocation() {
        startField("primaryLocation");

        return this;
    }

    public SuperHeroQuery realName() {
        startField("realName");

        return this;
    }

    public SuperHeroQuery superPowers() {
        startField("superPowers");

        return this;
    }

    public SuperHeroQuery teamAffiliations(org.eclipse.microprofile.graphql.superhero_client.SuperHeroAPI.TeamQueryDefinition queryDef) {
        startField("teamAffiliations");

        _queryBuilder.append('{');
        queryDef.define(new org.eclipse.microprofile.graphql.superhero_client.SuperHeroAPI.TeamQuery(_queryBuilder));
        _queryBuilder.append('}');

        return this;
    }
}
