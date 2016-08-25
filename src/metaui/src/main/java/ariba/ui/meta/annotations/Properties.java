/*
    Copyright 2008 Craig Federighi

    Licensed under the Apache License, Version 2.0 (the "License"); you may not use this
    file except in compliance with the License.
    You may obtain a copy of the License at
    http://www.apache.org/licenses/LICENSE-2.0

    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.

    $Id: //ariba/platform/ui/metaui/ariba/ui/meta/annotations/Properties.java#1 $
*/
package ariba.ui.meta.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Associates OSS properties with a field.
 * Usages:
 *      Properties("size:10; required:true")
 *      Properties("editing { component:AWTextField }")
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE,ElementType.FIELD,ElementType.METHOD})
@Inherited
public @interface Properties {
    public abstract String value();
}