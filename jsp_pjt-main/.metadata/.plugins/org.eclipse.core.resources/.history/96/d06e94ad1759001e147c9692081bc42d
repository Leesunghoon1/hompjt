package dao;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import domain.MemberVO;
import orm.DatabaseBuilder;

public class MemberDAOImpl implements MemberDAO {
	
	private static final Logger log = LoggerFactory.getLogger(MemberDAOImpl.class);
	private SqlSession sql;
	//sql, DB 연결
	 
	private final String NS = "MemberMapper."; //네임스페이스.id
	 // NS = NameSpace.id 인식
	
	
	public MemberDAOImpl() {
		new DatabaseBuilder();
		sql = DatabaseBuilder.getFactory().openSession();
	}
	
	
	@Override
	public int insert(MemberVO mvo) {
		log.info("회원강비 3번쨰 들어왔냐 ?");
		int isOK = sql.insert(NS + "add", mvo);
		if(isOK > 0) {
			sql.commit();
		}
		return isOK;
	}

}
