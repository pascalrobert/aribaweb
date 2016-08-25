/*
    Copyright 2009 Craig Federighi

    Licensed under the Apache License, Version 2.0 (the "License"); you may not use this
    file except in compliance with the License.
    You may obtain a copy of the License at
    http://www.apache.org/licenses/LICENSE-2.0

    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.

    $Id: //ariba/platform/ui/metaui/ariba/ui/meta/persistence/SortOrdering.java#1 $
*/
package ariba.ui.meta.persistence;

public class SortOrdering
{
    public enum Direction { Ascending, Descending, CaseInsensitiveAscending, CaseInsensitiveDescending }

    String key;
    Direction _direction;

    public SortOrdering (String key, Direction direction)
    {
        this.key = key;
        _direction = direction;
    }

    public String getKey ()
    {
        return key;
    }

    public void setKey (String key)
    {
        this.key = key;
    }

    public Direction getDirection ()
    {
        return _direction;
    }

    public void setDirection (Direction direction)
    {
        _direction = direction;
    }

    public boolean isAscending ()
    {
        return _direction == Direction.Ascending || _direction == Direction.CaseInsensitiveAscending;
    }

    public boolean isCaseInsensitive ()
    {
        return _direction == Direction.CaseInsensitiveDescending || _direction == Direction.CaseInsensitiveAscending;
    }
}
