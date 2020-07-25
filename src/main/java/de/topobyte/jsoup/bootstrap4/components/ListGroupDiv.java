// Copyright 2020 Sebastian Kuerten
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

import org.jsoup.nodes.Node;

import de.topobyte.jsoup.bootstrap4.components.listgroup.ListGroupA;
import de.topobyte.jsoup.bootstrap4.components.listgroup.ListGroupButton;
import de.topobyte.jsoup.bootstrap4.components.listgroup.ListGroupItem;
import de.topobyte.jsoup.components.Div;
import de.topobyte.jsoup.nodes.Element;

public class ListGroupDiv extends Div
{

	public ListGroupDiv()
	{
		super();
		addClass("list-group");
	}

	private void addClass(Element element)
	{
		element.addClass("list-group-item");
	}

	public ListGroupItem addItem()
	{
		ListGroupItem item = ac(new ListGroupItem());
		addClass(item);
		return item;
	}

	public ListGroupItem addTextItem(String text)
	{
		ListGroupItem item = addItem();
		item.appendText(text);
		addClass(item);
		return item;
	}

	public ListGroupItem addItem(Node e)
	{
		ListGroupItem item = addItem();
		item.ap(e);
		addClass(item);
		return item;
	}

	public ListGroupA addA(String href)
	{
		ListGroupA a = ac(new ListGroupA(href));
		addClass(a);
		return a;
	}

	public ListGroupA addA(String href, String text)
	{
		ListGroupA a = ac(new ListGroupA(href, text));
		addClass(a);
		return a;
	}

	public ListGroupButton addButton(String text)
	{
		ListGroupButton button = ac(new ListGroupButton());
		addClass(button);
		button.text(text);
		return button;
	}

}
