package egovframework.com.noticeMng.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import egovframework.com.maintenance.service.impl.MaintenanceDAO;
import egovframework.com.noticeMng.NoticeVO;
import egovframework.com.noticeMng.service.NoticeService;
import egovframework.rte.fdl.cmmn.EgovAbstractServiceImpl;

@Service("noticeService")
public class NoticeServiceImpl  extends EgovAbstractServiceImpl implements NoticeService {

	@Resource(name = "noticeDAO")
	private NoticeDAO noticeDAO;
	
	@Override
	public void updateReadTimeForNewMark(NoticeVO noticeVO) throws Exception {
		// TODO Auto-generated method stub
		noticeDAO.updateReadTimeForNewMark(noticeVO);
	}
	

	@Override
	public void updateTimeOfContent(NoticeVO noticeVO) throws Exception {
		// TODO Auto-generated method stub
		noticeDAO.updateTimeOfContent(noticeVO);
	}

}
