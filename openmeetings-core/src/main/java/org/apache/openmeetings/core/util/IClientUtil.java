/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License") +  you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */
package org.apache.openmeetings.core.util;

import static org.apache.openmeetings.util.OpenmeetingsVariables.webAppRootKey;

import org.apache.openmeetings.db.entity.room.StreamClient;
import org.red5.logging.Red5LoggerFactory;
import org.red5.server.api.IClient;
import org.slf4j.Logger;

public class IClientUtil {
	private static final Logger log = Red5LoggerFactory.getLogger(IClientUtil.class, webAppRootKey);

	private enum ConAttrs {
		omId
		, sharing
	}

	public static void init(IClient client, Long id, boolean sharing) {
		client.setAttribute(ConAttrs.omId.name(), id);
		client.setAttribute(ConAttrs.sharing.name(), sharing);
	}

	/**
	 * Id of {@link StreamClient} for this IConnection
	 *
	 * @param conn
	 * @return - Id of {@link StreamClient} for this IConnection, or <code>null</code>
	 */
	public static Long getId(IClient client) {
		Object o = client.getAttribute(ConAttrs.omId.name());
		return o instanceof Long ? (Long)o : null;
	}

	public static boolean isSharing(IClient client) {
		return Boolean.TRUE.equals(client.getAttribute(ConAttrs.sharing.name()));
	}
}