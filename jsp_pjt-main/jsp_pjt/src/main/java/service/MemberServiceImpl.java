package service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import dao.MemberDAO;
import dao.MemberDAOImpl;
import domain.MemberVO;

public class MemberServiceImpl implements MemberService {
	private static final Logger log = LoggerFactory.getLogger(MemberServiceImpl.class);
	private MemberDAO mdao;
	
	
	public MemberServiceImpl() {
		
		mdao = new MemberDAOImpl();
	}

	@Override
	public int register(MemberVO mvo) {
		log.info("가입 들어왔냐 ?");
		return mdao.insert(mvo);
	}

	@Override
	public MemberVO login(MemberVO mvo) {
		log.info("로그인 서버 임플에 들어왔냐 ?");
		return mdao.login(mvo);
	}

	@Override
	public int lastLogin(String id) {
		log.info("로그아웃 서버 임플에 들어왔냐 ?");
		return mdao.logout(id);
	}

	@Override
	public List<MemberVO> getList() {
		log.info("리시트 서버임플에 왓냐 ?");
		return mdao.getList();
	}

	@Override
	public int update(MemberVO mvo) {
		log.info("업데이트 서버임플에 왔냐 ?");
		return mdao.update(mvo);
	}

	@Override
	public int remove(String id) {
		log.info("리무브 서버임플에 왓냐 ?");
		return mdao.remove(id);
	}

}
