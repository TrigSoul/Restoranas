package restoranas;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.io.Serializable;

@Entity
public class Klientai_uzsakymai {
    private static final long serialVersionUID = -6790693372846798580L;

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)	

	private Integer id;
    
	private Integer klientai_id;
	private Integer uzsakymai_id;
	
    @JsonIgnoreProperties("klientaiKeliones")
    @ManyToOne
    @JoinColumn(insertable=false, updatable=false)
    private Klientai klientai;

    @ManyToOne
    @JoinColumn(insertable=false, updatable=false)
    private Uzsakymai uzsakymai;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getKlientai_id() {
		return klientai_id;
	}

	public void setKlientai_id(Integer klientai_id) {
		this.klientai_id = klientai_id;
	}

	public Integer getUzsakymai_id() {
		return uzsakymai_id;
	}

	public void setUzsakymai_id(Integer uzsakymai_id) {
		this.uzsakymai_id = uzsakymai_id;
	}

	public Klientai getKlientai() {
		return klientai;
	}

	public void setKlientai(Klientai klientai) {
		this.klientai = klientai;
	}

	public Uzsakymai getUzsakymai() {
		return uzsakymai;
	}

	public void setKeliones(Uzsakymai uzsakymai) {
		this.uzsakymai = uzsakymai;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	} 	
}
