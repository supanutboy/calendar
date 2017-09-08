package ku.cs.myapp;

import static org.junit.Assert.*;

import org.junit.Test;

import model.Memo;
import model.SubMemo;

public class dateTestinListMemo {

	@Test
	public void test() {
		Memo memo =new Memo();
		SubMemo sub1 = new SubMemo("Go to shopping","25th July 2006,i go to shopping", "25", "july", "2006");
		memo.addSub(sub1);
		SubMemo sub2 = new SubMemo("Go to school","12th October 2006,i must to go to school at 8.30","12","October","2006");
		memo.addSub(sub2);
		SubMemo sub =memo.getListDate().get(1);
		String str= sub.getSubject()+" "+sub.getInfo()+" "+sub.getDay()+" "+sub.getMonth()+" "+sub.getYear();
		assertEquals(str,"Go to school 12th October 2006,i must to go to school at 8.30 12 October 2006");
		
	}
	
	
}
