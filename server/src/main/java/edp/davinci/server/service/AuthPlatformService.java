/*
 * <<
 *  Davinci
 *  ==
 *  Copyright (C) 2016 - 2020 EDP
 *  ==
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *        http://www.apache.org/licenses/LICENSE-2.0
 *   Unless required by applicable law or agreed to in writing, software
 *   distributed under the License is distributed on an "AS IS" BASIS,
 *   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *   See the License for the specific language governing permissions and
 *   limitations under the License.
 *  >>
 *
 */

package edp.davinci.server.service;

import edp.davinci.core.dao.entity.Platform;
import edp.davinci.server.controller.ResultMap;
import edp.davinci.server.exception.ServerException;
import edp.davinci.core.dao.entity.User;

import javax.servlet.http.HttpServletRequest;
import java.util.concurrent.ConcurrentHashMap;

public interface AuthPlatformService {

    ConcurrentHashMap map = new ConcurrentHashMap();

    /**
     * 获取用户可见project 下的 可见vizs
     *
     * @param
     * @return
     */
    ResultMap getProjectVizs(String authCode, String email);

    String getAuthShareToken(Platform platform, String type, Long id, User user) throws ServerException;

    boolean verifyUser(String token, User user);

    boolean verifyPlatform(String token, Platform platform);

    ResultMap getShareContent(String token, User user, Platform platform, HttpServletRequest request);
}