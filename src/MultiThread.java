
public class MultiThread {
    public static void main(String[] args) {

        BankAccount account = new BankAccount(1000.0);
        Father father = new Father(account);
        Son son = new Son(account);

        father.start();
        son.start();

        try {
            father.join();
            son.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Final balance: " + account.getBalance());
    }
}
