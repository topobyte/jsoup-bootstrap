// Copyright 2016 Sebastian Kuerten
//
// This file is part of jsoup-bootstrap.
//
// jsoup-bootstrap is free software: you can redistribute it and/or modify
// it under the terms of the GNU Lesser General Public License as published by
// the Free Software Foundation, either version 3 of the License, or
// (at your option) any later version.
//
// jsoup-bootstrap is distributed in the hope that it will be useful,
// but WITHOUT ANY WARRANTY; without even the implied warranty of
// MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
// GNU Lesser General Public License for more details.
//
// You should have received a copy of the GNU Lesser General Public License
// along with jsoup-bootstrap. If not, see <http://www.gnu.org/licenses/>.

package de.topobyte.jsoup.bootstrap3.components;

import static de.topobyte.jsoup.HTML.div;
import static de.topobyte.jsoup.HTML.li;
import static de.topobyte.jsoup.HTML.span;
import static de.topobyte.jsoup.HTML.ul;

import org.jsoup.nodes.Node;

import de.topobyte.jsoup.ElementBuilder;
import de.topobyte.jsoup.bootstrap3.Bootstrap;
import de.topobyte.jsoup.nodes.Element;

public class Menu extends Element
{

	protected Element navbarHeader;
	protected Element navMain;
	protected Element navRight;

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

		Element button = navbarHeader.ac(ElementBuilder.create("button", "type",
				"button", "class", "navbar-toggle collapsed", "data-toggle",
				"collapse", "data-target", "#" + idNavbar, "aria-expanded",
				"false", "aria-controls", "navbar"));

		button.appendChild(
				span().addClass("sr-only").appendText("Toggle navigation"));
		button.appendChild(span().addClass("icon-bar"));
		button.appendChild(span().addClass("icon-bar"));
		button.appendChild(span().addClass("icon-bar"));

		// Entries

		Element entries = container.ac(div()
				.addClass("collapse navbar-collapse").attr("id", idNavbar));

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
