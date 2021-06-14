package com.company;

import java.io.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import java.util.Vector;
import java.io.Console;

//C:\Users\EPA\Desktop\PruebaTxt

public class Main {

    Notas notas[]  = new Notas[100];
    Usuarios rusuario [] = new Usuarios[5];
    int NotasC;
    static int contador_alumnos=0;
    static ALUMNOS alumnos[] = new ALUMNOS[100];
    static int contador_curso = 0;
    static Cursos[] curso = new Cursos[15];
    static AsignarAlumnos[] Asig_Al = new AsignarAlumnos[200];
    static AsignarProfesores[] Asig_Pf = new AsignarProfesores[30];
    static int contadorasignarAlumnos,contadornotas,contadorprofesores = 1;
    static Profesores[] profesores = new Profesores[20];
    static int Nprof = 0;
    static boolean asignacion;
    static int añonuevo;

    static int posAlmuno, posCurso,posNotaA,posNotaC,posProfe;



    Scanner lec =new Scanner (System.in);
    Scanner lect =new Scanner (System.in);
    Scanner lectu =new Scanner (System.in);

    public static void main(String[] args) {

        Main inicio =new Main();
        inicio.InicioSesion();


    }

    void Menu(){
        boolean entrar_menu = true;
        while (entrar_menu == true) {
            System.out.println("===Seleccione lo que desea hacer===");
            System.out.println("1. Cargar Alumnos");
            System.out.println("2. Cargar Profesores ");
            System.out.println("3. Cargar Cursos");
            System.out.println("4. Asignar Alumnos");
            System.out.println("5. Asignar Profesores");
            System.out.println("6. Cargar Notas");
            System.out.println("7. Registrar Usuario");
            System.out.println("8. Imprimir Reportes");
            System.out.println("9. Cerrar Sesión");
            System.out.println("====================================");
            System.out.print(">>>Escribir el número de opción: ");

            Scanner lec = new Scanner(System.in);
            int opccion = lec.nextInt();

            switch (opccion) {

                case 1:
                    CargaAlumnos();
                    break;
                case 2:
                    CargarPersonas();
                    break;
                case 3:
                    CargaCursos();
                    break;
                case 4:
                    AsignarAlunmo();
                    break;
                case 5:
                    AsignarProfesor();
                    break;
                case 6:
                    CargaNotas();
                    int i;
                    for (i = 0; i < NotasC; i++) {
                        System.out.print("Id:" + this.notas[i].getIdAlumnos() + "\tIdCurso:" + this.notas[i].getIdCursos() + "\tNota:" + this.notas[i].getNota() + "\n");
                    }
                    break;
                case 7:
                    RUsuarios();
                    break;
                case 8:
                    ReporteA();
                    reportes_curso();
                    ReporteASIG();
                    ReporteAsigPrf();
                    break;
                case 9:
                    System.out.println("Has cerrado sesión");
                    InicioSesion();
                    break;

            }
        }


    }

    void InicioSesion(){
        System.out.println("===Seleccione una opción===");
        System.out.println("1. Ingresar como Administrador");
        System.out.println("2. Ingresar como Usuario ");
        System.out.println("====================================");
        System.out.print(">>>Escribir el número de opción: ");

        Scanner lec = new Scanner(System.in);
        int opccion = lec.nextInt();

        switch(opccion){
            case 1:
                Inicio();
                break;
            case 2:
                InicioUsuario();
                break;

        }


    }

    void Inicio(){
            System.out.println("===Ininciar Sesión===");
            System.out.println("Introduzca su Usuario");
            System.out.print(">>>");
            Scanner lec = new Scanner(System.in);
            String usuario = lec.nextLine();
            if(usuario.equals("admin")){
                System.out.println("Introduzca su Contraseña");
                System.out.print(">>>");
                Scanner lect = new Scanner(System.in);
                String contraseña = lec.nextLine();
                if (contraseña.equals("admin")){
                    System.out.println("Bienvenido al Menu");
                    Menu();
                }else{
                    System.out.println("***Contraseña incorrecta***");
                    Archivos.addToEndFile("Logs.log","/n/n"+new Date()+"Error contraseña");
                    Inicio();
                }

            }else{
                System.out.println("***Usuario Incorrecto***");
                Archivos.addToEndFile("Logs.log","/n/n"+new Date()+"Error Usuario");
                Inicio();
            }

    }

    void RUsuarios(){

        System.out.println("===Registrar Usuario===");
        System.out.println("Introduzca su Usuario");
        System.out.print(">>>");
        Scanner lec = new Scanner(System.in);
        String usuario = lec.nextLine();
        Usuarios obj = new Usuarios();
        if (Usuarios.Verificar(usuario)==-1) {

            System.out.println("Introduzca su Contraseña");
            System.out.print(">>>");
            Scanner lect = new Scanner(System.in);
            String contraseña = lect.nextLine();

            System.out.println("Introduzca de nuevo su Contraseña");
            System.out.print(">>>");
            Scanner lectu = new Scanner(System.in);
            String contraseña2 = lect.nextLine();

            if(contraseña.equals(contraseña2)){
                obj.setUsuario(usuario);
                ListaUsuario.agregar(obj);

                obj.setContraseña(contraseña);
                ListaUsuario.agregar(obj);

                System.out.println("");
                System.out.println("------Usuario Registrado con Exito------");
                System.out.println("");
                InicioSesion();
            }else{
                System.out.println("Las contraseñas no coinciden");
                Archivos.addToEndFile("Logs.log","/n/n"+new Date()+"Error de contraseñas no coinciden");
                Menu();
            }

        }else{
            System.out.println("El usuario ya ha sido ingresado o limite de usuarios alcanzados");
            Archivos.addToEndFile("Logs.log","/n/n"+new Date()+"Error usuario no asignado");
            InicioSesion();
        }

    }

    void InicioUsuario(){
        System.out.println("===Inicio de Sesión de Usuario===");
        System.out.println("Introduzca su Usuario");
        System.out.print(">>>");
        Scanner lec = new Scanner(System.in);
        String usuario = lec.nextLine();

            System.out.println("Introduzca su Contraseña");
            System.out.print(">>>");
            Scanner lect = new Scanner(System.in);
            String contraseña = lec.nextLine();

            int pos = Usuarios.VerificarL(usuario,contraseña);
            if (pos == -1){
                System.out.println("");
                System.out.println("----Usuario o Contraseña Incorrecta----");
                System.out.println("");
                InicioSesion();
            }else{
                System.out.println("");
                System.out.println("=======Bienvenido al Menu=======");
                System.out.println("");
                MUsuarios();

            }




    }

    void MUsuarios(){
        System.out.println("===Seleccione lo que desea hacer===");
        System.out.println("1. Generar Reportes");
        System.out.println("2. Cerrar Sesión");
        System.out.println("====================================");
        System.out.print(">>>Escribir el número de opción: ");
        Scanner lec = new Scanner(System.in);
        int opccion = lec.nextInt();
        switch(opccion){
            case 1:
                System.out.println("Imprimir Reportes");
                MUsuarios();
                break;
            case 2:
                InicioSesion();
                break;

        }
    }

    public static void CargaAlumnos(){
        Scanner nose = new Scanner(System.in);//Instanciando scanner
        Scanner leer = new Scanner(System.in);//Instanciando scanner
        File archivo = null;//abrir archivo

        FileReader fr = null;//almacenar texto de archivo
        BufferedReader br = null;//leer el texto almacenado
        try {
            System.out.println(">>>Ingrese la ruta del archivo que desea leer (>>Alumnos<<): ");
            System.out.print(">");
            String R1 = leer.nextLine();
            R1 = R1.replaceAll("\"", "");
            int saltolinea = 0;

            // LECTURA DEL ARCHIVO
            System.out.println("...............................................");
            System.out.println(">> Su mensaje carga de Alumnos es <<");
            archivo = new File(R1);
            fr = new FileReader(archivo);
            br = new BufferedReader(fr);
            // Variable para guardar la linea que almacena el BufferedReader.
            String pok = ",";
            String linea;
            int Linea_alumno = 1;
            // String pok = "";// lectura fichero
            //(int id_alumno, int carne_alumno, String nombre_alumno, int fechaNac_alumno, String genero_alumno)
            while ((linea = br.readLine()) != null) {
                if (saltolinea != 0) {
                    System.out.println(linea);
                    linea=linea.trim();
                    String datos[] = linea.split(",");
                    int id_al = Integer.parseInt(datos[0].trim());
                    int carne_al = Integer.parseInt(datos[1].trim());
                    String nombre_al = datos[2].trim().toUpperCase();
                    String fecha_al = datos[3].trim();

                    String fecha [] = fecha_al.split("/");
                    int dia = Integer.parseInt(fecha[0]);
                    int mes = Integer.parseInt(fecha[1]);
                    int año = Integer.parseInt(fecha[2]);

                    String genero_al= datos[4].toUpperCase();

                    if (alumnos[0] == null) {
                        alumnos[0] = new ALUMNOS(id_al,carne_al,nombre_al,fecha_al,genero_al,dia,mes,año);
                    } else {
                        boolean asigID = true;
                        for (int i = 0; i < contador_alumnos; i++) {
                            if (alumnos[i].getId_alumno() == id_al) {
                                asigID = false;
                                System.out.println("no se puede asignar el alumno de la linea " + Linea_alumno + " \t ya existe una ID Igual asi que se descarta este ID");
                            }
                        }
                        if (asigID == true && contador_alumnos <= 100) {
                            int aux = 0;
                            Boolean SincOcup = false;
                            while (SincOcup == false) {
                                if (alumnos[aux] == null) {
                                    alumnos[aux] = new ALUMNOS(id_al,carne_al,nombre_al,fecha_al,genero_al,dia,mes,año);
                                    SincOcup = true;
                                    contador_alumnos++;
                                    Linea_alumno++;
                                } else {
                                    aux++;
                                }
                            }}
                        else {
                            System.out.println("Llegaste al limite de Alumnos ");
                        }
                    }}
                else{
                    saltolinea++;
                }}
            contador_alumnos++;
            System.out.println("...............................................");
            System.out.println(">> Carga terminada cargaste " + contador_alumnos + "  Alumnos <<");
            System.out.println("...............................................");

        } catch (Exception e) {
            // System.out.println("Error al ingresar el archivo");
            e.printStackTrace();
        } finally {
            // En el finally cerramos el fichero, para asegurarnos
            // que se cierra tanto si todo va bien como si salta
            // una excepcion.
            try {
                if (null != fr) {
                    //  System.out.println("Error al leer el archivo");
                    fr.close();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }


    public static void CargaCursos() {
        Scanner sc = new Scanner(System.in);
        File archivo = null;
        FileReader fr = null;
        BufferedReader br = null;

        try {
            System.out.println(">>>Ingrese la ruta del archivo que desea leer>>>>: ");
            System.out.print(">");
            String RC = sc.nextLine();
            RC = RC.replaceAll("\"", "");
            int saltolinea = 0;
            System.out.println("...............................................");
            System.out.println(">> Su mensaje carga de Cursos es <<");
            archivo = new File(RC);
            fr = new FileReader(archivo);
            br = new BufferedReader(fr);
            String cur = ",";
            int Linea_curso = 1;

            while(true) {
                while(true) {
                    String linea;
                    while((linea = br.readLine()) != null) {
                        if (saltolinea != 0) {
                            System.out.println(linea);
                            linea=linea.trim();
                            String[] datos = linea.split(",");
                            int id = Integer.parseInt(datos[0].trim());
                            int cod = Integer.parseInt(datos[1].trim());
                            String name = datos[2].trim().toUpperCase();
                            if (curso[0] == null) {
                                curso[0] = new Cursos(id, cod, name);
                            } else {
                                boolean asigID = true;

                                int aux;
                                for(aux = 0; aux < contador_curso; ++aux) {
                                    if (curso[aux].getId() == id) {
                                        asigID = false;
                                        System.out.println("no se puede asignar el curso de la linea " + Linea_curso + " \t ya existe una ID Igual asi que se descarta este ID");
                                    }
                                }

                                if (asigID && contador_curso <= 100) {
                                    aux = 0;
                                    Boolean SincOcup = false;

                                    while(!SincOcup) {
                                        if (curso[aux] == null) {
                                            curso[aux] = new Cursos(id, cod, name);
                                            SincOcup = true;
                                            ++contador_curso;
                                            ++Linea_curso;
                                        } else {
                                            ++aux;
                                        }
                                    }
                                } else {
                                    System.out.println("Llegaste al limite de cursos ");
                                }
                            }
                        } else {
                            ++saltolinea;
                        }
                    }

                    ++contador_curso;
                    System.out.println("...............................................");
                    System.out.println(">> Carga terminada cargaste " + contador_curso + "  cursos <<");
                    System.out.println("...............................................");
                    return;
                }
            }
        } catch (Exception var24) {
            var24.printStackTrace();
        } finally {
            try {
                if (null != fr) {
                    fr.close();
                }
            } catch (Exception var23) {
                var23.printStackTrace();
            }

        }
    }

    void CargaNotas (){

        try {
            Scanner lec = new Scanner(System.in);
            String  ruta;
            System.out.print("Ingrese la Ruta");
            System.out.println("");
            System.out.print(">>");
            ruta = lec.nextLine();


            File archivo = null;
            FileReader fr = null;
            BufferedReader br = null;
            //boolean asignacion = true;

            try{
                archivo = new File(ruta);
                fr = new FileReader(archivo);
                br = new BufferedReader(fr);

                String not = br.readLine();

                int LlenadoNotas = 0;
                try {
                while((not = br.readLine()) !=null) {
                    System.out.println(not);


                        //System.out.println(LlenadoNotas);

                        String Dato[] = not.split(",");

                        int Id = Integer.parseInt(Dato[0].trim());
                        int Curso = Integer.parseInt(Dato[1].trim());
                        double Nota = Double.parseDouble(Dato[2].trim());

                        posNotaC = BuscarCurso(Curso);
                        posNotaA = BuscarCurso(Id);

                        if (posNotaA != 0101 && posNotaC != 0101) {//si el alumno si existe se procede
                            if (notas[0] == null) {
                                notas[0] = new Notas(alumnos[posNotaA], curso[posNotaC],Nota);
                                //AsignarAlu nuevo = new AsignarAlumnos(alumnos[posAlmuno], curso[posCurso]);
                                contadornotas++;
                                LlenadoNotas++;
                                System.out.println("Si existe el curso"+curso[posNotaC].getId()+"con el alumno"+alumnos[posNotaA].getId_alumno());
                            }else {
                                System.out.println("Llegaste al limite de Notas ");
                                Archivos.addToEndFile("Logs.log","/n/n"+new Date()+"Error de notas");
                            }
                        }

                        /*if (contador_alumnos <= 100) {
                            int aux = 0;
                            Boolean SincOcup = false;
                            while (SincOcup == false) {
                                if (notas[aux] == null) {
                                    notas[aux] = new Notas(alumnos[posNotaA], curso[posNotaC],Nota);
                                    SincOcup = true;
                                    contadornotas++;
                                    LlenadoNotas++;
                               } else {
                            aux++;
                        }
                    }
                        }
                        else {
                            System.out.println("Llegaste al limite de Notas ");
                        }*/
                    }
                        contadornotas++;
            System.out.println("...............................................");
            System.out.println(">> Carga terminada cargaste " + contadornotas + "  Notas <<");
            System.out.println("...............................................");



                    } catch(Exception e){
                        e.printStackTrace();
                    }




            }catch (Exception e2) {
                e2.printStackTrace();

            }
        }catch (Exception e3) {
            e3.printStackTrace();

        }
    }

    public static void CargarPersonas(){

        Scanner lector = new Scanner(System.in);
        File archivo = null;
        FileReader fr = null;
        BufferedReader br = null;

        try {

            System.out.print("Ingresar la ruta del archivo csv a leer: ");
            String ruta;
            ruta = lector.nextLine();
            ruta = ruta.replaceAll("\"", "");
            archivo = new File(ruta);
            fr = new FileReader(archivo);
            br = new BufferedReader(fr);
            int s_linea = 1;

            String linea = br.readLine();
            int l_prof = 1;
            while ((linea = br.readLine()) != null) {

                if (s_linea != 0){
                    System.out.println(linea);
                    linea=linea.trim();
                    String[] datos = linea.split(",");
                    String nombre = datos[0].trim().toUpperCase();
                    int id_prof = Integer.parseInt(datos[1].trim());
                    int rp_prof = Integer.parseInt(datos[2].trim());
                    String fn_prof = datos[3].trim().toUpperCase();
                    String fc_prof = datos[4].trim().toUpperCase();
                    String g= datos[5].trim().toUpperCase();
                    if (profesores[0] == null) {
                        profesores[0] = new Profesores(nombre,id_prof,rp_prof,fn_prof,fc_prof,g);
                    } else {
                        boolean asigID = true;
                        for (int i = 0; i < Nprof; i++) {
                            if (profesores[i].getid_prof() == id_prof) {
                                asigID = false;
                                System.out.println("Ya existe una ID Igual asi que se descarta este ID");
                            }
                        }

                        if (asigID == true && Nprof <= 20) {
                            int aux = 0;
                            Boolean SincOcup = false;
                            while (SincOcup == false) {
                                if (profesores[aux] == null) {
                                    profesores[aux] = new Profesores(nombre,id_prof,rp_prof,fn_prof,fc_prof,g);
                                    SincOcup = true;
                                    Nprof++;
                                    l_prof++;
                                } else {
                                    aux++;
                                }
                            }}
                        else {
                            System.out.println("Llegaste al limite de Alumnos");
                        }
                    }}
                else{
                    s_linea++;
                }}
            Nprof++;
            System.out.println("...............................................");
            System.out.println(">> Carga terminada cargaste " + Nprof + "  Profesores <<");
            System.out.println("...............................................");






        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (null != fr) {
                    fr.close();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    public static void AsignarAlunmo() {
        Scanner lector = new Scanner(System.in);
        File archivo = null;
        FileReader fr = null;
        BufferedReader br = null;

        try {

            System.out.print("Ingresar la ruta del archivo csv a leer: ");
            String ruta;
            ruta = lector.nextLine();
            ruta = ruta.replaceAll("\"", "");
            archivo = new File(ruta);
            fr = new FileReader(archivo);
            br = new BufferedReader(fr);
            int lineaA = 1;
            String linea = br.readLine();
            int l_prof = 1;
            while ((linea = br.readLine()) != null) {
                System.out.println(linea);
                String datos4[] = linea.split(",");
                int idAlu = Integer.parseInt(datos4[0]);
                int idCurso = Integer.parseInt(datos4[1]);
                posAlmuno = BuscarAlumno(idAlu);//profesores[3]=3
                posCurso = BuscarCurso(idCurso);
                if (posAlmuno != 0101 && posCurso != 0101) {//si el alumno si existe se procede
                    if (Asig_Al[0] == null) {
                        Asig_Al[0] = new AsignarAlumnos(alumnos[posAlmuno], curso[posCurso]);
                        //AsignarAlu nuevo = new AsignarAlumnos(alumnos[posAlmuno], curso[posCurso]);

                        System.out.println("Se asigno el Alumno con ID: " + alumnos[posAlmuno].getId_alumno());
                        System.out.println("Al curso: " + curso[posCurso].getId());
                        System.out.println("---------------------------------------------------");
                        contadorasignarAlumnos++;
                        lineaA++;
                    } else {
                        boolean asigID = true;
                        for (int i = 0; i < contadorasignarAlumnos; i++) {
                            if (Asig_Al[i].getIdAlumnos() == alumnos[posAlmuno]) {
                                asigID = false;
                                System.out.println(" no se puede asignar el Alumno de la linea " + lineaA + "\t ya esta asignado");

                            }
                        }
                        if (asigID == true && contadorasignarAlumnos <= 200) {
                            int aux1 = 0;
                            Boolean SincOcup = false;
                            while (SincOcup == false) {
                                if (Asig_Al[aux1] == null) {
                                    Asig_Al[aux1] = new AsignarAlumnos(alumnos[posAlmuno], curso[posCurso]);
                                    //AsignarAlu nuevo = new AsignarAlumnos(alumnos[posAlmuno], curso[posCurso]);
                                    //AsignandoPok[contadorasignarAlumnos]=nuevo;
                                    SincOcup = true;
                                    System.out.println("Se asigno el Alumno con ID: " + alumnos[posAlmuno].getId_alumno());
                                    System.out.println("A la Poke Ball: " + curso[posCurso].getId());
                                    System.out.println("---------------------------------------------------");


                                    contadorasignarAlumnos++;
                                    lineaA++;
                                } else {
                                    aux1++;
                                }
                            }
                        } else {
                            System.out.println("Llegaste al limite de Poke Ball ");
                        }
                    }/////////////////////////////////////////////////
                }
            }
            //     MostrarDatosAsigPok(AsignandoPok);
            //AsignarPokes[contadorasignarPok]=nuevo;
            contadorasignarAlumnos++;
            System.out.println("........................................................");
            System.out.println(">> Carga terminada cargaste " + contadorasignarAlumnos + " Asignacion Alumnos <<");
            System.out.println("........................................................");
        } catch (Exception e) {
            // System.out.println("Error al ingresar el archivo");
            e.printStackTrace();
        } finally {
            // En el finally cerramos el fichero, para asegurarnos
            // que se cierra tanto si todo va bien como si salta
            // una excepcion.
            try {
                if (null != fr) {
                    //  System.out.println("Error al leer el archivo");
                    fr.close();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }

        }

    }

    public static void AsignarProfesor() {
        Scanner lector = new Scanner(System.in);
        File archivo = null;
        FileReader fr = null;
        BufferedReader br = null;

        try {

            System.out.print("Ingresar la ruta del archivo csv a leer: ");
            String ruta;
            ruta = lector.nextLine();
            ruta = ruta.replaceAll("\"", "");
            archivo = new File(ruta);
            fr = new FileReader(archivo);
            br = new BufferedReader(fr);
            int lineaA = 1;
            String linea = br.readLine();
            int l_prof = 1;
            while ((linea = br.readLine()) != null) {
                System.out.println(linea);
                String datos4[] = linea.split(",");
                int idProfe = Integer.parseInt(datos4[0]);
                int idCurso = Integer.parseInt(datos4[1]);
                posProfe = BuscarProfe(idProfe);//profesores[3]=3
                posProfe = BuscarCurso(idCurso);
                if (posProfe != 0101 && posProfe != 0101) {//si el alumno si existe se procede
                    if (Asig_Pf[0] == null) {
                        Asig_Pf[0] = new AsignarProfesores(profesores[posProfe], curso[posCurso]);
                        //AsignarAlu nuevo = new AsignarAlumnos(alumnos[posAlmuno], curso[posCurso]);

                        System.out.println("Se asigno el Profesor con ID: " + profesores[posProfe].getid_prof());
                        System.out.println("Al curso: " + curso[posCurso].getId());
                        System.out.println("---------------------------------------------------");
                        contadorprofesores++;
                        lineaA++;
                    } else {
                        boolean asigID = true;
                        for (int i = 0; i < contadorprofesores; i++) {
                            if (Asig_Pf[i].getIdProfesores() == profesores[posProfe]) {
                                asigID = false;
                                System.out.println(" no se puede asignar el Profesor de la linea " + lineaA + "\t ya esta asignado");

                            }
                        }
                        if (asigID == true && contadorprofesores <= 200) {
                            int aux1 = 0;
                            Boolean SincOcup = false;
                            while (SincOcup == false) {
                                if (Asig_Pf[aux1] == null) {
                                    Asig_Pf[aux1] = new AsignarProfesores(profesores[posProfe], curso[posCurso]);
                                    //AsignarAlu nuevo = new AsignarAlumnos(alumnos[posAlmuno], curso[posCurso]);
                                    //AsignandoPok[contadorasignarAlumnos]=nuevo;
                                    SincOcup = true;
                                    System.out.println("Se asigno el Profesor con ID: " + profesores[posProfe].getid_prof());
                                    System.out.println("A la Poke Ball: " + curso[posCurso].getId());
                                    System.out.println("---------------------------------------------------");


                                    contadorprofesores++;
                                    lineaA++;
                                } else {
                                    aux1++;
                                }
                            }
                        } else {
                            System.out.println("Llegaste al limite de Poke Ball ");
                        }
                    }/////////////////////////////////////////////////
                }
            }
            //     MostrarDatosAsigPok(AsignandoPok);
            //AsignarPokes[contadorasignarPok]=nuevo;
            contadorprofesores++;
            System.out.println("........................................................");
            System.out.println(">> Carga terminada cargaste " + contadorprofesores + " Asignacion Profesores <<");
            System.out.println("........................................................");
        } catch (Exception e) {
            // System.out.println("Error al ingresar el archivo");
            e.printStackTrace();
        } finally {
            // En el finally cerramos el fichero, para asegurarnos
            // que se cierra tanto si todo va bien como si salta
            // una excepcion.
            try {
                if (null != fr) {
                    //  System.out.println("Error al leer el archivo");
                    fr.close();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }

        }

    }

    public static int BuscarAlumno(int id_alumno) {
        for (int i = 0; i < alumnos.length; i++) {
            if (alumnos[i] != null) {
                if (alumnos[i].getId_alumno() == id_alumno) {
                    // System.out.println("LO ENCONTRAMOS");
                    return i;
                }
            }

        }
        return 0101;//no se encontro

    }

    public static int BuscarCurso(int id_curso) {
        for (int i = 0; i < curso.length; i++) {
            if (curso[i] != null) {
                if (curso[i].getId() == id_curso) {
                    // System.out.println("LO ENCONTRAMOS");
                    return i;
                }
            }

        }
        return 0101;//no se encontro

    }

    public static int BuscarProfe(int id_profe) {
        for (int i = 0; i < profesores.length; i++) {
            if (profesores[i] != null) {
                if (profesores[i].getid_prof() == id_profe ) {
                    // System.out.println("LO ENCONTRAMOS");
                    return i;
                }
            }

        }
        return 0101;//no se encontro

    }


    public static void ReporteA(){
        //Creando archivo
        Date date = new Date();
        DateFormat hourdateFormat = new SimpleDateFormat("HH:mm:ss dd/MM/yyyy");
        FileWriter fichero = null;
        PrintWriter pw = null;
        try{
            fichero = new FileWriter("R_Alumnos.html");//crear archivo
            pw = new PrintWriter(fichero);//este es nuestro lapiz
            pw.println(">HTML<");
            //<center> </center>
            pw.println("");
            pw.println("<center> Practica 2 (hora y fecha: " + hourdateFormat.format(date) + ")" + " </center>");
            pw.println("<center>Reporte Practica 2 </center>" );
            pw.println("<head>");
            pw.println("<title>Reporte Alumnos</title>");
            pw.println("</head>");
            /////////////////////////////////////////////////////////////////////////
            //  pw.println("<body text =#FFFFFF, background= Imagenes/fondo.jpg");
            //INICIANDO CONTENIDO
            //"C:\Users\lorena\Desktop\cargaAlumnos.txt"
            pw.println("<hr color=\"blue\" size=3 >");
            pw.print("<h1><center><font face=Cooper Black  font color= #2874A6 >°°Alumnos°° </aright></center></h1>");
            pw.println("<center> Se muestran todos los Alumnos ingresados en la carga masiva </center>" );
            pw.println("<body background=fiusac03.jpg>");
            pw . println ( " <hr align = left> " );


            for (int i = 0; i < alumnos.length; i++) {

                if (null!=alumnos[i]) {
                    pw.println("<hr color=\"green\" size=2 >");
                    pw.println("<center><font face=Cooper Black  font color=red> Alumno de la linea  "+(i+1) +"</font></center>" );
                    //System.out.println("Línea: "+(i+1));
                    pw.println("<div style=\"text-align:center;\">");
                    pw.println("<table border=\"1\" style=\"margin: 0 auto;\">");

                    pw.println("<tr>");//FILA inicio
                    pw.println("<td>" + "Carne del Alumno: " + "</td>");//COLUMNA
                    pw.println("<td>" +alumnos[i].getCarne_alumno()+ "</td>");//COLUMNA
                    pw.println("</tr>");//FILA

                    pw.println("<tr>");//FILA Inicio
                    pw.println("<td>" + "Nombre del Alumno: " + "</td>");//COLUMNA
                    pw.println("<td>" +alumnos[i].getNombre_alumno()+ "</td>");//COLUMNA
                    pw.println("</tr>");//FILA

                    pw.println("<tr>");//FILA Inicio
                    pw.println("<td>" + "Edad del Alumno: " + "</td>");//COLUMNA
                    añonuevo = 2021 - alumnos[i].getAño();
                    alumnos[i].setAño(añonuevo);
                    pw.println("<td>" +alumnos[i].getAño()+ "</td>");//COLUMNA
                    pw.println("</tr>");//FILA

                    pw.println("<tr>");//FILA Inicio
                    pw.println("<td>" + "Genero del Alumno: " + "</td>");//COLUMNA
                    pw.println("<td>" +alumnos[i].getGenero_alumno()+ "</td>");//COLUMNA
                    pw.println("</tr>");//FILA

                    pw.println("</table>");//se cierra la primera tabla
                    pw.println("</div>");

                }

            }
            pw.println("</body>");
            pw.println("</HTML>");


        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                // Nuevamente aprovechamos el finally para
                // asegurarnos que se cierra el fichero.
                if (null != fichero)
                    fichero.close();
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    public static void reportes_curso(){

        //Creando archivo
        //Creando archivo
        Date date = new Date();
        DateFormat hourdateFormat = new SimpleDateFormat("HH:mm:ss dd/MM/yyyy");
        FileWriter fichero = null;
        PrintWriter pw = null;
        try{
            fichero = new FileWriter("REPORTE_CURSOS.html");//crear archivo
            pw = new PrintWriter(fichero);//este es nuestro lapiz
            pw.println(">HTML<");
            //<center> </center>
            pw.println("<center>|||PRACTICA_2||| ***** (hora y fecha: " + hourdateFormat.format(date) + ")" + " </center>");// HORA DEL DOCUMENTO.

            pw.println("<center> <font face=Cooper Black  font color= # 000000 >  Reporte : Practica 2 </center>" );
            pw.println("<head>");// COMIENZA EL ENCABEZADO DEL REPORTE
            pw.println("<title> REPORTE CURSOS HTML </title>");
            pw.println("<head>");// TERMINA EL ENCABEZADO DEL REPORTE

            /////////////////////////////////////////////////////////////////////////
            pw.println("<body>");//INICIANDO CONTENIDO style=\"background-color: #3349FF ;\"

            // pw.print(" <img src=\"poke2.jpg\" width=\"475\" height=\"140\" align=\"right\"> ");
            //pw.print("<img src height=\"100\" width=\"35\">");
            pw.print("<h1><center><font face=Cooper Black  font color= # 000000 > Cursos </aright></center></h1>");
            pw.println("<center> Los datos de cada curso se muestran acontinuación: </center>" );
            pw.println("<body background=fiusac03.jpg>");
            pw . println ( " <hr align = left> " );


            //pw.println("div ");
            // pw.println("   width:50 %");
            //pw.println("  border:black 3 px solid");
            //pw.println("margin - left:auto");
            // pw.println(" margin - right :auto");


            for (int i = 0; i < curso.length; i++) {

                pw.println("<div style=\"text-align:left;\">");
                pw.println("<table border=\"1\" style=\"margin:0 auto;\">");

                if (null != curso[i]) {
                    pw.println("<hr color=\"green\" size=2 >");


                    pw.println("<center>"+" <font face=Britannic Bold font color=reed> Alumno de la linea "+(i+1) +"</font>"+"</center>" );

                    //"<\"img src=\"images/pizarra.jpg\"width=\"400\"height=\"341\" title=\"hola mundo\">"


                    pw.println("<br>");
                    pw.println("<tr>");
                    pw.println(" <td>"+" <font face=Britannic Bold font color=black> El ID del curso:"+(i+1) +"</font>"+"</td>");
                    pw.println("<td>"+ "<font face=Britannic Bold font color=black> "+ curso[i].getId()+"</font>"+"</td>");
                    pw.println("</tr>");
                    pw.println("</br>");


                    pw.println("<br>");
                    pw.println("<tr>");
                    pw.println("<td>"+" <font face=Britannic Bold font color=black> EL codigo del curso es:"+"</font>"+"</td>");
                    pw.println("<td>" + " <font face=Britannic Bold font color=black> "+ curso[i].getCod()+"</font"+"</td>");
                    pw.println("</tr>");
                    pw.println("</br>");





                    pw.println("<br>");
                    pw.println("<tr>");
                    pw.println("<td>"+" <font face=Britannic Bold font color=black>  Nombre del curso es:"+"</font>"+"</td>");
                    pw.println("<td>"+ " <font face=Britannic Bold font color= black> "+ curso[i].getName()+"</font>"+"</td>");
                    pw.println("</tr>");
                    pw.println("</br>");



                }


                //pw.println("/div ");

                pw.println("</table >");//cierre primer tabla
                pw.println("</div >");
            }



            pw.println("</body>");
            pw.println("</HTML>");


        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                // Nuevamente aprovechamos el finally para
                // asegurarnos que se cierra el fichero.
                if (null != fichero)
                    fichero.close();
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }


    public static void ReporteASIG(){
        //Creando archivo
        Date date = new Date();
        DateFormat hourdateFormat = new SimpleDateFormat("HH:mm:ss dd/MM/yyyy");
        DateFormat FechaFormat = new SimpleDateFormat("dd/MM/yyyy");

        FileWriter fichero = null;
        PrintWriter pw = null;

        try{
            fichero = new FileWriter("R_asignacion.html");//crear archivo
            pw = new PrintWriter(fichero);//este es nuestro lapiz
            pw.println(">HTML<");
            //<center> </center>
            pw.println("<center> Practica_1 (hora y fecha: " + hourdateFormat.format(date) + ")" + " </center>");
            pw.println("<center>Reporte G8 </center>" );
            pw.println("<head>");
            pw.println("<title>Reporte ASIGNACION HTML</title>");
            pw.println("</head>");
            /////////////////////////////////////////////////////////////////////////
            pw.println("<body>");//INICIANDO CONTENIDO style=\"background-color:# 000000;\"
            // pw.print(" <img src=\"fondo.jpg\" width=\"475\" height=\"140\" align=\"right\"> ");
            // pw.print("<img src height=\"100\" width=\"35\">");
            pw.println("<body background=fiusac03.jpg>");
            pw . println ( " <hr align = left> " );

            pw.print("<h1><center><font face=Cooper Black  font color= # 000000 > Asignacion de Alumnos </aright></center></h1>");
            pw.println("<center> ACONTINUACION SE MUESTRAN LAS ASIGNACIONES DE ALUMNOS ALOS CURSOS  </center>" );



            for (int i = 0; i < Asig_Al.length; i++) {
                pw.println("<div style=\"text-align:left;\">");
                pw.println("<table border=\"1\" style=\"margin:0 auto;\">");

                if (null!=Asig_Al[i]) {
                    pw.println("<hr color=\"green\" size=2 >");


                    pw.println("<br>");
                    pw.println(" <font face=Britannic Bold font color=black> La asignacion del ID:"  + Asig_Al[i].getIdAlumnos().getId_alumno()+  "con el código de curso"+ Asig_Al[i].getIdCursos().getId()+"</font>");
                    pw.println("<br>");

                    //"Comic Sans MS,Britannic Bold,verdana">
                    pw.println("<br>");
                    pw.println("<tr>");
                    pw.println("<center>"+" <font face=Britannic Bold font color=black> Alumno de la linea "+(i+1) +"</font>"+"</center>" );
                    pw.println("<td>"+" <font face=Britannic Bold   font color=red> ALUMNO </font>"+"</td>");
                    pw.println("<td>"+"        "+"</td>");
                    pw.println("<td>"+" <font face=Britannic Bold font color=red> CURSO </font> "+"</td>");
                    pw.println("<br>");
                    pw.println("</tr>");

                    pw.println("<br>");
                    pw.println("<tr>");
                    pw.println("<td>"+" <font face=Britannic Bold font color=black> NOMBRE </font>   "+"</td>");
                    pw.println("<td>"+" <font face=Britannic Bold font color=black>"+Asig_Al[i].getIdAlumnos().getNombre_alumno()+"</font> "+"</td>");
                    pw.println("<td>"+" <font face=Britannic Bold font color=black> NOMBRE </font>   "+"</td>");
                    pw.println("<td>" +"<font face=Britannic Bold font color=black>"  + Asig_Al[i].getIdCursos().getName()+"</font> "+"</td>");
                    pw.println("<br>");
                    pw.println("</tr>");

                    pw.println("<br>");
                    pw.println("<tr>");
                    pw.println("<td>"+" <font face=Britannic Bold font color=black> CARNET </font>   "+"</td>");
                    pw.println("<td>"+" <font face=Britannic Bold font color=black> "+Asig_Al[i].getIdAlumnos().getCarne_alumno()+"</font>"+"</td>");
                    pw.println("<td>"+" <font face=Britannic Bold font color=black> CODIGO </font>   "+"</td>");
                    pw.println("<td>"   +" <font face=Britannic Bold font color=black>"+ Asig_Al[i].getIdCursos().getCod()+"</font>"+"</td>");
                    pw.println("<br>");
                    pw.println("</tr>");


                    pw.println("<br>");
                    pw.println("<tr>");
                    pw.println("<td>"+" <font face=Britannic Bold font color=black> LA FECHA DE ASIGNACION ES: </font>   "+"</td>");
                    pw.println("<td>"+" <font face=Britannic Bold font color=black> "+ FechaFormat.format(date) +"</font>"+"</td>");
                    pw.println("</tr>");
                    pw.println("<br>");

                }

                pw.println("</table >");//cierre primer tabla
                pw.println("</div >");

            }
            pw.println("</body>");
            pw.println("</HTML>");


        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                // Nuevamente aprovechamos el finally para
                // asegurarnos que se cierra el fichero.
                if (null != fichero)
                    fichero.close();
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }



    public static void ReporteAsigPrf(){
        //Creando archivo
        Date date = new Date();
        DateFormat hourdateFormat = new SimpleDateFormat("HH:mm:ss dd/MM/yyyy");
        //DateFormat SimpleDateFormat = new dia("dd/MM/yyyy");
        FileWriter fichero = null;
        PrintWriter pw = null;
        try{
            fichero = new FileWriter("R_asignacionP.html");//crear archivo
            pw = new PrintWriter(fichero);//este es nuestro lapiz
            pw.println(">HTML<");
            //<center> </center>
            pw.println("<center> Practica 2 (hora y fecha: " + hourdateFormat.format(date) + ")" + " </center>");
            pw.println("<center>Reporte Profesores Asignados</center>" );
            pw.println("<head>");
            pw.println("<title>Reporte ASIGNACION HTML</title>");
            pw.println("</head>");
            /////////////////////////////////////////////////////////////////////////
            pw.println("<body>");//INICIANDO CONTENIDO style=\"background-color: #3349FF ;\"
            pw.println("<body background=fiusac03.jpg>");
            pw . println ( " <hr align = left> " );

            pw.print("<h1><center><font face=Cooper Black  font color= #2874A6 > Asignacion de Profesores </aright></center></h1>");
            pw.println("<center> ACONTINUACION SE MUESTRAN LAS ASIGNACIONES DE LOS PROFESORES  </center>" );
            for (int i = 0; i < 10; i++) {

            }
            for (int i = 0; i < Asig_Pf.length; i++) {
                if (null!=Asig_Pf[i]) {
                    System.out.println("Línea: "+(i+1));
                    pw.println("<div style=\"text-align:center;\">");
                    pw.println("<table border=\"1\" style=\"margin: 0 auto;\">");


                    pw.println("<br>");
                    pw.println("La asignación del Id:"+ Asig_Pf[i].getIdProfesores()+" con el codigo de curso"+Asig_Pf[i].getIdCursos()+" corresponde a los siguientes datos:");
                    pw.println("<br>");

                    pw.println("<tr>");//F1
                    pw.println("<td>" + "El Profesor con el Registro Personal: " + "</td>");//C1
                    pw.println("<td>" + Asig_Pf[i].getIdProfesores().getrp_prof()+"</td>");//C2
                    pw.println("<tr>");

                    pw.println("<tr>");//F2
                    pw.println("<td>" + "Nombre del Profesor" + "</td>");//C1
                    pw.println("<td>" + Asig_Pf[i].getIdProfesores().getnombre()+"</td>");//C2
                    pw.println("<tr>");

                    pw.println("<tr>");//F3
                    pw.println("<td>" + "Asignado al curso" + "</td>");//C1
                    pw.println("<td>" + Asig_Pf[i].getIdCursos().getCod()+"</td>");//C2
                    pw.println("<tr>");

                    pw.println("<tr>");
                    //pw.println("<td>" + "La fecha de asignacion es" + dia.format(date) + "</td>");
                    pw.println("<tr>");

                }

            }
            pw.println("</body>");
            pw.println("</HTML>");


        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                // Nuevamente aprovechamos el finally para
                // asegurarnos que se cierra el fichero.
                if (null != fichero)
                    fichero.close();
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }
}
