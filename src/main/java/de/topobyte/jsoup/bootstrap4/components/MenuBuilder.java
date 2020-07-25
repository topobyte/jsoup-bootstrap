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

package de.topobyte.jsoup.bootstrap4.components;

public class MenuBuilder
{

	private String id;
	private boolean fixed = false;
	private boolean fullWidth = false;
	private Expand expand = Expand.LG;
	private boolean light = true;
	private String color = null;

	public Menu create()
	{
		if (id != null) {
			return new Menu(id, fixed, fullWidth, expand, light, color);
		}
		return new Menu(fixed, fullWidth, expand, light, color);
	}

	public MenuBuilder setId(String idNavbar)
	{
		this.id = idNavbar;
		return this;
	}

	public MenuBuilder setFixed(boolean fixed)
	{
		this.fixed = fixed;
		return this;
	}

	public MenuBuilder setFullWidth(boolean fullWidth)
	{
		this.fullWidth = fullWidth;
		return this;
	}

	public MenuBuilder setExpand(Expand expand)
	{
		this.expand = expand;
		return this;
	}

	public MenuBuilder setLight(boolean light)
	{
		this.light = light;
		return this;
	}

	public MenuBuilder setColor(String color)
	{
		this.color = color;
		return this;
	}

}
