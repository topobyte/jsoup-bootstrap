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

package de.topobyte.jsoup;

import static de.topobyte.jsoup.Bootstrap.button;
import static de.topobyte.jsoup.Bootstrap.label;
import static de.topobyte.jsoup.HTML.a;
import static de.topobyte.jsoup.HTML.b;
import static de.topobyte.jsoup.HTML.br;
import static de.topobyte.jsoup.HTML.div;
import static de.topobyte.jsoup.HTML.h1;
import static de.topobyte.jsoup.HTML.i;
import static de.topobyte.jsoup.HTML.p;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import org.apache.commons.io.IOUtils;
import org.jsoup.nodes.Document;

import de.topobyte.jsoup.components.Div;
import de.topobyte.jsoup.components.bootstrap3.Breadcrumb;
import de.topobyte.jsoup.components.bootstrap3.Container;
import de.topobyte.jsoup.components.bootstrap3.Label;
import de.topobyte.jsoup.components.bootstrap3.Label.Type;
import de.topobyte.jsoup.components.bootstrap3.Menu;
import de.topobyte.jsoup.nodes.Element;

public class Test
{

	public static void main(String[] args) throws IOException
	{
		HtmlBuilder builder = new HtmlBuilder();

		Element head = builder.getHead();

		String header = IOUtils.toString(Thread.currentThread()
				.getContextClassLoader()
				.getResourceAsStream("bootstrap.headers.html"));
		System.out.println(header);
		ElementUtil.appendFragment(head, header);

		Element body = builder.getBody();

		// Menu

		Menu menu = new Menu();
		body.ap(menu);

		menu.addBrand(HTML.span().appendText("Awesome"));

		menu.addMain(a("#").appendText("Products"), false);
		menu.addMain(a("#").appendText("Services"), false);
		menu.addMain(a("#").appendText("Partners"), false);

		menu.addRight(a("#").appendText("About"), false);

		// Content

		Container c = body.ac(Bootstrap.container());

		Breadcrumb breadcrumb = Bootstrap.breadcrumb();
		c.ap(breadcrumb);

		breadcrumb.addTextItem("foo");
		breadcrumb.addTextItem("bar");
		breadcrumb.addTextItem("and");
		breadcrumb.addTextItem("so on");

		c.ap(h1().inner("The headline"));

		Div div = c.ac(div("foo"));

		Element p = div.ac(p().inner("this is a paragraph in a div. "));

		System.out.println(p);
		p.ap(b().inner("bold"));
		p.appendText(" and ");
		p.ap(i().inner("italic"));
		p.appendText(" text is possible as well");
		System.out.println(p);

		div.ap(button().inner("I'm a button"));

		p = div.ac(p().inner("Another paragraph with some labels:"));
		p.ap(br());

		List<Type> types = Arrays.asList(Label.Type.values());
		Iterator<Type> iterator = types.iterator();
		while (iterator.hasNext()) {
			Type type = iterator.next();
			Label label = label(type);
			p.ap(label.inner("I'm a label of type "
					+ type.toString().toLowerCase()));
			if (iterator.hasNext()) {
				p.appendText(" ");
			}
		}

		Document doc = builder.getDocument();
		System.out.println(doc);

		builder.write(new File("/tmp/jsoup-bootstrap.html"));
	}

}
