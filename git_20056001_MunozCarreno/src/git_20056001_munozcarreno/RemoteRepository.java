package git_20056001_munozcarreno;


import java.util.ArrayList;


/*
descripcion clase: Esta clase funciona como el constrcutor de la zona remote repository.

atributos: CommitsEnRemote (lista de tipo ArrayList<Commit>)

metodos incorporados: 

- ObtenerArchivosDeRemote
- toString


*/

public class RemoteRepository {
    //atributos u objetos
    private ArrayList<Commit> CommitsEnRemote;

    /**
     * CONSTRUCTOR
     */
    public RemoteRepository() {
        this.CommitsEnRemote = new ArrayList<>();
    }
    
    
    //METODOS
    
    
    /**
     * El metodo tiene como objetivo obtener todos los archivos de cada commit de la lista ingresada ListaCommits (de tipo ArrayList<Commit>)
     * @param ListaCommits
     * @return ArrayList
     */
    public static ArrayList<ArchTextoPlano> ObtenerArchivosDeRemote(ArrayList<Commit> ListaCommits){
        //SE CREA UN OBJETO DE TIPO ArrayList<ArchTextoPlano> PARA GUARDAR TODOS
        //LOS ARCHIVOS ALMACENADOS EN REMOTE REPOSITORY
        ArrayList<ArchTextoPlano> TodosLosArchivos = new ArrayList<>();
        //ITERADORES
        int i,j,p;
        
        //SE CREA OBJETO Commit
        Commit commit;
         
        //ArrayList<ArchTextoPlano> ArchivosIniciales = new ArrayList<>();
        
        //LISTA DE ARCHIVOS DE UN COMMIT
         ArrayList<ArchTextoPlano> archTemp = new ArrayList<>();
        
        
        //FOR QUE RECORRE TODA LA LISTA DE COMMITS
        for(i=0;i<ListaCommits.size();i++){
            //SE OBTIENE UN COMMIT
            commit = ListaCommits.get(i);
            //SE OBTIENE LA LISTA DE ARCHIVOS DEL COMMIT
            archTemp = commit.getArchivosCommit();
            //SE GUARDA LA LISTA DE ARCHIVOS EN UN NUEVO OBJETO
            TodosLosArchivos = ArchTextoPlano.UnirListasDeArchivos(archTemp,TodosLosArchivos);
        }
        return TodosLosArchivos;
    } 
    
    
    
    
    
    
    //GETTERS Y SETTERS

    /**
     * SELECTOR
     * @return ArrayList
     */
    public ArrayList<Commit> getCommitsEnRemote() {
        return CommitsEnRemote;
    }

    /**
     * MODIFICADOR
     * @param archivosCommit 
     */
    public void setCommitsEnRemote(ArrayList<Commit> archivosCommit) {
        this.CommitsEnRemote = archivosCommit;
    }

    @Override
    public String toString() {
        return "[" + CommitsEnRemote + ']';
    }
    
    
    
    /**
     * METODO QUE RETORNA UNA CADENA DE STRING CON LOS ULTIMOS 3 COMMIT DE REMOTE, MOSTRANDO MENSAJE Y ARCHIVOS VINCULADOS
     * @param Zonas
     * @return String
     */
    public String toStringInterfaz(ZonasDeTrabajo Zonas) {
        
        
        //SE CREA VARIABLE PARA ALMACENAR LA CANTIDAD DE COMMIT ALMACENADOS
        int cantCommits;
        //VARIABLE PARA EL NUMERO MAXIMO DE COMMITS
        int max = 3;
        
        //SE PROCEDE A OBTENER EL OBJETO TIPO LocalRepository
        RemoteRepository R = Zonas.getRemoteRepository();
        //SE OBTIENE LA LISTA DE COMMITS
        //SE CREA OBJETO PARA ALMACENAR LA LISTA DE COMMITS
        ArrayList<Commit> commits = R.getCommitsEnRemote();
       
        
        //LUEGO LA CANTIDAD DE COMMITS SE OBTIENE DE LA SIGUIENTE MANERA:
        cantCommits = commits.size();
 
        //ITERADOR
        int i=1;
        int j;
        
        
        
        //SE DEFINE OBJETO DE TIPO Commits
        Commit C;
        
        //SE DEFINE OBJETO DE TIPO ArrayList<ArchTextolano>
        ArrayList<ArchTextoPlano> listaArchivos =  new ArrayList<>();
        
        //SE DEFINE OBJETO TIPO ArchTextoPlano
        ArchTextoPlano archivo;
        
        
        //String con la palbra commit
        String PalabraCommit = "Commit ";
        ///string que almacenara el numero del commit
        String NumCommit;
        // string con el commit numero y mensaje
        String parte1;
        String parteF = "";
        
        // se almacena la contatenacion PalabraCommit y NumCommit
        String CommitNumero;
        
        while(cantCommits>0 && max>0){
            
            //SE OBTIENE EL COMMIT EN LA POSICIÓN i
            // ULTIMO COMMIT EN LOCAL
            C = commits.get(cantCommits-1); 
            
            //SE OBTIENE ALAMCENA EL NUMERO DEL COMMIT EN NumCommit
            NumCommit = String.valueOf(i);
            
            //SE CONCATENA EL STRING PalabraCommit y NumCommit
            CommitNumero = PalabraCommit.concat(NumCommit);
            CommitNumero = CommitNumero.concat(":\nMensaje: ");
            
            //SE CONCATENA CON EL MENSAJE DESCRIPTIVO
            CommitNumero = CommitNumero.concat(C.getMensaje());
            parte1 = CommitNumero.concat("\nArchivos:\n");
 
           //SE OBTIENE LA LISTA DE ARCHIVOS DEL COMMIT
            listaArchivos = C.getArchivosCommit();
            
            String nombreA;
            String archivos="";
            for(j=0;j<listaArchivos.size();j++){
                //se obtiene una lista de un archivo
                archivo = listaArchivos.get(j);
                //se obtiene el nombre del archivo
                nombreA = archivo.getNombre();
                //se concatena el nombre del archivo con "archivos"
                archivos = archivos.concat(nombreA);
                //se concatena un \n al final del String archivos
                archivos = archivos.concat("\n"); 
            }
            parte1 = parte1.concat(archivos);
            parte1 = parte1.concat("\n");
            parteF = parteF.concat(parte1);
            
        
           
            
            i+=1;
            max-=1;
            cantCommits-=1;
        }
        return parteF;
        
        
        
    }
    
    
    
    
    
    
    
    
}
