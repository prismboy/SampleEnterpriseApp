package com.ibm.jp.blmx.sample.ejb.session;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import org.openstack4j.api.OSClient.OSClientV3;
import org.openstack4j.api.storage.ObjectStorageService;
import org.openstack4j.model.common.Payload;
import org.openstack4j.openstack.OSFactory;

import com.ibm.jp.blmx.sample.ejb.bean.ObjectStrageCredentials;
import com.ibm.jp.blmx.sample.ejb.local.ObjectStorageSessionBeanLocal;

@Stateless
@LocalBean
public class ObjectStorageSessionBean implements ObjectStorageSessionBeanLocal {

	public ObjectStorageSessionBean() {
	}

	private class PayloadImpl implements Payload<InputStream> {
		private InputStream in;

		public PayloadImpl(InputStream is) {
			in = is;
		}

		@Override
		public void close() throws IOException {
			in.close();
		}

		@Override
		public void closeQuietly() {
			try {
				in.close();
			} catch (IOException e) {
				;
			}
		}

		@Override
		public InputStream getRaw() {
			return in;
		}

		@Override
		public InputStream open() {
			return in;
		}
	}

	public void write(String containerName, String path, String data) {
		ObjectStorageService service = bindService();

		ByteArrayInputStream bais = new ByteArrayInputStream(data.getBytes());
		Payload<InputStream> payload = new PayloadImpl(bais);
		service.objects().put(containerName, path, payload);
	}

	private ObjectStorageService bindService() {
		ObjectStrageCredentials osCredentials = new ObjectStrageCredentials();
		OSClientV3 os = OSFactory.builderV3().endpoint(osCredentials.getAuth_url())
				.credentials(osCredentials.getUserName(), osCredentials.getPassword(), osCredentials.getDomainIdent())
				.scopeToProject(osCredentials.getProjectIdent()).authenticate();
		os.useRegion(osCredentials.getRegion());

		return os.objectStorage();
	}
}
