package egovframework.com.noticeMng.service;

import egovframework.com.noticeMng.NoticeVO;

public interface NoticeService {

	public void updateReadTimeForNewMark(NoticeVO noticeVO) throws Exception;
	public void updateTimeOfContent(NoticeVO noticeVO) throws Exception;
}
