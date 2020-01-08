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

public class TeamInput implements Serializable {
    private Input<List<SuperHeroInput>> members = Input.undefined();

    private Input<String> name = Input.undefined();

    private Input<TeamInput> rivalTeam = Input.undefined();

    public List<SuperHeroInput> getMembers() {
        return members.getValue();
    }

    public Input<List<SuperHeroInput>> getMembersInput() {
        return members;
    }

    public TeamInput setMembers(List<SuperHeroInput> members) {
        this.members = Input.optional(members);
        return this;
    }

    public TeamInput setMembersInput(Input<List<SuperHeroInput>> members) {
        if (members == null) {
            throw new IllegalArgumentException("Input can not be null");
        }
        this.members = members;
        return this;
    }

    public String getName() {
        return name.getValue();
    }

    public Input<String> getNameInput() {
        return name;
    }

    public TeamInput setName(String name) {
        this.name = Input.optional(name);
        return this;
    }

    public TeamInput setNameInput(Input<String> name) {
        if (name == null) {
            throw new IllegalArgumentException("Input can not be null");
        }
        this.name = name;
        return this;
    }

    public TeamInput getRivalTeam() {
        return rivalTeam.getValue();
    }

    public Input<TeamInput> getRivalTeamInput() {
        return rivalTeam;
    }

    public TeamInput setRivalTeam(TeamInput rivalTeam) {
        this.rivalTeam = Input.optional(rivalTeam);
        return this;
    }

    public TeamInput setRivalTeamInput(Input<TeamInput> rivalTeam) {
        if (rivalTeam == null) {
            throw new IllegalArgumentException("Input can not be null");
        }
        this.rivalTeam = rivalTeam;
        return this;
    }

    public void appendTo(StringBuilder _queryBuilder) {
        String separator = "";
        _queryBuilder.append('{');

        if (this.members.isDefined()) {
            _queryBuilder.append(separator);
            separator = ",";
            _queryBuilder.append("members:");
            if (members.getValue() != null) {
                _queryBuilder.append('[');
                {
                    String listSeperator1 = "";
                    for (SuperHeroInput item1 : members.getValue()) {
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

        if (this.rivalTeam.isDefined()) {
            _queryBuilder.append(separator);
            separator = ",";
            _queryBuilder.append("rivalTeam:");
            if (rivalTeam.getValue() != null) {
                rivalTeam.getValue().appendTo(_queryBuilder);
            } else {
                _queryBuilder.append("null");
            }
        }

        _queryBuilder.append('}');
    }
}
