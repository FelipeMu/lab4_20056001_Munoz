
package Modelo;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

/*
descripcion clase: Esta clase es el constructor principal del TDA, inicializa
todas las zonas de trabajo (workspace, index, local y remote repository).


atributos:


workspace (objeto de tipo Workspace)
index (objeto de tipo Index)
localRepository (objeto de tipo LocalRepository)
remoteRepository (objeto de tipo RemoteRepository)

metodos incorporados:

- toString
- AgregarArchivo();
- gitAdd();
- gitCommit();
- gitPush();
- gitPull();
- gitStatus();
- gitLog();




*/



public class ZonasDeTrabajo {
    //se definen los atributos de la clase y los objetos (zonas de trabajo)

    
    private Workspace workspace;
    private Index index;
    private LocalRepository localRepository;
    private RemoteRepository remoteRepository;
    
   /**
    * CONSTRUCTOR
    */
    public ZonasDeTrabajo() {

        this.workspace = new Workspace();
        this.index = new Index();
        this.localRepository = new LocalRepository();
        this.remoteRepository = new RemoteRepository();
    }
    
    
    //METODOS
    
    /**
     * SELECTOR DE FECHA Y HORA
     * @return String
     */
     //descripcon metodo: El metodo tiene como objetivo retornar la fecha y hora actual.
    public static String obtenerFecha(){
        LocalDateTime Fecha = LocalDateTime.now();
        DateTimeFormatter SET = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        String formattedDate = Fecha.format(SET);
        return formattedDate;
    }
    
    ////////////////////////////////////////////////////////////////////////////////////////
    
     /**
     * MODIFICADOR
     * @param Zonas
     * @return ZonasDeTrabajo
     */
    // descripcion metodo: El objetivo de este metodo es agregar los archivos ingresados por el
    // usuario a la zona workspace
    public ZonasDeTrabajo AgregarArchivo(ZonasDeTrabajo Zonas){
        //atributos u objetos definidos
        String nombreArchivo;
        String Contenido;
        String FechaHora;
        //se crear un objeto de tipo Scanner
        Scanner S = new Scanner(System.in);
        //SE INGRESA EL NOMBRE DEL ARCHIVO
        
         // SE OBTIENE UN OBJETO DE TIPO WORKSPACE
        Workspace preWorkspace = Zonas.getWorkspace();
        //SE OBTIENE LA LISTA DE ARCHIVOS DEL OBJETO CREADO ANTERIORMENTE
        ArrayList<ArchTextoPlano> ArchivosDelWorkspace = preWorkspace.getArchivos_Workspace();
        
        
        System.out.printf("Ingrese el nombre del archivo: ");
        nombreArchivo = S.nextLine();
        System.out.printf("Ingrese el contenido del archivo: ");
        Contenido = S.nextLine();
        //Se incorpora la fecha y hora de creación con la clase MetodosExtras
        FechaHora = Workspace.obtenerFecha();
        
  
        //SE CREA UN OBJETO DE TIPO ArchTextoPlano
        ArchTextoPlano Archivo= new ArchTextoPlano(nombreArchivo,Contenido,FechaHora);
        // SE PROCEDE A AGREGAR EL NUEVO ARCHIVO A LA ZONA WORKSPACE
        ArchivosDelWorkspace.add(Archivo);
        
        
        //SE CREA UN NUEVO OBJETO DE TIPO ArrayList<ArchTextoPlano>
        ArrayList<ArchTextoPlano> Archivos_Actualizados = ArchTextoPlano.EliminarArchRep(ArchivosDelWorkspace);
       
        
        
        //SE ACTUALIZA LAS ZONA WORKSPACE
        Workspace NuevoWorkspace = new Workspace();
        NuevoWorkspace.setArchivos_Workspace(Archivos_Actualizados);
        
        //SE ACTUALIZA EL TDA DE ZonasDeTrabajo
        Zonas.setWorkspace(NuevoWorkspace);
        return Zonas;
    
    }
    
    /**
     * MODIFICADOR
     * @param Zonas
     * @return ZonasDeTrabajo
     */
    // descripcion metodo: El obejtivo de este metodo es pasar la cantidad total de archivos almacenados en
    // workspace o archivos especificos a la zona index.
    public ZonasDeTrabajo gitAdd(ZonasDeTrabajo Zonas){
        Scanner S = new Scanner(System.in);
        int op=0;
        do{
            System.out.println("**cantidad de archivos a ingresar**\n");
            System.out.println("(1) Todos los archivos.");
            System.out.println("(2) Archivos especificos.");
            System.out.printf("opcion:  ");
          
            
            try{
               
               op = S.nextInt();
               if(op < 1 || op > 2){
                   System.out.println(" ! Error, introduzca una opcion valida.\n");
                }
           } catch(InputMismatchException e){
               System.out.println("! Error, introduzca una opcion valida.\n");
               S.next();
            
           }
        }while(op < 1 || op > 2);
        
        //SE CREA UN OBJETO TEMPORAL DE TIPO WORKSPACE
        Workspace WorkspaceTemp = Zonas.getWorkspace();
        //SE OBTIENE LA LISTA DE ARCHIVOS CONTENIDOS EN WOKSPACE
        ArrayList<ArchTextoPlano> ListaArchivos_W = WorkspaceTemp.getArchivos_Workspace();
         
        //SE CREA UN OBJETO TEMPORAL DE TIPO INDEX
        Index IndexTemp = Zonas.getIndex();
        //SE OBTIENE LA LISTA DE ARCHIVOS CONTENIDOS EN INDEX
        ArrayList<ArchTextoPlano> ListaArchivos_I = IndexTemp.getArchivos_Index();

        // ATRIBUTO PARA LA CANTIDAD DE ARCHIVOS ALMACENADOS EN WORKSPCE
        int cantidadArch;

        //SE PROCEDE A TOMAR LA DECISIÓN ENTRE LAS DOS OPCIONES
        switch(op){
            //CASO EN QUE SE DESEA INGRESAR TODOS LOS ARCHIVOS
            case 1:
                //SE PASAN TODOS LOS ARCHIVOS DE WORKSPACE A INDEX
                ArrayList<ArchTextoPlano> NuevoIndex = ArchTextoPlano.UnirListasDeArchivos(ListaArchivos_W, ListaArchivos_I);
                
                //SE BORRAN LOS ARCHIVOS REPETIDOS
                ArrayList<ArchTextoPlano> NuevoIndex2 = Index.EliminarArchRep(NuevoIndex);
                //SE OBTIENE UN OBJETO TEMPORAL DE LAZONA INDEX
                Index IndexAuxiliar = Zonas.getIndex();
                //SE ACTUALIZA LA ZONA INDEX
                IndexAuxiliar.setArchivos_Index(NuevoIndex2);
                //SE ACTUALIZA LA ZONA DE TRABAJO
                Zonas.setIndex(IndexAuxiliar);         
                 break;
                 
             //CASO EN QUE SE DESEA PASAR ARCHIVOS ESPECIFICOS   
             case 2:
                 //SE DEBE MOSTRAR LOS NOMBRES DE LOS ARCHIVOS DISPONIBLES Y
                 //LA CANTIDAD DE ARCHIVOS EN EL WORKSPACE
                 cantidadArch=ListaArchivos_W.size();
                 //ATRIBUTO PARA LA CANTIDAD DE ARCHIVOS QUE DESEA EL USUARIO TRNAFERIR
                 int transferir=0;
                 
                do{ 
                    System.out.printf("(#) Existen %d archivos disponibles en Workspace\n",cantidadArch);
                    System.out.println("¿Cuantos archivos desea transferir?");
                    
                 
                    try{
               
                        transferir = S.nextInt();
                        if(transferir > cantidadArch || transferir < 1){
                            System.out.println(" ! Error, no existe tal cantidad de archivos en Workspace.\n");
                        }
                     } catch(InputMismatchException e){
                         System.out.println("! Error, introduzca una opcion valida.\n");
                         S.next();
              
                       }
                }while(transferir > cantidadArch || transferir < 1);
                
                //EN ESTE MOMENTO EN NÚMERO DE ARCHIVOS INGRESADOS POR EL 
                //USUARIO ES MENOR IGUAL A LA CANTIDAD QUE EXISTE EN LA ZONA
                //WORKSPACE, LUEGO SE PROCEDE A TRANSFERIRLOS.
                ArrayList<ArchTextoPlano> N_INDEX = ArchTextoPlano.UnirArchivosEspecificos(Zonas,transferir,cantidadArch);
                ArrayList<ArchTextoPlano> N_INDEX2 = Index.EliminarArchRep(N_INDEX);
                Index IndexTemporal = Zonas.getIndex();
                
                IndexTemporal.setArchivos_Index(N_INDEX2);
                Zonas.setIndex(IndexTemporal);
                break;
        }
        return Zonas;        
    }
    
    /**
     * MODIFICADOR
     * @param Zonas
     * @return ZonasDeTrabajo
     */
    // descripcion metodo: El metodo tiene como objetivo generar un commit con los archivos
    // almacenados en la zona index y transferirlos a la zona local repository, dejando la zona index
    // vacia nuevamente.
    public ZonasDeTrabajo gitCommit(ZonasDeTrabajo Zonas){
        Scanner S = new Scanner(System.in);
        //SE PROCEDE A OBTENER EL NOMBRE DEL AUTOR DEL REPOSITORIO
        String Autor;
        //SE INGRESA EL AUTOR DEL COMMIT
        System.out.printf("Ingrese nombre del autor: ");
        Autor = S.nextLine();
        
        //SE OBTIENE LA FECHA DE CREACIÓN DEL COMMIT
        String FechaCommit;
        FechaCommit = Commit.obtenerFecha();
        //SE CREA UN ATRIBUTO PARA GUARDAR EL MENSAJE
        String Mensaje;
        //SE LE INDICA AL USUARIO QUE INGRESE UN MENSAJE PARA EL COMMIT
        System.out.printf("Ingrese un mensaje descriptivo: ");
        Mensaje = S.nextLine();
        
        //SE PROCEDE A OBTENER UN OBJETO DE TIPO Index
        Index index = Zonas.getIndex();
        //SE OBTIENE LA LISTA DE ARCHIVOS
        ArrayList<ArchTextoPlano> ArchivosIndex = index.getArchivos_Index();
        

        //SE PROCEDE A CREAR UN OBJETO DE TIPO Commit
        Commit commit = new Commit(Autor,FechaCommit,Mensaje,ArchivosIndex);

        
        
        //SE OBTIENE UN OBJETO TIPO LocalRepository
        LocalRepository localRep = Zonas.getLocalRepository();
        
        //SE OBTIENE LA LISTA DE COMMIT DEL OBJETO localRep
        ArrayList<Commit> ListaCommits = localRep.getCommitsEnLocal();
        
        
        //SE AGREGA EL NUEVO COMMIT
        ListaCommits.add(commit);

        
        //AHORA SE PROCEDE A CREAR UN NUEVO OBJETO DE TIPO INDEX Y AGREGARLO A 
        Index nuevo_index = new Index();
        //SE ACTUALIZA LA ZONA localRep
        localRep.setCommitsEnLocal(ListaCommits); 
        
         //SE ACTUALIZA LA ZONA DE TRABAJO
        Zonas.setLocalRepository(localRep);
        
        
        //SE OBTIENE EL OBJETO LocalRepositorty
        LocalRepository L = Zonas.getLocalRepository();
        //SE CREA UN OBJETO DE TIPO ArrayList<Commit>
        ArrayList<Commit> commitsARevisar = L.getCommitsEnLocal();
        
         
        //SE CREA UN OBJETO DE TIPO ArrayList<Commit>
        ArrayList<Commit> nuevaListaC = new ArrayList<>();
        //EN nuevaLista SE ALMACENA LA LISTA DE COMMITS PERTENECIENTE A LA
        //ZONA LOCAL REPOSITORY (CON COMMMITS UNICOS)
        nuevaListaC = Commit.BorrarCommitRep(commitsARevisar);
        
        //SE CREA UN NUEVO OBJETO DE TIPO LocalRepository
        LocalRepository LocalDef = new LocalRepository();
        //SE ACTUALIZA LA LISTA DE COMMITS DEL OBJETO ANTERIOR
        LocalDef.setCommitsEnLocal(nuevaListaC);
        
        //SE ACTUALIZA LA ZONA DE TRABAJO CON RESPECTO A LA ZONA INDEX
        Zonas.setIndex(nuevo_index);
        //SE ACTUALIZA LA ZONA DE TRABAJO CON RESPECTO A LA ZONA LOCAL
        //REPOSITORY
        Zonas.setLocalRepository(LocalDef);
       
        return Zonas;
    }
    
    /**
     * MODIFICADOR
     * @param Zonas
     * @return ZonasDeTrabajo
     */
    // descripcion metodo: El metodo tiene como objetivo copiar todos los commit almacenados en local
    // repository y pasarlos a la zona remote repository, al mismo tiempo se eliminan los commits duplicados.
    public ZonasDeTrabajo gitPush(ZonasDeTrabajo Zonas){
  
        //SE PROCEDE A OBTENER EL OBJETO DE TIPO localRepository 
        LocalRepository local = Zonas.getLocalRepository();
        //SE OBTIENE LOS COMMIT DEL OBJETO local
        ArrayList<Commit> commitDeLocal = local.getCommitsEnLocal();
         
        //SE OBTIENE EL OBJETO UN OBJETO RemoteRepository
        RemoteRepository remote = Zonas.getRemoteRepository();
        
        //SE CDEFINE UN OBJETO DE TIPO ArrayList<Commits>
        ArrayList<Commit> commitDeRemote = remote.getCommitsEnRemote();
        
        //SE CREA UN OBJETO DE TIPO ArrayList<Commit>
        ArrayList<Commit> NuevoConjuntoCommits = new ArrayList<>();
        
        //SE PROCEDE A UNIR LOS COMMITS DE LOCAL REPOSITORY Y LOCAL REPOSITORY
        NuevoConjuntoCommits = Commit.UnirConjuntoDeCommits(commitDeLocal, commitDeRemote);
        //SE CREA UN OBJETO DE TIPO ArrayList<Commit>
        ArrayList<Commit> NuevoConjuntoCommits2 = new ArrayList<>();
        //SE PROCEDE A ELIMINAR LOS REPETIDOS
        NuevoConjuntoCommits2 = Commit.BorrarCommitRep(NuevoConjuntoCommits);

        
        // SE CREA UN NUEVO OBJETO DE TIPO RemoteRepository
        RemoteRepository remoteFinal = new RemoteRepository();
        //SE ACTUALIZA LA ZONA remtoeFinal
        remoteFinal.setCommitsEnRemote(NuevoConjuntoCommits2);
        ///SE ACTUALIZA LA ZONA DE TRABAJO
        Zonas.setRemoteRepository(remoteFinal);
       
        return Zonas;
    }
    
    /**
     * MODIFICADOR
     * @param Zonas
     * @return ZonasDeTrabajo
     */
    // descripcion metodo: El metodo tiene como finalidad traer las lista de commit
    // de remote repository a local repository, al mismo tiempo se deben llevar todos los archivos
    // almacenados en cada commit a la zona workspace.
    public ZonasDeTrabajo gitPull(ZonasDeTrabajo Zonas){
        //SE PROCEDE A CREAR UN OBJETO DE TIPO ArrayList<ArchTextoPlano> PARA
        //GUARDAR TODOS LOS ARCHIVOS QUE EXISTEN EN REMOTE REPOSITORY
        ArrayList<ArchTextoPlano> TodosLosArchivosR= new ArrayList<>();
        
        //SE OBTIENE UN  OBJETO DE TIPO RemoteRepsitory
        RemoteRepository remote = Zonas.getRemoteRepository();
        //SE OBTIENE LA LISTA DE COMMIT DEL OBJETO remote (instruccion anterior)
        ArrayList<Commit> CommitsRemote = remote.getCommitsEnRemote();
        
        //SE OBTIENE UNA LISTA CON TODOS LOS ARCHIVOS DE REMOTE REPOSITORY
        TodosLosArchivosR = RemoteRepository.ObtenerArchivosDeRemote(CommitsRemote);
        
        //SE PROCEDE A ELIMINAR LOS REPETIDOS
        
        //SE CREA UN NUEVO ONEJTO TIPO ArrayList<ArchTextoPlano>
        ArrayList<ArchTextoPlano> NuevosArchivosUnicos = new ArrayList<>();
        
        //SE OBTIENE UNA LISTA DE ARCHIVOS SIN REPETICIONES
        NuevosArchivosUnicos = ArchTextoPlano.EliminarArchRep(TodosLosArchivosR);
        
        //SE ACTUALIZA LA ZONA WORKSPACE
        Workspace workspace = Zonas.getWorkspace();
        //SE ACTUALIZA LA ZONA WORKSPACE
        workspace.setArchivos_Workspace(NuevosArchivosUnicos);
        
        //SE ACTUALIZA LA ZONA DE TRABAJO
        Zonas.setWorkspace(workspace);

        return Zonas;

    }
    
    /**
     * 
     * @param Zonas 
     */
    // descripcion metodo: El metodo tiene como finalidad mostrar cierta informacion
    // del repositorio, como el nombre del repositorio, el autor del repositorio, la 
    // cantidad de archivos almacenados en workspace e index, la cantidad de commit ubicados
    // en la zona local repository y informar si la zona remote repository cuenta con los ultimos
    // cambios generados por el usuario.
    public void gitStatus(Repositorio repositorio,ZonasDeTrabajo Zonas){
        
        //SE PROCEDE A MOSTRAR EL NOMBRE DEL REPOSITORIO Y SU AUTOR
        System.out.println("###REPOSITORIO ACTUAL###\n");
        
        //SE MUESTRA EL NOMBRE DEL REPOSITOIO
        System.out.printf("Nombre repositorio: %s \n",repositorio.getNombre_repositorio());
        //SE MUESTRA EL AUTOR DEL REPOSITORIO
        System.out.printf("Nombre autor: %s \n",repositorio.getAutor());
        
        //AHORA DE DEBE OBTENER LA CANTIDAD DE ARCHIVOS QUE POSEE WORKSPACE E
        //INDEX Y LA CANTIDAD DE COMMIT EN LOCAL REPOSITORY
        
        //SE CREAN LAS 3 VARIBLES PARA ACUMULAR LAS RESPECTIVAS CANTIDADES
        int cantArch_W;
        int cantArch_I;
        int cantCommits_Local;
        
        //SE OBTIENE EL OBJETO TIPO WORKSPACE
        Workspace workspace = Zonas.getWorkspace();
        ArrayList<ArchTextoPlano> cantidadAW = workspace.getArchivos_Workspace();
        //SE GUARDA LA CANTIDAD DE ARCHIVOS DE WORKSPACE
        cantArch_W = cantidadAW.size();
        
        
        //SE OBTIENE EL OBJETO TIPO INDEX
        Index index = Zonas.getIndex();
        ArrayList<ArchTextoPlano> cantidadAI = index.getArchivos_Index();
        //SE GUARDA LA CANTIDAD DE ARCHIVOS DE WORKSPACE
        cantArch_I = cantidadAI.size();
        
        //SE OBTIENE UN OBJETO DE TIPO LOCAL REPOSITORY
        LocalRepository localRep = Zonas.getLocalRepository();
        ArrayList<Commit> commitsL = localRep.getCommitsEnLocal();
        //SE OBTIENE LA CANTIDAD DE COMMIT QUE POSEE LOCAL REPOSITORY
        cantCommits_Local = commitsL.size();
        
        //SE MUESTRA LA CANTIDAD DE ARCHIVOS QUE POSEE WORKAPCE
        System.out.printf("Cantidad archivos en Workspace: %d \n",cantArch_W);
        //SE MUESTRA LA CANTIDAD DE ARCHIVOS QUE POSEE INDEX
        System.out.printf("Cantidad archivos en Index: %d \n",cantArch_I);
        //SE MUESTRA LA CANTIDAD DE COMMITS EN LOCAL REPOSITORY
        System.out.printf("Cantidad de commits en Local repostiroy: %d \n",cantCommits_Local);
        
        //AHORA SE DEBEN IGUALAR LA CANTIDAD DE COMMMIT DE LOCAL REPOSITORY
        //Y REMOTE REPOSITORY PARA VER SI ESTAN ACTUALIZADOS
        
        //LA CANTIDAD DE LOS COMMIT DE LOCAL YA SE OBTUVIERON ANTES *********
        
        
        int cantCommits_Remote;
        //SE PROCEDE A OBTENER LA CANTIDAD DE COMMIT DE REMOTE REPOSITORY
        RemoteRepository remoteRep = Zonas.getRemoteRepository();
        ArrayList<Commit> commitsR = remoteRep.getCommitsEnRemote();
        cantCommits_Remote = commitsR.size();
        
        //SE PROCEDE A IGUALARLOS
        //IGUALES => REMOTE ACTUALIZADO
        //DISTINTOS => REMOTE NO ACTUALIZADO
        
        String si = "actualizado";
        String no = "no actualizado";
        
        if(cantCommits_Local == cantCommits_Remote){
            System.out.printf("Estado de Remote repository: %s \n\n",si);
        }
        else{
            System.out.printf("Estado de Remote repository: %s \n\n",no);
        
        }
        System.out.printf("####FIN REPOSITORIO#####\n\n",no);
 
    }
    
    
    /**
     * 
     * @param Zonas 
     */
     // descripcion metodo: El objetivo de este metodo es mostrar los ultimos 5 commits
     // alamcenados en la zona local repository, si existen menos se muestra dichos commits.
    public void gitLog(ZonasDeTrabajo Zonas){
        //SE DEBEN MOSTRAR TODOS LOS COMMITS (MAX 5 COMMITS)

 
        //SE CREA VARIABLE PARA ALMACENAR LA CANTIDAD DE COMMIT ALMACENADOS
        int cantCommits;
        //VARIABLE PARA EL NUMERO MAXIMO DE COMMITS
        int max = 5;
        
        //SE PROCEDE A OBTENER EL OBJETO TIPO LocalRepository
        LocalRepository L = Zonas.getLocalRepository();
        //SE OBTIENE LA LISTA DE COMMITS
        //SE CREA OBJETO PARA ALMACENAR LA LISTA DE COMMITS
        ArrayList<Commit> commits = L.getCommitsEnLocal();
       
        
        //LUEGO LA CANTIDAD DE COMMITS SE OBTIENE DE LA SIGUIENTE MANERA:
        cantCommits = commits.size();
 
        //ITERADOR
        int i=1;
        int j;
        
        String fecha;
        String mensaje;
        String nombre_archivos;
        
        //SE DEFINE OBJETO DE TIPO Commits
        Commit C;
        
        //SE DEFINE OBJETO DE TIPO ArrayList<ArchTextolano>
        ArrayList<ArchTextoPlano> listaArchivos =  new ArrayList<>();
        
        //SE DEFINE OBJETO TIPO ArchTextoPlano
        ArchTextoPlano archivo;
        
        System.out.println("###ULTIMOS 5 COMMITS EN LOCAL REPOSITORY###\n");
        while(cantCommits>0 && max>0){
            
            //SE OBTIENE EL COMMIT EN LA POSICIÓN i
            C = commits.get(cantCommits-1);
            
            System.out.printf("Commit %d:\n",i);
            System.out.printf("-------------\n");
            System.out.printf("Fecha: %s\n",C.getTiempo());
            System.out.printf("Mensaje Descriptivo: %s\n",C.getMensaje());
            listaArchivos = C.getArchivosCommit();
            System.out.printf("Archivos:\n ");
            for(j=0;j<listaArchivos.size();j++){
                archivo = listaArchivos.get(j);
                System.out.printf("\t%s\n",archivo.getNombre());
            }
            System.out.println();
            i+=1;
            max-=1;
            cantCommits-=1;
        }
        System.out.println("###########################################\n\n");
    }
    
    
    
    
    ////////////////////////////////////////////////////////////////////////////////////////
    
    
    //GETTERS Y SETTERS



    
    /**
     * SELECTOR
     * @return ArrayList
     */
    public Workspace getWorkspace() {
        return workspace;
    }

    /**
     * MODIFICADOR  
     * @param workspace 
     */
    public void setWorkspace(Workspace workspace) {
        this.workspace = workspace;
    }

    /**
     * SELECTOR
     * @return ArrayList
     */
    public Index getIndex() {
        return index;
    }

    /**
     * MODIFICADOR
     * @param index 
     */
    public void setIndex(Index index) {
        this.index = index;
    }

    /**
     * SELECTOR
     * @return ArrayList
     */
    public LocalRepository getLocalRepository() {
        return localRepository;
    }

    /**
     * MODIFICADOR
     * @param localRepository 
     */
    public void setLocalRepository(LocalRepository localRepository) {
        this.localRepository = localRepository;
    }

    /**
     * SELECTOR
     * @return ArrayList
     */
    public RemoteRepository getRemoteRepository() {
        return remoteRepository;
    }

    /**
     * MODIFICADOR
     * @param remoteRepository 
     */
    public void setRemoteRepository(RemoteRepository remoteRepository) {
        this.remoteRepository = remoteRepository;
    }

    @Override
    public String toString() {
        return "ZonasDeTrabajo[" + ",\n workspace" + workspace + ",\n index" + index + ",\n localRepository" + localRepository + ",\n remoteRepository" + remoteRepository + ']';
    }
}
