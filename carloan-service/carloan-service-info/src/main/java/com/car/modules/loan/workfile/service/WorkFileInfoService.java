package com.car.modules.loan.workfile.service;

import com.car.modules.loan.workfile.dao.WorkFileInfoDao;
import com.car.modules.loan.workfile.dto.WorkFileInfoDTO;
import com.carloan.api.model.admin.SysUserVo;
import com.carloan.apimodel.common.ResponseResult;
import com.carloan.apimodel.order.AuditType;
import com.carloan.apimodel.order.WorkFileInfoParam;
import com.carloan.feign.admin.SysUserServicefeign;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Slf4j
@Service
public class WorkFileInfoService {
    @Autowired
    private WorkFileInfoDao dao;
    @Autowired
    SysUserServicefeign sysUserServicefeign;

    public static final String[] auditeStateArrXinShenQing = {"2300", "2400", "3100", "3300"
            , "2500", "2600"};
    public static final String[] auditeStateArrFuYi = {"3400", "3500", "3600"};

    //查询质检之后的所有状态的进件
    public PageInfo<WorkFileInfoDTO> query(WorkFileInfoParam param) throws Exception {
        //审批状态,审批类型
        String auditeState = param.getAuditeState();
        String auditType = param.getAuditType();
        List<String> auditeStateList = null;
        if (StringUtils.isEmpty(auditeState) && StringUtils.isEmpty(auditType)) {
            auditeStateList = new ArrayList<>(Arrays.asList(auditeStateArrXinShenQing));
            auditeStateList.addAll(Arrays.asList(auditeStateArrFuYi));
        } else {
            if (!StringUtils.isEmpty(auditType)) {
                if (AuditType.XinShenQing.getKey().equals(auditType)) {
                    auditeStateList = Arrays.asList(auditeStateArrXinShenQing);
                } else {
                    auditeStateList = Arrays.asList(auditeStateArrFuYi);
                }
            }
            if (!StringUtils.isEmpty(auditeState)) {
                auditeStateList = Arrays.asList(auditeState);
            }
        }
        param.setAuditeStateList(auditeStateList);
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("dto", param);
        PageHelper.startPage(param.getCurrentPage(), param.getPageSize());
        List<WorkFileInfoDTO> list = dao.query(paramMap);
        for (WorkFileInfoDTO dto : list) {
            //auditType,审核状态
            String auditeState2 = dto.getAuditeState();
            if (ArrayUtils.contains(auditeStateArrXinShenQing, auditeState2)) {
                dto.setAuditType(AuditType.XinShenQing.getValue());
            } else {
                dto.setAuditType(AuditType.FuYi.getValue());
            }
            //creUserId,信审员ID
            if (!StringUtils.isEmpty(dto.getCreUserId())) {
                try {
                    ResponseResult<SysUserVo> response = sysUserServicefeign.querySysUserByPrimaryKey(dto.getCreUserId());
                    if (response.isSucess()) {
                        SysUserVo sysUser = response.getData();
                        dto.setCreUserUserName(sysUser.getUserName());
                        dto.setCreUserOrgname(sysUser.getOrgname());
                    }
                } catch (Exception ex) {
                    log.error(ex.getMessage(), ex);
                }
            }
        }

        PageInfo<WorkFileInfoDTO> pageInfo = new PageInfo(list);
        return pageInfo;
    }

}
