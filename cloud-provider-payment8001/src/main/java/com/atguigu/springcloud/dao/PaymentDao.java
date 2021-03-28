package com.atguigu.springcloud.dao;

import com.atguigu.springcloud.entites.Payment;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface PaymentDao {

    @Insert("INSERT INTO `t_payment` (`serial`,`count`,`price`,`name`) VALUES (#{serial}, #{count}, #{price},#{name})")
    int Create(Payment model);

    @Select("SELECT id, `serial`, `count`, `price`,`name` FROM t_payment WHERE id = #{id}")
    Payment getPaymentById(@Param("id") long id);
}
