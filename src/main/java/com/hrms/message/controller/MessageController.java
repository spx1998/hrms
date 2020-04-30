package com.hrms.message.controller;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.hrms.common.domain.CONTANTS;
import com.hrms.common.domain.Msg;
import com.hrms.message.dao.MessageApplicationDao;
import com.hrms.message.dao.MessageMessageDao;
import com.hrms.message.dao.MessageReasonDao;
import com.hrms.message.dao.MessageStaffCareerInfoDao;
import com.hrms.message.entity.Application;
import com.hrms.message.entity.Message;
import com.hrms.message.entity.Reason;
import com.hrms.message.service.MessageService;
import com.hrms.security.utils.TokenUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MessageController {
    @Autowired
    MessageApplicationDao messageApplicationDao;

    @Autowired
    MessageStaffCareerInfoDao messageStaffCareerInfoDao;

    @Autowired
    MessageReasonDao messageReasonDao;

    @Autowired
    MessageMessageDao messageMessageDao;

    @Autowired
    MessageService messageService;

    @Autowired
    TokenUtils tokenUtils;

    private final Gson gson = new GsonBuilder()
            .setDateFormat("yyyy-MM-dd")
            .create();

    /**
     * 获取申请列表
     */
    @GetMapping("/message/application")
    public String getApplicationList(@RequestHeader("token") String token) {
        Msg msg = new Msg();
        try {
            String staffId = tokenUtils.getStaffIdFromToken(token);
            List<Application> applicationList = messageService.getApplicationList(staffId);
            msg.setStatus(CONTANTS.STATUS_SUCCESS);
            msg.setContent(gson.toJson(applicationList));
        } catch (Exception e) {
            e.printStackTrace();
            msg.setStatus(CONTANTS.STATUS_ERROR);
        }
        return gson.toJson(msg);
    }

    /**
     * 获取申请详情
     */
    @GetMapping("/application/detail")
    public String getApplicationDetail(@RequestParam("id") Integer id) {
        Msg msg = new Msg();
        try {
            Application application = messageService.getApplicationDetail(id);
            msg.setStatus(CONTANTS.STATUS_SUCCESS);
            msg.setContent(gson.toJson(application));
        } catch (Exception e) {
            e.printStackTrace();
            msg.setStatus(CONTANTS.STATUS_ERROR);
        }
        return gson.toJson(msg);
    }

    /**
     * 获取原因列表
     */
    @GetMapping("/application/reason/list")
    public String getReasonList() {
        Msg msg = new Msg();
        try {
            List<Reason> reasonList = messageReasonDao.getReasonList();
            msg.setStatus(CONTANTS.STATUS_SUCCESS);
            msg.setContent(gson.toJson(reasonList));
        } catch (Exception e) {
            e.printStackTrace();
            msg.setStatus(CONTANTS.STATUS_ERROR);
        }
        return gson.toJson(msg);
    }

    /**
     * 拒绝申请
     */
    @PostMapping("/application/reject/{id}")
    public String rejectApplication(@PathVariable("id") Integer id) {
        Msg msg = new Msg();
        try {
            messageService.rejectApplication(id);
            msg.setStatus(CONTANTS.STATUS_SUCCESS);
        } catch (Exception e) {
            e.printStackTrace();
            msg.setStatus(CONTANTS.STATUS_ERROR);
        }
        return gson.toJson(msg);
    }

    /**
     * 同意申请
     */
    @PostMapping("/application/agree/{id}")
    public String agreeApplication(@PathVariable("id") Integer id) {
        Msg msg = new Msg();
        try {
            messageService.agreeApplication(id);
            msg.setStatus(CONTANTS.STATUS_SUCCESS);
        } catch (Exception e) {
            e.printStackTrace();
            msg.setStatus(CONTANTS.STATUS_ERROR);
        }
        return gson.toJson(msg);
    }

    /**
     * 获取未读消息
     */
    @GetMapping("/message/unread")
    public String getUnreadList(@RequestHeader("token") String token) {
        Msg msg = new Msg();
        try {
            String staffId = tokenUtils.getStaffIdFromToken(token);
            List<Message> messages = messageMessageDao.getUnreadList(staffId);
            msg.setStatus(CONTANTS.STATUS_SUCCESS);
            msg.setContent(gson.toJson(messages));
        } catch (Exception e) {
            e.printStackTrace();
            msg.setStatus(CONTANTS.STATUS_ERROR);
        }
        return gson.toJson(msg);
    }

    /**
     * 获取全部消息
     */
    @GetMapping("/message/all")
    public String getAllMessageList(@RequestHeader("token") String token) {
        Msg msg = new Msg();
        try {
            String staffId = tokenUtils.getStaffIdFromToken(token);
            List<Message> messages = messageMessageDao.getMessageList(staffId);
            msg.setStatus(CONTANTS.STATUS_SUCCESS);
            msg.setContent(gson.toJson(messages));
        } catch (Exception e) {
            e.printStackTrace();
            msg.setStatus(CONTANTS.STATUS_ERROR);
        }
        return gson.toJson(msg);
    }

    /**
     * 阅读消息
     */
    @PostMapping("/message/read")
    public String read(@RequestBody String jsonStr) {
        Msg msg = new Msg();
        try {
            Message message = gson.fromJson(jsonStr, Message.class);
            messageMessageDao.readMessage(message.getMessageId());
            msg.setStatus(CONTANTS.STATUS_SUCCESS);
        } catch (Exception e) {
            e.printStackTrace();
            msg.setStatus(CONTANTS.STATUS_ERROR);
        }
        return gson.toJson(msg);
    }
}
