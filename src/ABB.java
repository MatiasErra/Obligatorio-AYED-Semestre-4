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
        Animal pAbuelaMaterna = new Animal();
        Animal pAbueloMaterno = new Animal();
        Animal pAbuelaPaterna = new Animal();
        Animal pAbueloPaterno = new Animal();
        if(pMadreAnimal != null){
            pAbuelaMaterna = unSistema.buscarAnimal(pMadreAnimal.getIdMadre(), 0);
            pAbueloMaterno = unSistema.buscarAnimal(pMadreAnimal.getIdPadre(), 0);
        }
        if(pPadreAnimal != null){
            pAbuelaPaterna = unSistema.buscarAnimal(pPadreAnimal.getIdMadre(), 0);
            pAbueloPaterno = unSistema.buscarAnimal(pPadreAnimal.getIdMadre(), 0);
        }

        ABB unArbolAnimal = new ABB();

        Nodo animal = new Nodo();
        animal.animal = pAnimal;

        Nodo madre = new Nodo();
        madre.animal = pMadreAnimal;
        Nodo padre = new Nodo();
        padre.animal = pPadreAnimal;

        Nodo abuelaMaterna = new Nodo();
        abuelaMaterna.animal = pAbuelaMaterna;
        Nodo abueloMaterno = new Nodo();
        abueloMaterno.animal = pAbueloMaterno;
        Nodo abuelaPaterna = new Nodo();
        abuelaPaterna.animal = pAbuelaPaterna;
        Nodo abueloPaterno = new Nodo();
        abueloPaterno.animal = pAbueloPaterno;

        animal.madre = madre;
        animal.padre = padre;
        animal.madre.madre = abuelaMaterna;
        animal.madre.padre = abueloMaterno;
        animal.padre.madre = abuelaPaterna;
        animal.padre.padre = abueloPaterno;

        unArbolAnimal.raiz = animal;

        return unArbolAnimal;
    }

    @Override
    public String toString() {
        String res = "Animal:\n"+this.raiz.animal.toString();
        if(this.raiz.madre.animal.getId() != null){
            res += "Madre:\n"+this.raiz.madre.animal;
            if(this.raiz.madre.madre.animal.getId() != null){
                res += "Abuela materna:\n"+this.raiz.madre.madre.animal;
            } if(this.raiz.madre.padre.animal.getId() != null){
                res += "Abuelo materno:\n"+this.raiz.madre.padre.animal;
            }
        } if(this.raiz.madre.animal.getId() == null){
            res += "El animal no tiene Madre.\nEl animal no tiene Abuela materna.\nEl animal no tiene Abuelo materno.\n";
        } if(this.raiz.padre.animal.getId() != null){
            res += "Padre:\n"+this.raiz.padre.animal;
            if(this.raiz.padre.madre.animal.getId() != null){
                res += "Abuela paterna:\n"+this.raiz.padre.madre.animal;
            } if(this.raiz.padre.padre.animal.getId() != null){
                res += "Abuelo paterno:\n"+this.raiz.padre.padre.animal;
            }
        } if(this.raiz.padre.animal.getId() == null){
            res += "El animal no tiene Padre.\nEl animal no tiene Abuela paterna.\nEl animal no tiene Abuelo paterno.\n";
        }
        return res;
    }

    public ABB(){
        raiz = null;
    }

}