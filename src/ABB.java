public class ABB {
    static class Nodo {
        Animal animal;
        Nodo madre, padre;
    }
    Nodo raiz;

    public ABB armarArbol(Animal pAnimal){
        Sistema unSistema = new Sistema();

        Animal pMadreAnimal = unSistema.buscarAnimal(pAnimal.getIdMadre(), 0);
        Animal pPadreAnimal = unSistema.buscarAnimal(pAnimal.getIdPadre(), 0);
        Animal pAbuelaMaterna = unSistema.buscarAnimal(pMadreAnimal.getIdMadre(), 0);
        Animal pAbuelaPaterna = unSistema.buscarAnimal(pPadreAnimal.getIdMadre(), 0);
        Animal pAbueloMaterno = unSistema.buscarAnimal(pMadreAnimal.getIdPadre(), 0);
        Animal pAbueloPaterno = unSistema.buscarAnimal(pPadreAnimal.getIdMadre(), 0);

        ABB unArbolAnimal = new ABB();

        unArbolAnimal.raiz.animal = pAnimal;
        unArbolAnimal.raiz.madre.animal = pMadreAnimal;
        unArbolAnimal.raiz.padre.animal = pPadreAnimal;
        unArbolAnimal.raiz.madre.madre.animal = pAbuelaMaterna;
        unArbolAnimal.raiz.madre.padre.animal = pAbueloMaterno;
        unArbolAnimal.raiz.padre.madre.animal = pAbuelaPaterna;
        unArbolAnimal.raiz.padre.padre.animal = pAbueloPaterno;

        return unArbolAnimal;
    }

    @Override
    public String toString() {
        return "Animal:\n"+this.raiz.animal.toString()+"Madre:\n"+this.raiz.madre.animal+"Padre:\n"+this.raiz.padre.animal+"Abuela materna:\n"+this.raiz.madre.madre.animal+"Abuelo materno:\n"+this.raiz.madre.padre.animal+"Abuela paterna:\n"+this.raiz.padre.madre.animal+"Abuelo paterno:\n"+this.raiz.padre.padre.animal;
    }

    public ABB(){
        raiz = null;
    }

}