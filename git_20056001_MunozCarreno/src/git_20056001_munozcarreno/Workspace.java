package git_20056001_munozcarreno;


import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

/*
descripcion clase: La clase actua como constructor de la zona remote
repository.

atributos: Archivos_Workspace (lista de tipo ArrayList<ArchTextoPlano>)

metodos incorporados: 

- obtenerFecha
- toString


*/



public class Workspace {
    //atributos u objetos
    private ArrayList<ArchTextoPlano> Archivos_Workspace;
    
    /**
     * CONSTRUCTOR
     */
    public Workspace() {
        //SE INICIALIZA LA ZONA WORKSPACE COMO UNA LISTA VACIA
        Archivos_Workspace = new ArrayList<>();
    }
    
    //MÉTODOS
    
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
    
    
    
    
    //GETTERS Y SETTERS
    
    /**
     * SELECTOR DE zonasWorkspace
     * @return zonasWorkspace
     */
    public ArrayList<ArchTextoPlano> getArchivos_Workspace() {
        return Archivos_Workspace;
    }
    /**
     * MODIFICADOR DE zonasWorkspace
     * @param zonaWorkspace 
     */
    public void setArchivos_Workspace(ArrayList<ArchTextoPlano> zonaWorkspace) {
        this.Archivos_Workspace = zonaWorkspace;
    }

    @Override
    public String toString() {
        return "-" + Archivos_Workspace + '.';
    }
    
    
    public String toStringInterfaz() {
        //String Archivos = "";
        int i;
        ArchTextoPlano arch;
        String NameArchivo;
        String formando = "- ";
        String guion = "- ";
        String nuevo;
        for(i=0;i<Archivos_Workspace.size();i++){
            if(i == 0){
              arch = Archivos_Workspace.get(i);
              NameArchivo = arch.getNombre();
              NameArchivo = NameArchivo.concat("\n");
              formando = formando.concat(NameArchivo);  
            }
            else{
                arch = Archivos_Workspace.get(i);
                NameArchivo = arch.getNombre();
                NameArchivo = NameArchivo.concat("\n");
                nuevo = guion.concat(NameArchivo);
                formando = formando.concat(nuevo);
            }
            
        }
        //Archivos = Archivos.concat(formando); 
        
        return formando;
    }
    
}
