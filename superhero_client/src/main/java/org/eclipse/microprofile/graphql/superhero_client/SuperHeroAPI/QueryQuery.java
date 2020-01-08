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
import com.shopify.graphql.support.Arguments;

/**
 * Query root
 */
public class QueryQuery extends AbstractQuery<QueryQuery> {
    QueryQuery(StringBuilder _queryBuilder) {
        super(_queryBuilder);
    }

    public QueryQuery allHeroes(org.eclipse.microprofile.graphql.superhero_client.SuperHeroAPI.SuperHeroQueryDefinition queryDef) {
        startField("allHeroes");

        _queryBuilder.append('{');
        queryDef.define(new org.eclipse.microprofile.graphql.superhero_client.SuperHeroAPI.SuperHeroQuery(_queryBuilder));
        _queryBuilder.append('}');

        return this;
    }

    public class AllHeroesInArguments extends Arguments {
        AllHeroesInArguments(StringBuilder _queryBuilder) {
            super(_queryBuilder, true);
        }

        /**
         * 
         */
        public AllHeroesInArguments city(String value) {
            if (value != null) {
                startArgument("city");
                AbstractQuery.appendQuotedString(_queryBuilder, value.toString());
            }
            return this;
        }
    }

    public interface AllHeroesInArgumentsDefinition {
        void define(AllHeroesInArguments args);
    }

    public QueryQuery allHeroesIn(org.eclipse.microprofile.graphql.superhero_client.SuperHeroAPI.SuperHeroQueryDefinition queryDef) {
        return allHeroesIn(args -> {}, queryDef);
    }

    public QueryQuery allHeroesIn(AllHeroesInArgumentsDefinition argsDef, org.eclipse.microprofile.graphql.superhero_client.SuperHeroAPI.SuperHeroQueryDefinition queryDef) {
        startField("allHeroesIn");

        AllHeroesInArguments args = new AllHeroesInArguments(_queryBuilder);
        argsDef.define(args);
        AllHeroesInArguments.end(args);

        _queryBuilder.append('{');
        queryDef.define(new org.eclipse.microprofile.graphql.superhero_client.SuperHeroAPI.SuperHeroQuery(_queryBuilder));
        _queryBuilder.append('}');

        return this;
    }

    public class AllHeroesInTeamArguments extends Arguments {
        AllHeroesInTeamArguments(StringBuilder _queryBuilder) {
            super(_queryBuilder, true);
        }

        /**
         * 
         */
        public AllHeroesInTeamArguments team(String value) {
            if (value != null) {
                startArgument("team");
                AbstractQuery.appendQuotedString(_queryBuilder, value.toString());
            }
            return this;
        }
    }

    public interface AllHeroesInTeamArgumentsDefinition {
        void define(AllHeroesInTeamArguments args);
    }

    public QueryQuery allHeroesInTeam(org.eclipse.microprofile.graphql.superhero_client.SuperHeroAPI.SuperHeroQueryDefinition queryDef) {
        return allHeroesInTeam(args -> {}, queryDef);
    }

    public QueryQuery allHeroesInTeam(AllHeroesInTeamArgumentsDefinition argsDef, org.eclipse.microprofile.graphql.superhero_client.SuperHeroAPI.SuperHeroQueryDefinition queryDef) {
        startField("allHeroesInTeam");

        AllHeroesInTeamArguments args = new AllHeroesInTeamArguments(_queryBuilder);
        argsDef.define(args);
        AllHeroesInTeamArguments.end(args);

        _queryBuilder.append('{');
        queryDef.define(new org.eclipse.microprofile.graphql.superhero_client.SuperHeroAPI.SuperHeroQuery(_queryBuilder));
        _queryBuilder.append('}');

        return this;
    }

    public QueryQuery allHeroesWithError(org.eclipse.microprofile.graphql.superhero_client.SuperHeroAPI.SuperHeroQueryDefinition queryDef) {
        startField("allHeroesWithError");

        _queryBuilder.append('{');
        queryDef.define(new org.eclipse.microprofile.graphql.superhero_client.SuperHeroAPI.SuperHeroQuery(_queryBuilder));
        _queryBuilder.append('}');

        return this;
    }

    public class AllHeroesWithPowerArguments extends Arguments {
        AllHeroesWithPowerArguments(StringBuilder _queryBuilder) {
            super(_queryBuilder, true);
        }

        /**
         * 
         */
        public AllHeroesWithPowerArguments power(String value) {
            if (value != null) {
                startArgument("power");
                AbstractQuery.appendQuotedString(_queryBuilder, value.toString());
            }
            return this;
        }
    }

    public interface AllHeroesWithPowerArgumentsDefinition {
        void define(AllHeroesWithPowerArguments args);
    }

    public QueryQuery allHeroesWithPower(org.eclipse.microprofile.graphql.superhero_client.SuperHeroAPI.SuperHeroQueryDefinition queryDef) {
        return allHeroesWithPower(args -> {}, queryDef);
    }

    public QueryQuery allHeroesWithPower(AllHeroesWithPowerArgumentsDefinition argsDef, org.eclipse.microprofile.graphql.superhero_client.SuperHeroAPI.SuperHeroQueryDefinition queryDef) {
        startField("allHeroesWithPower");

        AllHeroesWithPowerArguments args = new AllHeroesWithPowerArguments(_queryBuilder);
        argsDef.define(args);
        AllHeroesWithPowerArguments.end(args);

        _queryBuilder.append('{');
        queryDef.define(new org.eclipse.microprofile.graphql.superhero_client.SuperHeroAPI.SuperHeroQuery(_queryBuilder));
        _queryBuilder.append('}');

        return this;
    }

    public QueryQuery allHeroesWithSpecificError(org.eclipse.microprofile.graphql.superhero_client.SuperHeroAPI.SuperHeroQueryDefinition queryDef) {
        startField("allHeroesWithSpecificError");

        _queryBuilder.append('{');
        queryDef.define(new org.eclipse.microprofile.graphql.superhero_client.SuperHeroAPI.SuperHeroQuery(_queryBuilder));
        _queryBuilder.append('}');

        return this;
    }

    public QueryQuery allTeams(org.eclipse.microprofile.graphql.superhero_client.SuperHeroAPI.TeamQueryDefinition queryDef) {
        startField("allTeams");

        _queryBuilder.append('{');
        queryDef.define(new org.eclipse.microprofile.graphql.superhero_client.SuperHeroAPI.TeamQuery(_queryBuilder));
        _queryBuilder.append('}');

        return this;
    }

    public class CharacterArguments extends Arguments {
        CharacterArguments(StringBuilder _queryBuilder) {
            super(_queryBuilder, true);
        }

        /**
         * 
         */
        public CharacterArguments name(String value) {
            if (value != null) {
                startArgument("name");
                AbstractQuery.appendQuotedString(_queryBuilder, value.toString());
            }
            return this;
        }
    }

    public interface CharacterArgumentsDefinition {
        void define(CharacterArguments args);
    }

    public QueryQuery character(CharacterQueryDefinition queryDef) {
        return character(args -> {}, queryDef);
    }

    public QueryQuery character(CharacterArgumentsDefinition argsDef, CharacterQueryDefinition queryDef) {
        startField("character");

        CharacterArguments args = new CharacterArguments(_queryBuilder);
        argsDef.define(args);
        CharacterArguments.end(args);

        _queryBuilder.append('{');
        queryDef.define(new CharacterQuery(_queryBuilder));
        _queryBuilder.append('}');

        return this;
    }

    public class SuperHeroArguments extends Arguments {
        SuperHeroArguments(StringBuilder _queryBuilder) {
            super(_queryBuilder, true);
        }

        /**
         * 
         */
        public SuperHeroArguments name(String value) {
            if (value != null) {
                startArgument("name");
                AbstractQuery.appendQuotedString(_queryBuilder, value.toString());
            }
            return this;
        }
    }

    public interface SuperHeroArgumentsDefinition {
        void define(SuperHeroArguments args);
    }

    public QueryQuery superHero(org.eclipse.microprofile.graphql.superhero_client.SuperHeroAPI.SuperHeroQueryDefinition queryDef) {
        return superHero(args -> {}, queryDef);
    }

    public QueryQuery superHero(SuperHeroArgumentsDefinition argsDef, org.eclipse.microprofile.graphql.superhero_client.SuperHeroAPI.SuperHeroQueryDefinition queryDef) {
        startField("superHero");

        SuperHeroArguments args = new SuperHeroArguments(_queryBuilder);
        argsDef.define(args);
        SuperHeroArguments.end(args);

        _queryBuilder.append('{');
        queryDef.define(new org.eclipse.microprofile.graphql.superhero_client.SuperHeroAPI.SuperHeroQuery(_queryBuilder));
        _queryBuilder.append('}');

        return this;
    }

    public String toString() {
        return _queryBuilder.toString();
    }
}
