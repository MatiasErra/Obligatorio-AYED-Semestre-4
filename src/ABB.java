public class ABB {
    static class Nodo {

         String IdAnimal;
        Nodo madre, padre;

        public String GetIdAnimal() {
            return IdAnimal;
        }

        public Nodo GetPAnimal() {
            return padre;
        }

        public Nodo GetMAnimal() {
            return madre;
        }
    }


    Nodo raiz;






    public void imprimirPre(){

        System.out.println(toString(this.raiz));
    }





    public ABB armarArbol(Animal pAnimal, Animal Madre, Animal Padre  ){
        Sistema unSistema = new Sistema();
        String pMadreAnimal = "";
    if(Madre!= null) {
   pMadreAnimal = unSistema.buscarAnimal(Madre.getId(), 0);
    }
    else{
    pMadreAnimal = null;
    }
        String pPadreAnimal = "";
    if(Padre!=null) {
        pPadreAnimal = unSistema.buscarAnimal(Padre.getId(), 0);
    }
    else
    {
        pPadreAnimal = null;
    }
        String pAbuelaMaterna = "";
        String pAbueloMaterno = "";
        String pAbuelaPaterna = "";
        String pAbueloPaterno = "";
        ABB unArbolAnimal = new ABB();

        Nodo animal = new Nodo();
        animal.IdAnimal  = pAnimal.getId();

        Nodo madre = new Nodo();
        madre.IdAnimal = pMadreAnimal;
        Nodo padre = new Nodo();
        padre.IdAnimal = pPadreAnimal;
        animal.madre = madre;
        animal.padre = padre;


        if(pMadreAnimal != null){
            if(unSistema.buscarfamiliar(animal.madre.IdAnimal) != null) {
                pAbuelaMaterna = unSistema.buscarfamiliar(animal.madre.IdAnimal).madre.GetIdAnimal();
                pAbueloMaterno = unSistema.buscarfamiliar(animal.madre.IdAnimal).padre.GetIdAnimal();
            }
            else {
                pAbuelaMaterna = null;
                pAbueloMaterno = null;
            }
        }
        if(pPadreAnimal != null) {
            if(unSistema.buscarfamiliar(animal.padre.IdAnimal) != null)
            {
                pAbuelaPaterna = unSistema.buscarfamiliar(animal.padre.IdAnimal).madre.GetIdAnimal();
                pAbueloPaterno = unSistema.buscarfamiliar(animal.padre.IdAnimal).padre.GetIdAnimal();
            }
            else
            {
                pAbuelaPaterna = null;
                pAbueloPaterno = null;
            }
        }


        Nodo abuelaMaterna = new Nodo();
        abuelaMaterna.IdAnimal = pAbuelaMaterna;

        Nodo abueloMaterno = new Nodo();
        abueloMaterno.IdAnimal = pAbueloMaterno;

        Nodo abuelaPaterna = new Nodo();
        abuelaPaterna.IdAnimal = pAbuelaPaterna;

        Nodo abueloPaterno = new Nodo();
        abueloPaterno.IdAnimal = pAbueloPaterno;

        animal.madre.madre = abuelaMaterna;
        animal.madre.padre = abueloMaterno;
        animal.padre.madre = abuelaPaterna;
        animal.padre.padre = abueloPaterno;


        unArbolAnimal.raiz = animal;
        this.raiz = animal;

        return unArbolAnimal;
    }


    public String toString(Nodo nodo) {
        Sistema unSistema = new Sistema();
        if (this.raiz != null) {
            String res = "Animal:\n" + unSistema.devolverAnimal(this.raiz.IdAnimal, 0);
            if (this.raiz.madre.IdAnimal != null) {
                unSistema.devolverAnimal(this.raiz.madre.IdAnimal,  0);
                res += "Madre:\n" + unSistema.devolverAnimal(this.raiz.madre.IdAnimal,  0);
                if (this.raiz.madre.madre.IdAnimal != null) {
                    res += "Abuela materna:\n" +  unSistema.devolverAnimal(this.raiz.madre.madre.IdAnimal,  0);
                }
                if (this.raiz.madre.padre.IdAnimal != null) {
                    res += "Abuelo materno:\n" +  unSistema.devolverAnimal(this.raiz.madre.padre.IdAnimal,  0);
                }
            }
            if (this.raiz.madre.IdAnimal == null) {
                res += "El animal no tiene Madre.\nEl animal no tiene Abuela materna.\nEl animal no tiene Abuelo materno.\n";
            }

            if (this.raiz.padre.IdAnimal != null) {
                res += "Padre:\n" + unSistema.devolverAnimal(this.raiz.padre.IdAnimal,  0);

                 if (this.raiz.padre.madre.IdAnimal != null) {
                res += "Abuela paterna:\n" +  unSistema.devolverAnimal(this.raiz.padre.madre.IdAnimal,  0);
                 }
                if (this.raiz.padre.padre.IdAnimal != null) {
                res += "Abuelo paterno:\n" + unSistema.devolverAnimal(this.raiz.padre.padre.IdAnimal,  0);
                }
            }
            if (this.raiz.padre.IdAnimal == null) {
                res += "El animal no tiene Padre.\nEl animal no tiene Abuela paterna.\nEl animal no tiene Abuelo paterno.\n";
            }
            return res;
        }
        return "no hay arbol";
    }

    public ABB(){
    raiz = null;
    }

}