package kodlama.io.programmingLanguages.business.concretes;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlama.io.programmingLanguages.business.abstracts.LanguageService;
import kodlama.io.programmingLanguages.business.requests.language.CreateLanguageRequest;
import kodlama.io.programmingLanguages.business.requests.language.DeleteLanguageRequest;
import kodlama.io.programmingLanguages.business.requests.language.UpdateLanguageRequest;
import kodlama.io.programmingLanguages.business.responses.language.GetAllLanguagesResponse;
import kodlama.io.programmingLanguages.business.responses.language.GetLanguagesByIdResponse;
import kodlama.io.programmingLanguages.dataAccess.abstracts.LanguageRepository;
import kodlama.io.programmingLanguages.entities.concretes.Language;


@Service
public class LanguageManager implements LanguageService {
	private LanguageRepository languageRepository;
	
	
	@Autowired
	public LanguageManager(LanguageRepository languageRepository) {
		
		this.languageRepository = languageRepository;
	}
	
	public List<GetAllLanguagesResponse> getAll(){
		
		List<Language> languages = languageRepository.findAll();
		List<GetAllLanguagesResponse> languagesResponse = new ArrayList<>();
		
		for (Language language : languages){
            GetAllLanguagesResponse responseItem = new GetAllLanguagesResponse();
            responseItem.setId(language.getId());
            responseItem.setName(language.getName());

            languagesResponse.add(responseItem);
        }
        
        return languagesResponse;
    }
		
		

	@Override
	public void add(CreateLanguageRequest createLanguageRequest) {
		
		 Language language = new Language();
	        language.setName(createLanguageRequest.getName());
	        if(!isExist(language)){
	            this.languageRepository.save(language);
	        } else {
	            throw new RuntimeException("Bu dil zaten eklenmiş.");
	        }
		
	}

	@Override
	public void update(UpdateLanguageRequest updateLanguageRequest) {
		 Language language = this.languageRepository.findById(updateLanguageRequest.getId()).get();
	        if(!isExist(language)){
	            language.setName(updateLanguageRequest.getName());
	            this.languageRepository.save(language);
	        } else {
	            throw new RuntimeException("Bu dil var.");
	        }
		
	}

	@Override
	public void delete(DeleteLanguageRequest deleteLanguageRequest) {
		 this.languageRepository.deleteById(deleteLanguageRequest.getId());
		
	}

	@Override
	public GetLanguagesByIdResponse getId(int id) {
		 Language language = this.languageRepository.findById(id).get();
	     GetLanguagesByIdResponse byIdResponse =  new GetLanguagesByIdResponse();
	     byIdResponse.setName(language.getName());
	     byIdResponse.setId(language.getId());
		 return byIdResponse;
	}
	
	public boolean isExist(Language language){
        boolean exist = false;
        List<Language> languages = languageRepository.findAll();
        for (Language lang : languages){
            if (lang.getName().toLowerCase().equals(language.getName().toLowerCase())) {
                exist = true;
                return exist;
            }
        }
        return exist;
    }

}
