
public class Father extends Thread {

    private BankAccount account;

    int turn;
    boolean[] flag = new boolean[2];

    public Father(BankAccount account) {
        this.account = account;
    }

    @Override
    public void run() {
        System.out.println("Father is depositing " + account.getBalance());

        account.deposit(1000.0);

        System.out.println("Father is done depositing ");

        entrySection(0);
        account.deposit(1000.0);
        exitSection(0);

    }

    public void entrySection(int i) {

        flag[i] = true;
        turn = 1 - i;
        while (flag[1 - i] && turn == 1 - i) {
            // busy wait
        }
    }

    public void exitSection(int i) {
        flag[i] = false;
        System.out.println("--Process Father is done");
    }
}
