/*
 * PythonFileType.java
 *
 * Copyright (C) 2022 by Posit Software, PBC
 *
 * Unless you have received this program directly from Posit Software pursuant
 * to the terms of a commercial license agreement with Posit Software, then
 * this program is licensed to you under the terms of version 3 of the
 * GNU Affero General Public License. This program is distributed WITHOUT
 * ANY EXPRESS OR IMPLIED WARRANTY, INCLUDING THOSE OF NON-INFRINGEMENT,
 * MERCHANTABILITY OR FITNESS FOR A PARTICULAR PURPOSE. Please refer to the
 * AGPL (http://www.gnu.org/licenses/agpl-3.0.txt) for more details.
 *
 */
package org.rstudio.studio.client.common.filetypes;

import java.util.HashSet;

import org.rstudio.core.client.command.AppCommand;
import org.rstudio.studio.client.common.reditor.EditorLanguage;
import org.rstudio.studio.client.workbench.commands.Commands;

import com.google.gwt.resources.client.ImageResource;

public class PythonFileType extends TextFileType
{
   PythonFileType(
         String id,
         String label,
         EditorLanguage editorLanguage,
         String defaultExtension,
         ImageResource defaultIcon)
   {
      super(id,
            label,
            editorLanguage,
            defaultExtension,
            defaultIcon,
            WordWrap.DEFAULT, // word wrap
            false, // source on save
            true,  // execute code
            true,  // execute all code
            true,  // execute to current line
            false, // preview HTML 
            false, // knit to HTML
            false, // compile PDF
            false, // execute chunks
            false,  // auto-indent
            false, // check spelling
            false, // scope tree
            false  // preview from R
            );
   }
   
   @Override
   public HashSet<AppCommand> getSupportedCommands(Commands commands)
   {
      HashSet<AppCommand> pythonCommands = super.getSupportedCommands(commands);
      
      pythonCommands.remove(commands.extractFunction());
      pythonCommands.remove(commands.extractLocalVariable());
      pythonCommands.remove(commands.reformatCode());
      pythonCommands.remove(commands.renameInScope());
      pythonCommands.remove(commands.profileCode());
      pythonCommands.remove(commands.profileCodeWithoutFocus());
      pythonCommands.remove(commands.showDiagnosticsActiveDocument());
      pythonCommands.remove(commands.showDiagnosticsProject());
      pythonCommands.remove(commands.reindent());
      
      return pythonCommands;
   }
}
