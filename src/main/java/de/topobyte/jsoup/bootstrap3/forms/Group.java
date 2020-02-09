package de.topobyte.jsoup.bootstrap3.forms;

import de.topobyte.jsoup.components.Div;
import de.topobyte.jsoup.components.Label;
import de.topobyte.jsoup.nodes.Element;
import lombok.Getter;

public class Group
{

	@Getter
	private Div group;
	@Getter
	private Label label;
	@Getter
	private Element content;

	public Group(Div group, Label label, Element content)
	{
		this.group = group;
		this.label = label;
		this.content = content;
	}

}
