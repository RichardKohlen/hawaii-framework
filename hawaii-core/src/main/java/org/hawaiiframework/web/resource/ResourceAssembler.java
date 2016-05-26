/*
 * Copyright 2015-2016 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.hawaiiframework.web.resource;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * @author Marcel Overdijk
 * @since 2.0.0
 */
public interface ResourceAssembler<T, D> {

    /**
     * Converts the given object into a resource.
     */
    D toResource(T object);

    /**
     * Converts all given objects into resources.
     *
     * @param objects must not be {@literal null}.
     * @see #toResource(Object)
     */
    default List<D> toResources(Iterable<? extends T> objects) {
        Objects.requireNonNull(objects, "'objects' must not be null");
        List<D> result = new ArrayList<D>();
        for (T object : objects) {
            result.add(toResource(object));
        }
        return result;
    }
}
