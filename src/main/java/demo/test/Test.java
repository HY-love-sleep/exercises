package demo.test;

import com.lmax.disruptor.BlockingWaitStrategy;
import com.lmax.disruptor.EventFactory;
import com.lmax.disruptor.EventHandler;
import com.lmax.disruptor.RingBuffer;
import com.lmax.disruptor.dsl.Disruptor;
import com.lmax.disruptor.dsl.ProducerType;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.LockSupport;

/**
 * @author ：hongyan
 * @date ：Created in 2022/8/24 10:27
 * @description：测试
 */
public class Test {
    static class Element {
        private int value;

        public int getValue() {
            return value;
        }

        public void setValue(int value) {
            this.value = value;
        }
    }

    private static volatile int i = 1;
    public static void main(String[] args) throws InterruptedException {

        ThreadFactory threadFactory = new ThreadFactory() {
            @Override
            public Thread newThread(Runnable r) {
                return new Thread(r, "simpleThread");
            }
        };

        EventFactory<Element> eventFactory = new EventFactory<Element>() {
            @Override
            public Element newInstance() {
                return new Element();
            }
        };

        EventHandler<Element> eventHandler = new EventHandler<Element>() {
            @Override
            public void onEvent(Element element, long sequence, boolean b) throws Exception {
                System.out.println("element : " + element.getValue());
            }
        };

        BlockingWaitStrategy blockingWaitStrategy = new BlockingWaitStrategy();

        Disruptor<Element> disruptor = new Disruptor<Element>(eventFactory, 32, threadFactory, ProducerType.SINGLE, blockingWaitStrategy);

        disruptor.handleEventsWith(eventHandler);

        disruptor.start();

        RingBuffer<Element> ringBuffer = disruptor.getRingBuffer();

        while (true) {
            long sequence = ringBuffer.next();

            try {
                Element e = ringBuffer.get(sequence);
                e.setValue(i);
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                ringBuffer.publish(sequence);
            }
            i++;
            TimeUnit.MILLISECONDS.sleep(10L);
        }
    }
}
