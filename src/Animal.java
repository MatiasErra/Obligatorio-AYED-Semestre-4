public class Animal {
    private String id;
    private String tipo;
    private String sexo;
    private boolean desparasitado;
    private boolean vacunado;
    private String empresa;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public boolean isDesparasitado() {
        return desparasitado;
    }

    public void setDesparasitado(boolean desparasitado) {
        this.desparasitado = desparasitado;
    }

    public boolean isVacunado() {
        return vacunado;
    }

    public void setVacunado(boolean vacunado) {
        this.vacunado = vacunado;
    }


    public String getEmpresa() { return empresa; }

    public void setEmpresa(String empresa) { this.empresa = empresa; }

    @Override
    public String toString() {
        return "Id: "+this.id+". Tipo: "+this.tipo+". Sexo: "+this.sexo+". \nEsta desparacitado: "+(this.desparasitado?"Si":"No")+". Esta vacunado: "+(this.vacunado?"Si":"No")+". \nId empresa ganadera: "+this.empresa+"\n";
    }

    public Animal(String id, String tipo, String sexo, boolean desparasitado, boolean vacunado,  String empresa) {
        this.id = id;
        this.tipo = tipo;
        this.sexo = sexo;
        this.desparasitado = desparasitado;
        this.vacunado = vacunado;

        this.empresa = empresa;
    }

    public Animal(){}
}
