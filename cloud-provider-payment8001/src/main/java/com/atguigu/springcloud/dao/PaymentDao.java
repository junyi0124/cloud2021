package com.atguigu.springcloud.dao;

import com.atguigu.springcloud.entites.Payment;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface PaymentDao {

    @Insert("INSERT INTO `t_payment` (`serial`,`count`,`price`,`name`) VALUES (#{serial}, #{count}, #{price}, #{name})")
    int Create(Payment model);

    @Update("update `t_payment` set `count`=#{count},`price`=#{price},`name`=#{name} where `id`=#{id}")
    int Update(@Param("id") long id,
               @Param("count") int count,
               @Param("price") int price,
               @Param("name") String name
    );

    @Delete("delete `t_payment` where `id`=#{id}")
    int Delete(long id);

    @Select("SELECT `id`, `serial`, `count`, `price`,`name` FROM t_payment WHERE `id`=#{id}")
    Payment getPaymentById(@Param("id") long id);

    @Select("SELECT `id`, `serial`, `count`, `price`,`name` FROM t_payment")
    List<Payment> getPayments();




}
