package com.udacity.jwdnd.spring_security_basics.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface MessageMapper {

    @Select("SELECT * FROM MESSAGES WHERE messagetext = #{messagetext}")
    Message getMesssage

    @Insert()

}
