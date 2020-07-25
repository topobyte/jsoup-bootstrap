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

import static de.topobyte.jsoup.HTML.h1;

import java.io.IOException;
import java.nio.file.Path;

import org.jsoup.nodes.Document;

import de.topobyte.jsoup.HTML;
import de.topobyte.jsoup.bootstrap3.components.Container;
import de.topobyte.jsoup.bootstrap3.components.ContextualType;
import de.topobyte.jsoup.bootstrap3.components.ListGroup;
import de.topobyte.jsoup.bootstrap3.components.ListGroupDiv;
import de.topobyte.jsoup.components.ListItem;
import de.topobyte.jsoup.nodes.Element;

public class ListGroupsGenerator extends BaseGenerator
{

	private Path path = TestBootstrap3.DIR.resolve("list-groups.html");

	@Override
	public void generate() throws IOException
	{
		super.generate();

		Element body = builder.getBody();

		// Content

		Container c = body.ac(Bootstrap.container());

		c.ap(h1().inner("List groups"));

		c.ap(h1().inner("Basic"));
		basic(c);

		c.ap(h1().inner("Badges"));
		badges(c);

		c.ap(h1().inner("Linked items"));
		linked(c);

		c.ap(h1().inner("Button items"));
		buttons(c);

		c.ap(h1().inner("Disabled items"));
		disabled(c);

		c.ap(h1().inner("Various items"));
		various(c);

		c.ap(h1().inner("Contextual classes, default"));
		basicContextual(c);

		c.ap(h1().inner("Contextual classes, linked"));
		linkedContextual(c);

		Document doc = builder.getDocument();
		System.out.println(doc);

		builder.write(path);
	}

	private void basic(Container content)
	{
		ListGroup list = content.ac(Bootstrap.listGroup());
		list.addTextItem("Cras justo odio");
		list.addTextItem("Dapibus ac facilisis in");
		list.addTextItem("Morbi leo risus");
		list.addTextItem("Porta ac consectetur ac");
		list.addTextItem("Vestibulum at eros");
	}

	private void badges(Container content)
	{
		ListGroup list = content.ac(Bootstrap.listGroup());
		ListItem item;
		item = list.addTextItem("Cras justo odio");
		item.ac(Bootstrap.badge().appendText("14"));
		item = list.addTextItem("Dapibus ac facilisis in");
		item.ac(Bootstrap.badge().appendText("2"));
		item = list.addTextItem("Morbi leo risus");
		item.ac(Bootstrap.badge().appendText("1"));
	}

	private void linked(Container content)
	{
		ListGroupDiv list = content.ac(Bootstrap.listGroupDiv());
		list.addA("#", "Cras justo odio").setActive();
		list.addA("#", "Dapibus ac facilisis in");
		list.addA("#", "Morbi leo risus");
		list.addA("#", "Porta ac consectetur ac");
		list.addA("#", "Vestibulum at eros");
	}

	private void buttons(Container content)
	{
		ListGroupDiv list = content.ac(Bootstrap.listGroupDiv());
		list.addButton("Cras justo odio").setDisabled();
		list.addButton("Dapibus ac facilisis in").setActive();
		list.addButton("Morbi leo risus");
		list.addButton("Porta ac consectetur ac");
		list.addButton("Vestibulum at eros");
	}

	private void disabled(Container content)
	{
		ListGroupDiv list = content.ac(Bootstrap.listGroupDiv());
		list.addA("#", "Cras justo odio").setDisabled();
		list.addA("#", "Dapibus ac facilisis in");
		list.addA("#", "Morbi leo risus");
		list.addA("#", "Porta ac consectetur ac");
		list.addA("#", "Vestibulum at eros");
	}

	private void various(Container content)
	{
		ListGroupDiv list = content.ac(Bootstrap.listGroupDiv());
		list.addTextItem("Cras justo odio");
		list.addItem().appendText("Dapibus ac facilisis in");
		list.addItem(HTML.b().appendText("Morbi leo risus"));
	}

	private void basicContextual(Container content)
	{
		ListGroup list = content.ac(Bootstrap.listGroup());
		list.addTextItem("Cras justo odio").setContext(ContextualType.SUCCESS);
		list.addTextItem("Dapibus ac facilisis in")
				.setContext(ContextualType.INFO);
		list.addTextItem("Porta ac consectetur ac")
				.setContext(ContextualType.WARNING);
		list.addTextItem("Vestibulum at eros")
				.setContext(ContextualType.DANGER);
	}

	private void linkedContextual(Container content)
	{
		ListGroupDiv list = content.ac(Bootstrap.listGroupDiv());
		list.addA("#", "Cras justo odio").setContext(ContextualType.SUCCESS);
		list.addA("#", "Dapibus ac facilisis in")
				.setContext(ContextualType.INFO);
		list.addA("#", "Porta ac consectetur ac")
				.setContext(ContextualType.WARNING);
		list.addA("#", "Vestibulum at eros").setContext(ContextualType.DANGER);
	}

}
