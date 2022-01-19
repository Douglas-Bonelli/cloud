package br.com.intelligence.project.cloud.soap;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import br.com.intelligence.project.cloud.entity.Orgao;
import br.com.intelligence.project.cloud.service.imp.OrgaoServiceImp;
import br.gov.rs.tce.GetOrgaoDetailRequest;
import br.gov.rs.tce.GetOrgaoDetailResponse;
import br.gov.rs.tce.OrgaoDetail;

@Endpoint
public class OrgaoEndPoint {
	
	@Autowired
	OrgaoServiceImp service;
	
	
	@PayloadRoot( namespace = "http://tce.rs.gov.br" , localPart = "GetOrgaoDetailRequest" )
	@ResponsePayload
	public GetOrgaoDetailResponse processGetOrgaoDetailRequest(@RequestPayload GetOrgaoDetailRequest req) {
		
		OrgaoDetail detail = new OrgaoDetail();
		
		Optional<Orgao> opt = service.findById(req.getId());
		if(opt.isPresent()){
			detail.setId(opt.get().getId());
			detail.setNome(opt.get().getNome());
		}
		
		GetOrgaoDetailResponse response = new GetOrgaoDetailResponse();
		response.setOrgaoDetail(detail);
		
		return response;
	}

}
