package demo.data;

import java.util.List;

import demo.Spittle;

public interface ArekRepository {
	List<Spittle> findSpittles(long max, int count);
}
