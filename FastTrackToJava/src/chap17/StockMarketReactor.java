package chap17;

import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.concurrent.Flow;
import java.util.concurrent.Flow.Subscription;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.SubmissionPublisher;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

/**
 * This class shows a stock market data stream processing using reactive programming. 
 */
public class StockMarketReactor {

	private static long startTime = System.currentTimeMillis();

	private static void log(String toLog) {
		long time = System.currentTimeMillis() - startTime;
		System.out.println(time + ": " + toLog);
	}

    private static void sleep(double seconds) {
        try {
            Thread.sleep((long) (seconds * 1000));
        }
        catch (InterruptedException e) {
            // Swallow the error
        }
    }

    static void doWork(int processingTime) {
        sleep(processingTime);
    }

	private static void simulateMarket(SubmissionPublisher<MarketEvent> publisher, List<MarketEvent> events) {

		events.stream().forEach(event -> {
			log("Publishing event: " + event + " Estimated processing lag: " + publisher.estimateMaximumLag() +
					" Estimated demand: " + publisher.estimateMinimumDemand());
			publisher.offer(event,						// Publish this stock market event and let any/all subscribers process it.
							1, TimeUnit.SECONDS,// Wait up to 1 seconds for a subscriber to process it or it will be dropped
							(sub, message) ->			// This handler determines if the event should be retried or not if dropped
								{
									log("Message dropped: " + message);
									return false;
								});	
		}); 
	}
	
	public static void main(String[] args) {

		// SubmissionPublisher is an AutoClosable
		try (SubmissionPublisher<MarketEvent> publisher = 
				new SubmissionPublisher<>(ForkJoinPool.commonPool(),	// Create a publisher using the common ForkJoinPool as the async framework.  
										  2, 		    // Queue size is set to two
										  (analyzer, exception) -> log("TradeAnalyzer error: " + exception.getMessage()))) // If any subscribers error out, print out the exception message 
		{
			// Only 1 subscriber is created and subscribed to market events.
			// SubmissionPublisher acts like a multicast source so adding more subscribers will broadcast to all subscribers.
			TradeAnalyzer analyzer = new TradeAnalyzer(MarketEvent.TradeType.SELL, MarketEvent.TradeType.BUY);
			publisher.subscribe(analyzer);
		
			List<MarketEvent> events = Arrays.asList(MarketEvent.makeBuyEvent("AAPL", 188.64),
													MarketEvent.makeSellEvent("FB", 184.67),
					  						    	    MarketEvent.makeBuyEvent("GOOG", 1085.18),
					  						    	    MarketEvent.makeBuyEvent("AMZN", 1589.54),
					  						    	    MarketEvent.makeSellEvent("NFLX", 328.92));
		
			simulateMarket(publisher, events);
		
			// Give subscribers enough to finish processing
			sleep(10);
		}
	}
	
	/**
	 * This is the FlowSubscriber class, which subscribes to stock market events and receives messages. 
	 */
	private static class TradeAnalyzer implements Flow.Subscriber<MarketEvent> {

		private final Set<MarketEvent.TradeType> processTypes;
		private Subscription subcription;
		
		private TradeAnalyzer(MarketEvent.TradeType... processTypes) {
			this.processTypes = Arrays.asList(processTypes).stream().collect(Collectors.toSet());
		}
		
		/**
		 * Callback when the TradeAnalyzer has subscribed.
		 */
		@Override
		public void onSubscribe(Subscription sub) {
			log("Subscribed");
			this.subcription = sub;
			
			// Must ask for events or nothing will happen.
			sub.request(1);
		}
		
		/**
		 * Callback when new market events are received.
		 * 
		 * @param next Next event to process.
		 */
		@Override
		public void onNext(MarketEvent next) {
			log("Received event: " + next);
			subcription.request(1);
			
			// Any errors thrown by the TradeAnalyzer will call onError()
			if (processTypes.contains(next.getTradeType()) == false) {
				throw new RuntimeException("Can't process SELL types: " + next);
			}
		
			process(next);
		}
		
		/**
		 * Callback when TradeAnalyzer is unsubscribed in a normal (non-error) life-cycle.
		 */
		@Override
		public void onComplete() {
			log("Worker completed");
		}

		/**
		 * Callback when the TradeAnalyzer has erred out. Call INSTEAD of onComplete().
		 * 
		 *  @param throwable Exception thrown by publisher.
		 */
		@Override
		public void onError(Throwable throwable) {
			log("Error received: " + throwable.getMessage());
		}

		/**
		 * Simulate actual work being done.
		 * 
		 * @param event The event to process.
		 */
		private void process(MarketEvent event) {
			doWork(2);
		}
	}
}