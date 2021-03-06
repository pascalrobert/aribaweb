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

    $Id: //ariba/platform/util/core/ariba/util/io/TemporaryFileList.java#5 $
*/

package ariba.util.io;

import java.io.File;
import java.util.List;

import ariba.util.core.ListUtil;
import ariba.util.log.Log;

/**
    @aribaapi private
*/
public class TemporaryFileList
{
    public List list;

    public TemporaryFileList ()
    {
        this.begin();
    }

    public void begin ()
    {
        this.list = ListUtil.list();
    }

    public void add (File file)
    {
        this.list.add(file);
    }

    public void end ()
    {
        try {
            this.cleanFiles();
        }
        catch (SecurityException e) {
        }
    }

    private void cleanFiles ()
    {
        for (int idx = 0; idx < this.list.size(); idx++) {
            File file = (File)this.list.get(idx);
            if (file.exists()) {
                if (!file.delete()) {
                    Log.util.warning(2892, file.getAbsolutePath());
                }
            }
        }
        this.list.clear();
    }
}
