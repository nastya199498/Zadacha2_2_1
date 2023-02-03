package hiber;
import hiber.config.AppConfig;
import hiber.model.Car;
import hiber.model.User;
import hiber.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import java.sql.SQLException;
import java.util.List;
public class MainApp {
   public static void main(String[] args) throws SQLException {
      AnnotationConfigApplicationContext context = 
            new AnnotationConfigApplicationContext(AppConfig.class);
      UserService userService = context.getBean(UserService.class);
      User user1 = new User("Ivan", "Ivanov", "user1@mail.ru");
      User user2 = new User("Petr", "Petrov", "user2@mail.ru");
      User user3 = new User("Tom", "Sidorov", "user3@mail.ru");
      User user4 = new User("Maks", "Korolev", "user4@mail.ru");
      Car car1 = new Car("BMW", 1);
      Car car2 = new Car("AUDI", 2);
      Car car3 = new Car("LADA", 3);
      Car car4 = new Car("RENO", 4);
      userService.add(user1.setCar(car1).setUser(user1));
      userService.add(user2.setCar(car2).setUser(user2));
      userService.add(user3.setCar(car3).setUser(user3));
      userService.add(user4.setCar(car4).setUser(user4));
      List<User> users = userService.listUsers();
      for (User user : users) {
         System.out.println("Id = " + user.getId());
         System.out.println("First Name = " + user.getFirstName());
         System.out.println("Last Name = " + user.getLastName());
         System.out.println("Email = " + user.getEmail());
         System.out.println("--------------------");
      }
      System.out.println(userService.getUserByCar(car1.getModel(), car1.getSeries()));
      context.close();
   }
}
