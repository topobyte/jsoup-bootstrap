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

package de.topobyte.jsoup.components.bootstrap3;

import java.util.EnumMap;
import java.util.Map;

import org.jsoup.nodes.Node;

import de.topobyte.jsoup.components.Div;

public class Alert extends Div
{

	public static enum Type {
		SUCCESS,
		INFO,
		WARNING,
		DANGER
	}

	private static Map<Type, String> map = new EnumMap<>(Type.class);
	static {
		for (Type type : Type.values()) {
			map.put(type, type.name().toLowerCase());
		}
	}

	public Alert(Type type)
	{
		if (type == null) {
			throw new IllegalArgumentException("null is not allowed");
		}
		String typename = map.get(type);
		attr("class", "alert alert-" + typename);
		attr("role", "alert");
	}

	public Alert(Type type, String text)
	{
		this(type);
		appendText(text);
	}

	public Alert(Type type, Node child)
	{
		this(type);
		appendChild(child);
	}

}
