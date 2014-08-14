package org.mu.opencomm.common.dbutil;

import java.util.Iterator;
import java.util.List;

public class Page<T> implements Iterable<T> {
	
	private long totalElements;
	
	private long totalPages;
	
	private List<T> content;
	
	public Page() {}
	
	public boolean isEmpty() {
		return totalElements == 0;
	}

	public void setTotalElements(long totalElements) {
		this.totalElements = totalElements;
	}

	public void setTotalPages(long totalPages) {
		this.totalPages = totalPages;
	}

	public void setContent(List<T> content) {
		this.content = content;
	}

	public long getTotalElements() {
		return totalElements;
	}
	
	public long getTotalPages() {
		return totalPages;
	}
	
	public List<T> getContent() {
		return content;
	}

	@Override
	public Iterator<T> iterator() {
		return content.iterator();
	}
}
