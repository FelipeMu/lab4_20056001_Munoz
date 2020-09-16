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
    
    
    public String gitStatusWorkspace(Repositorio repositorio){
        
        ZonasDeTrabajo Zonas = repositorio.getZonas();
        Workspace w = Zonas.getWorkspace();
        String archivosW = w.toStringInterfaz();

        return archivosW;
    
    
    }
}
