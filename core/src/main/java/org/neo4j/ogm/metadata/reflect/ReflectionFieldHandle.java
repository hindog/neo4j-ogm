/*
 * Copyright (c) 2002-2022 "Neo4j,"
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
package org.neo4j.ogm.metadata.reflect;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;

import org.neo4j.ogm.metadata.FieldHandle;

public class ReflectionFieldHandle implements FieldHandle {
    private Field field;

    public ReflectionFieldHandle(Field field) {
        this.field = field;
        this.field.setAccessible(true);
    }

    @Override
    public Type getGenericType() {
        return field.getGenericType();
    }

    @Override
    public Class<?> getType() {
        return field.getType();
    }

    @Override
    public int getModifiers() {
        return field.getModifiers();
    }

    @Override
    public boolean isSynthetic() {
        return field.isSynthetic();
    }

    @Override
    public boolean isParameterized() {
        return field.getGenericType() instanceof ParameterizedType;
    }

    @Override
    public boolean isGeneric() {
        return field.getGenericType() instanceof TypeVariable;
    }

    @Override
    public boolean isArray() {
        return getType().isArray();
    }

    @Override
    public boolean isIterable() {
        return Iterable.class.isAssignableFrom(getType());
    }

    @Override
    public String getName() {
        return field.getName();
    }

    @Override
    public void set(Object instance, Object value) throws IllegalAccessException {
        field.set(instance, value);
    }

    @Override
    public Object get(Object instance) throws IllegalAccessException {
        return field.get(instance);
    }

    @Override
    public Annotation[] getDeclaredAnnotations() {
        return field.getDeclaredAnnotations();
    }

    @Override
    public <T extends Annotation> T getAnnotation(Class<T> annotation) {
        return field.getAnnotation(annotation);
    }

    @Override
    public int hashCode() {
        return field.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return (obj instanceof ReflectionFieldHandle) && field.equals(((ReflectionFieldHandle) obj).field);
    }
}
