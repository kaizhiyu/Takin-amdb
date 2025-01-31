/*
 * Copyright 2021 Shulie Technology, Co.Ltd
 * Email: shulie@shulie.io
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package io.shulie.amdb.service;

import io.shulie.amdb.common.dto.agent.AgentConfigDTO;
import io.shulie.amdb.common.dto.agent.AgentStatInfoDTO;
import io.shulie.amdb.common.request.agent.AgentConfigQueryRequest;
import com.github.pagehelper.PageInfo;

/**
 * agent配置服务
 *
 * @author anjone
 * @date 2021/8/18
 */
public interface AgentConfigService {
    PageInfo<AgentConfigDTO> selectByParams(AgentConfigQueryRequest param);

    AgentStatInfoDTO count(AgentConfigQueryRequest param);
}
