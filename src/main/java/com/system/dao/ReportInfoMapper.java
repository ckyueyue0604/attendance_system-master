package com.system.dao;

import java.util.List;
import java.util.Map;

import com.system.pojo.PagingVO;
import com.system.pojo.ReportInfo;

public interface ReportInfoMapper {
    int deleteByPrimaryKey(Integer reportId);

    int insert(ReportInfo record);

    int insertSelective(ReportInfo record);

    ReportInfo selectByPrimaryKey(Integer reportId);

    int updateByPrimaryKeySelective(ReportInfo record);

    int updateByPrimaryKey(ReportInfo record);

    List<ReportInfo> selectReportInfoDataAll(Map<String,Object> paramMap);

    List<ReportInfo> selectReportInfoData(Map<String,Object> paramMap);

    void executeReportProc(Map<String,Object> paramMap);
    
    int getReportInfo();
    
    List<ReportInfo> findByPaging(PagingVO pagingVO) throws Exception;
}