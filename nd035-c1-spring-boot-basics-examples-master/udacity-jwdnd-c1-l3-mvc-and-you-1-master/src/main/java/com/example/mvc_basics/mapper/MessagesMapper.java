package mapper;

import com.example.mvc_basics.model.ChatMessage;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface MessagesMapper {

    @Select("SELECT * FROM MESSAGES WHERE messageid=#{messageid}")
    ChatMessage getMessageText(String messageid);

    @Insert("INSERT INTO MESSAGES (username, messagetext) VALUES(#{username},#{messagetext}")
    @Options(useGeneratedKeys = true, keyProperty = "messageid")
    int addMessage(ChatMessage message);
}
