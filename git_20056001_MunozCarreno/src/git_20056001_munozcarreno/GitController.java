/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package git_20056001_munozcarreno;

import java.util.ArrayList;

/**
 *
 * @author CLundstedt
 */
public class GitController {
    
    
    /**
     * 
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
    
    /**
     * 
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
        
        System.out.printf("ENTRO A GITCONTROLLER GIT AGREGAR ARCHIVOS..\n\n");
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
        System.out.printf("SE RETORNA LA NUEVA ZONA DEL METODO AGREGARARCHIVOS.\n");
        return rep;
    
    
    }
    
    /**
     * 
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
     * 
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
     * 
     * @param repositorio
     * @return String
     */
    public String gitStatusIndex(Repositorio repositorio){
        
        ZonasDeTrabajo Zonas = repositorio.getZonas();
        Index i = Zonas.getIndex();
        String archivosI = i.toStringInterfaz();

        return archivosI;
    
    
    }
    
    
    ////////////////////////////////////////////////////////////////////////////
    //________metodos auxiliares______________________________________________
    ////////////////////////////////////////////////////////////////////////////
    
    /**
     * 
     * @param Zonas
     * @param rep
     * @return String
     */
    //descripcion metodo: se obtiene la cantidad de archivos en workspace
    public String GetAmountFiles(ZonasDeTrabajo Zonas,Repositorio rep) {
        String A = "";
        Workspace workspace = Zonas.getWorkspace();
        ArrayList<ArchTextoPlano> archivos = workspace.getArchivos_Workspace();
        int amount = archivos.size();
        String numCadena = String.valueOf(amount);
        System.out.printf("el string es:"+numCadena+".\n\n");
        return numCadena;
    }
    
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
    
    public String gitFilesToTransfer(Repositorio repositorio){
        
        ZonasDeTrabajo Zonas = repositorio.getZonas();
        Workspace w = Zonas.getWorkspace();
        String archivosW = w.toStringInterfazNum();

        return archivosW;
    
    
    }
    
}
