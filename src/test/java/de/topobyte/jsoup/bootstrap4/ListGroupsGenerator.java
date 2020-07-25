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

package de.topobyte.jsoup.bootstrap4;

import static de.topobyte.jsoup.HTML.h1;

import java.io.IOException;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

import org.jsoup.nodes.Document;

import de.topobyte.jsoup.HTML;
import de.topobyte.jsoup.bootstrap4.components.Badge;
import de.topobyte.jsoup.bootstrap4.components.Container;
import de.topobyte.jsoup.bootstrap4.components.ContextualType;
import de.topobyte.jsoup.bootstrap4.components.ListGroup;
import de.topobyte.jsoup.bootstrap4.components.ListGroupDiv;
import de.topobyte.jsoup.bootstrap4.util.ListGroups;
import de.topobyte.jsoup.components.ListItem;
import de.topobyte.jsoup.nodes.Element;

public class ListGroupsGenerator extends BaseGenerator
{

	private Path path = TestBootstrap4.DIR.resolve("list-groups.html");

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

	private List<String> texts = new ArrayList<>();
	{
		texts.add("Cras justo odio");
		texts.add("Dapibus ac facilisis in");
		texts.add("Morbi leo risus");
		texts.add("Porta ac consectetur ac");
		texts.add("Vestibulum at eros");
	}

	private String getText(int i)
	{
		return texts.get(i % texts.size());
	}

	private void basic(Container content)
	{
		ListGroup list = content.ac(Bootstrap.listGroup());
		for (int i = 0; i < 5; i++) {
			list.addTextItem(getText(i));
		}
	}

	private void badges(Container content)
	{
		ListGroup list = content.ac(Bootstrap.listGroup());
		ListItem item;
		int i = 0;
		item = list.addTextItem(getText(i++));
		ListGroups.setBadge(item, Badge.Type.SECONDARY, "14");
		item = list.addTextItem(getText(i++));
		ListGroups.setBadge(item, Badge.Type.SECONDARY, "2");
		item = list.addTextItem(getText(i++));
		ListGroups.setBadge(item, Badge.Type.SECONDARY, "1");
	}

	private void linked(Container content)
	{
		ListGroupDiv list = content.ac(Bootstrap.listGroupDiv());
		int i = 0;
		list.addA("#", getText(i++)).setActive();
		list.addA("#", getText(i++));
		list.addA("#", getText(i++));
		list.addA("#", getText(i++));
		list.addA("#", getText(i++));
	}

	private void buttons(Container content)
	{
		ListGroupDiv list = content.ac(Bootstrap.listGroupDiv());
		int i = 0;
		list.addButton(getText(i++)).setDisabled();
		list.addButton(getText(i++)).setActive();
		list.addButton(getText(i++));
		list.addButton(getText(i++));
		list.addButton(getText(i++));
	}

	private void disabled(Container content)
	{
		ListGroupDiv list = content.ac(Bootstrap.listGroupDiv());
		int i = 0;
		list.addA("#", getText(i++)).setDisabled();
		list.addA("#", getText(i++));
		list.addA("#", getText(i++));
		list.addA("#", getText(i++));
		list.addA("#", getText(i++));
	}

	private void various(Container content)
	{
		ListGroupDiv list = content.ac(Bootstrap.listGroupDiv());
		int i = 0;
		list.addTextItem(getText(i++));
		list.addItem().appendText(getText(i++));
		list.addItem(HTML.b().appendText(getText(i++)));
	}

	private void basicContextual(Container content)
	{
		ListGroup list = content.ac(Bootstrap.listGroup());
		int i = 0;
		for (ContextualType type : ContextualType.values()) {
			list.addTextItem(getText(i++)).setContext(type);
		}
	}

	private void linkedContextual(Container content)
	{
		ListGroupDiv list = content.ac(Bootstrap.listGroupDiv());
		int i = 0;
		for (ContextualType type : ContextualType.values()) {
			list.addA("#", getText(i++)).setContext(type);
		}
	}

}
