package com.system.service;

import java.text.ParseException;
import java.util.List;
import java.util.Map;

import com.system.pojo.Leave;

public interface LeaveService {

    void handinLeave(Map<String, Object> paramMap) throws ParseException;

    int getCountLeave(String id);

    List<Leave> findByPaging(Map<String,Object> paramMap) throws Exception;

    Leave findByRecordId(int recordId);

    int getUnhandledCount(int departmentId);

    int getDepartmentLeaveCount(int departmentId);

    List<Leave> findByPagingD(Map<String,Object> paramMap) throws Exception;

    void handleLeave(Map<String,Object> paramMap);
}
