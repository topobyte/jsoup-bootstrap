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

package de.topobyte.jsoup.bootstrap3.components;

import de.topobyte.jsoup.HTML;
import de.topobyte.jsoup.components.A;
import de.topobyte.jsoup.components.Button;
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

	public A addA(String href)
	{
		A a = ac(HTML.a(href));
		addClass(a);
		return a;
	}

	public A addA(String href, String text)
	{
		A a = ac(HTML.a(href, text));
		addClass(a);
		return a;
	}

	public Button addButton(String text)
	{
		Button button = ac(HTML.button());
		addClass(button);
		button.text(text);
		return button;
	}

}
