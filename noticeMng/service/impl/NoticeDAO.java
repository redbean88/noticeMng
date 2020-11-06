package egovframework.com.noticeMng.service.impl;

import org.springframework.stereotype.Repository;

import egovframework.com.noticeMng.NoticeVO;
import egovframework.rte.psl.dataaccess.EgovAbstractDAO;

@Repository("noticeDAO")
public class NoticeDAO extends EgovAbstractDAO {

	public void updateReadTimeForNewMark(NoticeVO noticeVO) {
		// TODO Auto-generated method stub
		update("noticeDAO.updateReadTimeForNewMark", noticeVO);
	}

	public void updateTimeOfContent(NoticeVO noticeVO) {
		// TODO Auto-generated method stub
		update("noticeDAO.updateTimeOfContent", noticeVO);
	}

}
