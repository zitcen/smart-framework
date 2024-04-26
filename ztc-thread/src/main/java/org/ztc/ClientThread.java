package org.ztc;

/**
 * @ClassName ClientThread
 * @Description TODO
 * @Author ztc
 * @Date 2024/4/25 17:11
 */
public class ClientThread extends Thread{
    private Sequence sequence;
    public ClientThread(Sequence sequence){
        this.sequence =sequence;
    }

    @Override
    public void run() {
//        super.run();
        for (int i = 0; i < 3; i++){
            System.out.println(Thread.currentThread().getName() + " => " + sequence.getNumber());
        }
    }
}
