/* omri cohen - 24.04.2014 */
/* class for scheduling tasks */
package bee;

import java.util.concurrent.*;

public class Scheduler {
	private final ScheduledExecutorService scheduler; /* scheduler */
	private ScheduledFuture<?> sFuture; /* The scheduled object handle */
	
	public Scheduler()
	{
		 scheduler =  Executors.newScheduledThreadPool(1); /* get a new thread pool */
	}
	
	public int  ScheduleTask(Runnable Task, long initialDelay, long delay)
	{
		try{
			sFuture = scheduler.scheduleWithFixedDelay(Task, initialDelay, delay, TimeUnit.SECONDS); /* Schedule a given task */
		}
		catch(Exception e){
			e.printStackTrace();
		}

		return 0;
	}
	
	public int  CancelTask(Runnable Task)
	{
		try{
			/* schedule a cancellation of the given task */
			sFuture.cancel(true);
			scheduler.shutdown();
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return 0;
	}
	
	public boolean IsCancelled()
	{
		return sFuture.isCancelled();
	}
	public boolean IsDone()
	{
		return sFuture.isDone();
	}
}
