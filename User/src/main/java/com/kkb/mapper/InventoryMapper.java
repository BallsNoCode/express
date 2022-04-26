package com.kkb.mapper;

import com.kkb.pojo.Inventory;
import com.kkb.vo.Top;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author APPDE
 */
@Mapper
public interface InventoryMapper extends tk.mybatis.mapper.common.Mapper<Inventory> {

    /**
     * 总排行榜信息
     * @return 手机号 ：次数
     */
    @Select("SELECT e_phone,COUNT(*) as count FROM inventory GROUP BY e_phone ORDER BY COUNT(*) DESC LIMIT 0,5")
    List<Top> count1();

    /**
     * 月排行榜信息
     * @return 手机号 ：次数
     */
    @Select("SELECT e_phone,COUNT(*) as count FROM inventory WHERE YEAR(in_time)=YEAR(NOW()) GROUP BY e_phone ORDER BY COUNT(*) DESC LIMIT 0,5")
    List<Top> count2();

    /**
     * 年排行榜信息
     * @return 手机号 ：次数
     */
    @Select("SELECT e_phone,COUNT(*) as count FROM inventory WHERE DATE_FORMAT(in_time, '%Y%m') = DATE_FORMAT(CURDATE(), '%Y%m') GROUP BY e_phone ORDER BY COUNT(*) DESC LIMIT 0,5")
    List<Top> count3();

}
