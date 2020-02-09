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
import de.topobyte.jsoup.bootstrap3.forms.Checkbox;
import de.topobyte.jsoup.bootstrap3.forms.Group;
import de.topobyte.jsoup.bootstrap3.forms.InputGroup;
import de.topobyte.jsoup.bootstrap3.forms.SelectGroup;
import de.topobyte.jsoup.components.Button;
import de.topobyte.jsoup.components.Div;
import de.topobyte.jsoup.components.Input;
import de.topobyte.jsoup.components.Input.Type;
import de.topobyte.jsoup.components.Label;
import de.topobyte.jsoup.components.Option;
import de.topobyte.jsoup.components.Select;
import de.topobyte.jsoup.nodes.Element;

public class BootstrapForms
{

	public static Group addGroup(Element form)
	{
		Div group = form.ac(HTML.div("form-group"));

		return new Group(group, null, group);
	}

	public static Group addGroup(Element form, String label)
	{
		Div group = form.ac(HTML.div("form-group"));

		Label eLabel = group.ac(HTML.label());
		eLabel.text(label);

		return new Group(group, eLabel, group);
	}

	public static InputGroup addInput(Element form, String name)
	{
		Group group = addGroup(form);

		Input input = group.getContent().ac(HTML.input());
		input.setName(name);
		input.addClass("form-control");

		return new InputGroup(group, input);
	}

	public static InputGroup addInput(Element form, String name, String label)
	{
		Group group = addGroup(form, label);

		Input input = group.getContent().ac(HTML.input());
		input.setName(name);
		input.addClass("form-control");

		return new InputGroup(group, input);
	}

	public static ButtonGroup addSubmit(Element form, String buttonText)
	{
		Group group = addGroup(form);

		Button button = group.getContent().ac(HTML.button());
		button.attr("type", "submit");
		button.addClass("btn");
		button.addClass("btn-default");
		button.appendText(buttonText);

		return new ButtonGroup(group, button);
	}

	public static SelectGroup addSelect(Element form, String name, String label,
			List<String> names, List<String> values)
	{
		return addSelect(form, name, label, names, values, -1);
	}

	public static SelectGroup addSelect(Element form, String name, String label,
			List<String> names, List<String> values, int selectedIndex)
	{
		Group group = addGroup(form, label);

		Select select = group.getContent().ac(HTML.select());
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

		return new SelectGroup(group, select, options, map);
	}

	public static Checkbox addCheckbox(Element form, String name)
	{
		return addCheckbox(form, name, null);
	}

	public static Checkbox addCheckbox(Element form, String name, String text)
	{
		Div checkbox = form.ac(HTML.div("checkbox"));

		Label label = checkbox.ac(HTML.label());
		Input input = label.ac(HTML.input());
		input.setName(name);
		input.setType(Type.CHECKBOX);
		if (text != null) {
			label.appendText(text);
		}

		return new Checkbox(checkbox, label, input);
	}

}
