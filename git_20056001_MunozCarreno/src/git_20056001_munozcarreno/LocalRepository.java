package git_20056001_munozcarreno;


import java.util.ArrayList;


/*
descripcion clase: La clase tiene como objetivo inicializar la zona local
repository (constructor de la zona local repository)

atributos: CommitsEnLocal (lista de tipo ArrayList<Commit>, que contiene todos
los commit realizados por el usuario)

metodos incorporados: 

- toString


*/

public class LocalRepository {
    //atributos u objetos
    private ArrayList<Commit> CommitsEnLocal; 
    
    /**
     * CONSTRUCTOR
     */
    public LocalRepository() {
        this.CommitsEnLocal = new ArrayList<>();
    }

    //GETTERS Y SETTERS
    
    /**
     * SELECTOR
     * @return ArrayList
     */
    public ArrayList<Commit> getCommitsEnLocal() {
        return CommitsEnLocal;
    }

    /**
     * MODIFICADOR
     * @param localRepository 
     */
    public void setCommitsEnLocal(ArrayList<Commit> localRepository) {
        this.CommitsEnLocal = localRepository;
    }

    @Override
    public String toString() {
        return "[" + CommitsEnLocal + ']';
    }
    
    
    
    
    
    
    public String toStringInterfaz(ZonasDeTrabajo Zonas) {
        
        
        //SE CREA VARIABLE PARA ALMACENAR LA CANTIDAD DE COMMIT ALMACENADOS
        int cantCommits;
        //VARIABLE PARA EL NUMERO MAXIMO DE COMMITS
        int max = 3;
        
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
            CommitNumero = CommitNumero.concat(": ");
            
            //SE CONCATENA CON EL MENSAJE DESCRIPTIVO
            CommitNumero = CommitNumero.concat(C.getMensaje());
            parte1 = CommitNumero.concat("\n\n");
 
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
            parteF = parteF.concat(parte1);
            
        
           
            
            i+=1;
            max-=1;
            cantCommits-=1;
        }
        return parteF;
        
        
        
    }
    
    
}
