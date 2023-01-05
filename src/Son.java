
public class Son extends Thread {

    private BankAccount account;

    int turn;
    boolean[] flag = new boolean[2];

    public Son(BankAccount account) {
        this.account = account;
    }

    @Override
    public void run() {
        System.out.println("Son is withdrawing " + account.getBalance());

        account.withdraw(1000.0);

        System.out.println("Son is done withdrawing ");

        entrySection(1);
        account.withdraw(1000.0);
        exitSection(1);

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
        System.out.println("--Process Son is done");
    }

}
