import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class UserDialog {
    Scanner scanner = new Scanner(System.in);

    int getPeopleNumber(int peopleNumber){
        System.out.println("На скольких человек необходимо разделить счёт?");
        while(peopleNumber <= 1) {
            try {
                peopleNumber = scanner.nextInt();

                if(peopleNumber == 1) {
                    System.out.println("Нет смысла ничего считать и делить для одного человека\nВведите корректное значение");
                } else if(peopleNumber < 1) {
                    System.out.println("Количество человек меньше 1. Это некорректное значение для подсчёта\nВведите корректное значение");
                }
            } catch (InputMismatchException e) {
                scanner.nextLine();
                System.out.println("Неверный формат данных\nВведите корректное значение");
            }
        }

        return  peopleNumber;
    }

    Product getProduct(){
        Product product = new Product();
        System.out.println("Введите название товара");
        product.name = scanner.next();
        System.out.println("Введите стоимость товара");
        while (true) {
            try {
                product.coast = Double.parseDouble(scanner.next());
                if(product.coast < 0) {
                    System.out.println("Стоимость товара не может быть отрицательной\nВведите корректное значение");
                } else {
                    break;
                }
            } catch (NumberFormatException e) {
                scanner.nextLine();
                System.out.println("Неверный формат данных\nВведите корректное значение");
            }
        }
        return product;
    }

    boolean isFinished(String productName) {
        System.out.println(productName + " успешно добавлен");
        System.out.println("Хотите добавить еще один товар?");
        String result = scanner.next();
        return result.equalsIgnoreCase("завершить");
    }

    void showProductList(List<String> productNamesList) {
        System.out.println("Добавленные товары:");
        productNamesList.forEach((productName) ->
                System.out.println(productName)
        );
    }

    void showSum(double sum) {
        DecimalFormat df = new DecimalFormat("#.##");
        df.setDecimalFormatSymbols(DecimalFormatSymbols.getInstance(Locale.ENGLISH));

        System.out.println(df.format(sum) + " " + formatString(sum));
    }

    String formatString(double sum) {
        int result = (int)sum % 100;
        if(result >= 10 && result <= 20) {
            return "рублей";
        }

        result = (int)sum % 10;
        if(result == 0 || result >= 5) {
            return "рублей";
        } else if(result >= 2) {
            return "рубля";
        } else if(result == 1) {
            return "рубль";
        } else {
            return "Format ERROR";
        }
    }
}
