package lab11.init;

import lab11.fin.Category;

import java.util.*;

public class MemoryMovieDb implements MovieDb {

	private final Map<Category, List<Movie>> database = new HashMap<>();

	@Override
	public void add(Set<Category> categories, String name, Integer yearReleased) {

		// implement this
	}

	@Override
	public void add(Category category, String name, Integer yearReleased) {

		// implement this
	}

	@Override
	public Movie findByName(String name) {
		// implement this
		return null;
	}

	@Override
	public List<String> findByCategory(Category category) {
		// implement this
		return Collections.emptyList();
	}

	@Override
	public boolean delete(String name) {
		// implement this
		return false;
	}
}
