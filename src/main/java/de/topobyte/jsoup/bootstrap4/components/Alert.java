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

import java.util.EnumMap;
import java.util.Map;

import org.jsoup.nodes.Node;

import de.topobyte.jsoup.components.Div;

public class Alert extends Div
{

	private static Map<ContextualType, String> map = new EnumMap<>(
			ContextualType.class);
	static {
		for (ContextualType type : ContextualType.values()) {
			map.put(type, type.name().toLowerCase());
		}
	}

	public Alert(ContextualType type)
	{
		if (type == null) {
			throw new IllegalArgumentException("null is not allowed");
		}
		String typename = map.get(type);
		attr("class", "alert alert-" + typename);
		attr("role", "alert");
	}

	public Alert(ContextualType type, String text)
	{
		this(type);
		appendText(text);
	}

	public Alert(ContextualType type, Node child)
	{
		this(type);
		appendChild(child);
	}

}
