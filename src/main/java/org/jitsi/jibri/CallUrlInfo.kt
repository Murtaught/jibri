/*
 * Copyright @ 2018 Atlassian Pty Ltd
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 */

package org.jitsi.jibri

import java.util.Objects

/**
 * We assume the 'baseUrl' represents a sort of landing page (on the same
 * domain) where we can set the necessary local storage values.  The call
 * url will be created by joining [baseUrl] and [callName] with a "/"
 */
data class CallUrlInfo(
        val baseUrl: String = "",
        val callName: String = ""
) {
    val callUrl = "$baseUrl/$callName"

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other == null) return false
        if (javaClass != other.javaClass) return false
        val otherCallUrlInfo = other as CallUrlInfo
        return hashCode() == otherCallUrlInfo.hashCode()
    }

    override fun hashCode(): Int {
        return Objects.hash(baseUrl.toLowerCase(), callName.toLowerCase())
    }
}
