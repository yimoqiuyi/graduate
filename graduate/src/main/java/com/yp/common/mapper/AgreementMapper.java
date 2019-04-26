package com.yp.common.mapper;

import com.yp.common.pojo.Agreement;
import org.apache.ibatis.annotations.Param;

import java.util.List;

//合同的配置操作
public interface AgreementMapper {

    //选择单个合同配置
    public Agreement selectOneAgreementById(@Param("agreementId") int agreementId);

    //选择所有合同的配置
    public List<Agreement> selectAllAgreement();

    //录入合同配置
    public boolean insertAgreement(Agreement agreement);

    //根据合同配置id修改合同配置
    public boolean updateAgreementByid(@Param("agreement") Agreement agreement, @Param("agreementId") int agreementId);

    //根据合同配置id删除合同配置
    public int delectAgreementByid(@Param("agreementId")int agreementId);

    //删除所有合同配置
    public int delectAllAgreement();

    //根据协议 managementId查看合同配置项
    public Agreement selectAgreementBymanagementId(@Param("managementId")int managementId);

    //根据responsibleId查看合同配置
    public Agreement selectAgreementByresponsibleId(@Param("responsibleId")int responsibleId);
}
