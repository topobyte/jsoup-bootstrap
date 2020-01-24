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

package de.topobyte.jsoup.bootstrap3;

import static de.topobyte.jsoup.HTML.a;

import java.io.IOException;

import org.apache.commons.io.IOUtils;

import de.topobyte.jsoup.ElementUtil;
import de.topobyte.jsoup.HTML;
import de.topobyte.jsoup.HtmlBuilder;
import de.topobyte.jsoup.bootstrap3.components.Menu;
import de.topobyte.jsoup.nodes.Element;

public class BaseGenerator
{

	protected HtmlBuilder builder = new HtmlBuilder();

	public void generate() throws IOException
	{
		Element head = builder.getHead();

		String header = IOUtils
				.toString(Thread.currentThread().getContextClassLoader()
						.getResourceAsStream("bootstrap.headers.html"));
		System.out.println(header);
		ElementUtil.appendFragment(head, header);

		Element body = builder.getBody();

		// Menu

		menu(body);
	}

	protected static void menu(Element body)
	{
		Menu menu = new Menu();
		body.ap(menu);

		menu.addBrand(HTML.span().appendText("Awesome"));

		menu.addMain(a("index.html").appendText("Overview"), false);
		menu.addMain(a("forms.html").appendText("Forms"), false);
		menu.addMain(a("list-groups.html").appendText("List-Groups"), false);

		menu.addRight(a("#").appendText("About"), false);
	}

}
