package in.com.user.marksheet;

import java.text.SimpleDateFormat;
import java.util.Iterator;
import java.util.List;

public class TestUser {

	public static void main(String[] args) throws Exception {
		//testAddData();
		//testDelete();
		//testUpdate();
		//testFindByPk();
		testSearch();

	}

	public static void testAddData() throws Exception {
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		UserBean bean =new UserBean();
		bean.setFirstName("Riyansh ");
		bean.setLastName("Jain");
		bean.setLoginId("riyansh119@yahoo.com");
		bean.setPassword("123");
		bean.setDob(sdf.parse("2001-01-01"));
		bean.setAddress("Ujjain");
		UserModel model=new UserModel();
		model.addData(bean);
		
	}
	public static void testDelete() throws Exception {
		UserModel.deleteRecord(2);
	}
	public static void testUpdate() throws Exception {
		UserBean bean=new UserBean();
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		bean.setId(1);
		bean.setFirstName("Riyansh");
		bean.setLastName("Jain");
		bean.setLoginId("riyansh@gmai.com");
		bean.setPassword("123");
		bean.setAddress("Bhopal");
		bean.setDob(sdf.parse("2001-01-01"));
		UserModel model =new UserModel();
		model.UpdateRecord(bean);
	}

	public static void testFindByPk() throws Exception {
    UserModel model =new UserModel();
    UserBean bean=model.findByPk(1);
    if(bean!=null) {
    	System.out.print(bean.getId());
    	System.out.print("\t"+bean.getFirstName());
    	System.out.print("\t"+bean.getLastName());
    	System.out.print("\t"+bean.getLoginId());
    	System.out.print("\t"+bean.getPassword());
    	System.out.print("\t"+bean.getDob());
    	System.out.println("\t"+ bean.getAddress());
    }
    else {
    	System.out.println("No record from this id");
    }
		
	}

	public static void testSearch() throws Exception  {
		UserModel model =new UserModel();
		UserBean bean =new UserBean();
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		bean.setDob(sdf.parse("2001-01-01"));

		List list=model.search(bean,1,5);
		Iterator it=list.iterator();
		while(it.hasNext()) {
			bean=(UserBean) it.next();
		System.out.print(bean.getId());
		System.out.print("\t"+bean.getFirstName());
		System.out.print("\t"+bean.getLastName());
		System.out.print("\t"+bean.getLoginId());
		System.out.print("\t"+bean.getPassword());
		System.out.print("\t"+bean.getDob());
		System.out.println("\t"+bean.getAddress());
		}
		
		
	}
	
	
	
}
