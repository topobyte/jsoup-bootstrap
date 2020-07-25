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

import de.topobyte.jsoup.bootstrap4.components.listgroup.ListGroupItem;
import de.topobyte.jsoup.components.UnorderedList;
import de.topobyte.jsoup.nodes.Element;

public class ListGroup extends UnorderedList
{

	public ListGroup()
	{
		super();
		addClass("list-group");
	}

	private void addClass(Element element)
	{
		element.addClass("list-group-item");
	}

	@Override
	public ListGroupItem addItem()
	{
		ListGroupItem item = ac(new ListGroupItem());
		addClass(item);
		return item;
	}

	@Override
	public ListGroupItem addTextItem(String text)
	{
		ListGroupItem item = addItem();
		item.appendText(text);
		addClass(item);
		return item;
	}

	@Override
	public ListGroupItem addItem(Node e)
	{
		ListGroupItem item = addItem();
		item.ap(e);
		addClass(item);
		return item;
	}

}
