package v2.com.company.payroll.services;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;


// TODO Database.java - having bug with executor, "Cause: org.apache.ibatis.executor.ExecutorException: Cannot commit, transaction is already closed"
public class Database {
	private static InputStream config = null;
	private static SqlSessionFactory ssf = null;
	private static SqlSession session = null;
	
	public static SqlSession openSession() throws IOException {
		config = Resources.getResourceAsStream("resources/mybatis/mybatis-config.xml");
		ssf = new SqlSessionFactoryBuilder().build( config);
		session = ssf.openSession();
		
		return session;
	}
	
	public static SqlSession closeSession() throws IOException {
		session.commit();
		session.close();

		return session;	
	}
}
