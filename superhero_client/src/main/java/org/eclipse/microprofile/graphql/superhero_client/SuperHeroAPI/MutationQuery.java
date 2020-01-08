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
 * Mutation root
 */
public class MutationQuery extends AbstractQuery<MutationQuery> {
    MutationQuery(StringBuilder _queryBuilder) {
        super(_queryBuilder);
    }

    public class AddHeroToTeamArguments extends Arguments {
        AddHeroToTeamArguments(StringBuilder _queryBuilder) {
            super(_queryBuilder, true);
        }

        /**
         * 
         */
        public AddHeroToTeamArguments hero(String value) {
            if (value != null) {
                startArgument("hero");
                AbstractQuery.appendQuotedString(_queryBuilder, value.toString());
            }
            return this;
        }

        /**
         * 
         */
        public AddHeroToTeamArguments team(String value) {
            if (value != null) {
                startArgument("team");
                AbstractQuery.appendQuotedString(_queryBuilder, value.toString());
            }
            return this;
        }
    }

    public interface AddHeroToTeamArgumentsDefinition {
        void define(AddHeroToTeamArguments args);
    }

    /**
     * Adds a hero to the specified team and returns the updated team.
     */
    public MutationQuery addHeroToTeam(org.eclipse.microprofile.graphql.superhero_client.SuperHeroAPI.TeamQueryDefinition queryDef) {
        return addHeroToTeam(args -> {}, queryDef);
    }

    /**
     * Adds a hero to the specified team and returns the updated team.
     */
    public MutationQuery addHeroToTeam(AddHeroToTeamArgumentsDefinition argsDef, org.eclipse.microprofile.graphql.superhero_client.SuperHeroAPI.TeamQueryDefinition queryDef) {
        startField("addHeroToTeam");

        AddHeroToTeamArguments args = new AddHeroToTeamArguments(_queryBuilder);
        argsDef.define(args);
        AddHeroToTeamArguments.end(args);

        _queryBuilder.append('{');
        queryDef.define(new org.eclipse.microprofile.graphql.superhero_client.SuperHeroAPI.TeamQuery(_queryBuilder));
        _queryBuilder.append('}');

        return this;
    }

    public class CreateNewHeroArguments extends Arguments {
        CreateNewHeroArguments(StringBuilder _queryBuilder) {
            super(_queryBuilder, true);
        }

        /**
         * 
         */
        public CreateNewHeroArguments hero(org.eclipse.microprofile.graphql.superhero_client.SuperHeroAPI.SuperHeroInput value) {
            if (value != null) {
                startArgument("hero");
                value.appendTo(_queryBuilder);
            }
            return this;
        }
    }

    public interface CreateNewHeroArgumentsDefinition {
        void define(CreateNewHeroArguments args);
    }

    public MutationQuery createNewHero(org.eclipse.microprofile.graphql.superhero_client.SuperHeroAPI.SuperHeroQueryDefinition queryDef) {
        return createNewHero(args -> {}, queryDef);
    }

    public MutationQuery createNewHero(CreateNewHeroArgumentsDefinition argsDef, org.eclipse.microprofile.graphql.superhero_client.SuperHeroAPI.SuperHeroQueryDefinition queryDef) {
        startField("createNewHero");

        CreateNewHeroArguments args = new CreateNewHeroArguments(_queryBuilder);
        argsDef.define(args);
        CreateNewHeroArguments.end(args);

        _queryBuilder.append('{');
        queryDef.define(new org.eclipse.microprofile.graphql.superhero_client.SuperHeroAPI.SuperHeroQuery(_queryBuilder));
        _queryBuilder.append('}');

        return this;
    }

    public class ProvisionHeroArguments extends Arguments {
        ProvisionHeroArguments(StringBuilder _queryBuilder) {
            super(_queryBuilder, true);
        }

        /**
         * 
         */
        public ProvisionHeroArguments item(ItemInput value) {
            if (value != null) {
                startArgument("item");
                value.appendTo(_queryBuilder);
            }
            return this;
        }

        /**
         * 
         */
        public ProvisionHeroArguments hero(String value) {
            if (value != null) {
                startArgument("hero");
                AbstractQuery.appendQuotedString(_queryBuilder, value.toString());
            }
            return this;
        }
    }

    public interface ProvisionHeroArgumentsDefinition {
        void define(ProvisionHeroArguments args);
    }

    /**
     * Gives a hero new equipment
     */
    public MutationQuery provisionHero(org.eclipse.microprofile.graphql.superhero_client.SuperHeroAPI.SuperHeroQueryDefinition queryDef) {
        return provisionHero(args -> {}, queryDef);
    }

    /**
     * Gives a hero new equipment
     */
    public MutationQuery provisionHero(ProvisionHeroArgumentsDefinition argsDef, org.eclipse.microprofile.graphql.superhero_client.SuperHeroAPI.SuperHeroQueryDefinition queryDef) {
        startField("provisionHero");

        ProvisionHeroArguments args = new ProvisionHeroArguments(_queryBuilder);
        argsDef.define(args);
        ProvisionHeroArguments.end(args);

        _queryBuilder.append('{');
        queryDef.define(new org.eclipse.microprofile.graphql.superhero_client.SuperHeroAPI.SuperHeroQuery(_queryBuilder));
        _queryBuilder.append('}');

        return this;
    }

    public class RemoveHeroArguments extends Arguments {
        RemoveHeroArguments(StringBuilder _queryBuilder) {
            super(_queryBuilder, true);
        }

        /**
         * 
         */
        public RemoveHeroArguments hero(String value) {
            if (value != null) {
                startArgument("hero");
                AbstractQuery.appendQuotedString(_queryBuilder, value.toString());
            }
            return this;
        }
    }

    public interface RemoveHeroArgumentsDefinition {
        void define(RemoveHeroArguments args);
    }

    /**
     * Removes a hero... permanently...
     */
    public MutationQuery removeHero(org.eclipse.microprofile.graphql.superhero_client.SuperHeroAPI.SuperHeroQueryDefinition queryDef) {
        return removeHero(args -> {}, queryDef);
    }

    /**
     * Removes a hero... permanently...
     */
    public MutationQuery removeHero(RemoveHeroArgumentsDefinition argsDef, org.eclipse.microprofile.graphql.superhero_client.SuperHeroAPI.SuperHeroQueryDefinition queryDef) {
        startField("removeHero");

        RemoveHeroArguments args = new RemoveHeroArguments(_queryBuilder);
        argsDef.define(args);
        RemoveHeroArguments.end(args);

        _queryBuilder.append('{');
        queryDef.define(new org.eclipse.microprofile.graphql.superhero_client.SuperHeroAPI.SuperHeroQuery(_queryBuilder));
        _queryBuilder.append('}');

        return this;
    }

    public class RemoveHeroFromTeamArguments extends Arguments {
        RemoveHeroFromTeamArguments(StringBuilder _queryBuilder) {
            super(_queryBuilder, true);
        }

        /**
         * 
         */
        public RemoveHeroFromTeamArguments hero(String value) {
            if (value != null) {
                startArgument("hero");
                AbstractQuery.appendQuotedString(_queryBuilder, value.toString());
            }
            return this;
        }

        /**
         * 
         */
        public RemoveHeroFromTeamArguments team(String value) {
            if (value != null) {
                startArgument("team");
                AbstractQuery.appendQuotedString(_queryBuilder, value.toString());
            }
            return this;
        }
    }

    public interface RemoveHeroFromTeamArgumentsDefinition {
        void define(RemoveHeroFromTeamArguments args);
    }

    /**
     * Removes a hero to the specified team and returns the updated team.
     */
    public MutationQuery removeHeroFromTeam(org.eclipse.microprofile.graphql.superhero_client.SuperHeroAPI.TeamQueryDefinition queryDef) {
        return removeHeroFromTeam(args -> {}, queryDef);
    }

    /**
     * Removes a hero to the specified team and returns the updated team.
     */
    public MutationQuery removeHeroFromTeam(RemoveHeroFromTeamArgumentsDefinition argsDef, org.eclipse.microprofile.graphql.superhero_client.SuperHeroAPI.TeamQueryDefinition queryDef) {
        startField("removeHeroFromTeam");

        RemoveHeroFromTeamArguments args = new RemoveHeroFromTeamArguments(_queryBuilder);
        argsDef.define(args);
        RemoveHeroFromTeamArguments.end(args);

        _queryBuilder.append('{');
        queryDef.define(new org.eclipse.microprofile.graphql.superhero_client.SuperHeroAPI.TeamQuery(_queryBuilder));
        _queryBuilder.append('}');

        return this;
    }

    public class RemoveItemFromHeroArguments extends Arguments {
        RemoveItemFromHeroArguments(StringBuilder _queryBuilder) {
            super(_queryBuilder, false);
        }

        /**
         * 
         */
        public RemoveItemFromHeroArguments hero(String value) {
            if (value != null) {
                startArgument("hero");
                AbstractQuery.appendQuotedString(_queryBuilder, value.toString());
            }
            return this;
        }
    }

    public interface RemoveItemFromHeroArgumentsDefinition {
        void define(RemoveItemFromHeroArguments args);
    }

    /**
     * Removes equipment from a hero
     */
    public MutationQuery removeItemFromHero(String itemId, org.eclipse.microprofile.graphql.superhero_client.SuperHeroAPI.SuperHeroQueryDefinition queryDef) {
        return removeItemFromHero(itemId, args -> {}, queryDef);
    }

    /**
     * Removes equipment from a hero
     */
    public MutationQuery removeItemFromHero(String itemId, RemoveItemFromHeroArgumentsDefinition argsDef, org.eclipse.microprofile.graphql.superhero_client.SuperHeroAPI.SuperHeroQueryDefinition queryDef) {
        startField("removeItemFromHero");

        _queryBuilder.append("(itemID:");
        AbstractQuery.appendQuotedString(_queryBuilder, itemId.toString());

        argsDef.define(new RemoveItemFromHeroArguments(_queryBuilder));

        _queryBuilder.append(')');

        _queryBuilder.append('{');
        queryDef.define(new org.eclipse.microprofile.graphql.superhero_client.SuperHeroAPI.SuperHeroQuery(_queryBuilder));
        _queryBuilder.append('}');

        return this;
    }

    public class SetRivalTeamArguments extends Arguments {
        SetRivalTeamArguments(StringBuilder _queryBuilder) {
            super(_queryBuilder, true);
        }

        /**
         * 
         */
        public SetRivalTeamArguments teamName(String value) {
            if (value != null) {
                startArgument("teamName");
                AbstractQuery.appendQuotedString(_queryBuilder, value.toString());
            }
            return this;
        }

        /**
         * 
         */
        public SetRivalTeamArguments rivalTeam(org.eclipse.microprofile.graphql.superhero_client.SuperHeroAPI.TeamInput value) {
            if (value != null) {
                startArgument("rivalTeam");
                value.appendTo(_queryBuilder);
            }
            return this;
        }
    }

    public interface SetRivalTeamArgumentsDefinition {
        void define(SetRivalTeamArguments args);
    }

    public MutationQuery setRivalTeam(org.eclipse.microprofile.graphql.superhero_client.SuperHeroAPI.TeamQueryDefinition queryDef) {
        return setRivalTeam(args -> {}, queryDef);
    }

    public MutationQuery setRivalTeam(SetRivalTeamArgumentsDefinition argsDef, org.eclipse.microprofile.graphql.superhero_client.SuperHeroAPI.TeamQueryDefinition queryDef) {
        startField("setRivalTeam");

        SetRivalTeamArguments args = new SetRivalTeamArguments(_queryBuilder);
        argsDef.define(args);
        SetRivalTeamArguments.end(args);

        _queryBuilder.append('{');
        queryDef.define(new org.eclipse.microprofile.graphql.superhero_client.SuperHeroAPI.TeamQuery(_queryBuilder));
        _queryBuilder.append('}');

        return this;
    }

    public class UpdateItemPowerLevelArguments extends Arguments {
        UpdateItemPowerLevelArguments(StringBuilder _queryBuilder) {
            super(_queryBuilder, false);
        }

        /**
         * 
         */
        public UpdateItemPowerLevelArguments powerLevel(Integer value) {
            if (value != null) {
                startArgument("powerLevel");
                _queryBuilder.append(value);
            }
            return this;
        }
    }

    public interface UpdateItemPowerLevelArgumentsDefinition {
        void define(UpdateItemPowerLevelArguments args);
    }

    /**
     * Update an item&#39;s powerLevel
     */
    public MutationQuery updateItemPowerLevel(String itemId, ItemQueryDefinition queryDef) {
        return updateItemPowerLevel(itemId, args -> {}, queryDef);
    }

    /**
     * Update an item&#39;s powerLevel
     */
    public MutationQuery updateItemPowerLevel(String itemId, UpdateItemPowerLevelArgumentsDefinition argsDef, ItemQueryDefinition queryDef) {
        startField("updateItemPowerLevel");

        _queryBuilder.append("(itemID:");
        AbstractQuery.appendQuotedString(_queryBuilder, itemId.toString());

        argsDef.define(new UpdateItemPowerLevelArguments(_queryBuilder));

        _queryBuilder.append(')');

        _queryBuilder.append('{');
        queryDef.define(new ItemQuery(_queryBuilder));
        _queryBuilder.append('}');

        return this;
    }

    public String toString() {
        return _queryBuilder.toString();
    }
}
