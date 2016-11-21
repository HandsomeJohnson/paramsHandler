package com.hexincad;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


/**
 * 分页
 * 
 */
public class Page<T> implements Serializable {

	private static final long serialVersionUID = -2053800594583879853L;

	/** 内容 */
	private List <T> rows = new ArrayList<T>();
	private List <T> footer = new ArrayList<T>();
	/** 总记录数 */
	private final long total;

	/**
	 * 初始化一个新创建的Page对象
	 */
	public Page() {
		this.total = 0L;
	}

	/**
	 * @param content
	 *            内容
	 * @param total
	 *            总记录数
	 * @param pageable
	 *            分页信息
	 */
	public Page(List<T> rows, long total, Pageable pageable) {
		this.rows.addAll(rows);
		this.total = total;
	}










	/**
	 * 获取内容
	 * 
	 * @return 内容
	 */
	public List<T> getRows() {
		return rows;
	}
	public void setRows(List<T> rows) {
		this.rows = rows;
	}
	/**
	 * 获取总记录数
	 * 
	 * @return 总记录数
	 */
	public long getTotal() {
		return total;
	}

	
	public List<T> getFooter() {
		return footer;
	}

	public void setFooter(List<T> footer) {
		this.footer = footer;
	}
}