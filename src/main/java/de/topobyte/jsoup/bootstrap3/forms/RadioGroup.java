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

package de.topobyte.jsoup.bootstrap3.forms;

import java.util.List;
import java.util.Map;

import de.topobyte.jsoup.components.Input;
import lombok.Getter;

public class RadioGroup
{

	@Getter
	private Group group;
	@Getter
	private List<Input> inputs;
	@Getter
	private Map<String, Input> valueToInput;

	public RadioGroup(Group group, List<Input> inputs,
			Map<String, Input> valueToInput)
	{
		this.group = group;
		this.inputs = inputs;
		this.valueToInput = valueToInput;
	}

}
