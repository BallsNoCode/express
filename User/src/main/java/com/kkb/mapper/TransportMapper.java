package com.kkb.mapper;

import com.kkb.pojo.Transport;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectKey;

import java.util.List;

/**
 * @author APPDE
 */
@Mapper
public interface TransportMapper extends tk.mybatis.mapper.common.Mapper<Transport> {


}
