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

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.shopify.graphql.support.AbstractResponse;
import com.shopify.graphql.support.SchemaViolationError;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Mutation root
 */
public class Mutation extends AbstractResponse<Mutation> {
    public Mutation() {
    }

    public Mutation(JsonObject fields) throws SchemaViolationError {
        for (Map.Entry<String, JsonElement> field : fields.entrySet()) {
            String key = field.getKey();
            String fieldName = getFieldName(key);
            switch (fieldName) {
                case "setRivalTeam": {
                    org.eclipse.microprofile.graphql.superhero_client.SuperHeroAPI.Team optional1 = null;
                    if (!field.getValue().isJsonNull()) {
                        optional1 = new org.eclipse.microprofile.graphql.superhero_client.SuperHeroAPI.Team(jsonAsObject(field.getValue(), key));
                    }

                    responseData.put(key, optional1);

                    break;
                }

                case "createNewHero": {
                    SuperHero optional1 = null;
                    if (!field.getValue().isJsonNull()) {
                        optional1 = new SuperHero(jsonAsObject(field.getValue(), key));
                    }

                    responseData.put(key, optional1);

                    break;
                }

                case "removeHeroFromTeam": {
                    org.eclipse.microprofile.graphql.superhero_client.SuperHeroAPI.Team optional1 = null;
                    if (!field.getValue().isJsonNull()) {
                        optional1 = new org.eclipse.microprofile.graphql.superhero_client.SuperHeroAPI.Team(jsonAsObject(field.getValue(), key));
                    }

                    responseData.put(key, optional1);

                    break;
                }

                case "removeItemFromHero": {
                    SuperHero optional1 = null;
                    if (!field.getValue().isJsonNull()) {
                        optional1 = new SuperHero(jsonAsObject(field.getValue(), key));
                    }

                    responseData.put(key, optional1);

                    break;
                }

                case "updateItemPowerLevel": {
                    Item optional1 = null;
                    if (!field.getValue().isJsonNull()) {
                        optional1 = new Item(jsonAsObject(field.getValue(), key));
                    }

                    responseData.put(key, optional1);

                    break;
                }

                case "removeHero": {
                    List<SuperHero> optional1 = null;
                    if (!field.getValue().isJsonNull()) {
                        List<SuperHero> list1 = new ArrayList<>();
                        for (JsonElement element1 : jsonAsArray(field.getValue(), key)) {
                            SuperHero optional2 = null;
                            if (!element1.isJsonNull()) {
                                optional2 = new SuperHero(jsonAsObject(element1, key));
                            }

                            list1.add(optional2);
                        }

                        optional1 = list1;
                    }

                    responseData.put(key, optional1);

                    break;
                }

                case "provisionHero": {
                    SuperHero optional1 = null;
                    if (!field.getValue().isJsonNull()) {
                        optional1 = new SuperHero(jsonAsObject(field.getValue(), key));
                    }

                    responseData.put(key, optional1);

                    break;
                }

                case "addHeroToTeam": {
                    org.eclipse.microprofile.graphql.superhero_client.SuperHeroAPI.Team optional1 = null;
                    if (!field.getValue().isJsonNull()) {
                        optional1 = new org.eclipse.microprofile.graphql.superhero_client.SuperHeroAPI.Team(jsonAsObject(field.getValue(), key));
                    }

                    responseData.put(key, optional1);

                    break;
                }

                case "__typename": {
                    responseData.put(key, jsonAsString(field.getValue(), key));
                    break;
                }

                default: {
                    readCustomField(fieldName, field.getValue());
                }
            }
        }
    }

    public String getGraphQlTypeName() {
        return "Mutation";
    }

    public org.eclipse.microprofile.graphql.superhero_client.SuperHeroAPI.Team getSetRivalTeam() {
        return (org.eclipse.microprofile.graphql.superhero_client.SuperHeroAPI.Team) get("setRivalTeam");
    }

    public Mutation setSetRivalTeam(org.eclipse.microprofile.graphql.superhero_client.SuperHeroAPI.Team arg) {
        optimisticData.put(getKey("setRivalTeam"), arg);
        return this;
    }

    public SuperHero getCreateNewHero() {
        return (SuperHero) get("createNewHero");
    }

    public Mutation setCreateNewHero(SuperHero arg) {
        optimisticData.put(getKey("createNewHero"), arg);
        return this;
    }

    /**
     * Removes a hero to the specified team and returns the updated team.
     */

    public org.eclipse.microprofile.graphql.superhero_client.SuperHeroAPI.Team getRemoveHeroFromTeam() {
        return (org.eclipse.microprofile.graphql.superhero_client.SuperHeroAPI.Team) get("removeHeroFromTeam");
    }

    public Mutation setRemoveHeroFromTeam(org.eclipse.microprofile.graphql.superhero_client.SuperHeroAPI.Team arg) {
        optimisticData.put(getKey("removeHeroFromTeam"), arg);
        return this;
    }

    /**
     * Removes equipment from a hero
     */

    public SuperHero getRemoveItemFromHero() {
        return (SuperHero) get("removeItemFromHero");
    }

    public Mutation setRemoveItemFromHero(SuperHero arg) {
        optimisticData.put(getKey("removeItemFromHero"), arg);
        return this;
    }

    /**
     * Update an item&#39;s powerLevel
     */

    public Item getUpdateItemPowerLevel() {
        return (Item) get("updateItemPowerLevel");
    }

    public Mutation setUpdateItemPowerLevel(Item arg) {
        optimisticData.put(getKey("updateItemPowerLevel"), arg);
        return this;
    }

    /**
     * Removes a hero... permanently...
     */

    public List<SuperHero> getRemoveHero() {
        return (List<SuperHero>) get("removeHero");
    }

    public Mutation setRemoveHero(List<SuperHero> arg) {
        optimisticData.put(getKey("removeHero"), arg);
        return this;
    }

    /**
     * Gives a hero new equipment
     */

    public SuperHero getProvisionHero() {
        return (SuperHero) get("provisionHero");
    }

    public Mutation setProvisionHero(SuperHero arg) {
        optimisticData.put(getKey("provisionHero"), arg);
        return this;
    }

    /**
     * Adds a hero to the specified team and returns the updated team.
     */

    public org.eclipse.microprofile.graphql.superhero_client.SuperHeroAPI.Team getAddHeroToTeam() {
        return (org.eclipse.microprofile.graphql.superhero_client.SuperHeroAPI.Team) get("addHeroToTeam");
    }

    public Mutation setAddHeroToTeam(org.eclipse.microprofile.graphql.superhero_client.SuperHeroAPI.Team arg) {
        optimisticData.put(getKey("addHeroToTeam"), arg);
        return this;
    }

    public boolean unwrapsToObject(String key) {
        switch (getFieldName(key)) {
            case "setRivalTeam": return true;

            case "createNewHero": return true;

            case "removeHeroFromTeam": return true;

            case "removeItemFromHero": return true;

            case "updateItemPowerLevel": return true;

            case "removeHero": return true;

            case "provisionHero": return true;

            case "addHeroToTeam": return true;

            default: return false;
        }
    }
}

