package test;

public class test2 {
	private static int GG=100;

	public static void main(String[] args) {
		locker L = new test2.locker();
		
		Thread t1 = new Thread(new task1(L));
		Thread t2 = new Thread(new task2(L));
		Thread t3 = new Thread(new task3(L));
		
		t1.start();
		t2.start();
		t3.start();

	}
	
	
	private static class task1 implements Runnable{
		locker l;
		int count =0;
		public task1(locker l){
			this.l=l;
		};
		
		

		@Override
		public void run() {
			while(true){
				synchronized (l) {
					if(l.num==0){
						System.out.print("A");
						count++;
						l.num=1;
						l.notifyAll();
						
					}else{
						try {
							l.wait();
						} catch (InterruptedException e) {							
							e.printStackTrace();
						}
					}
					if(count==GG){
						break;
					}
				}
			}
		}
		
	}
	
	private static class task2 implements Runnable{
		locker l;
		int count =0;
		public task2(locker l){
			this.l=l;
		}

		@Override
		public void run() {
			while(true){
				synchronized (l) {
					if(l.num==1){
						System.out.print("B");
						count++;
						l.num=2;
						l.notifyAll();
					}else{
						
						try {
							l.wait();
						} catch (InterruptedException e) {							
							e.printStackTrace();
						}
					}
					if(count==GG){
						break;
					}
				}
			}
			
		}
		
	}
	
	private static class task3 implements Runnable{
		locker l;
		int count =0;
		public task3(locker l){
			this.l=l;
		}

		@Override
		public void run() {
			while(true){
				synchronized (l) {
					if(l.num==2){
						System.out.print("C ");
						count++;
						l.num=0;
						l.notifyAll();
						
					}else{
						try {
							l.wait();
						} catch (InterruptedException e) {							
							e.printStackTrace();
						}
					}
					if(count==GG){
						break;
					}
				}
			}
			
		}
		
	}
	
	
	private static class locker{
		int num=0;
	}
	

}
