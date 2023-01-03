// dev branch for Y.Practicum
public class Main {

    public static void main(String[] args) {
        UserDialog userDialog = new UserDialog();
        Calculator calculator = new Calculator();
        int peopleNumber = 0;

        peopleNumber = userDialog.getPeopleNumber(peopleNumber);
        addProduct(userDialog, calculator);
        showResult(userDialog, calculator, peopleNumber);
    }

    public static void addProduct(UserDialog userDialog, Calculator calculator) {
        String productName;
        do {
            Product product = userDialog.getProduct();
            productName = product.name;
            calculator.addCoast(product.name, product.coast);
        } while (!userDialog.isFinished(productName));
    }

    public static void showResult(UserDialog userDialog, Calculator calculator, int peopleNumber) {
        userDialog.showProductList(calculator.productNamesList);
        userDialog.showSum(calculator.calculateResultSum(peopleNumber));
    }
}
