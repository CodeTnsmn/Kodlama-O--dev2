package kodlama.io.programmingLanguages.wepApi;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlama.io.programmingLanguages.business.abstracts.LanguageService;
import kodlama.io.programmingLanguages.business.requests.language.CreateLanguageRequest;
import kodlama.io.programmingLanguages.business.requests.language.DeleteLanguageRequest;
import kodlama.io.programmingLanguages.business.requests.language.UpdateLanguageRequest;
import kodlama.io.programmingLanguages.business.responses.language.GetAllLanguagesResponse;
import kodlama.io.programmingLanguages.business.responses.language.GetLanguagesByIdResponse;

@RequestMapping("/api/languages")
@RestController
public class LanguagesControllers {

	 private LanguageService languageService;
	 
	 @Autowired
	    public LanguagesControllers(LanguageService languageService) {
	        this.languageService = languageService;
	    }

	    @GetMapping("/getall")
	    public List<GetAllLanguagesResponse> getAll(){
	        return languageService.getAll();
	    }

	    @PostMapping("/add-language")
	    public void add(CreateLanguageRequest createLanguageRequest) {
	         languageService.add(createLanguageRequest);
	    }

	    @PutMapping("/update-language")
	    public void update(UpdateLanguageRequest updateLanguageRequest){
	        languageService.update(updateLanguageRequest);
	    }

	    @DeleteMapping("/delete-language")
	    public void delete(DeleteLanguageRequest deleteLanguageRequest){
	        languageService.delete(deleteLanguageRequest);
	    }
	    
	    @GetMapping("/getId/{id}")
	    public GetLanguagesByIdResponse getById(int id){
	        return languageService.getId(id);
	    }
}
