/*
 * Copyright (c) 2002-2015 "Neo Technology,"
 * Network Engine for Objects in Lund AB [http://neotechnology.com]
 *
 * This product is licensed to you under the Apache License, Version 2.0 (the "License").
 * You may not use this product except in compliance with the License.
 *
 * This product may include a number of subcomponents with
 * separate copyright notices and license terms. Your use of the source
 * code for these subcomponents is subject to the terms and
 * conditions of the subcomponent's license, as noted in the LICENSE file.
 *
 */

package org.neo4j.ogm.domain.entityMapping;

import org.neo4j.ogm.annotation.EndNode;
import org.neo4j.ogm.annotation.RelationshipEntity;
import org.neo4j.ogm.annotation.StartNode;

/**
 * @author vince
 */
@RelationshipEntity(type="RATED")
public class Rating {

    public Long id;

    @StartNode
    public Person person;

    @EndNode
    public Movie movie;

    public int value;

    public static Rating create(Person person, Movie movie, int value) {
        Rating rating = new Rating();
        rating.person = person;
        rating.movie = movie;
        rating.value = value;
        return rating;
    }
}
