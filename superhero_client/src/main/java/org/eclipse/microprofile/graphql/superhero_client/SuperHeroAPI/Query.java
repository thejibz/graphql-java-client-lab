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
 * Query root
 */
public class Query extends AbstractResponse<Query> {
    public Query() {
    }

    public Query(JsonObject fields) throws SchemaViolationError {
        for (Map.Entry<String, JsonElement> field : fields.entrySet()) {
            String key = field.getKey();
            String fieldName = getFieldName(key);
            switch (fieldName) {
                case "character": {
                    Character optional1 = null;
                    if (!field.getValue().isJsonNull()) {
                        optional1 = org.eclipse.microprofile.graphql.superhero_client.SuperHeroAPI.UnknownCharacter.create(jsonAsObject(field.getValue(), key));
                    }

                    responseData.put(key, optional1);

                    break;
                }

                case "allHeroesWithSpecificError": {
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

                case "superHero": {
                    SuperHero optional1 = null;
                    if (!field.getValue().isJsonNull()) {
                        optional1 = new SuperHero(jsonAsObject(field.getValue(), key));
                    }

                    responseData.put(key, optional1);

                    break;
                }

                case "allHeroes": {
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

                case "allTeams": {
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

                case "allHeroesWithError": {
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

                case "allHeroesInTeam": {
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

                case "allHeroesWithPower": {
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

                case "allHeroesIn": {
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
        return "Query";
    }

    public Character getCharacter() {
        return (Character) get("character");
    }

    public Query setCharacter(Character arg) {
        optimisticData.put(getKey("character"), arg);
        return this;
    }

    public List<SuperHero> getAllHeroesWithSpecificError() {
        return (List<SuperHero>) get("allHeroesWithSpecificError");
    }

    public Query setAllHeroesWithSpecificError(List<SuperHero> arg) {
        optimisticData.put(getKey("allHeroesWithSpecificError"), arg);
        return this;
    }

    public SuperHero getSuperHero() {
        return (SuperHero) get("superHero");
    }

    public Query setSuperHero(SuperHero arg) {
        optimisticData.put(getKey("superHero"), arg);
        return this;
    }

    public List<SuperHero> getAllHeroes() {
        return (List<SuperHero>) get("allHeroes");
    }

    public Query setAllHeroes(List<SuperHero> arg) {
        optimisticData.put(getKey("allHeroes"), arg);
        return this;
    }

    public List<org.eclipse.microprofile.graphql.superhero_client.SuperHeroAPI.Team> getAllTeams() {
        return (List<org.eclipse.microprofile.graphql.superhero_client.SuperHeroAPI.Team>) get("allTeams");
    }

    public Query setAllTeams(List<org.eclipse.microprofile.graphql.superhero_client.SuperHeroAPI.Team> arg) {
        optimisticData.put(getKey("allTeams"), arg);
        return this;
    }

    public List<SuperHero> getAllHeroesWithError() {
        return (List<SuperHero>) get("allHeroesWithError");
    }

    public Query setAllHeroesWithError(List<SuperHero> arg) {
        optimisticData.put(getKey("allHeroesWithError"), arg);
        return this;
    }

    public List<SuperHero> getAllHeroesInTeam() {
        return (List<SuperHero>) get("allHeroesInTeam");
    }

    public Query setAllHeroesInTeam(List<SuperHero> arg) {
        optimisticData.put(getKey("allHeroesInTeam"), arg);
        return this;
    }

    public List<SuperHero> getAllHeroesWithPower() {
        return (List<SuperHero>) get("allHeroesWithPower");
    }

    public Query setAllHeroesWithPower(List<SuperHero> arg) {
        optimisticData.put(getKey("allHeroesWithPower"), arg);
        return this;
    }

    public List<SuperHero> getAllHeroesIn() {
        return (List<SuperHero>) get("allHeroesIn");
    }

    public Query setAllHeroesIn(List<SuperHero> arg) {
        optimisticData.put(getKey("allHeroesIn"), arg);
        return this;
    }

    public boolean unwrapsToObject(String key) {
        switch (getFieldName(key)) {
            case "character": return false;

            case "allHeroesWithSpecificError": return true;

            case "superHero": return true;

            case "allHeroes": return true;

            case "allTeams": return true;

            case "allHeroesWithError": return true;

            case "allHeroesInTeam": return true;

            case "allHeroesWithPower": return true;

            case "allHeroesIn": return true;

            default: return false;
        }
    }
}

