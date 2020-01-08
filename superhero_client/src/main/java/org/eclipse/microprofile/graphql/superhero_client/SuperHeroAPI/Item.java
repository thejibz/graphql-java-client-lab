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
public class Item extends AbstractResponse<Item> {
    public Item() {
    }

    public Item(JsonObject fields) throws SchemaViolationError {
        for (Map.Entry<String, JsonElement> field : fields.entrySet()) {
            String key = field.getKey();
            String fieldName = getFieldName(key);
            switch (fieldName) {
                case "height": {
                    responseData.put(key, jsonAsDouble(field.getValue(), key));

                    break;
                }

                case "id": {
                    responseData.put(key, jsonAsString(field.getValue(), key));

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

                case "powerLevel": {
                    responseData.put(key, jsonAsInteger(field.getValue(), key));

                    break;
                }

                case "supernatural": {
                    responseData.put(key, jsonAsBoolean(field.getValue(), key));

                    break;
                }

                case "weight": {
                    responseData.put(key, jsonAsDouble(field.getValue(), key));

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
        return "Item";
    }

    public Double getHeight() {
        return (Double) get("height");
    }

    public Item setHeight(Double arg) {
        optimisticData.put(getKey("height"), arg);
        return this;
    }

    public String getId() {
        return (String) get("id");
    }

    public Item setId(String arg) {
        optimisticData.put(getKey("id"), arg);
        return this;
    }

    public String getName() {
        return (String) get("name");
    }

    public Item setName(String arg) {
        optimisticData.put(getKey("name"), arg);
        return this;
    }

    public Integer getPowerLevel() {
        return (Integer) get("powerLevel");
    }

    public Item setPowerLevel(Integer arg) {
        optimisticData.put(getKey("powerLevel"), arg);
        return this;
    }

    public Boolean getSupernatural() {
        return (Boolean) get("supernatural");
    }

    public Item setSupernatural(Boolean arg) {
        optimisticData.put(getKey("supernatural"), arg);
        return this;
    }

    public Double getWeight() {
        return (Double) get("weight");
    }

    public Item setWeight(Double arg) {
        optimisticData.put(getKey("weight"), arg);
        return this;
    }

    public boolean unwrapsToObject(String key) {
        switch (getFieldName(key)) {
            case "height": return false;

            case "id": return false;

            case "name": return false;

            case "powerLevel": return false;

            case "supernatural": return false;

            case "weight": return false;

            default: return false;
        }
    }
}

