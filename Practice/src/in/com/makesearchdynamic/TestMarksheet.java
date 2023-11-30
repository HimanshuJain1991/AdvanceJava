package in.com.makesearchdynamic;

import java.util.Iterator;
import java.util.List;

public class TestMarksheet {

	public static void main(String[] args) throws Exception {
		//testSearch();
       // testFindPk();
		testAddData();
	}


	private static void testSearch() throws Exception {
		MarksheetModel model=new MarksheetModel();
		MarksheetBean bean=new MarksheetBean();
		bean.setName("Riyansh");
		bean.setRollNo(102);
		List list=model.search(bean,1,1);
		Iterator it=list.iterator();
		
		while(it.hasNext()) {
			bean=(MarksheetBean) it.next();
			System.out.print(bean.getId());
     		System.out.print("\t"+bean.getName());
			System.out.print("\t"+bean.getRollNo());
			System.out.print("\t"+bean.getPhyscis());
			System.out.print("\t"+bean.getChemistry());
			System.out.println("\t"+bean.getMaths());
		}
	}

	public static void testFindPk() throws Exception {
		MarksheetModel model =new MarksheetModel();
		MarksheetBean bean=model.findByPk1(10);
		if(bean!=null) {
		System.out.print(bean.getId());
		System.out.print("\t"+bean.getName());
		System.out.print("\t"+bean.getRollNo());
		System.out.print("\t"+bean.getPhyscis());
		System.out.print("\t"+bean.getChemistry());
		System.out.println("\t"+bean.getMaths());
		}
		else {
			System.out.println("id not found");
		}
	}
	public static void testAddData() throws Exception{
		MarksheetModel model=new MarksheetModel();
		MarksheetBean bean=new MarksheetBean();
		bean.setName("Sahu Sir Rays");
		bean.setRollNo(231);
		bean.setPhyscis(99);
		bean.setChemistry(88);
		bean.setMaths(100);
		model.addData(bean);
	
	}

}
