package com.yp.common.service.impl;

 import com.yp.common.mapper.PerformanceMapper;
import com.yp.common.pojo.Dateutile;
import com.yp.common.pojo.Performance;
import com.yp.common.service.PasswordHelper;
import com.yp.common.service.PerformanceService;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

 import java.beans.IntrospectionException;
 import java.lang.reflect.InvocationTargetException;
 import java.text.ParseException;
 import java.util.List;
 import java.util.Map;

@Component
public class PerformanceServiceImpl implements PerformanceService {
    @Autowired
    private PerformanceMapper performanceMapper;

    private SalaryDao salaryDao;

    public void setSalaryDao(SalaryDao salaryDao) {
        this.salaryDao = salaryDao;
    }


    @Override
    public Performance selectOnePerformance(int performanceId) {
        return performanceMapper.selectOnePerformance(performanceId);
    }

    @Override
    public List<Performance> selectPerformanceByGroupId(int groupId) {
        return performanceMapper.selectPerformanceByGroupId(groupId);
    }

    @Override
    public List<Performance> selectPerformanceBySubparkId(int subParkId) {
        return performanceMapper.selectPerformanceBySubparkId(subParkId);
    }

    @Override
    public List<Performance> selectPerformanceByGeneralParkId(int generalParkId) {
        return performanceMapper.selectPerformanceByGeneralParkId(generalParkId);
    }

    @Override
    public List<Performance> selectPerformanceByGroupIdAndTime(Dateutile dateutile) {
        return performanceMapper.selectPerformanceByGroupIdAndTime(dateutile);
    }

    @Override
    public List<Performance> selectPerformanceBySubparkIdAndTime(Dateutile dateutile) {
        return performanceMapper.selectPerformanceBySubparkIdAndTime(dateutile);
    }

    @Override
    public List<Performance> selectPerformanceByCondition(Map<String, Object> map) {
        return performanceMapper.selectPerformanceByCondition(map);
    }

    @Override
    public List<Performance> selectPerformanceByGeneralParkIdAndTime(Dateutile dateutile) {
        return performanceMapper.selectPerformanceByGeneralParkIdAndTime(dateutile);
    }

    @Override
    public XSSFWorkbook downLoadExcel(int groupId) {
        List<Performance> performanceList=performanceMapper.selectPerformanceByGroupId(groupId);
        XSSFWorkbook workbook=null;
        try {
            workbook =salaryDao.exportExcelInfo(performanceList);
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (IntrospectionException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return workbook;
    }

    @Override
    public List<Performance> selectPerformanceBySubparkIdAndLimit(int subParkId, int page, int limit) {
        return performanceMapper.selectPerformanceBySubparkIdAndLimit(subParkId, page, limit);
    }

    @Override
    public boolean insertPerformance(Performance performance) {
        return performanceMapper.insertPerformance(performance);
    }

    @Override
    public boolean updatePerformance(Performance performance) {
        return performanceMapper.updatePerformance(performance);
    }

    @Override
    public int deletePerformanceById(int performanceId) {
        return performanceMapper.deletePerformanceById(performanceId);
    }
}
