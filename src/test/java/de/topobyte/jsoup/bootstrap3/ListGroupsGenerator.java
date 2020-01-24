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
import java.nio.file.Paths;

import org.jsoup.nodes.Document;

import de.topobyte.jsoup.bootstrap3.components.Container;
import de.topobyte.jsoup.bootstrap3.components.ListGroup;
import de.topobyte.jsoup.components.ListItem;
import de.topobyte.jsoup.nodes.Element;

public class ListGroupsGenerator extends BaseGenerator
{

	private Path path = Paths.get("/tmp/jsoup-bootstrap/list-groups.html");

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

}
