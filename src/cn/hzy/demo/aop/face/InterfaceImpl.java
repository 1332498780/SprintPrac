package cn.hzy.demo.aop.face;

public class InterfaceImpl implements AInterface {

	@Override
	public void help() {
		System.out.println("ÈÃÎÒ×öÄãµÄÑÛ¾¦£¡");
	}

	@Override
	public void say(String[] strs) {
		for(String str:strs) {
			System.out.print(str+",");
		}
	}

}
