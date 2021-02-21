package com.edu.gdut.imis.CommunityMIS.action;

import java.io.File;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import net.sf.json.JSONArray;
import com.edu.gdut.imis.CommunityMIS.bean.User;
import com.edu.gdut.imis.CommunityMIS.bean.Entry;
import com.edu.gdut.imis.CommunityMIS.bean.Member;
import com.edu.gdut.imis.CommunityMIS.bean.Activity;
import com.edu.gdut.imis.CommunityMIS.dao.UserDAO;
import com.edu.gdut.imis.CommunityMIS.dao.EntryDAO;
import com.edu.gdut.imis.CommunityMIS.dao.MemberDAO;
import com.edu.gdut.imis.CommunityMIS.dao.ActivityDAO;
import com.edu.gdut.imis.CommunityMIS.util.Constants;
import com.edu.gdut.imis.CommunityMIS.util.StringUtils;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

@SuppressWarnings("serial")
public class UserAction extends ActionSupport {
	private User user;
	@Autowired
	private UserDAO userDAO;
	private List<User> userlist;

	private Activity activity;
	private List<Activity> activitylist;
	@Autowired
	private ActivityDAO activityDAO;
    
	private Member member;
	private List<Member> memberlist;
	@Autowired
	private MemberDAO memberDAO;
	
	private Integer currentPage;
	private static Integer pageSize = 20;
	private Long totalCount;
	private Long totalPage;

	private String[] checkboxid;
	private Integer tid;
	private String actionmessage;
	private Integer[] id;
	private String images;
	private String content;
	private String comNum;
	private JSONArray resultTypelist;
	private String errorMessag;
	private Integer status;
	private File fileInput;
	private String fileInputName;
	
	private Entry entry;
	@Autowired
	private EntryDAO entryDAO;
	private List<Entry> entrylist;

	public String user_user_edit(){
		if(user != null && user.getId()!= null){
			user = userDAO.findById(user.getId());
		}
		return "success";
	}
	
	public String user_user_messageedit(){
		user = (User) ActionContext.getContext().getSession()
				.get(Constants.USER_SESSION);
		return "success";
	}
	public String user_user_messagesave(){
		if(user != null){
			userDAO.update(user);
			addActionMessage("操作成功.");
		}
		return "user_user_messagesave";
	}
	

	public String user_user_save(){
		if(user != null){
			if(user.getId()==null){
				user.setPassword(user.getPassword());
				userDAO.save(user);
			}else{
				user.setPassword(user.getPassword());
				userDAO.update(user);
			}
			addActionMessage("操作成功.");
		}
		int i = user.getMean();
		user = new User();
		user.setMean(i);
		return user_user_list();
	}
	
	public String user_user_audit(){
		if(user!=null && user.getId()!=null){
			user = userDAO.findById(user.getId());
			user.setMean(2);
			userDAO.update(user);
			addActionMessage("审核成功.");
		}
		user = new User();
		return user_user_list();
	}
	
	@SuppressWarnings("unchecked")
	public String user_user_list(){
		if(currentPage== null){
			currentPage=1;
		}
		if(user==null){
			user = new User();
		}
		if(user != null){
			
			user.setState(1);
			userlist = userDAO.find(user, (currentPage - 1) * pageSize,
					pageSize);
			
			totalCount = (long) userDAO.findByExample(user).size();
			totalPage = (totalCount-1+pageSize)/pageSize;
		}
		
		return "user_user_list";
	}

	public String user_user_del(){
		if(user!= null && user.getId() != null){
			user = userDAO.findById(user.getId());
			userDAO.delete(user);
			addActionMessage("操作成功.");
		}
		user = new User();
		return user_user_list();
	}
	
	public String editUser() {
		user = (User) ActionContext.getContext().getSession()
				.get(Constants.USER_SESSION);
		if (user != null) {
			if (user.getId() != null) {
				user = userDAO.findById(user.getId());
			}
		}
		return "editUser";
	}

	public String saveUser() {
		if (user == null) {
			user = new User();
		}
		
		if ("".equals(user.getPassword())) {
			addActionError("密码不能为空.");
			return "saveUser";
		}
		if (user.getId() != null) {
			String s = user.getPassword();
			user = userDAO.findById(user.getId());
			user.setPassword(s);
			addActionMessage("密码修改成功.");
			userDAO.update(user);
		}
		return "saveUser";
	}

	@SuppressWarnings("unchecked")
	public String user_activity_list() {
		if (currentPage == null) {
			currentPage = 1;
		}

		if (activity == null) {
			activity = new Activity();
		}
		if(activity!=null) {
		activitylist = activityDAO.find(activity, (currentPage - 1) * pageSize,
				pageSize);
	
		
		totalCount = (long) activityDAO.findByExample(activity).size();
		totalPage = (totalCount-1+pageSize)/pageSize;
		
		}
		
		return "user_activity_list";
	}
	
	@SuppressWarnings("unchecked")
	public String user_entry_list(){
		if (currentPage == null) {
			currentPage = 1;
		}
		
		if (entry == null) {
			entry = new Entry();
		}
		
		entrylist = entryDAO.find(entry, (currentPage - 1) * pageSize,
				pageSize);
		
		totalCount = (long) entryDAO.findByExample(entry).size();
		
		totalPage = totalCount % pageSize == 0 ? totalCount / pageSize
				: totalCount / pageSize + 1;
		return "user_entry_list";
	}
	
	public String user_entry_yes(){
		if(entry!=null && entry.getId()!=null){
			entry = entryDAO.findById(entry.getId());
			entry.setState(1);
			entryDAO.update(entry);
			addActionMessage("操作成功.");
		}
		return user_entry_list();
	}
	
	public String user_entry_no(){
		if(entry!=null && entry.getId()!=null){
			entry = entryDAO.findById(entry.getId());
			entry.setState(2);
			entryDAO.update(entry);
			addActionMessage("操作成功.");
		}
		return user_entry_list();
	}

	
	public String user_activity_edit() {
		if (activity != null) {
			if (activity.getId() != null) {
				activity = activityDAO.findById(activity.getId());
				
			}
		}
		return "success";
	}
	
	public String user_activity_view() {
		if (activity != null) {
			if (activity.getId() != null) {
				activity = activityDAO.findById(activity.getId());
				
			}
		}
		return "success";
	}
	
	public String user_entry_edit() {
		if (entry != null) {
			if (entry.getId() != null) {
				entry = entryDAO.findById(entry.getId());
				
			}
		}
		return "success";
	}
	
	public String user_activity_save() {
		if (activity != null) {
			if (activity.getId() != null) {
				activity.setCreatedate(new Timestamp(new Date().getTime()));
				activityDAO.update(activity);
				addActionMessage("操作成功.");
			} else {
					activity.setCreatedate(new Timestamp(new Date().getTime()));
					activityDAO.save(activity);
					addActionMessage("操作成功.");
			}

		} else {
			addActionMessage("操作失败.");
		}
		return user_activity_list();
	}
	
	@SuppressWarnings("unchecked")
	public String user_entry_save(){
		
		if (entry != null&&entry.getAid()!=null) {
		
				user = (User) ActionContext.getContext().getSession()
					.get(Constants.USER_SESSION);
				Entry b = new Entry();
				b.setUid(user.getId());
				b.setAid(entry.getAid());
				entrylist = entryDAO.findByExample(b);
				if(entrylist!=null&&entrylist.size()>0){
					addActionMessage("此活动您已报名，请勿重复报名.");
					activity = new Activity();
					return user_activity_list();
				}
				
				
				activity = activityDAO.findById(entry.getAid());
				entry.setUid(user.getId());
				entry.setState(0);
				entry.setSex(user.getSex());
				entry.setPhone(user.getPhone());
				entry.setName(user.getName());
				entry.setBackup(activity.getTheme());
				entry.setCreatedate(new Timestamp(new Date().getTime()));
				entryDAO.save(entry);
				addActionMessage("报名成功.");
		}else{
			addActionMessage("操作异常.");
		}
		activity = new Activity();
		return user_activity_list();
		
	}
	

	
	public String user_activity_del() {
		if (activity != null) {
			if (activity.getId() != null) {
				activity = activityDAO.findById(activity.getId());
				activityDAO.delete(activity);
			}
			
		}
		addActionMessage("操作成功.");
		return user_activity_list();
	}
	public String user_entry_del() {
		if (entry != null) {
			if (entry.getId() != null) {
				entry = entryDAO.findById(entry.getId());
				entryDAO.delete(entry);
			}
			
		}
		addActionMessage("操作成功.");
		return user_activity_list();
	}

	private String errormessage;
	@SuppressWarnings("unchecked")
	public String user_user_regedit(){
		
		if(user!=null){
			if(StringUtils.isEmpty(user.getUsername())){
				this.setErrormessage("请输入用户名");
				return "user_user_regedit_error";
			}else{
				userlist = userDAO.findByUsername(user.getUsername());
				if(userlist!=null && userlist.size()>0){
					this.setErrormessage(" 此用户名已存在");
					return "user_user_regedit_error";
				}
			}
			if(StringUtils.isEmpty(user.getPassword())){
				this.setErrormessage("请输入密码");
				return "user_user_regedit_error";
			}
			if(StringUtils.isEmpty(user.getName())){
				this.setErrormessage("请输入姓名");
				return "user_user_regedit_error";
			}
			if(StringUtils.isEmpty(user.getPhone())){
				this.setErrormessage("请输入手机");
				return "user_user_regedit_error";
			}
			user.setMean(1);
			user.setState(1);
			userDAO.save(user);
			this.setErrormessage("注册成功，请登录");
		}
		
		return "user_user_regedit_success";
	}
	
	
	
	
	
	
	
	
	
	
	@SuppressWarnings("unchecked")
	public String user_member_list() {
		if (currentPage == null) {
			currentPage = 1;
		}

		if (member == null) {
			member = new Member();
		}
		memberlist = memberDAO.find(member, (currentPage - 1) * pageSize,
				pageSize);
		
		totalCount = (long) memberDAO.findByExample(member).size();
		totalPage = totalCount % pageSize == 0 ? totalCount / pageSize
				: totalCount / pageSize + 1;
		return "user_member_list";
	}
	

	
	public String user_member_edit() {
		if (member != null) {
			if (member.getId() != null) {
				member = memberDAO.findById(member.getId());
				
			}
		}
		return "success";
	}
	
	public String user_member_view() {
		if (member != null) {
			if (member.getId() != null) {
				member = memberDAO.findById(member.getId());
				
			}
		}
		return "success";
	}

	
	public String user_member_save() {
		if (member != null) {
			if (member.getId() != null) {
				member.setCreatedate(new Timestamp(new Date().getTime()));
				memberDAO.update(member);
				addActionMessage("操作成功.");
			} else {
					member.setCreatedate(new Timestamp(new Date().getTime()));
					memberDAO.save(member);
					addActionMessage("操作成功.");
			}

		} else {
			addActionMessage("操作失败.");
		}
		return user_member_list();
	}
	

	
	public String user_member_del() {
		if (member != null) {
			if (member.getId() != null) {
				member = memberDAO.findById(member.getId());
				memberDAO.delete(member);
			}
			
		}
		addActionMessage("操作成功.");
		return user_member_list();
	}

	
	
	
	
	
	
	
	
	
	
	
	

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public UserDAO getUserDAO() {
		return userDAO;
	}

	public void setUserDAO(UserDAO userDAO) {
		this.userDAO = userDAO;
	}

	public List<User> getUserlist() {
		return userlist;
	}

	public void setUserlist(List<User> userlist) {
		this.userlist = userlist;
	}

	public Activity getActivity() {
		return activity;
	}

	public void setActivity(Activity activity) {
		this.activity = activity;
	}

	public List<Activity> getActivitylist() {
		return activitylist;
	}

	public void setActivitylist(List<Activity> activitylist) {
		this.activitylist = activitylist;
	}

	public ActivityDAO getActivityDAO() {
		return activityDAO;
	}

	public void setActivityDAO(ActivityDAO activityDAO) {
		this.activityDAO = activityDAO;
	}

	public Integer getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(Integer currentPage) {
		this.currentPage = currentPage;
	}

	public static Integer getPageSize() {
		return pageSize;
	}

	public static void setPageSize(Integer pageSize) {
		UserAction.pageSize = pageSize;
	}

	public Long getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(Long totalCount) {
		this.totalCount = totalCount;
	}

	public Long getTotalPage() {
		return totalPage;
	}

	public void setTotalPage(Long totalPage) {
		this.totalPage = totalPage;
	}

	public String[] getCheckboxid() {
		return checkboxid;
	}

	public void setCheckboxid(String[] checkboxid) {
		this.checkboxid = checkboxid;
	}

	public Integer getTid() {
		return tid;
	}

	public void setTid(Integer tid) {
		this.tid = tid;
	}

	public String getActionmessage() {
		return actionmessage;
	}

	public void setActionmessage(String actionmessage) {
		this.actionmessage = actionmessage;
	}

	public Integer[] getId() {
		return id;
	}

	public void setId(Integer[] id) {
		this.id = id;
	}

	public String getImages() {
		return images;
	}

	public void setImages(String images) {
		this.images = images;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getComNum() {
		return comNum;
	}

	public void setComNum(String comNum) {
		this.comNum = comNum;
	}

	public JSONArray getResultTypelist() {
		return resultTypelist;
	}

	public void setResultTypelist(JSONArray resultTypelist) {
		this.resultTypelist = resultTypelist;
	}

	public String getErrorMessag() {
		return errorMessag;
	}

	public void setErrorMessag(String errorMessag) {
		this.errorMessag = errorMessag;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public File getFileInput() {
		return fileInput;
	}

	public void setFileInput(File fileInput) {
		this.fileInput = fileInput;
	}

	public String getFileInputName() {
		return fileInputName;
	}

	public void setFileInputName(String fileInputName) {
		this.fileInputName = fileInputName;
	}

	public Entry getEntry() {
		return entry;
	}

	public void setEntry(Entry entry) {
		this.entry = entry;
	}

	public EntryDAO getEntryDAO() {
		return entryDAO;
	}

	public void setEntryDAO(EntryDAO entryDAO) {
		this.entryDAO = entryDAO;
	}

	public List<Entry> getEntrylist() {
		return entrylist;
	}

	public void setEntrylist(List<Entry> entrylist) {
		this.entrylist = entrylist;
	}

	public String getErrormessage() {
		return errormessage;
	}

	public void setErrormessage(String errormessage) {
		this.errormessage = errormessage;
	}

	public Member getMember() {
		return member;
	}

	public void setMember(Member member) {
		this.member = member;
	}

	public List<Member> getMemberlist() {
		return memberlist;
	}

	public void setMemberlist(List<Member> memberlist) {
		this.memberlist = memberlist;
	}

	public MemberDAO getMemberDAO() {
		return memberDAO;
	}

	public void setMemberDAO(MemberDAO memberDAO) {
		this.memberDAO = memberDAO;
	}

	
     
}
