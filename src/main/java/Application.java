import java.util.List;

public class Application {
    public static void main(String[] args){
        TodoClient td = new TodoClient();


        List<Todo> list = td.getTodos();
        System.out.print(list);

    }
}
