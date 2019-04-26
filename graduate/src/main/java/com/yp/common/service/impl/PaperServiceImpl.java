package com.yp.common.service.impl;

import com.yp.common.mapper.PaperMapper;
import com.yp.common.pojo.Paper;
import com.yp.common.service.PaperService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Component
public class PaperServiceImpl implements PaperService {
@Autowired
private PaperMapper paperMapper;
    @Override
    public Paper selectOnePaper(int paperId) {
        return paperMapper.selectOnePaper(paperId);
    }

    @Override
    public int selectPapersbyGroupId(int groupId) {
        return paperMapper.selectPapersbyGroupId(groupId);
    }

    @Override
    public List<Paper> selectAllPaperBygroupId(int groupId) {
        return paperMapper.selectAllPaperBygroupId(groupId);
    }

    @Override
    public List<Paper> selectAllPaperBysubParkId(int subParkId) {
        return paperMapper.selectAllPaperBysubParkId(subParkId);
    }

    @Override
    public List<Paper> selectAllPaperBygeneralParkId(int generalParkId) {
        return paperMapper.selectAllPaperBygeneralParkId(generalParkId);
    }

    @Override
    public List<Paper> selectPaperByLimit(Map<String, Object> map) {
        return paperMapper.selectPaperByLimit(map);
    }

    @Override
    public List<Paper> selectPaperByGroupIdAndState(int groupId, int paperState) {
        return paperMapper.selectPaperByGroupIdAndState(groupId,paperState);
    }

    @Override
    public List<Paper> selectPaperByGroupIdandLimit(Map<String, Object> map) {
        return paperMapper.selectPaperByGroupIdandLimit(map);
    }

    @Override
    public boolean insertOnePaper(Paper paper) {
        return paperMapper.insertOnePaper(paper);
    }

    @Override
    public boolean updatePaper(Paper paper) {
        return paperMapper.updatePaper(paper);
    }

    @Override
    public int delectOnePaper(int paperId) {
        return paperMapper.delectOnePaper(paperId);
    }

    @Override
    public int delectAllaper() {
        return paperMapper.delectAllaper();
    }

    @Override
    public int deletePaperByAchievementsId(int achievementsId) {
        return paperMapper.deletePaperByAchievementsId(achievementsId);
    }
}
