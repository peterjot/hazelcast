/*
 * Copyright (c) 2008-2020, Hazelcast, Inc. All Rights Reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.hazelcast.sql.impl.compiler;

import static com.hazelcast.sql.impl.compiler.emitter.EmitterConstants.C_VISIBILITY_DEFAULT;
import static com.hazelcast.sql.impl.compiler.emitter.EmitterConstants.C_VISIBILITY_PRIVATE;
import static com.hazelcast.sql.impl.compiler.emitter.EmitterConstants.C_VISIBILITY_PROTECTED;
import static com.hazelcast.sql.impl.compiler.emitter.EmitterConstants.C_VISIBILITY_PUBLIC;

public enum CompilerVisibilityModifier {
    PUBLIC(C_VISIBILITY_PUBLIC),
    PROTECTED(C_VISIBILITY_PROTECTED),
    PRIVATE(C_VISIBILITY_PRIVATE),
    DEFAULT(C_VISIBILITY_DEFAULT);

    private final String name;

    CompilerVisibilityModifier(String name) {
        this.name = name;
    }

    public String getDefinition() {
        return name;
    }
}