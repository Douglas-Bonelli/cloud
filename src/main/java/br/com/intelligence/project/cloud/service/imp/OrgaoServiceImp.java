package br.com.intelligence.project.cloud.service.imp;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.intelligence.project.cloud.entity.Orgao;
import br.com.intelligence.project.cloud.helper.Status;
import br.com.intelligence.project.cloud.repository.OrgaoRepository;
import br.com.intelligence.project.cloud.service.OrgaoService;

@Service
public class OrgaoServiceImp implements OrgaoService {
	
	
	@Autowired
	OrgaoRepository orgaoRepo = new OrgaoRepository();
	
	

	@Override
	public List<Orgao> getAll() {
		return this.orgaoRepo.listAll();
	}
	
	
	
	

	@Override
	public Optional<Orgao> findById(int id) {
		
		Optional<Orgao> opt = getAll().stream()
									  .filter( o -> o.getId() == id)
									  .findAny();
		
		if (opt.isPresent()) return opt;
		else return opt.empty();
	}





	@Override
	public Status deleteById(int id) {
		
		Optional<Orgao> opt = getAll().stream()
									  .filter( o -> o.getId() == id)
									  .findAny();
		
		if (opt.isPresent()) {
			getAll().remove(opt.get());
			return Status.SUCCESS;
		}
		else
			return Status.FAILURE;
	}
	

}
