package de.topobyte.jsoup.components.bootstrap3;

import static de.topobyte.jsoup.HTML.div;
import static de.topobyte.jsoup.HTML.li;
import static de.topobyte.jsoup.HTML.span;
import static de.topobyte.jsoup.HTML.ul;

import org.jsoup.nodes.Node;

import de.topobyte.jsoup.Bootstrap;
import de.topobyte.jsoup.ElementBuilder;
import de.topobyte.jsoup.nodes.Element;

public class Menu extends Element
{

	private Element navbarHeader;
	private Element navMain;
	private Element navRight;

	public Menu()
	{
		this("bs-navbar-collapse");
	}

	public Menu(String idNavbar)
	{
		super("nav");
		addClass("navbar navbar-default");

		Element container = ac(Bootstrap.container());

		navbarHeader = container.ac(div("navbar-header"));

		// Button

		Element button = navbarHeader.ac(ElementBuilder.create("button",
				"type", "button", "class", "navbar-toggle collapsed",
				"data-toggle", "collapse", "data-target", "#" + idNavbar,
				"aria-expanded", "false", "aria-controls", "navbar"));

		button.appendChild(span().addClass("sr-only").appendText(
				"Toggle navigation"));
		button.appendChild(span().addClass("icon-bar"));
		button.appendChild(span().addClass("icon-bar"));
		button.appendChild(span().addClass("icon-bar"));

		// Entries

		Element entries = container.ac(div().addClass(
				"collapse navbar-collapse").attr("id", idNavbar));

		navMain = entries.ac(ul().addClass("nav navbar-nav"));
		navRight = entries.ac(ul().addClass("nav navbar-nav navbar-right"));
	}

	public void addBrand(org.jsoup.nodes.Element brand)
	{
		brand.addClass("navbar-brand");
		navbarHeader.ap(brand);
	}

	public void addMain(Node content, boolean active)
	{
		Element li = navMain.ac(li());
		if (active) {
			li.addClass("active");
		}
		li.appendChild(content);
		navMain.appendChild(li);
	}

	public void addRight(Node content, boolean active)
	{
		Element li = navRight.ac(li());
		if (active) {
			li.addClass("active");
		}
		li.appendChild(content);
	}

}
