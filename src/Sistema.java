import java.io.Console;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Sistema {
    static List<Animal> listaAnimal = new ArrayList<>();
    static List<Usuario> listaUsuario = new ArrayList<>();
    static List<Empresa> listaEmpresa = new ArrayList<>();
    static List<ABB> listaABB = new ArrayList<>();

    static String idEmpresa;
    static Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {

        Usuario c = new Usuario("1", "1");
        Empresa e1 = new Empresa("1", "Joselitos", "0", "xd");
        Empresa e2 = new Empresa("2", "Bruno", "0", "xd2");
        Animal a1 = new Animal("1", "Ovino", "Hembra", false, false, "1");
        Animal a2 = new Animal("2", "Ovino", "Hembra", false, false, "1");
        Animal a3 = new Animal("3", "Ovino", "Macho", false, false, "1");

        Animal a4 = new Animal("4", "Ovino", "Macho", false, false, "1");
        Animal a5 = new Animal("5", "Ovino", "Hembra", false, false, "1");
        Animal a6 = new Animal("6", "Ovino", "Macho", false, false, "1");

        Animal a7 = new Animal("7", "Ovino", "Macho", false, false, "1");

        Animal a8 = new Animal("8", "Ovino", "Macho", false, false, "2");



        listaAnimal.add(a1);
        listaAnimal.add(a2);
        listaAnimal.add(a3);
        listaAnimal.add(a4);
        listaAnimal.add(a5);
        listaAnimal.add(a6);
        listaAnimal.add(a7);
        listaAnimal.add(a8);



        listaUsuario.add(c);
        listaEmpresa.add(e1);
        listaEmpresa.add(e2);

        ABB armar1 = new ABB();
        armar1.armarArbol(a1, a2, a3);
        listaABB.add(armar1);
        ABB armar2 = new ABB();
        armar2.armarArbol(a4, a5, a6);
        listaABB.add(armar2);
        ABB armar3 = new ABB();
        armar3.armarArbol(a7, a1, a4);
        listaABB.add(armar3);

        Usuario logueado = new Usuario();
        int opcion = 1;
        while (opcion != 0) {
            if (logueado.getUsuario() == null) {
                int opcionLogin = 1;
                System.out.println("Debe iniciar sesion para continuar.\n1. Iniciar sesion.\n2. Registrarse.");
                opcionLogin = scan.nextInt();
                System.out.println("Ingrese su usuario.");
                String user = scan.next();
                System.out.println("Ingrese su contraseña.");
                String password = scan.next();
                switch (opcionLogin) {
                    case 1:
                        for (Usuario unUsuario : listaUsuario) {
                            if (unUsuario.getUsuario().equals(user) && unUsuario.getContrasenia().equals(password)) {
                                logueado = unUsuario;
                            }
                        }
                        if (logueado.getUsuario() == null) {
                            System.out.println("Usuario o contraseña incorrecta.");
                        } else {
                            System.out.println("Ingreso con exito.");
                        }
                        break;
                    case 2:
                        Usuario test = new Usuario();
                        for (Usuario unUsuario : listaUsuario) {
                            if (unUsuario.getUsuario().equals(user)) {
                                test = unUsuario;
                            }
                        }
                        if (test.getUsuario() == null) {
                            logueado = new Usuario(user, password);
                            System.out.println("Registrado con exito.");
                        } else {
                            System.out.println("Ocurrio un error.");
                        }
                        break;
                    default:
                        System.out.println("Seleccione una opcion valida.");
                        break;
                }
            } else {
                System.out.println("Desea crear o seleccionar una empresa:\n1. Crear empresa\n2. Seleccionar empresa existente.\n3. Eliminar empresa.\n0. Cerrar.");
                opcion = scan.nextInt();
                switch (opcion) {
                    case 0:
                        break;
                    case 1:
                        altaEmpresa();
                        break;
                    case 2:
                        seleccionarEmpresa();
                        break;
                    case 3:
                        bajaEmpresa();
                        break;
                    default:
                        System.out.println("Seleccione una opcion valida.");
                        break;
                }
            }
        }
    }

    public static String generarIdEmpresa() {
        String[] rndm = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9"};
        String id = "";
        int cont = 1;
        while (cont != 0) {
            cont = 0;
            id = "";
            for (int i = 0; i < 6; i++) {
                id += rndm[(int) (Math.random() * 10)];
            }
            for (Empresa unaEmpresa : listaEmpresa) {
                if (unaEmpresa.getId().equals(id)) {
                    cont++;
                }
            }
        }
        return id;
    }

    public static void altaEmpresa() {
        System.out.println("Ingrese el nombre de su empresa.");
        String nombre = scan.next();
        System.out.println("Ingrese el telefono de su empresa.");
        String tel = scan.next();
        System.out.println("Ingrese la direccion de su empresa.");
        String direccion = scan.next();
        int cont = 0;
        for (Empresa unaEmpresa : listaEmpresa) {
            if (nombre.equals(unaEmpresa.getNombre())) {
                cont++;
            }
        }
        if (cont == 0) {
            String id = generarIdEmpresa();
            Empresa pEmpresa = new Empresa(id, nombre, tel, direccion);
            listaEmpresa.add(pEmpresa);
            empresa(id);
        } else {
            System.out.println("El nombre de la empresa ya existe.");
        }
    }

    public static void seleccionarEmpresa() {
        int cont = 1;
        for (Empresa unaEmpresa : listaEmpresa) {
            System.out.println(cont + ". " + unaEmpresa.toString());
            cont++;
        }
        if (cont == 1) {
            System.out.println("No hay ninguna empresa.");
        } else {
            Empresa unaEmpresa = new Empresa();
            while (unaEmpresa.getId() == null) {
                System.out.println("Seleccione el numero de empresa que desea seleccionar.");
                int numE = scan.nextInt();
                try {
                    unaEmpresa = listaEmpresa.get(numE - 1);
                    System.out.println("Empresa seleccionada correctamente.");

                    empresa(unaEmpresa.getId());

                } catch (IndexOutOfBoundsException E) {
                    System.out.println("Esa empresa no existe.");
                }
            }
        }
    }




    public static void bajaEmpresa() {
        int cont = 1;
        for (Empresa unaEmpresa : listaEmpresa) {
            System.out.println(cont + ". " + unaEmpresa.toString());
            cont++;
        }
        if (cont == 1) {
            System.out.println("No hay ninguna empresa para eliminar.");
        } else {
            System.out.println("Seleccione el numero de empresa que desea eliminar.");
            int numE = scan.nextInt();
            try {
                listaEmpresa.remove(numE - 1);
                System.out.println("Empresa eliminada correctamente.");
            } catch (IndexOutOfBoundsException E) {
                System.out.println("Esa empresa no existe.");
            }
        }
    }

    public static void empresa(String idEmpresa) {
        int opcion = 1;
        while (opcion != 0) {
            System.out.println("Ingrese una opcion del menu:\n1. Ingresar un animal.\n2. Desparasitar un animal.\n3. Vacunar un animal.\n4. Listar animales por especie.\n5. Listar genealogia de un animal.\n6. Listar animal.\n0. Salir de la empresa.");
            opcion = scan.nextInt();
            switch (opcion) {
                case 0:
                    break;
                case 1:
                    altaAnimal(idEmpresa);
                    break;
                case 2:
                    desparasitarAnimal(idEmpresa);
                    break;
                case 3:
                    vacunarAnimal(idEmpresa);
                    break;
                case 4:
                    listarPorEspecie(idEmpresa);
                    break;
                case 5:
                    listarPorFamiliaPorId(idEmpresa);
                    break;
                case 6:
                    listarAPPorId(idEmpresa);
                    break;
                default:
                    System.out.println("Seleccione una opcion valida.");
                    break;
            }
        }
    }

    public static String generarIdAnimal() {
        String[] rndm = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9"};
        String id = "";
        int cont = 1;
        while (cont != 0) {
            cont = 0;
            id = "";
            for (int i = 0; i < 6; i++) {
                id += rndm[(int) (Math.random() * 10)];
            }
            for (Animal unAnimal : listaAnimal) {
                if (unAnimal.getId().equals(id)) {
                    cont++;
                }
            }
        }
        return id;
    }

    public String buscarAnimal(String pId, int index) {
        if (listaAnimal.size() == index) {
            return null;
        }
        if (listaAnimal.get(index).getId().equals(pId)) {
            return listaAnimal.get(index).getId();
        } else {
            return buscarAnimal(pId, index + 1);
        }
    }

    public Animal devolverAnimal(String pId, int index) {
        if (listaAnimal.size() == index) {
            return null;
        }
        if (listaAnimal.get(index).getId().equals(pId)) {
            return listaAnimal.get(index);
        } else {
            return devolverAnimal(pId, index + 1);
        }
    }

    public static void altaAnimal(String idEmpresa) {
        String id = generarIdAnimal();
        System.out.println("Ingrese el tipo de animal, ovino o bovino.");
        String tipo = scan.next().toLowerCase().charAt(0) == 'o' ? "Ovino" : "Bovino";
        System.out.println("Ingrese el sexo del animal, hembra o macho.");
        String sexo = scan.next().toLowerCase().charAt(0) == 'h' ? "Hembra" : "Macho";
        int cont = 1;
        List<Animal> listaMadre = new ArrayList<>();
        for (Animal unAnimal : listaAnimal) {
            if (unAnimal.getSexo().equals("Hembra") && unAnimal.getTipo().equals(tipo) &&
            unAnimal.getEmpresa().equals(idEmpresa)) {
                System.out.println(cont + ". " + unAnimal);
                listaMadre.add(unAnimal);
                cont++;
            }
        }

        System.out.println("Ingrese el numero del madre del animal, 0 si es desconocido.");
        boolean tf = false;
        int num = scan.nextInt();

        Animal animalMadre = new Animal();
        while (!tf) {
            if (num == 0) {
                System.out.println("Madre del animal seleccionada como nula.");
                tf = true;
            }
            if (num <= listaMadre.size() && num > 0) {
                animalMadre = listaMadre.get(num - 1);
                System.out.println("Madre del animal seleccionada.");
                tf = true;
            } else {
                System.out.println("Ese numero de animal no existe, intente de nuevo.");
            }
        }
        cont = 1;
        Animal animalPadre = new Animal();
        List<Animal> listaPadre = new ArrayList<>();
        for (Animal unAnimal : listaAnimal) {
            if (unAnimal.getSexo().equals("Macho") && unAnimal.getTipo().equals(tipo)
                    && unAnimal.getEmpresa().equals(idEmpresa)) {
                System.out.println(cont + ". " + unAnimal);
                listaPadre.add(unAnimal);
                cont++;
            }
        }
        System.out.println("Ingrese el numero del padre del animal, 0 si es desconocido.");
        tf = false;
        num = scan.nextInt();
        String idPadre = "";
        while (!tf) {
            if (num == 0) {
                System.out.println("Padre del animal seleccionado como nula.");
                tf = true;
            }
            if (num <= listaPadre.size() && num > 0) {
                animalPadre = listaPadre.get(num - 1);
                System.out.println("Padre del animal seleccionado.");
                tf = true;
            } else {
                System.out.println("Ese numero de animal no existe, intente de nuevo.");
            }
        }
        Animal pAnimal = new Animal(id, tipo, sexo, false, false, idEmpresa);

        listaAnimal.add(pAnimal);

        ABB pArbolAnimal = new ABB();
        pArbolAnimal.armarArbol(pAnimal, animalMadre, animalPadre);
        listaABB.add(pArbolAnimal);

        System.out.println("Animal ingresado correctamente.");
    }

    public static void desparasitarAnimal(String idEmpresa) {
        int cont = 1;
        for (Animal unAnimal : listaAnimal) {
            if (!unAnimal.isDesparasitado() && unAnimal.getEmpresa().equals(idEmpresa)) {
                System.out.println(cont + ". " + unAnimal);
                cont++;
            }
        }
        if (cont == 1) {
            System.out.println("No hay animales para desparacitar");
        } else {

            System.out.println("Seleccione el numero de animal que quiere desparasitar.");
            int numA = scan.nextInt();
            if (numA > cont) {
                System.out.println("No existe ese numero de animal.");
            } else {
                cont = 1;
                for (Animal unAnimal : listaAnimal) {
                    if (!unAnimal.isDesparasitado() && unAnimal.getEmpresa().equals(idEmpresa)) {
                        if (cont == numA) {
                            unAnimal.setDesparasitado(true);
                            System.out.println("El animal fue desparacitado correctamente.");
                        }
                        cont++;
                    }
                }
            }
        }
    }

    public static void vacunarAnimal(String idEmpresa) {
        int cont = 1;
        for (Animal unAnimal : listaAnimal) {
            if (!unAnimal.isVacunado() && unAnimal.getEmpresa().equals(idEmpresa)) {
                System.out.println(cont + ". " + unAnimal);
                cont++;
            }
        }
        if (cont == 1) {
            System.out.println("No hay animales para desparacitar");
        } else {
            System.out.println("Seleccione el numero de animal que quiere vacunar.");
            int numA = scan.nextInt();
            if (numA > cont) {
                System.out.println("No existe ese numero de animal.");
            } else {
                cont = 1;
                for (Animal unAnimal : listaAnimal) {
                    if (!unAnimal.isVacunado()) {
                        if (cont == numA) {
                            unAnimal.setVacunado(true);
                            System.out.println("El animal fue vacunado correctamente.");
                        }
                        cont++;
                    }
                }
            }
        }
    }

    public static void listarPorEspecie(String idEmpresa) {
        System.out.println("Seleccione la epecie a listar");
        String tipo = scan.next().toLowerCase().charAt(0) == 'o' ? "Ovino" : "Bovino";

        int cont = 1;
        for (Animal unAnimal : listaAnimal) {
            if (unAnimal.getTipo().equals(tipo) && unAnimal.getEmpresa().equals(idEmpresa)) {
                System.out.println(cont + " " + unAnimal);
            }
        }
    }


    public static void listarPorFamiliaPorId(String idEmpresa) {


        for (Animal unAnimal : listaAnimal) {
if(unAnimal.getEmpresa().equals(idEmpresa)) {

    System.out.println(unAnimal);
}
        }
        System.out.println("Seleccione el id del animal que quiere listar la familia.");
        String id = scan.next();

        //  Animal Sanimal =new Animal();


            for (Animal unAnimal : listaAnimal) {
                if (unAnimal.getId().equals(id) && unAnimal.getEmpresa().equals(idEmpresa)) {

                    System.out.println("Animal selecionado con exito");


                    for (ABB arbol : listaABB) {
                        if (arbol.raiz.GetIdAnimal().equals(unAnimal.getId())) {

                            arbol.imprimirPre();


                        }
                    }
                }


            }
        }
    public static void listarAPPorId(String idEmpresa) {
        System.out.println("Seleccione el id del animal que quiere listar.");
        String id = scan.next();
        for (Animal unAnimal : listaAnimal) {
            if (unAnimal.getId().equals(id) && unAnimal.getEmpresa().equals(idEmpresa)) {
                System.out.println(unAnimal.toString());
            }
        }
        for (Animal unAnimal : listaAnimal) {
            if (!unAnimal.getId().equals(id) && unAnimal.getEmpresa().equals(idEmpresa)) {
                System.out.println("No existe ese ID");
            }
        }
    }


        public  ABB.Nodo buscarfamiliar(String id) {

                for (ABB arbol : listaABB) {
                    if (arbol.raiz.GetIdAnimal().equals(id)) {
                            return arbol.raiz;
                    }
                }


            return null;
        }

}



