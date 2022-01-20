package br.com.intelligence.project.cloud.exception;

import org.springframework.ws.soap.server.endpoint.annotation.FaultCode;
import org.springframework.ws.soap.server.endpoint.annotation.SoapFault;



//@SoapFault( faultCode = FaultCode.CLIENT)
//@SoapFault( faultCode = FaultCode.CUSTOM , customFaultCode = "{http://tce.rs.gov.br}001_Not_Found")
@SoapFault( faultCode = FaultCode.CUSTOM , customFaultCode = "{http://tce.rs.gov.br}001")
public class NotFoundException extends RuntimeException {

	private static final long serialVersionUID = -8530314887665484261L;

	public NotFoundException(String message) {
		super(message);
	}

	
	
}
