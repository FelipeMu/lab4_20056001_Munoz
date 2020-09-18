/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package git_20056001_munozcarreno;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author CLundstedt
 */
public class GitController {
    
    
    /**
     * METODO QUE INICIALIZA EL REPOSITORIO
     * @param RepoName
     * @param AuthorName
     * @return Repositorio 
     * @throws RepositoryAuthorException
     * @throws InvalidDatasException 
     */
    public Repositorio gitInit (String RepoName, String AuthorName) throws RepositoryAuthorException, InvalidDatasException {
        if(RepoName.equalsIgnoreCase(AuthorName)){
            throw new RepositoryAuthorException();
        }
        
        if(AuthorName == null || AuthorName.isEmpty() || AuthorName.trim().isEmpty() || RepoName == null || RepoName.isEmpty() || RepoName.trim().isEmpty()){
            throw new InvalidDatasException();
        }
    
        //  AQUI SE INICIA EL REPOSITORIO DE FORMA NORMAL
        
        //Se crea el repositorio inicializandolo con los datos entregados por el usuario.
        Repositorio repositorio = new Repositorio(RepoName,AuthorName);
        return repositorio;
    }
    
    
    /////////////////////////////////////////////////////////////////////////////////////////////////////////////
    //________METODOS RELACIONADOS CON LOS COMANDOS(BOTONES): Nuevo Archivo, add, commit, push, pull ___________
    /////////////////////////////////////////////////////////////////////////////////////////////////////////////
    
    
    /**
     * METODO QUE TIENE COMO OBJETIVO AGREGAR ARCHIVOS A LA ZONA WORKSPACE (COMANDO NUEVO ARCHIVO)
     * @param NameFile
     * @param Content
     * @param Zonas
     * @param rep
     * @return Repositorio
     * @throws DatasCreateFileInvalidException 
     */
    public Repositorio gitAgregarArchivo (String NameFile, String Content, ZonasDeTrabajo Zonas, Repositorio rep) throws DatasCreateFileInvalidException{
        
        if(NameFile == null || NameFile.isEmpty() || NameFile.trim().isEmpty() || Content == null || Content.isEmpty() || Content.trim().isEmpty()){
            throw new DatasCreateFileInvalidException();
        }

        //EN CASO QUE LOS DATOS SEAN VALIDOS SE PROCEDE CON EL DESARROLLO
        //DEL PROGRAMA
        
        String FechaHora;
        
        
         // SE OBTIENE UN OBJETO DE TIPO WORKSPACE
        Workspace preWorkspace = Zonas.getWorkspace();
        //SE OBTIENE LA LISTA DE ARCHIVOS DEL OBJETO CREADO ANTERIORMENTE
        ArrayList<ArchTextoPlano> ArchivosDelWorkspace = preWorkspace.getArchivos_Workspace();

        //Se incorpora la fecha y hora de creación con la clase MetodosExtras
        FechaHora = Workspace.obtenerFecha();
        
  
        //SE CREA UN OBJETO DE TIPO ArchTextoPlano
        ArchTextoPlano Archivo= new ArchTextoPlano(NameFile,Content,FechaHora);
        // SE PROCEDE A AGREGAR EL NUEVO ARCHIVO A LA ZONA WORKSPACE
        ArchivosDelWorkspace.add(Archivo);
        
        
        //SE CREA UN NUEVO OBJETO DE TIPO ArrayList<ArchTextoPlano>
        ArrayList<ArchTextoPlano> Archivos_Actualizados = ArchTextoPlano.EliminarArchRep(ArchivosDelWorkspace);
       
        //SE ACTUALIZA LAS ZONA WORKSPACE
        Workspace NuevoWorkspace = new Workspace();
        NuevoWorkspace.setArchivos_Workspace(Archivos_Actualizados);
        
        //SE ACTUALIZA EL TDA DE ZonasDeTrabajo
        Zonas.setWorkspace(NuevoWorkspace);
        rep.setZonas(Zonas);
        return rep;
    }
    
    /**
     * METODO QUE AGREGA TODOS LOS ARCHIVOS ALMACENADOS EN WORKSPACE A LA ZONA INDEX
     * @param Zonas
     * @param rep
     * @return Repositorio
     */
    public Repositorio gitAddCaso1(ZonasDeTrabajo Zonas, Repositorio rep){
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
        
        
        //SE PASAN TODOS LOS ARCHIVOS DE WORKSPACE A INDEX
        ArrayList<ArchTextoPlano> NuevoIndex = ArchTextoPlano.UnirListasDeArchivos(ListaArchivos_W, ListaArchivos_I);
        //SE OBTIENE UN OBJETO TEMPORAL DE LAZONA INDEX
        Index IndexAuxiliar = Zonas.getIndex();
        //SE ACTUALIZA LA ZONA INDEX
        IndexAuxiliar.setArchivos_Index(NuevoIndex);
        //SE ACTUALIZA LA ZONA DE TRABAJO
        Zonas.setIndex(IndexAuxiliar); 
        rep.setZonas(Zonas);
        return rep;

    }   
    
   /**
    * METODO QUE AGREGA ARCHIVOS ESPECIFICOS DE LA ZONA WORKSPACE A LA ZONA INDEX
    * @param Zonas
    * @param rep
    * @param AmountFilesTT
    * @param NumberChoose
    * @return Repositorio
    * @throws FilesTransferedException
    * @throws NumberFileOutLimitException 
    */
    public Repositorio gitAddCaso2 (ZonasDeTrabajo Zonas,Repositorio rep, int AmountFilesTT,int NumberChoose) throws FilesTransferedException, NumberFileOutLimitException{
        //GENERO UN OBJETO DE TIPO ArchTextoPlano
        Workspace ZonaWorkspace = Zonas.getWorkspace();
        //DEFINO UN OBJETO DE TIPO Arraylist<ArchTextoPlano>
        ArrayList<ArchTextoPlano> LosArchivos = ZonaWorkspace.getArchivos_Workspace();
        
        ArrayList<ArchTextoPlano> ListaIndex;
        
        //SE CREA UN OBJETO TEMPORAL DE TIPO WORKSPACE
        Workspace WorkspaceTemp = Zonas.getWorkspace();
        //SE OBTIENE LA LISTA DE ARCHIVOS CONTENIDOS EN WOKSPACE
        ArrayList<ArchTextoPlano> ListaArchivos_W = WorkspaceTemp.getArchivos_Workspace();
        int cantidadArch=ListaArchivos_W.size();
        
        if(AmountFilesTT == 0){
            throw new FilesTransferedException();
        }
        
        if(NumberChoose < 0 || NumberChoose > cantidadArch){ 
            throw new NumberFileOutLimitException();
        }
        
        int indice = NumberChoose - 1;
        //AHORA SE DEBE TRANFERIR EL ARCHIVO EN LA POSICION INDICE AL INDEX
        //SE DEFINE UN OBJETO TIPO INDEX
        Index NIndex = Zonas.getIndex();
        //CREO UN OBJETO DE TIPO ArrayList<ArchTextoPlano>
        ListaIndex = NIndex.getArchivos_Index();

        //SE AGREGA EL ARCHIVO EN LA POSICIÓN indice de Workspace
        ListaIndex.add(LosArchivos.get(indice));
        //SE ACTUALIZA LA ZONA INDEX
        NIndex.setArchivos_Index(ListaIndex);

        //SE ACTUALIZA LA ZONA DE TRABAJO
        Zonas.setIndex(NIndex);
        // QUE TRANSFERIR DISMINUYA EN 1 SIGNIFICA QUE YA SE PASO UN
        //ARCHIVO DE WORKPSACE A INDEX
        
        rep.setZonas(Zonas);

        return rep;
    }
    
    
    /**
     * METODO QUE CREA UN COMMIT Y ACTUALIZA LOCAL REPOSITORY
     * @param Zonas
     * @param rep
     * @param Author
     * @param Message
     * @return Repositorio
     * @throws InvalidCommitException 
     */
    public Repositorio gitCommit(ZonasDeTrabajo Zonas, Repositorio rep,String Author, String Message) throws InvalidCommitException{
    
        if(Author == null || Author.isEmpty() || Author.trim().isEmpty() || Message == null || Message.isEmpty() || Message.trim().isEmpty()){
            throw new InvalidCommitException();
        }
        
        // se procede con la ejecucion del comando
        
        String FechaCommit;
        FechaCommit = Commit.obtenerFecha();
        //SE PROCEDE A OBTENER UN OBJETO DE TIPO Index
        Index index = Zonas.getIndex();
        //SE OBTIENE LA LISTA DE ARCHIVOS
        ArrayList<ArchTextoPlano> ArchivosIndex = index.getArchivos_Index();
        
        //SE PROCEDE A CREAR UN OBJETO DE TIPO Commit
        Commit commit = new Commit(Author,FechaCommit,Message,ArchivosIndex);

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
        
        rep.setZonas(Zonas);
        return rep;
    }
    
    /**
     * METODO QUE PASA TODOS LOS COMMIT DE LOCAL A REMOTE REPOSITORY
     * @param Zonas
     * @param rep
     * @return Repositorio
     */
    public Repositorio gitPush(ZonasDeTrabajo Zonas, Repositorio rep){
    
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
        rep.setZonas(Zonas);
        return rep;
    
    }
    
    /**
     * METODO QUE TRAE TODOS LOS ARCHIVOS DE CADA COMMIT A LA ZONA WORKSPACE Y CADA COMMIT A LA ZONA LOCAL REPOSITORY
     * @param Zonas
     * @param rep
     * @return Repositorio
     */
    public Repositorio gitPull(ZonasDeTrabajo Zonas,Repositorio rep){
        
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
        rep.setZonas(Zonas);
        return rep;
    }
    
    
    public String gitLog(ZonasDeTrabajo Zonas){
        //ZonasDeTrabajo Zonas = repositorio.getZonas();
        LocalRepository l = Zonas.getLocalRepository();
        String commitsLocal = l.toStringInterfaz5c(Zonas);
        return commitsLocal;
    
    }
    
    ////////////////////////////////////////////////////////////////////////////
    //________METODOS RELACIONADOS CON LOS STATUS DE CADA ZONA__________________
    ////////////////////////////////////////////////////////////////////////////
    
    
     /**
     * METODO QUE TIENE COMO OBJETIVO RETORNAR UNA CADENA QUE CONTIENE TODOS LOS ARCHIVOS DE WORKSPACE
     * @param repositorio
     * @return String
     */
    public String gitStatusWorkspace(Repositorio repositorio){
        
        ZonasDeTrabajo Zonas = repositorio.getZonas();
        Workspace w = Zonas.getWorkspace();
        String archivosW = w.toStringInterfaz();

        return archivosW;
    }
    
    /**
     * METODO QUE RETORNA UNA CADENA DE STRING CON TODOS LOS ARCHIVOS CONTENIDOS EN INDEX
     * @param repositorio
     * @return String
     */
    public String gitStatusIndex(Repositorio repositorio){
        
        ZonasDeTrabajo Zonas = repositorio.getZonas();
        Index i = Zonas.getIndex();
        String archivosI = i.toStringInterfaz();

        return archivosI;
    }
    
    /**
     * METODO QUE RETORNA UNA CADENA DE STRING CON CADA COMMIT DE LOCAL, MOSTRANDO MENSAJE Y ARCHIVOS VINCULADOS
     * @param repositorio
     * @param Zonas
     * @return String 
     */
    public String gitStatusLocal(Repositorio repositorio, ZonasDeTrabajo Zonas){
        //ZonasDeTrabajo Zonas = repositorio.getZonas();
        LocalRepository l = Zonas.getLocalRepository();
        String commitsLocal = l.toStringInterfaz(Zonas);
        return commitsLocal;
    }
    
    /**
     * METODO QUE RETORNA UNA CADENA DE STRING CON CADA COMMIT DE REMOTE, MOSTRANDO MENSAJE Y ARCHIVOS VINCULADOS
     * @param repositorio
     * @param Zonas
     * @return String 
     */
    public String gitStatusRemote(Repositorio repositorio, ZonasDeTrabajo Zonas){
        //ZonasDeTrabajo Zonas = repositorio.getZonas();
        RemoteRepository r = Zonas.getRemoteRepository();
        String commitsRemote = r.toStringInterfaz(Zonas);
        return commitsRemote;
    }
    
    
    ////////////////////////////////////////////////////////////////////////////
    //____METODOS RELACIONADOS RELACIONEADOS CON LA VALIDACION DE UN COMANDO____
    ////////////////////////////////////////////////////////////////////////////
    
    /**
     * METODO CUYO ES OBJETIVO ES VERIFICAR SI EL COMANDO EJECUTADO ES CORRECTO
     * @param ListaComandos
     * @param comando
     * @return boolean
     * @throws ComandException 
     */
    public boolean gitComandosExternos(ArrayList<String> ListaComandos,String comando) throws ComandException{
        if(!gitComandos(ListaComandos,comando)){
            throw new ComandException();
        
        }
        return true;
    }
    
    
    
    /**
     * METODO QUE DEPENDIENDO DEL COMANDO EJECUTADO, VERIFICA SI ES POSIBLE HACER DICHO COMANDO
     * @param ListaComandos
     * @param comando
     * @return 
     */
    public boolean gitComandos(ArrayList<String> ListaComandos,String comando){
        
        boolean ejecutar = true;
        //SE PROCEDE A VERIFICAR QUE EL COMANDO "comando" SELECCIONADO SEA VALIDO
        
        //COMANDO Add _____________________
        
        //STRING QUE ALMACENARA EL ULTIMO COMANDO EJECUTADO
        String C;
        
        //ENTERO QUE ALMACENA EL TAMANO DE LA LISTA ListaComandos
        int largo;
        //CASO BORDE
        if(ListaComandos.isEmpty() && comando.equals("CargarArchivosWorkspace->")){
            
            ejecutar = true;
        }
        
        else{
        
            if(ListaComandos.isEmpty()){
                ejecutar = false;
            }
            
            else{
                largo = ListaComandos.size();

                //SE OBTIENE EL COMANDO (String)
                C = ListaComandos.get(largo-1);

                switch(comando){

                    //COMANDO ADD
                    case "CargarArchivosWorkspace->":
                        if(ListaComandos.isEmpty() || C.equals("CargarArchivosWorkspace->") || C.equals("Add->") || C.equals("Commit->") || C.equals("Pull->") ){
                            ejecutar = true;

                        }
                        else{
                            ejecutar = false;
                        }

                        break;

                    //COMANDO ADD    
                    case "Add->":
                        if(  C.equals("CargarArchivosWorkspace->") || C.equals("Add->") || C.equals("Commit->") || C.equals("Pull->")  ){
                        ejecutar = true;

                        }
                        else{
                            ejecutar = false;
                        }
                        break;

                    //COMANDO COMMIT
                    case "Commit->":
                        if( C.equals("Add->") ){
                        ejecutar = true;

                        }
                        else{
                            ejecutar = false;
                        }
                        break;

                    //COMANDO PUSH
                    case "Push->":
                        if( C.equals("Commit->") ){   
                        ejecutar = true;

                        }
                        else{
                            ejecutar = false;
                        }
                        break;

                    //COMANDO PULL
                    case "Pull->":
                        if( C.equals("Push->") ){
                        ejecutar = true;

                        }
                        else{
                            ejecutar = false;
                        }
                        break;
                }
            }   
        }
        return ejecutar;
    }
    
    
    
    
    
    ////////////////////////////////////////////////////////////////////////////////////////////
    //___________METODOS AUXILIARES QUE AYUDAN A LOS METODOS PRINCIPALES (comandos)____________
    ///////////////////////////////////////////////////////////////////////////////////////////
    
    /**
     * SE OBTIENE UN STRING CON TODOS LOS ARCHIVOS DE WORKSPACE
     * @param Zonas
     * @param rep
     * @return String
     */
    public String GetAmountFiles(ZonasDeTrabajo Zonas,Repositorio rep) {
        String A = "";
        Workspace workspace = Zonas.getWorkspace();
        ArrayList<ArchTextoPlano> archivos = workspace.getArchivos_Workspace();
        int amount = archivos.size();
        String numCadena = String.valueOf(amount);
        System.out.printf("el string es:"+numCadena+".\n\n");
        return numCadena;
    }
    
    /**
     * METODO QUE REVISA QUE LA CANTIDAD DE ARCHIVOS A ONGRESAR A INDEX SEA MENOR QUE LA CANTIDAD DE ARCHIVOS EN WORKSPACE
     * @param Zonas
     * @param rep
     * @param AmountFiles
     * @return Repositorio
     * @throws AmountFilesException
     * @throws AmountFilesNotIntException 
     */
    //descripcion: metodo que revisa que la cantidad de archivos a ingresar al index sea menor que la cant de archivos en workspace
    public Repositorio VerifAmountFiles(ZonasDeTrabajo Zonas,Repositorio rep,int AmountFiles) throws AmountFilesException, AmountFilesNotIntException{
        //se procede a obtener la cantidad de archivos de workspace
        //SE CREA UN OBJETO TEMPORAL DE TIPO WORKSPACE
        Workspace WorkspaceTemp = Zonas.getWorkspace();
        //SE OBTIENE LA LISTA DE ARCHIVOS CONTENIDOS EN WOKSPACE
        ArrayList<ArchTextoPlano> ListaArchivos_W = WorkspaceTemp.getArchivos_Workspace();
        // ATRIBUTO PARA LA CANTIDAD DE ARCHIVOS ALMACENADOS EN WORKSPCE
        int cantidadArch;
        //LA CANTIDAD DE ARCHIVOS EN EL WORKSPACE
        cantidadArch=ListaArchivos_W.size();
        
        //SE REVISA QUE CANTIDAD INGRESADA SEA VALIDA
        if(AmountFiles > cantidadArch || AmountFiles < 1){
            throw new AmountFilesException();
        }
        
        if(AmountFiles != (int)AmountFiles){
            throw new AmountFilesNotIntException();
        } 
        return rep;       
    }
    
    /**
     * METODO RETORNA UN STRING CON TODOS LOS ARCHIVOS DE WORKSPACE ENUMERADOS, EJEMPLO, 1)ARCHIVO.TXT, 2)ARCHIVO2.RKT, ETC.
     * @param repositorio
     * @return String
     */
    //descripcion: entrega como string los archivos enumerados de workspace
    public String gitFilesToTransfer(Repositorio repositorio){
        
        ZonasDeTrabajo Zonas = repositorio.getZonas();
        Workspace w = Zonas.getWorkspace();
        String archivosW = w.toStringInterfazNum();

        return archivosW;
    }
    
    /**
     * METODO QUE ELIMINA LOS ARCHIVOS REPETIDOS EN INDEX AL MOMENTO QUE SE EJECUTA UN ADD
     * @param Zonas
     * @param rep
     * @param AmountFiles
     * @return Repositorio
     * @throws AmountFilesStillPositiveException 
     */
    public Repositorio DeleteFilesRep(ZonasDeTrabajo Zonas,Repositorio rep,int AmountFiles) throws AmountFilesStillPositiveException{
        if(AmountFiles > 0){
         throw new AmountFilesStillPositiveException();
        }

        //se obtiene la lista de archivos de index
        Index index = Zonas.getIndex();
        ArrayList<ArchTextoPlano> N_INDEX = index.getArchivos_Index();
        ArrayList<ArchTextoPlano> N_INDEX2 = Index.EliminarArchRep(N_INDEX);
        Index IndexTemporal = Zonas.getIndex();

        IndexTemporal.setArchivos_Index(N_INDEX2);
        Zonas.setIndex(IndexTemporal);
        rep.setZonas(Zonas);
        return rep;
    
    }
    
   
}
