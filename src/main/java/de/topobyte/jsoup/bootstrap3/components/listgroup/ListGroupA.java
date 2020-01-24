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

package de.topobyte.jsoup.bootstrap3.components.listgroup;

import de.topobyte.jsoup.bootstrap3.components.ContextualType;
import de.topobyte.jsoup.components.A;

public class ListGroupA extends A
{

	public ListGroupA()
	{
		super();
	}

	public ListGroupA(String href, String content)
	{
		super(href, content);
	}

	public ListGroupA(String href)
	{
		super(href);
	}

	public void setContext(ContextualType type)
	{
		ContextualLists.setContext(this, type);
	}

}
