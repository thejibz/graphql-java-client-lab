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

import java.util.Map;

/**
 * 
 */
public class Sidekick extends AbstractResponse<Sidekick> implements Character {
    public Sidekick() {
    }

    public Sidekick(JsonObject fields) throws SchemaViolationError {
        for (Map.Entry<String, JsonElement> field : fields.entrySet()) {
            String key = field.getKey();
            String fieldName = getFieldName(key);
            switch (fieldName) {
                case "name": {
                    String optional1 = null;
                    if (!field.getValue().isJsonNull()) {
                        optional1 = jsonAsString(field.getValue(), key);
                    }

                    responseData.put(key, optional1);

                    break;
                }

                case "superHeroSidekicked": {
                    SuperHero optional1 = null;
                    if (!field.getValue().isJsonNull()) {
                        optional1 = new SuperHero(jsonAsObject(field.getValue(), key));
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
        return "Sidekick";
    }

    public String getName() {
        return (String) get("name");
    }

    public Sidekick setName(String arg) {
        optimisticData.put(getKey("name"), arg);
        return this;
    }

    public SuperHero getSuperHeroSidekicked() {
        return (SuperHero) get("superHeroSidekicked");
    }

    public Sidekick setSuperHeroSidekicked(SuperHero arg) {
        optimisticData.put(getKey("superHeroSidekicked"), arg);
        return this;
    }

    public boolean unwrapsToObject(String key) {
        switch (getFieldName(key)) {
            case "name": return false;

            case "superHeroSidekicked": return true;

            default: return false;
        }
    }
}

