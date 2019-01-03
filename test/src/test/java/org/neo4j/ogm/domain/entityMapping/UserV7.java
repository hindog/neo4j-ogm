/*
 * Copyright (c) 2002-2019 "Neo4j,"
 * Neo4j Sweden AB [http://neo4j.com]
 *
 * This file is part of Neo4j.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.neo4j.ogm.domain.entityMapping;

import org.neo4j.ogm.annotation.Relationship;

/**
 * Annotated getter and setter (implied outgoing), non annotated field. Relationship type same as property name
 *
 * @author Luanne Misquitta
 */
public class UserV7 extends Entity {

    @Relationship(type = "KNOWS")
    private UserV7 knows;

    public UserV7 getKnows() {
        return knows;
    }

    public void setKnows(UserV7 knows) {
        this.knows = knows;
    }
}
