package kodlama.io.programmingLanguages.business.abstracts;

import java.util.List;

import kodlama.io.programmingLanguages.business.requests.language.CreateLanguageRequest;
import kodlama.io.programmingLanguages.business.requests.language.DeleteLanguageRequest;
import kodlama.io.programmingLanguages.business.requests.language.UpdateLanguageRequest;
import kodlama.io.programmingLanguages.business.responses.language.GetAllLanguagesResponse;
import kodlama.io.programmingLanguages.business.responses.language.GetLanguagesByIdResponse;

public interface LanguageService {

	List<GetAllLanguagesResponse> getAll();
    void add(CreateLanguageRequest createBrandRequest);
    void update(UpdateLanguageRequest updateLanguageRequest);
    void delete(DeleteLanguageRequest deleteLanguageRequest);
    GetLanguagesByIdResponse getId(int id);
}
