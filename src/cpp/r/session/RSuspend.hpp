/*
 * RSuspend.hpp
 *
 * Copyright (C) 2009-18 by RStudio, Inc.
 *
 * Unless you have received this program directly from RStudio pursuant
 * to the terms of a commercial license agreement with RStudio, then
 * this program is licensed to you under the terms of version 3 of the
 * GNU Affero General Public License. This program is distributed WITHOUT
 * ANY EXPRESS OR IMPLIED WARRANTY, INCLUDING THOSE OF NON-INFRINGEMENT,
 * MERCHANTABILITY OR FITNESS FOR A PARTICULAR PURPOSE. Please refer to the
 * AGPL (http://www.gnu.org/licenses/agpl-3.0.txt) for more details.
 *
 */

#ifndef R_SESSION_SUSPEND_HPP
#define R_SESSION_SUSPEND_HPP

#include <core/FilePath.hpp>

namespace rstudio {
namespace r {
namespace session {

struct RSuspendOptions;

void setSuspendedSessionPath(const core::FilePath& path);
core::FilePath suspendedSessionPath();
bool suspend(const RSuspendOptions& options,
             const core::FilePath& suspendedSessionPath,
             bool disableSaveCompression,
             bool force);

class SerializationCallbackScope : boost::noncopyable
{
public:
   SerializationCallbackScope(int action, const core::FilePath& targetPath = core::FilePath());
   ~SerializationCallbackScope();
};

} // namespace session
} // namespace r
} // namespace rstudio

#endif // R_SESSION_SUSPEND_HPP 
