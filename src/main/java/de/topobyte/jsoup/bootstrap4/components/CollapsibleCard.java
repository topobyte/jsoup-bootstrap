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

package de.topobyte.jsoup.bootstrap4.components;

import java.util.UUID;

import de.topobyte.jsoup.HTML;
import de.topobyte.jsoup.components.A;
import de.topobyte.jsoup.components.Div;

public class CollapsibleCard extends Div
{

	private Div panelHead;
	private Div panelBody;
	private Div panelFooter;
	private String collapseId;

	/**
	 * Create a new collapsible card with a random UUID-based collapse id.
	 *
	 * @param withFooter
	 *            whether the footer div should be added.
	 */
	public CollapsibleCard(boolean withFooter, boolean collapseWithHeaderClick,
			boolean open)
	{
		this(withFooter,
				"collapse-" + UUID.randomUUID().toString().substring(0, 10),
				collapseWithHeaderClick, open);
	}

	/**
	 * Create a new collapsible card with the specified collapse id.
	 *
	 * @param withFooter
	 *            whether the footer div should be added.
	 */
	public CollapsibleCard(boolean withFooter, String collapseId,
			boolean collapseWithHeaderClick, boolean open)
	{
		super("card");

		this.collapseId = collapseId;

		A a = ac(HTML.a("#" + collapseId));
		if (!open) {
			a.addClass("collapsed");
		}
		panelHead = a.ac(HTML.div("card-header"));
		a.attr("data-toggle", "collapse");
		a.attr("aria-expanded", Boolean.toString(open));

		Div collapse = ac(HTML.div("collapse"));
		if (open) {
			collapse.addClass("show");
		}
		collapse.attr("id", collapseId);
		panelBody = collapse.ac(HTML.div("card-body"));

		if (withFooter) {
			panelFooter = collapse.ac(HTML.div("card-footer"));
		}

		if (collapseWithHeaderClick) {

		}
	}

	public String getCollapseId()
	{
		return collapseId;
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
