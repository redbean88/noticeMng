# noticeMng

# excelManage

# �����

### ��������
+ ����������ȸ ��Ʈ�ѷ�
  + ������̼� �� �Ķ���� �߰�
  + @NoticeInsertAnnotation
  + @ModelAttribute("noticeVO") NoticeVO noticeVO 
  + **taskId**�� ���� PK��, **taskManageUserId**�� ����� PK��
  > ����
  ```java
  
    @NoticeInsertAnnotation
	@RequestMapping("/maintenance/selectTaskMngView.do")
	public String SelectTaskMngView(@ModelAttribute("maintenanceVO") MaintenanceVO maintenanceVO, 
			@ModelAttribute("noticeVO") NoticeVO noticeVO 	,//new��ũ ǥ�ø� ���� ó��
			ModelMap model) throws Exception {
      
      ...�������μ���...
      
      
      };
   ```
   
+ new ǥ�� ���� ��Ʈ�ѷ�
  + ������̼� �� �Ķ���� �߰�
  + @@NoticeUpdateTimeOfContentAnnotation
  + @ModelAttribute("noticeVO") NoticeVO noticeVO 	
  + **taskId**�� ���� PK��, **taskManageUserId**�� ����� PK��
  > ����
  ```java
  //��������ó��
	@NoticeUpdateTimeOfContentAnnotation //new��ũ ǥ�ø� ���� ó��
	@RequestMapping("/maintenance/updateTaskMngEditProc.do")
	public String UpdateTaskMngEditProc(@ModelAttribute("maintenanceVO") MaintenanceVO maintenanceVO, 
			@ModelAttribute("noticeVO") NoticeVO noticeVO 	,//new��ũ ǥ�ø� ���� ó��
			ModelMap model, EmplyrVo emplyrVO) throws Exception {
      
        ...�������μ���...
      
      };
  
  ```
+ ��� ��ȸ ����
  + new��Ŀ ǥ�� ���� �߰�
  ```sql
  CASE WHEN 
  NVL((select 
    LAST_UPDUSR_PNTTM 
  from 
    NOTICE_MNG_COUNTER C 
  where 
    C.CONTER_FLAG = 'contents' AND C.MNG_UNIQ_ID = E.MNG_UNIQ_ID
  ),E.MNG_EDIT_DATE) 																		/*�ش�� ���� ������(��� ����)*/
   >
          NVL(
          (select 
            /*+ INDEX_DESC(C MAINTENACE_CNT_IDX)*/ LAST_UPDUSR_PNTTM 
          from
            NOTICE_MNG_COUNTER C 
          where 
            C.CONTER_FLAG = 'user' AND C.MNG_UNIQ_ID = E.MNG_UNIQ_ID AND C.UNIQ_ID = #taskManageUserId# AND ROWNUM = 1
  ),TO_DATE ('20000101','YYYYMMDD'))  																		/*�ش�� ���� Ȯ����*/
          THEN 'new'
             ELSE 'old' END
          AS NEW_MARK 
  ```
