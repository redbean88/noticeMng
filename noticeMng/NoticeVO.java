package egovframework.com.noticeMng;

public class NoticeVO {

	private String taskId;	//업무 고유키
	
	private String taskManageUserId; // 업무 분기 담당 아이디

	public String getTaskId() {
		return taskId;
	}

	public NoticeVO setTaskId(String taskId) {
		this.taskId = taskId;
		return this;
	}

	public String getTaskManageUserId() {
		return taskManageUserId;
	}

	public NoticeVO setTaskManageUserId(String taskManageUserId) {
		this.taskManageUserId = taskManageUserId;
		return this;
	}
	  
	
	
}
