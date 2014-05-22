/**
 * RemoteExceptionException0.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.4 Built on : Apr 26, 2008 (06:24:30 EDT)
 */

package otservices.mapper.webservice;

public class RemoteExceptionException0 extends java.lang.Exception {
	
	private otservices.mapper.webservice.MapperServerWebServiceImplStub.RemoteExceptionE	faultMessage;
	
	
	public RemoteExceptionException0() {
		super("RemoteExceptionException0");
	}
	
	
	public RemoteExceptionException0(java.lang.String s) {
		super(s);
	}
	
	
	public RemoteExceptionException0(java.lang.String s, java.lang.Throwable ex) {
		super(s, ex);
	}
	
	
	public void setFaultMessage(
			otservices.mapper.webservice.MapperServerWebServiceImplStub.RemoteExceptionE msg) {
		faultMessage = msg;
	}
	
	
	public otservices.mapper.webservice.MapperServerWebServiceImplStub.RemoteExceptionE getFaultMessage() {
		return faultMessage;
	}
}
