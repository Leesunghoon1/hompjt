package dao;

import java.util.List;

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
		log.info("회원가입 3번쨰 들어왔냐 ?");
		int isOK = sql.insert(NS + "add", mvo);
		if(isOK > 0) {
			sql.commit();
		}
		return isOK;
	}


	@Override
	public MemberVO login(MemberVO mvo) {
		log.info("login check 3");
		return sql.selectOne(NS+ "login", mvo);
	}


	@Override
	public int logout(String id) {
		log.info("lastLogin check 3");
		int isOK = sql.update(NS + "logout", id);
		if(isOK > 0) {
			sql.commit();
		}
		return isOK;
	}


	@Override
	public List<MemberVO> getList() {
		log.info("getlist check 3");
		return sql.selectList(NS + "list");
	}


	@Override
	public int update(MemberVO mvo) {
		log.info("update check 3");
		int isOK = sql.update(NS + "update", mvo);
		if(isOK > 0) {
			sql.commit();
		}
		return isOK;
	}


	@Override
	public int remove(String id) {
		log.info("update check 3");
		int isOK = sql.delete(NS + "del", id);
		if(isOK > 0) {
			sql.commit();
		}
		return isOK;
	}

}
