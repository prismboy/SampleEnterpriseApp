package com.ibm.jp.blmx.sample.ejb.local;

import javax.ejb.Local;

@Local
public interface ObjectStorageSessionBeanLocal {
	void write(String containerName, String path, String data);
}
