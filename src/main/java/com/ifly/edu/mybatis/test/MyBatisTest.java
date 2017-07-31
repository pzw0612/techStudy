package com.ifly.edu.mybatis.test;

import java.io.IOException;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.ifly.edu.mybatis.bean.User;
import com.ifly.edu.mybatis.dao.UserMapper;

/**
 *
 * @author pangzhw
 * @date 2015年5月13日
 */
public class MyBatisTest {
	/**
	 * 获得MyBatis SqlSessionFactory
	 * SqlSessionFactory负责创建SqlSession，一旦创建成功，就可以用SqlSession实例来执行映射语句
	 * ，commit，rollback，close等方法。
	 * 
	 * @return
	 */
	private static SqlSessionFactory getSessionFactory() {
		SqlSessionFactory sessionFactory = null;
		String resource = "com/ifly/edu/mybatis/configuration.xml";
		try {
			sessionFactory = new SqlSessionFactoryBuilder().build(Resources.getResourceAsReader(resource));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return sessionFactory;
	}

	public static void main(String[] args) {
		SqlSession sqlSession = getSessionFactory().openSession();
		SqlSession sqlSession2 = getSessionFactory().openSession();
		UserMapper userMapper = sqlSession.getMapper(UserMapper.class);

		// test select
		List<User> list = userMapper.findByName("andy");
		for(User item:list){
			System.out.println(item.getName());
		}
		System.out.println("---------------");
		
        // 同一个session的相同sql查询,将会使用一级缓存 
		list = userMapper.findByName("andy");
		for(User item:list){
			System.out.println(item.getName());
		}
		System.out.println("---------------");
		
        // 参数改变,需要重新查询
	     list = sqlSession.selectList("findByName","xl");
		for(User item:list){
			System.out.println(item.getName());
		}

        // 清空缓存后需要重新查询
		sqlSession.clearCache();
	     
		list = userMapper.findByName("andy");
		for(User item:list){
			System.out.println(item.getName());
		}
		System.out.println("---------------");
		
	     list = sqlSession.selectList("findByName","xl");
		for(User item:list){
			System.out.println(item.getName());
		}
		
		System.out.println("---------------");
	     list = sqlSession.selectList("findByName","xl");
		for(User item:list){
			System.out.println(item.getName());
		}
		
		System.out.println("--------二级缓存-------");	
		sqlSession.clearCache();
		
	     list = sqlSession2.selectList("findByName","xl");
		for(User item:list){
			System.out.println(item.getName());
		}
		
	
		System.out.println("-----------------");	
		list = sqlSession.selectList("findByName","xl");
		for(User item:list){
			System.out.println(item.getName());
		}
		
//		// test insert
//		User user1 = new User();
//		user1.setName("xl");
//		user1.setAge(22);
//		userMapper.insertUser(user1);
//		// it is a must or no data will be insert into server.
//		sqlSession.commit();

	}
}
