public class NodoABB {

    String IdAnimal;
    private NodoABB madre;
    private NodoABB padre;

    public NodoABB (String dato, NodoABB madre, NodoABB padre){
        this.IdAnimal = dato;
        this.madre = madre;
        this.padre = padre;
    }

    public NodoABB getMadre(){
        return this.madre;
    }

    public NodoABB getPadre(){
        return this.padre;
    }

    public String getId(){
        return this.IdAnimal;
    }

    public void setID(String dato){
        this.IdAnimal = dato;
    }

    public void setPadre(NodoABB padre){
        this.padre = padre;
    }

    public void setMadre(NodoABB izq){
        this.madre = izq;
    }


}
