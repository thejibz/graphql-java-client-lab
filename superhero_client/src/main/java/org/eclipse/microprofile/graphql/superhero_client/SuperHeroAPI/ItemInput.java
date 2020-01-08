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
import com.shopify.graphql.support.Input;

import java.io.Serializable;

public class ItemInput implements Serializable {
    private double height;

    private String id;

    private int powerLevel;

    private boolean supernatural;

    private double weight;

    private Input<String> name = Input.undefined();

    public ItemInput(double height, String id, int powerLevel, boolean supernatural, double weight) {
        this.height = height;

        this.id = id;

        this.powerLevel = powerLevel;

        this.supernatural = supernatural;

        this.weight = weight;
    }

    public double getHeight() {
        return height;
    }

    public ItemInput setHeight(double height) {
        this.height = height;
        return this;
    }

    public String getId() {
        return id;
    }

    public ItemInput setId(String id) {
        this.id = id;
        return this;
    }

    public int getPowerLevel() {
        return powerLevel;
    }

    public ItemInput setPowerLevel(int powerLevel) {
        this.powerLevel = powerLevel;
        return this;
    }

    public boolean getSupernatural() {
        return supernatural;
    }

    public ItemInput setSupernatural(boolean supernatural) {
        this.supernatural = supernatural;
        return this;
    }

    public double getWeight() {
        return weight;
    }

    public ItemInput setWeight(double weight) {
        this.weight = weight;
        return this;
    }

    public String getName() {
        return name.getValue();
    }

    public Input<String> getNameInput() {
        return name;
    }

    public ItemInput setName(String name) {
        this.name = Input.optional(name);
        return this;
    }

    public ItemInput setNameInput(Input<String> name) {
        if (name == null) {
            throw new IllegalArgumentException("Input can not be null");
        }
        this.name = name;
        return this;
    }

    public void appendTo(StringBuilder _queryBuilder) {
        String separator = "";
        _queryBuilder.append('{');

        _queryBuilder.append(separator);
        separator = ",";
        _queryBuilder.append("height:");
        _queryBuilder.append(height);

        _queryBuilder.append(separator);
        separator = ",";
        _queryBuilder.append("id:");
        AbstractQuery.appendQuotedString(_queryBuilder, id.toString());

        _queryBuilder.append(separator);
        separator = ",";
        _queryBuilder.append("powerLevel:");
        _queryBuilder.append(powerLevel);

        _queryBuilder.append(separator);
        separator = ",";
        _queryBuilder.append("supernatural:");
        _queryBuilder.append(supernatural);

        _queryBuilder.append(separator);
        separator = ",";
        _queryBuilder.append("weight:");
        _queryBuilder.append(weight);

        if (this.name.isDefined()) {
            _queryBuilder.append(separator);
            separator = ",";
            _queryBuilder.append("name:");
            if (name.getValue() != null) {
                AbstractQuery.appendQuotedString(_queryBuilder, name.getValue().toString());
            } else {
                _queryBuilder.append("null");
            }
        }

        _queryBuilder.append('}');
    }
}
