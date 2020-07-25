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

package de.topobyte.jsoup.bootstrap4.components;

import org.jsoup.nodes.Node;

import de.topobyte.jsoup.components.ListItem;
import de.topobyte.jsoup.components.OrderedList;

public class Breadcrumb extends OrderedList
{

	public Breadcrumb()
	{
		attr("class", "breadcrumb");
	}

	@Override
	public ListItem addTextItem(String text)
	{
		ListItem item = super.addTextItem(text);
		item.addClass("breadcrumb-item");
		return item;
	}

	@Override
	public ListItem addItem(Node e)
	{
		ListItem item = super.addItem(e);
		item.addClass("breadcrumb-item");
		return item;
	}

}
