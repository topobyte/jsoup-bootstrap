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

import de.topobyte.jsoup.HTML;
import de.topobyte.jsoup.components.Div;

public class Card extends Div
{

	private Div cardHead;
	private Div cardBody;
	private Div cardFooter;

	public Card(boolean withFooter)
	{
		super("card");

		cardHead = ac(HTML.div("card-header"));
		cardBody = ac(HTML.div("card-body"));
		if (withFooter) {
			cardFooter = ac(HTML.div("card-footer"));
		}
	}

	public Div getCardHead()
	{
		return cardHead;
	}

	public Div getCardBody()
	{
		return cardBody;
	}

	public Div getCardFooter()
	{
		return cardFooter;
	}

}
