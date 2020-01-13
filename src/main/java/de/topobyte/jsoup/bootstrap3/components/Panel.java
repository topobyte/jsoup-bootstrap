// Copyright 2019 Sebastian Kuerten
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
import de.topobyte.jsoup.components.Div;

public class Panel extends Div
{

	private Div panelHead;
	private Div panelBody;
	private Div panelFooter;

	public Panel(boolean withFooter)
	{
		super("panel panel-default");

		panelHead = ac(HTML.div("panel-heading"));
		panelBody = ac(HTML.div("panel-body"));
		if (withFooter) {
			panelFooter = ac(HTML.div("panel-footer"));
		}
	}

	public Div getPanelHead()
	{
		return panelHead;
	}

	public Div getPanelBody()
	{
		return panelBody;
	}

	public Div getPanelFooter()
	{
		return panelFooter;
	}

}
