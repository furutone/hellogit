package bean;

import java.io.Serializable;
import java.util.List;

import org.codehaus.jackson.annotate.JsonProperty;

public class DynaTreeData implements Serializable {

	//TODO: @JsonProperty http://hmkcode.com/jackson-java-json/
	private String title;
	private String key;
	private String select;
	private String tooltip;
	private List<DynaTreeData> children;

	/**
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * @param title
	 *            the title to set
	 */
	public void setTitle(String title) {
		this.title = title;
	}

	/**
	 * @return the key
	 */
	public String getKey() {
		return key;
	}

	/**
	 * @param key
	 *            the key to set
	 */
	public void setKey(String key) {
		this.key = key;
	}

	/**
	 * @return the select
	 */
	public String getSelect() {
		return select;
	}

	/**
	 * @param select
	 *            the select to set
	 */
	public void setSelect(String select) {
		this.select = select;
	}

	/**
	 * @return the tooltip
	 */
	public String getTooltip() {
		return tooltip;
	}

	/**
	 * @param tooltip
	 *            the tooltip to set
	 */
	public void setTooltip(String tooltip) {
		this.tooltip = tooltip;
	}

	/**
	 * @return the children
	 */
	public List<DynaTreeData> getChildren() {
		return children;
	}

	/**
	 * @param children
	 *            the children to set
	 */
	public void setChildren(List<DynaTreeData> children) {
		this.children = children;
	}

}
