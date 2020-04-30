package com.hrms.message.service;

import com.hrms.common.domain.MessageTemplate;
import com.hrms.message.dao.*;
import com.hrms.message.entity.Application;
import com.hrms.message.entity.StaffCareerInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class MessageService {
    @Autowired
    MessageApplicationDao messageApplicationDao;

    @Autowired
    MessageStaffCareerInfoDao messageStaffCareerInfoDao;

    @Autowired
    MessageMessageDao messageMessageDao;

    @Autowired
    MessageApplicationStepDao messageApplicationStepDao;

    @Autowired
    MessageDepartmentDao messageDepartmentDao;

    @Transactional
    public List<Application> getApplicationList(String staffId) {
        List<Application> applicationList = messageApplicationDao.getApplicationByApprover(staffId);
        Set<String> staffIds = new HashSet<>();
        for (Application application : applicationList) {
            staffIds.add(application.getApplicantId());
        }
        if (!staffIds.isEmpty()) {
            List<StaffCareerInfo> staffCareerInfoList = messageStaffCareerInfoDao.getStaffInfos(staffIds);

            HashMap<String, String> hashMap = new HashMap<>();
            for (StaffCareerInfo staffCareerInfo : staffCareerInfoList) {
                hashMap.put(staffCareerInfo.getStaffId(), staffCareerInfo.getName());
            }

            for (Application application : applicationList) {
                application.setApplicantName(hashMap.get(application.getApplicantId()));
            }
        }
        return applicationList;
    }

    @Transactional
    public Application getApplicationDetail(Integer id) {
        Application application = messageApplicationDao.getApplicationDetail(id);
        String name = messageStaffCareerInfoDao.getNameByStaffId(application.getApplicantId());
        application.setApplicantName(name);
        return application;
    }

    @Transactional
    public void rejectApplication(Integer id) {
        //TODO: 设为拒绝 发送拒绝信息
        messageApplicationDao.rejectApplication(id);
        Application application = messageApplicationDao.getApplicationDetail(id);
        String name = messageStaffCareerInfoDao.getNameByStaffId(application.getApproverId());
        application.setApproverName(name);
        String msg = generateRejectMessage(application);
        messageMessageDao.createMessage(application.getApplicantId(), msg);
    }

    @Transactional
    public void agreeApplication(Integer id) {
        //TODO: 设为通过 发送同意信息 分类进行后续操作
        Application application = messageApplicationDao.getApplicationDetail(id);
        int nextStep = messageApplicationStepDao.getNextStep(application.getType(), application.getStep());
        String nextId = "";
        String status = "agree";
        if (nextStep == 2) {
            nextId = messageDepartmentDao.getDepartmentHr(application.getApplicantId());
            status = "processing";
        }
        messageApplicationDao.agreeApplication(id, nextId, nextStep, status);
        String name = messageStaffCareerInfoDao.getNameByStaffId(application.getApproverId());
        application.setApproverName(name);
        String msg = generateAgreeMessage(application, nextStep, nextId);
        messageMessageDao.createMessage(application.getApplicantId(), msg);
    }

    private String generateAgreeMessage(Application application, int nextStep, String nextId) {
        String type = "";
        switch (application.getType()) {
            case 1:
                type = "请假";
                break;
            case 2:
                type = "补贴";
                break;
            case 3:
                type = "调动";
                break;
            case 4:
                type = "离职";
                break;

        }
        if (nextStep == 0) {
            return MessageTemplate.agreeApplication[0] + type + MessageTemplate.agreeApplication[1] + application.getApproverName() + MessageTemplate.agreeApplication[2] + MessageTemplate.agreeApplication[4];
        } else
            return MessageTemplate.agreeApplication[0] + type + MessageTemplate.agreeApplication[1] + application.getApproverName() + MessageTemplate.agreeApplication[2] + MessageTemplate.agreeApplication[3];


    }

    private String generateRejectMessage(Application application) {
        String type = "";
        switch (application.getType()) {
            case 1:
                type = "请假";
                break;
            case 2:
                type = "补贴";
                break;
            case 3:
                type = "调动";
                break;
            case 4:
                type = "离职";
                break;

        }
        return MessageTemplate.rejectApplication[0] + type + MessageTemplate.rejectApplication[1] + application.getApproverName() + MessageTemplate.rejectApplication[2];
    }
}
