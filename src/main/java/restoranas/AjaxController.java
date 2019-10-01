package restoranas;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller    // This means that this class is a Controller
@RequestMapping(path="/ajax") // This means URL's start with /demo (after Application path)
public class AjaxController {
	
	@Autowired
	UzsakymaiRepository uzsakymaiRepository;
	
	@Autowired
	KlientaiRepository klientaiRepository;	
	
	@Autowired
	Klientai_uzsakymaiRepository klientai_uzsakymaiRepository;		
	
	@GetMapping(path="/saugoti-uzsakyma") // Map ONLY GET Requests
	public @ResponseBody String saugotiUzsakyma (@RequestParam Integer id 
			, @RequestParam String pav
			, @RequestParam String sudetis
			) {
		// @ResponseBody means the returned String is the response, not a view name
		// @RequestParam means it is a parameter from the GET or POST request
		
		String res = "Not done";
		Uzsakymai n = new Uzsakymai();
		
		if (id > 0) {
		
			Optional <Uzsakymai> found = uzsakymaiRepository.findById( id );
		
			// variantas trynimuiui
			// uzsakymaiRepository.deleteById(id);
		
			if ( found.isPresent() ) {
			
			   n = found.get();
			   n.setId(id);
			}
		}
		
	    n.setPav( pav );
	    n.setSudetis(sudetis);
	    uzsakymaiRepository.save(n);	
	    res = "Saved";
	    
		return res;
	}
	
	@GetMapping(path="/salinti-uzsakyma") // Map ONLY GET Requests
	public @ResponseBody String salintiUzsakyma (@RequestParam Integer id 
			) {
		// @ResponseBody means the returned String is the response, not a view name
		// @RequestParam means it is a parameter from the GET or POST request
		
		Optional <Uzsakymai> found = uzsakymaiRepository.findById( id );
		
		String res = "Not done";
		
		if ( found.isPresent() ) {
			
			   Uzsakymai n = found.get();
			   uzsakymaiRepository.deleteById(id);
			   res = "Deleted";
		}		
		return res;
	}		

	@GetMapping(path="/lst-uzsakymai")
	public @ResponseBody Iterable<Uzsakymai> getAllUzsakymai() {
		// This returns a JSON or XML with the users
		return uzsakymaiRepository.findAll();
	}	

	@GetMapping(path="/saugoti-klienta") // Map ONLY GET Requests
	public @ResponseBody String saugotiKlienta (@RequestParam Integer id 
			, @RequestParam String Vardas_pavarde
			, @RequestParam Integer flagRiesutai
			, @RequestParam Integer flagPieno_produktai	
			) {
		// @ResponseBody means the returned String is the response, not a view name
		// @RequestParam means it is a parameter from the GET or POST request
		
		String res = "Not done";
		Klientai n = new Klientai();
		
		if (id > 0) {
		
			Optional <Klientai> found = klientaiRepository.findById( id );
		
			// variantas trynimuiui
			// uzsakymaiRepository.deleteById(id);
		
			if ( found.isPresent() ) {
			
			   n = found.get();
			   n.setId(id);
			}
		}
		
	    n.setVardas_pavarde( Vardas_pavarde );
	    n.setFlagRiesutai(flagRiesutai);
	    n.setFlagPieno_produktai(flagPieno_produktai);

	    klientaiRepository.save(n);	
	    res = "Saved";
	    
		return res;
	}
	
	@GetMapping(path="/salinti-klienta") // Map ONLY GET Requests
	public @ResponseBody String salintiKlienta (@RequestParam Integer id 
			) {
		// @ResponseBody means the returned String is the response, not a view name
		// @RequestParam means it is a parameter from the GET or POST request
		
		Optional <Klientai> found = klientaiRepository.findById( id );
		
		String res = "Not done";
		
		if ( found.isPresent() ) {
			
			   Klientai n = found.get();
			   klientaiRepository.deleteById(id);
			   res = "Deleted";
		}		
		return res;
	}		

	@GetMapping(path="/lst-klientai")
	public @ResponseBody Iterable<Klientai> getAllKlientai() {
		// This returns a JSON or XML with the users
		return klientaiRepository.findAll();
	}	
	
	@GetMapping(path="/klientas")
	public @ResponseBody Optional<Klientai> getKlientas(@RequestParam Integer id) {
		// This returns a JSON or XML with the users
		Optional <Klientai> found = klientaiRepository.findById( id );		
		/*
		if ( found.isPresent() ) {
			
			   Uzsakymai n = found.get();
		}		
		*/	
		return found;
	}	
	
	@GetMapping(path="/kliento-uzsakymai") // Map ONLY GET Requests
	public @ResponseBody String saugotiProduktaPatiekalo (@RequestParam Integer id 
			, @RequestParam(defaultValue="0") Integer id_kl
			, @RequestParam(defaultValue="0") Integer id_keliones
			) {
		// @ResponseBody means the returned String is the response, not a view name
		// @RequestParam means it is a parameter from the GET or POST request
		
		String res = "Not done";
		Klientai_uzsakymai n = new Klientai_uzsakymai();
		
		System.out.println ( "id: " + id + " kliento. id: " + id_kl + " keliones. id " + id_keliones );
		
		if (id > 0) {
		
			Optional <Klientai_uzsakymai> found = klientai_uzsakymaiRepository.findById( id );
		
			// variantas trynimuiui
			// uzsakymaiRepository.deleteById(id);
		
			if ( found.isPresent() ) {
			
			   n = found.get();
			  //  n.setId(id);
			}
			
		} else {
		
			if ( ( id_kl > 0 ) && ( id_keliones > 0 ) ) {
				
				n.setKlientai_id ( id_kl );
				n.setUzsakymai_id( id_keliones );
			}
		}
		
		System.out.println ( n.toString() );			   			   
		klientai_uzsakymaiRepository.save(n);	
		res = "Saved";
	    
		return res;
	}
	
	@GetMapping(path="/salinti-kliento-uzsakyma") // Map ONLY GET Requests
	public @ResponseBody String salintiKliento_uzsakymas (@RequestParam Integer id_kl
			, @RequestParam Integer id 
			) {
		// @ResponseBody means the returned String is the response, not a view name
		// @RequestParam means it is a parameter from the GET or POST request
		
		Optional <Klientai_uzsakymai> found = klientai_uzsakymaiRepository.findById( id );
		
		String res = "Not done";
		
		if ( found.isPresent() ) {
			
			   Klientai_uzsakymai n = found.get();
			   klientai_uzsakymaiRepository.deleteById(id);
			   res = "Deleted";
		}		
		return res;
	}	

}
