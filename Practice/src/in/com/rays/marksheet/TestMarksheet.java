package in.com.rays.marksheet;

import java.util.Iterator;
import java.util.List;

public class TestMarksheet  {

	public static void main(String[] args) throws Exception {
	     testAdd();
		//testDelete();
		//MarksheetModel.getData();
		//testFindByPk();
		//testFindByName();
	//	testSearch();
		//MarksheetModel model=new MarksheetModel();
	//	model.nextPk();
		
		

	}
	
	
		
		
	

	private static void testSearch() throws Exception {
	MarksheetModel model=new MarksheetModel();
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

	public static void testFindByName() throws Exception {
		MarksheetModel model=new MarksheetModel();
		MarksheetBean bean=model.findByName("Riyansh Jain");
		if(bean!=null) {
			System.out.print(bean.getId());
			System.out.print("\t"+bean.getName());
			System.out.print("\t"+bean.getRoll_no());
			System.out.print("\t"+bean.getPhyscis());
			System.out.print("\t"+bean.getChemistry());
			System.out.print("\t"+bean.getMaths());
		}
		else {
			System.out.println("Name Not Found");
		}
		
	}

	public  void testFindByPk() throws Exception {
	  MarksheetModel model=new MarksheetModel();
	 MarksheetBean bean= model.findByPk(477);
	 if(bean!=null) {
		System.out.println(bean.getId());
		System.out.print(bean.getName());
		System.out.print(bean.getRoll_no());
		System.out.print(bean.getPhyscis());
		System.out.print(bean.getChemistry());
		System.out.print(bean.getMaths());
	 }else {
		 System.out.println("Id not found");
		 
	 }
	}

	static void testDelete() throws Exception {
	MarksheetBean bean2=new MarksheetBean();
	bean2.setId(888);
	MarksheetModel.deleteData(bean2);
		
	}
	public static void testAdd() throws Exception  {
		MarksheetBean bean=new MarksheetBean();
		bean.setName("PM MODI New");bean.setRoll_no(1111);
		bean.setPhyscis(88);bean.setChemistry(65);bean.setMaths(99);
		MarksheetModel.insertData(bean);

	
		
		
	}

}
