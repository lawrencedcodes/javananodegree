package com.udacity.jwdnd.c1.review.mapper;

import com.udacity.jwdnd.c1.review.model.User;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;

public interface MessageMapper {
    @Select("SELECT * FROM MESSAGES WHERE username = #{username} ")
    User getUser(String username);

    @Insert("INSERT INTO MESSAGES (username, messagetext)" + "VALUES(#{username}, #{messagetext})")
    @Options(useGeneratedKeys = true, keyProperty = "messageId")
    int insert(User user);

    @Delete("DELETE FROM USERS WHERE username = #{username} ")
    void delete(String username);
}
