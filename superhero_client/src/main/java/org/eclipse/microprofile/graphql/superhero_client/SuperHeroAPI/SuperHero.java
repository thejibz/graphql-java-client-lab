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
 * 
 */
public class SuperHero extends AbstractResponse<SuperHero> implements Character {
    public SuperHero() {
    }

    public SuperHero(JsonObject fields) throws SchemaViolationError {
        for (Map.Entry<String, JsonElement> field : fields.entrySet()) {
            String key = field.getKey();
            String fieldName = getFieldName(key);
            switch (fieldName) {
                case "currentLocation": {
                    String optional1 = null;
                    if (!field.getValue().isJsonNull()) {
                        optional1 = jsonAsString(field.getValue(), key);
                    }

                    responseData.put(key, optional1);

                    break;
                }

                case "equipment": {
                    List<Item> optional1 = null;
                    if (!field.getValue().isJsonNull()) {
                        List<Item> list1 = new ArrayList<>();
                        for (JsonElement element1 : jsonAsArray(field.getValue(), key)) {
                            Item optional2 = null;
                            if (!element1.isJsonNull()) {
                                optional2 = new Item(jsonAsObject(element1, key));
                            }

                            list1.add(optional2);
                        }

                        optional1 = list1;
                    }

                    responseData.put(key, optional1);

                    break;
                }

                case "name": {
                    String optional1 = null;
                    if (!field.getValue().isJsonNull()) {
                        optional1 = jsonAsString(field.getValue(), key);
                    }

                    responseData.put(key, optional1);

                    break;
                }

                case "primaryLocation": {
                    String optional1 = null;
                    if (!field.getValue().isJsonNull()) {
                        optional1 = jsonAsString(field.getValue(), key);
                    }

                    responseData.put(key, optional1);

                    break;
                }

                case "realName": {
                    String optional1 = null;
                    if (!field.getValue().isJsonNull()) {
                        optional1 = jsonAsString(field.getValue(), key);
                    }

                    responseData.put(key, optional1);

                    break;
                }

                case "superPowers": {
                    List<String> optional1 = null;
                    if (!field.getValue().isJsonNull()) {
                        List<String> list1 = new ArrayList<>();
                        for (JsonElement element1 : jsonAsArray(field.getValue(), key)) {
                            String optional2 = null;
                            if (!element1.isJsonNull()) {
                                optional2 = jsonAsString(element1, key);
                            }

                            list1.add(optional2);
                        }

                        optional1 = list1;
                    }

                    responseData.put(key, optional1);

                    break;
                }

                case "teamAffiliations": {
                    List<org.eclipse.microprofile.graphql.superhero_client.SuperHeroAPI.Team> optional1 = null;
                    if (!field.getValue().isJsonNull()) {
                        List<org.eclipse.microprofile.graphql.superhero_client.SuperHeroAPI.Team> list1 = new ArrayList<>();
                        for (JsonElement element1 : jsonAsArray(field.getValue(), key)) {
                            org.eclipse.microprofile.graphql.superhero_client.SuperHeroAPI.Team optional2 = null;
                            if (!element1.isJsonNull()) {
                                optional2 = new org.eclipse.microprofile.graphql.superhero_client.SuperHeroAPI.Team(jsonAsObject(element1, key));
                            }

                            list1.add(optional2);
                        }

                        optional1 = list1;
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
        return "SuperHero";
    }

    public String getCurrentLocation() {
        return (String) get("currentLocation");
    }

    public SuperHero setCurrentLocation(String arg) {
        optimisticData.put(getKey("currentLocation"), arg);
        return this;
    }

    public List<Item> getEquipment() {
        return (List<Item>) get("equipment");
    }

    public SuperHero setEquipment(List<Item> arg) {
        optimisticData.put(getKey("equipment"), arg);
        return this;
    }

    public String getName() {
        return (String) get("name");
    }

    public SuperHero setName(String arg) {
        optimisticData.put(getKey("name"), arg);
        return this;
    }

    public String getPrimaryLocation() {
        return (String) get("primaryLocation");
    }

    public SuperHero setPrimaryLocation(String arg) {
        optimisticData.put(getKey("primaryLocation"), arg);
        return this;
    }

    public String getRealName() {
        return (String) get("realName");
    }

    public SuperHero setRealName(String arg) {
        optimisticData.put(getKey("realName"), arg);
        return this;
    }

    public List<String> getSuperPowers() {
        return (List<String>) get("superPowers");
    }

    public SuperHero setSuperPowers(List<String> arg) {
        optimisticData.put(getKey("superPowers"), arg);
        return this;
    }

    public List<org.eclipse.microprofile.graphql.superhero_client.SuperHeroAPI.Team> getTeamAffiliations() {
        return (List<org.eclipse.microprofile.graphql.superhero_client.SuperHeroAPI.Team>) get("teamAffiliations");
    }

    public SuperHero setTeamAffiliations(List<org.eclipse.microprofile.graphql.superhero_client.SuperHeroAPI.Team> arg) {
        optimisticData.put(getKey("teamAffiliations"), arg);
        return this;
    }

    public boolean unwrapsToObject(String key) {
        switch (getFieldName(key)) {
            case "currentLocation": return false;

            case "equipment": return true;

            case "name": return false;

            case "primaryLocation": return false;

            case "realName": return false;

            case "superPowers": return false;

            case "teamAffiliations": return true;

            default: return false;
        }
    }
}

