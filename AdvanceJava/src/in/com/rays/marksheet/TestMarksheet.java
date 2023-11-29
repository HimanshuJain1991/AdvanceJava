package in.com.rays.marksheet;

import java.util.Iterator;
import java.util.List;

public class TestMarksheet {

	public static void main(String[] args) throws Exception {
     //testAdd();
     // testDelete();
		//testUpdate();
		//testFindByPk();
		//testSearch();
		
	}
	


	public static void testSearch() throws Exception  {
		MarksheetModel model =new MarksheetModel();
		List list=model.search();
		Iterator it=list.iterator();
		while(it.hasNext()) {
			MarksheetBean bean=(MarksheetBean) it.next();
		System.out.print(bean.getId());
		System.out.print("\t"+bean.getName());
		System.out.print("\t"+bean.getRoll_no());
		System.out.print("\t"+bean.getPhyscis());
		System.out.print("\t"+bean.getChemistry());
		System.out.println("\t"+bean.getMaths());
		}
		
		
	}



	public static void testFindByPk() throws Exception {
    MarksheetModel model =new MarksheetModel();
    MarksheetBean bean=model.findByPk(987);
    if(bean!=null) {
    	System.out.print(bean.getId());
    	System.out.print("\t"+bean.getName());
    	System.out.print("\t"+bean.getRoll_no());
    	System.out.print("\t"+bean.getPhyscis());
    	System.out.print("\t"+bean.getChemistry());
    	System.out.print("\t"+bean.getMaths());
    }
    else {
    	System.out.println("id not found");
    }
		
	}

	public static void testAdd() throws Exception {
		MarksheetBean bean=new MarksheetBean();
		//bean.setId(2001);
		bean.setName("Shruti Jain");
		bean.setRoll_no(2222);
		bean.setPhyscis(48);
		bean.setChemistry(87);
		bean.setMaths(58);
		
		MarksheetModel.addRecord(bean);
	
	}
	public static void testDelete() throws Exception {
		MarksheetModel.deleteRecord(2001);
	}
	
	public static void testUpdate() throws Exception{
		MarksheetBean bean1=new MarksheetBean();
		bean1.setId(143);
		bean1.setName("Rays Student");
		bean1.setRoll_no(252);
		bean1.setPhyscis(85);
		bean1.setChemistry(45);
		bean1.setMaths(78);
		MarksheetModel.UpdateRecord(bean1);
		
	}
	

	

}
