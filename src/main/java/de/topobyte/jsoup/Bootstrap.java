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

package de.topobyte.jsoup;

import de.topobyte.jsoup.components.Div;
import de.topobyte.jsoup.components.bootstrap3.Breadcrumb;
import de.topobyte.jsoup.components.bootstrap3.Button;
import de.topobyte.jsoup.components.bootstrap3.Container;
import de.topobyte.jsoup.components.bootstrap3.ContainerFluid;
import de.topobyte.jsoup.components.bootstrap3.Label;

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

	public static Label label(Label.Type type)
	{
		return new Label(type);
	}

}
