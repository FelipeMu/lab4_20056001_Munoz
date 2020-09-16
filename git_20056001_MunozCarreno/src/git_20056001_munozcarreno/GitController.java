/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package git_20056001_munozcarreno;

/**
 *
 * @author CLundstedt
 */
public class GitController {
    public void gitInit (String RepoName, String AuthorName) throws RepositoryAuthorException, InvalidDatasException {
        if(RepoName.equalsIgnoreCase(AuthorName)){
            throw new RepositoryAuthorException();
        }
        
        //  AQUI SE INICIA EL REPOSITORIO DE FORMA NORMAL
        if(AuthorName == null || AuthorName.isEmpty() || AuthorName.trim().isEmpty() || RepoName == null || RepoName.isEmpty() || RepoName.trim().isEmpty()){
            throw new InvalidDatasException();
        }
    
    }
}
