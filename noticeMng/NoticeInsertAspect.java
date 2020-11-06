package egovframework.com.noticeMng;

import javax.annotation.Resource;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import egovframework.com.cmm.LoginVO;
import egovframework.com.cmm.util.EgovUserDetailsHelper;
import egovframework.com.noticeMng.service.NoticeService;

@Component
@Aspect
public class NoticeInsertAspect {
	
	Logger logger = LoggerFactory.getLogger(NoticeInsertAspect.class);
	
	@Resource(name = "noticeService")
	private NoticeService noticeService;
	
	@Pointcut("@annotation(NoticeInsertAnnotation)")
	void getAnnotation(){}
	
	@AfterReturning("getAnnotation()")
	public void NoticeInsetData(JoinPoint jp) throws Throwable{
		
		NoticeVO noticeVO = isTaskIdNull(getNoticeVO(isNull(jp.getArgs())));
		LoginVO loginVO = (LoginVO)EgovUserDetailsHelper.getAuthenticatedUser();
		noticeVO.setTaskManageUserId(loginVO.getUniqId());
		if(noticeVO != null){
			noticeService.updateReadTimeForNewMark(noticeVO);
		}
	}


	private NoticeVO isTaskIdNull(NoticeVO noticeVO) {
		if(noticeVO.getTaskId() == null){
			return null;
		}
		return noticeVO;
	}

	private NoticeVO getNoticeVO(Object[] list) {
		NoticeVO noticeVO = new NoticeVO();
		if(list == null){
			return null;
		}
		for(Object item : list){
			if(item instanceof NoticeVO){
				NoticeVO tempVO = (NoticeVO)item;
				noticeVO.setTaskId(tempVO.getTaskId());
			}
		}
		return noticeVO;
		
	}

	private Object[] isNull(Object[] args) {
		if(args.length < 1 || args ==null){
			return null;
		}
		return args;
	}

}
