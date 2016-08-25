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

    $Id: //ariba/platform/ui/aribaweb/ariba/ui/aribaweb/core/AWMonitorSessionStatsPage.java#3 $
*/

package ariba.ui.aribaweb.core;

import java.util.Map;

import ariba.util.core.GrowOnlyHashtable;

public class AWMonitorSessionStatsPage extends AWComponent
{
    public static final String PageName = "AWMonitorSessionStatsPage";

    private Map _sessionMap = null;
    public Object[] _sessions;
    public Object _currentSession;

    /////////////
    // Awake
    /////////////
    protected void awake ()
    {
        GrowOnlyHashtable go =
            application().getSessionStatusManager().getSessionStatusTable();
        if (go.isEmpty()) {
            return;
        }
        _sessionMap = (Map)go.elementsArray()[0];

        if (_sessionMap != null) {
            _sessions = _sessionMap.keySet().toArray();
        }
    }

    protected void sleep ()
    {
        _sessionMap = null;
        _sessions = null;
    }

    // disable automatic session validation for this page
    protected boolean shouldValidateSession ()
    {
        return false;
    }

    public boolean shouldCachePage ()
    {
        return false;
    }

    public String currentState ()
    {
        String state = (String)_sessionMap.get(_currentSession);
        return state == null ? "disconnected" : state;
    }

    //////////////////////
    // Stateless/full Support
    //////////////////////
    public boolean isStateless ()
    {
        return false;
    }
}