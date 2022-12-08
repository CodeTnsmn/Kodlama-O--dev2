package kodlama.io.programmingLanguages.business.concretes;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlama.io.programmingLanguages.business.abstracts.SubLanguageTechService;
import kodlama.io.programmingLanguages.business.requests.subLanguageTech.CreateSubLanguageTechRequest;
import kodlama.io.programmingLanguages.business.requests.subLanguageTech.DeleteSubLanguageTechRequest;
import kodlama.io.programmingLanguages.business.requests.subLanguageTech.UpdateSubLanguageTechRequest;
import kodlama.io.programmingLanguages.business.responses.subLanguageTech.GetAllLanguageTechsResponse;
import kodlama.io.programmingLanguages.business.responses.subLanguageTech.GetLanguageTechByIdResponse;
import kodlama.io.programmingLanguages.dataAccess.abstracts.LanguageRepository;
import kodlama.io.programmingLanguages.dataAccess.abstracts.SubLanguageTechRepository;
import kodlama.io.programmingLanguages.entities.concretes.Language;
import kodlama.io.programmingLanguages.entities.concretes.SubLanguageTechnology;



@Service
public class SubLanguageTechManager implements SubLanguageTechService {
	
	 private SubLanguageTechRepository subLanguageTechRepository;
	 private LanguageRepository languageRepository;
	
	 
	
	@Autowired 
	public SubLanguageTechManager(SubLanguageTechRepository subLanguageTechRepository,LanguageRepository languageRepository) {
		
		this.subLanguageTechRepository = subLanguageTechRepository;
		this.languageRepository = languageRepository;
	}

	@Override
	public List<GetAllLanguageTechsResponse> getAll() {
		 List<SubLanguageTechnology> subTechLanguages = subLanguageTechRepository.findAll();
	        List<GetAllLanguageTechsResponse> subTechLanguagesResponse = new ArrayList<>();

	        for (SubLanguageTechnology subTechLanguage : subTechLanguages) {
	            GetAllLanguageTechsResponse responseItem = new GetAllLanguageTechsResponse();
	            responseItem.setId(subTechLanguage.getId());
	            responseItem.setName(subTechLanguage.getName());
	            responseItem.setLanguage(subTechLanguage.getLanguage().getName());

	            subTechLanguagesResponse.add(responseItem);
	        }
		return subTechLanguagesResponse;
	}

	@Override
	public void add(CreateSubLanguageTechRequest createSubLanguageTechRequest) {
		 SubLanguageTechnology subLanguageTechnology = new SubLanguageTechnology();
	        subLanguageTechnology.setName(createSubLanguageTechRequest.getName());
	        Language language = languageRepository.findById(createSubLanguageTechRequest.getLanguageId()).get();
	        subLanguageTechnology.setLanguage(language);
	        if (!isExist(subLanguageTechnology)) {
	            subLanguageTechRepository.save(subLanguageTechnology);
	        } else {
	            throw new RuntimeException("Bu dil zaten eklenmiş.");
	        }

		
	}

	@Override
	public void delete(DeleteSubLanguageTechRequest deleteSubLanguageTechRequest) {
		this.subLanguageTechRepository.deleteById(deleteSubLanguageTechRequest.getId());
		
	}

	@Override
	public void update(UpdateSubLanguageTechRequest updateSubLanguageTechRequest) {
		    SubLanguageTechnology subLanguageTechnology = subLanguageTechRepository.findById(updateSubLanguageTechRequest.getId()).get();
	        subLanguageTechnology.setName(updateSubLanguageTechRequest.getName());
	        Language language = languageRepository.findById(updateSubLanguageTechRequest.getLanguageId()).get();
	        subLanguageTechnology.setLanguage(language);
	        this.subLanguageTechRepository.save(subLanguageTechnology);
		
	}

	@Override
	public GetLanguageTechByIdResponse getId(int id) {
		
		SubLanguageTechnology subLanguageTechnology = this.subLanguageTechRepository.findById(id).get();
        GetLanguageTechByIdResponse getLanguageTechByIdResponse = new GetLanguageTechByIdResponse();

        getLanguageTechByIdResponse.setLanguage(subLanguageTechnology.getLanguage().getName());
        getLanguageTechByIdResponse.setName(subLanguageTechnology.getName());
        getLanguageTechByIdResponse.setId(id);


        return getLanguageTechByIdResponse;
	}

	 public boolean isExist(SubLanguageTechnology subLanguageTechnology) {
	        boolean exist = false;
	        List<SubLanguageTechnology> subLanguageTechnologies = subLanguageTechRepository.findAll();
	        for (SubLanguageTechnology subLangTech : subLanguageTechnologies) {
	            if (subLanguageTechnology.getName().toLowerCase().equals(subLangTech.getName().toLowerCase())) {
	                if (subLanguageTechnology.getLanguage().equals(subLangTech.getLanguage())) {
	                    exist = true;
	                    return exist;
	                }
	            }
	        }
	        return exist;
	    }
	
}
