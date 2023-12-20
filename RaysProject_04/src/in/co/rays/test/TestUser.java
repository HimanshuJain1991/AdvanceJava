package in.co.rays.test;

import java.text.SimpleDateFormat;

import in.co.rays.bean.UserBean;
import in.co.rays.model.UserModel;
import in.co.rays.util.DataUtility;

public class TestUser {

	public static void main(String[] args) throws Exception {
		//testaddData();
		//testdelete();
		testUpdate();

	}

	private static void testaddData() throws Exception {
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		UserBean bean=new UserBean();
		bean.setFirstName("Narendra ");
		bean.setLastName("Modi");
		bean.setLoginId("modi@123");
		bean.setPassword("123");
		bean.setDob(sdf.parse("2023-12-09"));
		bean.setAddress("Gujrat");
		UserModel model=new UserModel();
		model.addData(bean);
		
	}
	private static void testdelete() throws Exception{
		
		UserModel model =new UserModel();
		model.deleteRecord(62);
		
	}
	private static void testUpdate() throws Exception{
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		UserBean bean=new UserBean();
		bean.setId(65);
		bean.setFirstName("Himanshu");
		bean.setLastName("Jain");
		bean.setLoginId("parshav1992@gmai.com");
		bean.setPassword("123456");
		bean.setAddress("Indore");
		//bean.setDob(DataUtility.stringToDate("2023-12-11"));
		bean.setDob(sdf.parse("2023-12-12"));
		
		UserModel model=new UserModel();
		model.update(bean);
		
		
		
	}

}
