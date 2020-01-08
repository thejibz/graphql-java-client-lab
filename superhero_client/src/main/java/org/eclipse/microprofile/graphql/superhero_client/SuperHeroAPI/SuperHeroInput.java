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
import java.util.List;

public class SuperHeroInput implements Serializable {
    private Input<List<ItemInput>> equipment = Input.undefined();

    private Input<String> name = Input.undefined();

    private Input<String> primaryLocation = Input.undefined();

    private Input<String> realName = Input.undefined();

    private Input<List<String>> superPowers = Input.undefined();

    private Input<List<org.eclipse.microprofile.graphql.superhero_client.SuperHeroAPI.TeamInput>> teamAffiliations = Input.undefined();

    public List<ItemInput> getEquipment() {
        return equipment.getValue();
    }

    public Input<List<ItemInput>> getEquipmentInput() {
        return equipment;
    }

    public SuperHeroInput setEquipment(List<ItemInput> equipment) {
        this.equipment = Input.optional(equipment);
        return this;
    }

    public SuperHeroInput setEquipmentInput(Input<List<ItemInput>> equipment) {
        if (equipment == null) {
            throw new IllegalArgumentException("Input can not be null");
        }
        this.equipment = equipment;
        return this;
    }

    public String getName() {
        return name.getValue();
    }

    public Input<String> getNameInput() {
        return name;
    }

    public SuperHeroInput setName(String name) {
        this.name = Input.optional(name);
        return this;
    }

    public SuperHeroInput setNameInput(Input<String> name) {
        if (name == null) {
            throw new IllegalArgumentException("Input can not be null");
        }
        this.name = name;
        return this;
    }

    public String getPrimaryLocation() {
        return primaryLocation.getValue();
    }

    public Input<String> getPrimaryLocationInput() {
        return primaryLocation;
    }

    public SuperHeroInput setPrimaryLocation(String primaryLocation) {
        this.primaryLocation = Input.optional(primaryLocation);
        return this;
    }

    public SuperHeroInput setPrimaryLocationInput(Input<String> primaryLocation) {
        if (primaryLocation == null) {
            throw new IllegalArgumentException("Input can not be null");
        }
        this.primaryLocation = primaryLocation;
        return this;
    }

    public String getRealName() {
        return realName.getValue();
    }

    public Input<String> getRealNameInput() {
        return realName;
    }

    public SuperHeroInput setRealName(String realName) {
        this.realName = Input.optional(realName);
        return this;
    }

    public SuperHeroInput setRealNameInput(Input<String> realName) {
        if (realName == null) {
            throw new IllegalArgumentException("Input can not be null");
        }
        this.realName = realName;
        return this;
    }

    public List<String> getSuperPowers() {
        return superPowers.getValue();
    }

    public Input<List<String>> getSuperPowersInput() {
        return superPowers;
    }

    public SuperHeroInput setSuperPowers(List<String> superPowers) {
        this.superPowers = Input.optional(superPowers);
        return this;
    }

    public SuperHeroInput setSuperPowersInput(Input<List<String>> superPowers) {
        if (superPowers == null) {
            throw new IllegalArgumentException("Input can not be null");
        }
        this.superPowers = superPowers;
        return this;
    }

    public List<TeamInput> getTeamAffiliations() {
        return teamAffiliations.getValue();
    }

    public Input<List<TeamInput>> getTeamAffiliationsInput() {
        return teamAffiliations;
    }

    public SuperHeroInput setTeamAffiliations(List<TeamInput> teamAffiliations) {
        this.teamAffiliations = Input.optional(teamAffiliations);
        return this;
    }

    public SuperHeroInput setTeamAffiliationsInput(Input<List<TeamInput>> teamAffiliations) {
        if (teamAffiliations == null) {
            throw new IllegalArgumentException("Input can not be null");
        }
        this.teamAffiliations = teamAffiliations;
        return this;
    }

    public void appendTo(StringBuilder _queryBuilder) {
        String separator = "";
        _queryBuilder.append('{');

        if (this.equipment.isDefined()) {
            _queryBuilder.append(separator);
            separator = ",";
            _queryBuilder.append("equipment:");
            if (equipment.getValue() != null) {
                _queryBuilder.append('[');
                {
                    String listSeperator1 = "";
                    for (ItemInput item1 : equipment.getValue()) {
                        _queryBuilder.append(listSeperator1);
                        listSeperator1 = ",";
                        item1.appendTo(_queryBuilder);
                    }
                }
                _queryBuilder.append(']');
            } else {
                _queryBuilder.append("null");
            }
        }

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

        if (this.primaryLocation.isDefined()) {
            _queryBuilder.append(separator);
            separator = ",";
            _queryBuilder.append("primaryLocation:");
            if (primaryLocation.getValue() != null) {
                AbstractQuery.appendQuotedString(_queryBuilder, primaryLocation.getValue().toString());
            } else {
                _queryBuilder.append("null");
            }
        }

        if (this.realName.isDefined()) {
            _queryBuilder.append(separator);
            separator = ",";
            _queryBuilder.append("realName:");
            if (realName.getValue() != null) {
                AbstractQuery.appendQuotedString(_queryBuilder, realName.getValue().toString());
            } else {
                _queryBuilder.append("null");
            }
        }

        if (this.superPowers.isDefined()) {
            _queryBuilder.append(separator);
            separator = ",";
            _queryBuilder.append("superPowers:");
            if (superPowers.getValue() != null) {
                _queryBuilder.append('[');
                {
                    String listSeperator1 = "";
                    for (String item1 : superPowers.getValue()) {
                        _queryBuilder.append(listSeperator1);
                        listSeperator1 = ",";
                        AbstractQuery.appendQuotedString(_queryBuilder, item1.toString());
                    }
                }
                _queryBuilder.append(']');
            } else {
                _queryBuilder.append("null");
            }
        }

        if (this.teamAffiliations.isDefined()) {
            _queryBuilder.append(separator);
            separator = ",";
            _queryBuilder.append("teamAffiliations:");
            if (teamAffiliations.getValue() != null) {
                _queryBuilder.append('[');
                {
                    String listSeperator1 = "";
                    for (TeamInput item1 : teamAffiliations.getValue()) {
                        _queryBuilder.append(listSeperator1);
                        listSeperator1 = ",";
                        item1.appendTo(_queryBuilder);
                    }
                }
                _queryBuilder.append(']');
            } else {
                _queryBuilder.append("null");
            }
        }

        _queryBuilder.append('}');
    }
}
