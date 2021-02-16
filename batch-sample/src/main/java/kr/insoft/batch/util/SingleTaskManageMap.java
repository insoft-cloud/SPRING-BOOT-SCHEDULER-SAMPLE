package kr.insoft.batch.util;

import java.util.HashMap;

public class SingleTaskManageMap extends HashMap<String, Object>{
	private static final long serialVersionUID = -4965906406520499314L;
	private static SingleTaskManageMap singleTaskManageMap;
	
	private SingleTaskManageMap() {}
	
	public static synchronized SingleTaskManageMap getInstance() {
		if(singleTaskManageMap == null) {
			singleTaskManageMap = new SingleTaskManageMap();
	      }
	      return singleTaskManageMap;
	}
}
