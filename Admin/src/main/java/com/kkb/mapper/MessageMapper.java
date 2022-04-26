package com.kkb.mapper;

import com.kkb.pojo.Message;
import org.apache.ibatis.annotations.Mapper;
import tk.mybatis.mapper.common.BaseMapper;

/**
 * @author APPDE
 */
@Mapper
public interface MessageMapper extends BaseMapper<Message> {
}
