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

package io.shulie.amdb.service.impl;

import com.github.pagehelper.PageHelper;
import io.shulie.amdb.common.dto.agent.AgentConfigDTO;
import io.shulie.amdb.common.dto.agent.AgentStatInfoDTO;
import io.shulie.amdb.entity.TAmdbAgentConfigDO;
import io.shulie.amdb.mapper.TAmdbAgentConfigDOMapper;
import io.shulie.amdb.common.request.agent.AgentConfigQueryRequest;
import io.shulie.amdb.service.AgentConfigService;
import com.github.pagehelper.PageInfo;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

/**
 * @author anjone
 * @date 2021/8/18
 */
@Component
public class AgentConfigServiceImpl implements AgentConfigService {

    @Autowired
    TAmdbAgentConfigDOMapper amdbAgentConfigDOMapper;

    @Override
    public PageInfo<AgentConfigDTO> selectByParams(AgentConfigQueryRequest request) {

        Example example = new Example(TAmdbAgentConfigDO.class);
        Example.Criteria criteria = example.createCriteria();
        if (StringUtils.isNotBlank(request.getAppName())) {
            criteria.andLike("appName", '%' + request.getAppName() + '%');
        }
        if (StringUtils.isNotBlank(request.getConfigKey())) {
            criteria.andLike("configKey", '%' + request.getConfigKey() + '%');
        }
        if (request.getStatus() != null) {
            criteria.andEqualTo("status", request.getStatus());
        }

        PageHelper.startPage(request.getCurrentPage(), request.getPageSize());
        List<TAmdbAgentConfigDO> tAmdbAgentConfigDOS = amdbAgentConfigDOMapper.selectByExample(example);

        return new PageInfo(tAmdbAgentConfigDOS);

    }

    @Override
    public AgentStatInfoDTO count(AgentConfigQueryRequest param) {
        TAmdbAgentConfigDO tAmdbAgentConfigDO = new TAmdbAgentConfigDO();
        if(StringUtils.isNotBlank(param.getAppName())) {
            tAmdbAgentConfigDO.setAppName(param.getAppName());
        }
        if(StringUtils.isNotBlank(param.getConfigKey())) {
            tAmdbAgentConfigDO.setConfigKey(param.getConfigKey());
        }
        AgentStatInfoDTO ret = new AgentStatInfoDTO();
        int sum = amdbAgentConfigDOMapper.selectCount(tAmdbAgentConfigDO);
        ret.setConfigCount(sum);

        tAmdbAgentConfigDO.setStatus(false);
        int invalidCount = amdbAgentConfigDOMapper.selectCount(tAmdbAgentConfigDO);
        ret.setInvalidCount(invalidCount);
        ret.setEffectiveCount( ret.getConfigCount() - ret.getInvalidCount());

//        List<AgentStatEntity> agentStatEntities = amdbAgentConfigDOMapper.countGroupByStatus(tAmdbAgentConfigDO);
        return ret;
    }
}
