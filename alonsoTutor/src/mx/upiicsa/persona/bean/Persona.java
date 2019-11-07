package mx.upiicsa.persona.bean;
public class Persona {
    private Integer id;
	private String primerApellido;
    private String segundoApellido;
    private String nombre;
    private String curp;
    private Integer folio;
    private String genero;
    private String tipoSangre;
    private Integer codigo;

    
    public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
    public String getPrimerApellido() {
        return this.primerApellido;
    }

    public void setPrimerApellido(String primerApellido) {
        this.primerApellido = primerApellido;
    }

    public String getSegundoApellido() {
        return this.segundoApellido;
    }

    public void setSegundoApellido(String segundoApellido) {
        this.segundoApellido = segundoApellido;
    }

    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCurp() {
        return this.curp;
    }

    public void setCurp(String curp) {
        this.curp = curp;
    }

    public Integer getFolio() {
        return this.folio;
    }

    public void setFolio(Integer folio) {
        this.folio = folio;
    }

    public String getGenero() {
        return this.genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getTipoSangre() {
        return this.tipoSangre;
    }

    public void setTipoSangre(String tipoSangre) {
        this.tipoSangre = tipoSangre;
    }
    
    public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

 //   public String getPersona(){
   //         return  "Nombre: "+nombre+" Fecha de nacimiento: "+Fechadenacimiento.getDayOfMonth()+"/"+Fechadenacimiento.getMonth()+"/"+Fechadenacimiento.getYear()+" Direccion: calle "+direccion.getCalle()
     //           +" #"+direccion.getNumero() +" Col."+direccion.getColonia()+" C.P "+direccion.getCp();
        
//}
}