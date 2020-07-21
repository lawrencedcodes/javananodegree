
@Mapper
public interface UserMapper {
	@Select("SELECT * FROM USERS WHERE username = #{username}")
	User getUser(String username);


	@Insert("INSERT INTO USERS (username, salt, password, firstname, lastname) " +
	           "VALUES(#{username}, #{salt}, #{password}, #{firstName}, #{lastName})")
		   @Options(useGeneratedKeys = true, keyProperty = "userId")
		      int insert(User user);

	@Delete("DELETE FROM USERS  WHERE username = #{username}")
	   void delete(String username);
}


*********Spring Security Sample*********
@Override
protected void configure(HttpSecurity http) throws Exception {
	   http.authorizeRequests()
		              .antMatchers("/order", "/css/**", "/js/**").permitAll()
			                 .anyRequest().authenticated();
	      http.formLogin()
		                 .loginPage("/login")
				            .permitAll();
	         http.formLogin()
			            .defaultSuccessUrl("/tacos", true);
}
