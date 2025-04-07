class ThreadA extends Thread{
    @Override
    public void run() {
        for(int i=0; i<200; i++){
            System.out.println("ThreadA : "+ i);
        }
    }
}
class ThreadB extends Thread{
    @Override
    public void run() {
        for(int i=0; i<200; i++){
            System.out.println("ThreadB : "+ i);
        }
    }
}

public class MainThread{
    public static void main(String[] args){
        ThreadA th1 = new ThreadA();
        ThreadB th2 = new ThreadB();
        th1.start();
        th2.start();
        for(int i=0; i<200; i++){
            System.out.println("main : " + i);
        }
    }
}