// Copyright 2018 Sebastian Kuerten
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

package de.topobyte.jsoup.bootstrap3;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import de.topobyte.jsoup.HTML;
import de.topobyte.jsoup.bootstrap3.forms.ButtonGroup;
import de.topobyte.jsoup.bootstrap3.forms.InputGroup;
import de.topobyte.jsoup.bootstrap3.forms.SelectGroup;
import de.topobyte.jsoup.components.Button;
import de.topobyte.jsoup.components.Div;
import de.topobyte.jsoup.components.Form;
import de.topobyte.jsoup.components.Input;
import de.topobyte.jsoup.components.Label;
import de.topobyte.jsoup.components.Option;
import de.topobyte.jsoup.components.Select;

public class BootstrapForms
{

	public static InputGroup addInput(Form form, String name)
	{
		Div group = form.ac(HTML.div("form-group"));

		Input input = group.ac(HTML.input());
		input.setName(name);
		input.addClass("form-control");

		return new InputGroup(group, null, null, input);
	}

	public static InputGroup addInput(Form form, String name, String label)
	{
		Div group = form.ac(HTML.div("form-group"));

		Label eLabel = group.ac(HTML.label());
		eLabel.text(label);

		Input input = group.ac(HTML.input());
		input.setName(name);
		input.addClass("form-control");

		return new InputGroup(group, eLabel, null, input);
	}

	public static ButtonGroup addSubmit(Form form, String buttonText)
	{
		Div group = form.ac(HTML.div("form-group"));

		Button button = group.ac(HTML.button());
		button.attr("type", "submit");
		button.addClass("btn");
		button.addClass("btn-default");
		button.appendText(buttonText);

		return new ButtonGroup(group, null, button);
	}

	public static SelectGroup addSelect(Form form, String name, String label,
			List<String> names, List<String> values)
	{
		return addSelect(form, name, label, names, values, -1);
	}

	public static SelectGroup addSelect(Form form, String name, String label,
			List<String> names, List<String> values, int selectedIndex)
	{
		Div group = form.ac(HTML.div("form-group"));

		Label eLabel = group.ac(HTML.label());
		eLabel.text(label);

		Select select = group.ac(HTML.select());
		select.attr("name", name);
		select.addClass("form-control");

		List<Option> options = new ArrayList<>();
		Map<String, Option> map = new HashMap<>();
		for (int i = 0; i < names.size(); i++) {
			Option option = select.ac(HTML.option());
			option.setValue(values.get(i));
			option.text(names.get(i));
			if (i == selectedIndex) {
				option.setSelected(true);
			}

			options.add(option);
			map.put(values.get(i), option);
		}

		return new SelectGroup(group, eLabel, null, select, options, map);
	}

}
