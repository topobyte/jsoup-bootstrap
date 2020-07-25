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

import de.topobyte.jsoup.HTML;
import de.topobyte.jsoup.bootstrap4.forms.Group;
import de.topobyte.jsoup.components.Div;
import de.topobyte.jsoup.components.Label;
import de.topobyte.jsoup.nodes.Element;

public class BootstrapFormsHorizontal extends BootstrapForms
{

	@Override
	public Group addGroup(Element form)
	{
		Div group = form.ac(HTML.div("form-group row"));
		Div div = group.ac(HTML.div("offset-sm-2 col-sm-10"));

		return new Group(group, null, div);
	}

	@Override
	public Group addGroup(Element form, String label)
	{
		Div group = form.ac(HTML.div("form-group row"));

		Label eLabel = group.ac(HTML.label());
		eLabel.addClass("col-sm-2 control-label");
		eLabel.text(label);

		Div div = group.ac(HTML.div("col-sm-10"));

		return new Group(group, eLabel, div);
	}

	/**
	 * Add an arbitrary element without a label to the form such that it takes
	 * up the full width of the form.
	 */
	public void addFullWidth(Element form, Element element)
	{
		Div group = form.ac(HTML.div("form-group row"));
		Div div = group.ac(HTML.div("col-sm-12"));
		div.ac(element);
	}

}
