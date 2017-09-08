package ku.cs.myapp;

import static org.junit.Assert.*;

import org.junit.Test;

import model.Memo;
import model.SubMemo;

public class EditDateMemo {

	@Test
	public void test() {
		Memo memo =new Memo();
		SubMemo sub1 = new SubMemo("Go to shopping","25th July 2006,i go to shopping", "25", "july", "2006");
		SubMemo sub2 = new SubMemo("Go to school","12th October 2006,i must to go to school at 8.30","12","October","2006");
		sub1.setInfo("Hello");
		sub2.setInfo("ABC");
		assertEquals(sub1.getInfo(),"Hello");
		assertEquals(sub2.getInfo(),"ABC");

	}

}
