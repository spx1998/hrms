package com.hrms.message.dao;

import com.hrms.message.entity.Message;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * (Message)表数据库访问层
 *
 * @author makejava
 * @since 2020-04-30 15:00:01
 */
@Mapper
@Repository
public interface MessageMessageDao {

    void createMessage(String receiverId, String msg);

    List<Message> getUnreadList(String staffId);

    List<Message> getMessageList(String staffId);

    void readMessage(Integer messageId);
}