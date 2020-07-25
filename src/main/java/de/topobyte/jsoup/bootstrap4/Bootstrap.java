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

package de.topobyte.jsoup.bootstrap4;

import de.topobyte.jsoup.bootstrap4.components.Alert;
import de.topobyte.jsoup.bootstrap4.components.Badge;
import de.topobyte.jsoup.bootstrap4.components.Breadcrumb;
import de.topobyte.jsoup.bootstrap4.components.Button;
import de.topobyte.jsoup.bootstrap4.components.Container;
import de.topobyte.jsoup.bootstrap4.components.ContainerFluid;
import de.topobyte.jsoup.bootstrap4.components.ContextualType;
import de.topobyte.jsoup.bootstrap4.components.ListGroup;
import de.topobyte.jsoup.bootstrap4.components.ListGroupDiv;
import de.topobyte.jsoup.components.Div;

public class Bootstrap
{

	public static Container container()
	{
		return new Container();
	}

	public static ContainerFluid containerFluid()
	{
		return new ContainerFluid();
	}

	public static Button button()
	{
		return new Button();
	}

	public static Breadcrumb breadcrumb()
	{
		return new Breadcrumb();
	}

	public static Div row()
	{
		return new Div("row");
	}

	public static Badge badge(Badge.Type type)
	{
		return new Badge(type);
	}

	public static Alert alert(ContextualType type)
	{
		return new Alert(type);
	}

	public static ListGroup listGroup()
	{
		return new ListGroup();
	}

	public static ListGroupDiv listGroupDiv()
	{
		return new ListGroupDiv();
	}

}
