import github.GithubCliet;

public class Application {
    public static void main(String[] args){
        GithubCliet gc = new GithubCliet();
        System.out.println(gc.getEvents() +"\n");
    }
}
