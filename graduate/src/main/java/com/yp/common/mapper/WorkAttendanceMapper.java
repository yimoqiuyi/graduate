package com.yp.common.mapper;

import com.yp.common.pojo.WorkAttendance;
import org.apache.ibatis.annotations.Param;

import java.util.List;

//��λ��Ӧ���ڲ���
public interface WorkAttendanceMapper {

    public List<WorkAttendance> selectAllWorkAttendanceByAttendanceId(@Param("attendanceId") int attendanceId);

    //�û�-����¼��
    public boolean insertOneWorkAttendance(WorkAttendance workAttendance);

    //�û�-�����޸�
    public boolean updateOneWorkAttendance(WorkAttendance workAttendance);

    //�û�-����ɾ��
    public int deleteOneWorkAttendanceById(@Param("waId") int waId);

    //����userIdɾ���û�-����
    public int deleteWorkAttendacneByUserId(@Param("userId") int userId);
}
