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

import java.util.UUID;

import de.topobyte.jsoup.HTML;
import de.topobyte.jsoup.components.Div;

public class CollapsiblePanel extends Div
{

	private Div panelHead;
	private Div panelBody;
	private Div panelFooter;
	private String collapseId;

	/**
	 * Create a new collapsible panel with a random UUID-based collapse id.
	 * 
	 * @param withFooter
	 *            whether the footer div should be added.
	 */
	public CollapsiblePanel(boolean withFooter, boolean collapseWithHeaderClick,
			boolean open)
	{
		this(withFooter, UUID.randomUUID().toString(), collapseWithHeaderClick,
				open);
	}

	/**
	 * Create a new collapsible panel with the specified collapse id.
	 * 
	 * @param withFooter
	 *            whether the footer div should be added.
	 */
	public CollapsiblePanel(boolean withFooter, String collapseId,
			boolean collapseWithHeaderClick, boolean open)
	{
		super("panel panel-default");

		this.collapseId = collapseId;

		panelHead = ac(HTML.div("panel-heading clickable"));

		Div collapse = ac(HTML.div("panel-collapse collapse"));
		if (open) {
			collapse.addClass("in");
		}
		collapse.attr("id", collapseId);
		panelBody = collapse.ac(HTML.div("panel-body"));

		if (withFooter) {
			panelFooter = collapse.ac(HTML.div("panel-footer"));
		}

		if (collapseWithHeaderClick) {
			panelHead.attr("data-toggle", "collapse");
			panelHead.attr("data-target", "#" + collapseId);
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
