package restoranas;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class Klientai {
	
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer id;
    
    private String Vardas_pavarde;
    
    private String flag_riesutai;
    
    private String flag_pieno_produktai;
    
    @JsonIgnoreProperties("klientai")    
    @OneToMany(mappedBy = "klientai",cascade = CascadeType.ALL)
    private List<Klientai_uzsakymai> klientai_uzsakymai; 

	/**
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * @return the vardas_pavarde
	 */
	public String getVardas_pavarde() {
		return Vardas_pavarde;
	}

	/**
	 * @param vardas_pavarde the vardas_pavarde to set
	 */
	public void setVardas_pavarde(String vardas_pavarde) {
		Vardas_pavarde = vardas_pavarde;
	}

	/**
	 * @return the flag_riesutai
	 */
	public String getFlag_riesutai() {
		return flag_riesutai;
	}

	/**
	 * @param flag_riesutai the flag_riesutai to set
	 */
	public void setFlag_riesutai(String flag_riesutai) {
		this.flag_riesutai = flag_riesutai;
	}

	/**
	 * @return the flag_pieno_produktai
	 */
	public String getFlag_pieno_produktai() {
		return flag_pieno_produktai;
	}

	/**
	 * @param flag_pieno_produktai the flag_pieno_produktai to set
	 */
	public void setFlag_pieno_produktai(String flag_pieno_produktai) {
		this.flag_pieno_produktai = flag_pieno_produktai;
	}

	public Iterable<Klientai_uzsakymai> getKlientai_uzsakymai() {
		return klientai_uzsakymai;
	}

	public void setKlientai_uzsakymai(List<Klientai_uzsakymai> klientai_uzsakymai) {
		this.klientai_uzsakymai = klientai_uzsakymai;
	}

	public void setFlagPieno_produktai(Integer flagPieno_produktai) {
		// TODO Auto-generated method stub
		
	}

	public void setFlagRiesutai(Integer flagRiesutai) {
		// TODO Auto-generated method stub
		
	}
}
