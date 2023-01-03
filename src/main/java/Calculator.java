import java.util.ArrayList;
import java.util.List;

public class Calculator {
    double sum = 0;
    List<String> productNamesList = new ArrayList<>();

    void addCoast(String name, double coast){
        productNamesList.add(name);
        sum += coast;
    }

    double calculateResultSum(int peopleNumber) {
        return sum / peopleNumber;
    }
}
