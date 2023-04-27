package Login;

public class EraserThread implements Runnable {
    private boolean End;

    public EraserThread(String Prompt) {
        System.out.print(Prompt);
    }

    public void run() {
        End = true;
        while (End) {
            System.out.print("\b*");

            try {
                Thread.currentThread();
                Thread.sleep(20);
            } catch (InterruptedException Error) {
                Error.printStackTrace();
            }
        }
    }

    public void maskEnd() {
        this.End = false;
    }
}