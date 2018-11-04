package lab.extra.multithreaded_streamio;

public interface MessageSink<T> {

	public void put(T message);
}
