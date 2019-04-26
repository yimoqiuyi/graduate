package com.yp.common.service;

import com.yp.common.pojo.Admissioncontract;
import com.yp.common.pojo.Dateutile;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;
import java.util.Map;

public interface AdmissioncontractService {

    //查看单个合同表
    public Admissioncontract selectOneAdmissioncontract(@Param("admissionId") int admissionId);

    //入园合同表的操作
    public List<Admissioncontract> selectOneAllAdmissioncontract(@Param("groupId") int groupId);//根据团队id查看团队所有合同

    //查看所有团队合同表
    public List<Admissioncontract> selectAllAdmissioncontract();

    // 根据分园区外键进行查看合同
    public List<Admissioncontract> selectAllAdmissioncontractBysubParkId(int subParkId);

    //根据总园区外键查看合同
    public List<Admissioncontract> selectAllAdmissioncontractBygeneralParkId(@Param("generalParkId") int generalParkId);

    //@Param("groupId") int groupId,@Param("signDate") String signDate, @Param("expirationDate"
    //根据时间以及团队id选择团队合同
    public List<Admissioncontract> selectAllAdmissioncontractBytimeandgroupID(Dateutile dateutile);

    //根据分园区与时间查看合同
    public List<Admissioncontract> selectAllAdmissioncontractByTimeAndsubParkId(Dateutile dateutile);

    //根据总园区与时间查看合同
    public List<Admissioncontract> selectAllAdmissioncontractByTimeAndgeneralParkId(Dateutile dateutile);

    public List<Admissioncontract> selectAdmissioncontractByLimit(@Param("subParkId") int subParkId, @Param("page") int page, @Param("limit") int limit);

    //通过合同签订与过期时间进行查看合同
    public Admissioncontract selectAllAdmissioncontractBytime(@Param("signDate") String signDate, @Param("expirationDate") String expirationDate);

    //根据条件分页查询合同
    public List<Admissioncontract> selectAdmissioncontractByCondition(@Param("map") Map<String, Object> map);

    //录入团队合同
    public boolean insertOneAdmissioncontract(Admissioncontract admissioncontract);

    //根据id删除合同
    public int delectOneAdmissioncontractByid(@Param("admissionId") int admissionId);

    //删除所有团队合同
    public int delectAllAdmissioncontract();

    //修改入园合同
    public boolean updateOneAdmissioncontractByid(Admissioncontract admissioncontract);

}
