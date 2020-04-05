package com.hk.test;

import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.log4j.Logger;
import org.junit.Test;

import com.hk.mapper.UserMapper;
import com.hk.pojo.MyUser;

public class MyBatisTest {
	//private static Logger logger = Logger.getLogger(MyBatisTest.class); 
	@Test
	public void test1() {
		 // 读取配置文件 mybatis-config.xml
        InputStream config;
		try {
			config = Resources
			        .getResourceAsStream("mybatis-config.xml");
			 // 根据配置文件构建SqlSessionFactory
	        SqlSessionFactory ssf = new SqlSessionFactoryBuilder()
	                .build(config);
	        // 通过 SqlSessionFactory 创建 SqlSession
	        SqlSession ss = ssf.openSession();
	        // 查询一个用户
			/*
			 * MyUser mu = ss.selectOne( "com.hk.mapper.UserMapper.selectUserById", 1);
			 * List<MyUser> list=ss.selectList("com.hk.mapper.UserMapper.selectAllUser");
			 */
	        
	        UserMapper dao=ss.getMapper(UserMapper.class);
	        MyUser myUser=dao.selectUserById("1");
	        System.out.println(myUser);
	        MyUser user=new MyUser();
	        user.setUid("1");
	        user.setUname("李四");
	        user.setUage(1);
	        user.setBirth(new Date());
	        //MyUser mu = ss.selectOne( "com.hk.mapper.UserMapper.selectUserById", 1);
	        //ss.insert("com.hk.mapper.UserMapper.addUser", user);
	        //ss.update("com.hk.mapper.UserMapper.updateUser", user);
	        //ss.delete("com.hk.mapper.UserMapper.deleteUser", "1");
            //System.out.println(mu);
            ss.commit();
            ss.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
       
	}
}
