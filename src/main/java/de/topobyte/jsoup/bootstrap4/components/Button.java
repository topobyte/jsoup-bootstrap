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

import de.topobyte.jsoup.nodes.Element;

public class Button extends Element
{

	public Button()
	{
		super("a");
		attr("class", "btn btn-primary");
		attr("role", "button");
	}

	public Button(String text)
	{
		this();
		appendText(text);
	}

	public Button(Node child)
	{
		this();
		appendChild(child);
	}

	public Button(String text, String href)
	{
		this(text);
		attr("href", href);
	}

	public Button(Node child, String href)
	{
		this(child);
		attr("href", href);
	}

}
