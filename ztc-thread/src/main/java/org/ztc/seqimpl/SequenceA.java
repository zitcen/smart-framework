package org.ztc.seqimpl;

import org.ztc.ClientThread;
import org.ztc.Sequence;

/**
 * @ClassName SequenceA
 * @Description TODO
 * @Author ztc
 * @Date 2024/4/25 17:23
 */
public class SequenceA implements Sequence {
    private static int number = 1;
    @Override
    public int getNumber() {
        number++;
        return number;
    }

    public static void main(String[] args) {
        Sequence sequence = new SequenceA();
        ClientThread thread1 = new ClientThread(sequence);
        ClientThread thread2 = new ClientThread(sequence);
        ClientThread thread3 = new ClientThread(sequence);
        thread1.start();
        thread2.start();
        thread3.start();
    }
}
