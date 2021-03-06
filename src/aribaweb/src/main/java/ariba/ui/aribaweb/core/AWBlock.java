/*
    Copyright 1996-2008 Ariba, Inc.

    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at
        http://www.apache.org/licenses/LICENSE-2.0

    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.

    $Id: //ariba/platform/ui/aribaweb/ariba/ui/aribaweb/core/AWBlock.java#2 $
*/

package ariba.ui.aribaweb.core;

import java.util.Map;

/**
    See AWIncludeBlock for details.
*/
public final class AWBlock extends AWContainerElement
{
    private String _name;

    public void init (String tagName, Map bindingsHashtable)
    {
        AWBinding nameBinding = (AWBinding)bindingsHashtable.remove(AWBindingNames.name);
        _name = nameBinding.stringValue(null);
        super.init(tagName, bindingsHashtable);
    }

    public String name ()
    {
        return _name;
    }

    /**
        This guarantees that the contentElement is always an AWTemplate.
    */
    public AWTemplate subtemplate ()
    {
        AWTemplate template = null;
        AWElement contentElement = contentElement();
        if (contentElement != null) {
            if (contentElement instanceof AWTemplate) {
                template = (AWTemplate)contentElement;
            }
            else {
                AWConcreteTemplate concreteTemplate = new AWConcreteTemplate();
                concreteTemplate.init();
                concreteTemplate.add(contentElement);
                setContentElement(concreteTemplate);
                template = concreteTemplate;
            }
        }
        return template;
    }

    // A Subtemplate skips all three phases as these will be handled otherwise.
    
    public void applyValues(AWRequestContext requestContext, AWComponent component)
    {
    }

    public AWResponseGenerating invokeAction(AWRequestContext requestContext, AWComponent component)
    {
        return null;
    }

    public void renderResponse(AWRequestContext requestContext, AWComponent component)
    {
    }
}
