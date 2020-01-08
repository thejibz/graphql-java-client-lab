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
public class Team extends AbstractResponse<Team> {
    public Team() {
    }

    public Team(JsonObject fields) throws SchemaViolationError {
        for (Map.Entry<String, JsonElement> field : fields.entrySet()) {
            String key = field.getKey();
            String fieldName = getFieldName(key);
            switch (fieldName) {
                case "members": {
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

                case "name": {
                    String optional1 = null;
                    if (!field.getValue().isJsonNull()) {
                        optional1 = jsonAsString(field.getValue(), key);
                    }

                    responseData.put(key, optional1);

                    break;
                }

                case "rivalTeam": {
                    Team optional1 = null;
                    if (!field.getValue().isJsonNull()) {
                        optional1 = new Team(jsonAsObject(field.getValue(), key));
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
        return "Team";
    }

    public List<SuperHero> getMembers() {
        return (List<SuperHero>) get("members");
    }

    public Team setMembers(List<SuperHero> arg) {
        optimisticData.put(getKey("members"), arg);
        return this;
    }

    public String getName() {
        return (String) get("name");
    }

    public Team setName(String arg) {
        optimisticData.put(getKey("name"), arg);
        return this;
    }

    public Team getRivalTeam() {
        return (Team) get("rivalTeam");
    }

    public Team setRivalTeam(Team arg) {
        optimisticData.put(getKey("rivalTeam"), arg);
        return this;
    }

    public boolean unwrapsToObject(String key) {
        switch (getFieldName(key)) {
            case "members": return true;

            case "name": return false;

            case "rivalTeam": return true;

            default: return false;
        }
    }
}

