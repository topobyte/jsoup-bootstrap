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

package de.topobyte.jsoup.bootstrap3;

import static de.topobyte.jsoup.HTML.b;
import static de.topobyte.jsoup.HTML.br;
import static de.topobyte.jsoup.HTML.div;
import static de.topobyte.jsoup.HTML.h1;
import static de.topobyte.jsoup.HTML.i;
import static de.topobyte.jsoup.HTML.p;
import static de.topobyte.jsoup.bootstrap3.Bootstrap.alert;
import static de.topobyte.jsoup.bootstrap3.Bootstrap.button;
import static de.topobyte.jsoup.bootstrap3.Bootstrap.label;

import java.io.IOException;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import org.jsoup.nodes.Document;

import de.topobyte.jsoup.HTML;
import de.topobyte.jsoup.bootstrap3.components.Alert;
import de.topobyte.jsoup.bootstrap3.components.Breadcrumb;
import de.topobyte.jsoup.bootstrap3.components.CollapsiblePanel;
import de.topobyte.jsoup.bootstrap3.components.Container;
import de.topobyte.jsoup.bootstrap3.components.ContextualType;
import de.topobyte.jsoup.bootstrap3.components.Label;
import de.topobyte.jsoup.bootstrap3.components.NavTabs;
import de.topobyte.jsoup.bootstrap3.components.Panel;
import de.topobyte.jsoup.components.Div;
import de.topobyte.jsoup.nodes.Element;

public class OverviewGenerator extends BaseGenerator
{

	private Path path = TestBootstrap3.DIR.resolve("index.html");

	@Override
	public void generate() throws IOException
	{
		super.generate();

		Element body = builder.getBody();

		// Content

		Container c = body.ac(Bootstrap.container());

		breadcrumbs(c);

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

		labels(div);

		navTabs(div);

		panels(div);

		alerts(div);

		Document doc = builder.getDocument();
		System.out.println(doc);

		builder.write(path);
	}

	private static void breadcrumbs(Container c)
	{
		Breadcrumb breadcrumb = Bootstrap.breadcrumb();
		c.ap(breadcrumb);

		breadcrumb.addTextItem("foo");
		breadcrumb.addTextItem("bar");
		breadcrumb.addTextItem("and");
		breadcrumb.addTextItem("so on");
	}

	private static void labels(Div div)
	{
		Element p = div.ac(p().inner("Another paragraph with some labels:"));
		p.ap(br());

		List<Label.Type> types = Arrays.asList(Label.Type.values());
		Iterator<Label.Type> iterator = types.iterator();
		while (iterator.hasNext()) {
			Label.Type type = iterator.next();
			Label label = label(type);
			p.ap(label.inner(
					"I'm a label of type " + type.toString().toLowerCase()));
			if (iterator.hasNext()) {
				p.appendText(" ");
			}
		}
	}

	private static void navTabs(Div div)
	{
		div.ac(p().inner("Nav tabs:"));
		NavTabs navTabs = new NavTabs();
		div.ac(navTabs.getElement());

		for (int i = 1; i <= 5; i++) {
			Element link = HTML.a("#").appendText("item " + i);
			navTabs.addItem(link, i == 2);
		}
	}

	private static void panels(Div div)
	{
		div.ac(p().inner("Panels:"));

		Panel panel = div.ac(new Panel(false));
		panel.getPanelHead().appendText("A simple panel");
		panel.getPanelBody().appendText("Some content");

		panel = div.ac(new Panel(true));
		panel.getPanelHead().appendText("A simple panel");
		panel.getPanelBody().appendText("Some content");
		panel.getPanelFooter().appendText("A footer");

		CollapsiblePanel cpanel = div
				.ac(new CollapsiblePanel(false, true, false));
		cpanel.getPanelHead().appendText("A collapsible panel");
		cpanel.getPanelBody().appendText("Some content");

		cpanel = div.ac(new CollapsiblePanel(true, true, true));
		cpanel.getPanelHead().appendText("A collapsible panel");
		cpanel.getPanelBody().appendText("Some content");
		cpanel.getPanelFooter().appendText("A footer");
	}

	private static void alerts(Div div)
	{
		div.ac(p().inner("Alerts:"));

		List<ContextualType> types = Arrays.asList(ContextualType.values());
		Iterator<ContextualType> iterator = types.iterator();
		while (iterator.hasNext()) {
			ContextualType type = iterator.next();
			Alert alert = div.ac(alert(type));
			alert.appendText(
					"I'm an alert of type " + type.toString().toLowerCase());
		}
	}

}
