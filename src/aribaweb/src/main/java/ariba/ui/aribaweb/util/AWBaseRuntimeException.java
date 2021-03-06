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

    $Id: //ariba/platform/ui/aribaweb/ariba/ui/aribaweb/util/AWBaseRuntimeException.java#3 $
*/

package ariba.ui.aribaweb.util;


/**
    Base class of AW exceptions which support the Java 1.4.1 methods to
    store the Throwable which was the cause of this exception.
*/

public class AWBaseRuntimeException extends RuntimeException
{
    Throwable _cause;
    String _message;

    public AWBaseRuntimeException (String message, Throwable cause)
    {
        _cause = cause;
        _message = message;
    }

    public Throwable getCause ()
    {
        return _cause;
    }
}