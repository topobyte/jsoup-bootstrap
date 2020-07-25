// Copyright 2019 Sebastian Kuerten
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

package de.topobyte.jsoup.bootstrap4.components;

import de.topobyte.jsoup.HTML;
import de.topobyte.jsoup.components.ListItem;
import de.topobyte.jsoup.components.UnorderedList;
import de.topobyte.jsoup.nodes.Element;

public class NavTabs
{

	private UnorderedList list = HTML.ul();

	public NavTabs()
	{
		list.addClass("nav nav-tabs");
	}

	public UnorderedList getElement()
	{
		return list;
	}

	public ListItem addItem(String href, String text, boolean active)
	{
		ListItem item = list.addItem();
		item.addClass("nav-item");
		Element a = item.ac(HTML.a(href).inner(text));
		a.addClass("nav-link");
		if (active) {
			a.addClass("active");
		}
		return item;
	}

}
