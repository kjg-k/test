package question;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import sqlmap.MyAppSqlConfig;

public class QuestionDAO {
	private static SqlSessionFactory sqlMapper;
	private static SqlSession session;
	
	static{
		sqlMapper = MyAppSqlConfig.getSqlMapInstance();
		session = sqlMapper.openSession(true);
	}
	
	public boolean create(QuestionDTO dto) throws Exception {	
		boolean flag = false;
		
		try {
			
			if(session.insert("question.create", dto) > 0) {
				flag = true;
			}
					
		} finally {
			session.close();
		}
		
		return flag;	
	}
	
	public List<QuestionDTO> list(Map map) throws Exception {
		
		 return session.selectList("question.list", map);
		 
	}
	
	public QuestionDTO read(int questionNum) throws Exception {
		
		return session.selectOne("question.read", questionNum);
		
	}
	
	public boolean update(QuestionDTO dto) throws Exception {
		boolean flag = false;
		
		try {
			
			if(session.update("question.update", dto) > 0) {
				flag = true;
			}
					
		} finally {
			session.close();
		}
		
		return flag;	
		
	}
	

}
