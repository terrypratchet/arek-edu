new Thread() - new state
start() - alive
run() completed - dead


Thread.currentThread().getName()

when you invoke start() second time it throws IllegalThreadStateException

Some of the methods that can
help us influence thread scheduling are as follows:
public static void sleep(long millis) throws InterruptedException
public static void yield()
public final void join() throws InterruptedException
public final void setPriority(int newPriority)


public final void wait() throws InterruptedException
public final void notify()
public final void notifyAll()


waiting/blocked/sleeping
blocked waiting for resource (I/O)

yield currently running thread head back to runnable

t.start();
t.join();
This blocks the current thread from becoming runnable
until aft
er the thread referenced by t is no longer alive.


Guaranteed to cause the current thread to stop executing
until the thread it joins with


public static int getCount() {
synchronized(MyClass.class) {
return count;
}
}

public static void classMethod() {
Class cl = Class.forName("MyClass");
synchronized (cl) {
// do stuff
}
}

Thread safe classes:
Collections.synchronizedList(
new LinkedList());


wait(), notify(), and notifyAll() must be called from within a synchronized
context!
