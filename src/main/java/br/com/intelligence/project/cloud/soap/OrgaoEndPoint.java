package br.com.intelligence.project.cloud.soap;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import br.com.intelligence.project.cloud.entity.Orgao;
import br.com.intelligence.project.cloud.exception.NotFoundException;
import br.com.intelligence.project.cloud.helper.Status;
import br.com.intelligence.project.cloud.service.imp.OrgaoServiceImp;
import br.com.intelligenceweb.DeleteOrgaoRequest;
import br.com.intelligenceweb.DeleteOrgaoResponse;
import br.com.intelligenceweb.GetAllOrgaoDetailRequest;
import br.com.intelligenceweb.GetAllOrgaoDetailResponse;
import br.com.intelligenceweb.GetOrgaoDetailRequest;
import br.com.intelligenceweb.GetOrgaoDetailResponse;
import br.com.intelligenceweb.OrgaoDetail;
import br.com.intelligenceweb.StatusSoap;

@Endpoint
public class OrgaoEndPoint {
	
	@Autowired
	OrgaoServiceImp service;
	
	
	
	@PayloadRoot( namespace = "http://intelligenceweb.com.br" , localPart = "GetOrgaoDetailRequest" )
	@ResponsePayload
	public GetOrgaoDetailResponse processGetOrgaoDetailRequest(@RequestPayload GetOrgaoDetailRequest req) throws Exception {
		
		Optional<Orgao> opt = service.findById(req.getId());
		
		if ( opt.isEmpty() )
			throw new NotFoundException("Invalid Orgao id: "+ req.getId());
		else 
			return convertToCustomerDetailResponse(   opt.get()  );
		
	}
	
	
	@PayloadRoot( namespace = "http://intelligenceweb.com.br" , localPart = "GetAllOrgaoDetailRequest" )
	@ResponsePayload
	public GetAllOrgaoDetailResponse processGetAllOrgaoDetailRequest(@RequestPayload GetAllOrgaoDetailRequest req) throws Exception {
		return convertToGetAllCustomerDetailResponse( service.getAll() );
	}
	
	
	@PayloadRoot( namespace = "http://intelligenceweb.com.br" , localPart = "DeleteOrgaoRequest" )
	@ResponsePayload
	public DeleteOrgaoResponse procesDeleteOrgaoRequest(@RequestPayload DeleteOrgaoRequest req) throws Exception {
		DeleteOrgaoResponse resp = new DeleteOrgaoResponse();
		resp.setStatus(  convertToStatusSoap(service.deleteById(req.getId())) );
		return resp;
	}
	
	
	
	
	
	
	
	/**
	 * Este metodo é Responsavel por receber um Orgao e Transformar em um OrgaoDetail
	 * @param og
	 * @return
	 */
	private OrgaoDetail convertToOrgaoDetail(Orgao og) {
		OrgaoDetail det = new OrgaoDetail();
		det.setId(og.getId());
		det.setNome(og.getNome());
		return det;
	}
	
	
	/**
	 * Este Metodo é responsavel po Receber um Objeto Orgao e Transformar em um retorno para o WebService Soap
	 * @param o
	 * @return
	 */
	private GetOrgaoDetailResponse convertToCustomerDetailResponse(Orgao o) {
		GetOrgaoDetailResponse resp = new GetOrgaoDetailResponse();
		resp.setOrgaoDetail( convertToOrgaoDetail(o)  );
		return resp;
	}
	
	
	/**
	 * Este Metodo é responsavel Por Receber uma Lista de orgaos e devolver um Objeto SOAP com uma lista de orgãos
	 * @param orgaos
	 * @return
	 */
	private GetAllOrgaoDetailResponse convertToGetAllCustomerDetailResponse( List<Orgao> orgaos ){

		GetAllOrgaoDetailResponse getAll = new GetAllOrgaoDetailResponse();	
		orgaos.stream().forEach( c -> getAll.getOrgaoDetail().add( convertToOrgaoDetail(c) ) );
		
		return getAll;
	}
	
	private StatusSoap convertToStatusSoap(Status status) {
		
		if( status == status.SUCCESS)
			return StatusSoap.SUCCESS;
		
		else return StatusSoap.FAILURE;
	}
	
	
	
	
	
	

}
