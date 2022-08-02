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
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import org.neo4j.ogm.metadata.MethodHandle;

public class ReflectionMethodHandle implements MethodHandle {
    private Method method;

    public ReflectionMethodHandle(Method method) {
        this.method = method;
        this.method.setAccessible(true);
    }

    @Override
    public String getName() {
        return method.getName();
    }

    @Override
    public Annotation[] getDeclaredAnnotations() {
        return method.getDeclaredAnnotations();
    }

    @Override
    public Object invoke(Object instance, Object... args) throws SecurityException, IllegalAccessException, InvocationTargetException {
        return method.invoke(instance, args);
    }

    @Override
    public int hashCode() {
        return method.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return (obj instanceof ReflectionMethodHandle) && method.equals(((ReflectionMethodHandle) obj).method);
    }
}
