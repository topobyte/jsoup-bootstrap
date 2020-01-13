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

package de.topobyte.jsoup;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import de.topobyte.jsoup.HTML;
import de.topobyte.jsoup.components.Button;
import de.topobyte.jsoup.components.Div;
import de.topobyte.jsoup.components.Input;
import de.topobyte.jsoup.components.Label;
import de.topobyte.jsoup.components.Option;
import de.topobyte.jsoup.components.Select;
import de.topobyte.jsoup.forms.InputGroup;
import de.topobyte.jsoup.forms.RadioGroup;
import de.topobyte.jsoup.forms.SelectGroup;
import de.topobyte.jsoup.nodes.Element;

public class BootstrapFormsHorizontal
{

	public static InputGroup addInput(Element form, String name)
	{
		Div group = form.ac(HTML.div("form-group"));

		Div div = group.ac(HTML.div("col-sm-offset-2 col-sm-10"));
		Input input = div.ac(HTML.input());
		input.setName(name);
		input.addClass("form-control");

		return new InputGroup(group, null, div, input);
	}

	public static InputGroup addInput(Element form, String name, String label)
	{
		Div group = form.ac(HTML.div("form-group"));

		Label eLabel = group.ac(HTML.label());
		eLabel.addClass("col-sm-2 control-label");
		eLabel.text(label);

		Div div = group.ac(HTML.div("col-sm-10"));
		Input input = div.ac(HTML.input());
		input.setName(name);
		input.addClass("form-control");

		return new InputGroup(group, eLabel, div, input);
	}

	public static void addSubmit(Element form, String buttonText)
	{
		Div group = form.ac(HTML.div("form-group"));
		Div div = group.ac(HTML.div("col-sm-offset-2 col-sm-10"));

		Button button = div.ac(HTML.button());
		button.attr("type", "submit");
		button.addClass("btn");
		button.addClass("btn-default");
		button.appendText(buttonText);
	}

	public static SelectGroup addSelect(Element form, String name, String label,
			List<String> names, List<String> values)
	{
		return addSelect(form, name, label, names, values, -1);
	}

	public static SelectGroup addSelect(Element form, String name, String label,
			List<String> names, List<String> values, int selectedIndex)
	{
		Div group = form.ac(HTML.div("form-group"));

		Label eLabel = group.ac(HTML.label());
		eLabel.addClass("col-sm-2 control-label");
		eLabel.text(label);

		Div div = group.ac(HTML.div("col-sm-10"));

		Select select = div.ac(HTML.select());
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

		return new SelectGroup(group, options, map);
	}

	public static RadioGroup addRadio(Element form, String name, String label,
			List<String> names, List<String> values)
	{
		return addRadio(form, name, label, names, values, -1, null);
	}

	public static RadioGroup addRadio(Element form, String name, String label,
			List<String> names, List<String> values, String onChange)
	{
		return addRadio(form, name, label, names, values, -1, onChange);
	}

	public static RadioGroup addRadio(Element form, String name, String label,
			List<String> names, List<String> values, int selectedIndex,
			String onChange)
	{
		Div group = form.ac(HTML.div("form-group"));

		Label eLabel = group.ac(HTML.label());
		eLabel.addClass("col-sm-2 control-label");
		eLabel.text(label);

		Div div = group.ac(HTML.div("col-sm-10"));

		Div dr = div.ac(HTML.div("radio"));

		List<Input> inputs = new ArrayList<>();
		Map<String, Input> map = new HashMap<>();
		for (int i = 0; i < names.size(); i++) {
			Label radioLabel = dr.ac(HTML.label());
			Input input = radioLabel.ac(HTML.input());
			input.attr("type", "radio");
			input.attr("name", name);
			input.attr("id", String.format("%s%d", name, i + 1));
			input.attr("value", values.get(i));
			if (onChange != null) {
				input.attr("onchange",
						String.format("%s(this.value)", onChange));
			}
			radioLabel.appendText(names.get(i));

			inputs.add(input);
			map.put(values.get(i), input);
		}

		return new RadioGroup(group, inputs, map);
	}

	/**
	 * Add an arbitrary element with a label to the form.
	 */
	public static void addElement(Element form, String label, Element element)
	{
		Div group = form.ac(HTML.div("form-group"));

		Label eLabel = group.ac(HTML.label());
		eLabel.addClass("col-sm-2 control-label");
		eLabel.text(label);

		Div div = group.ac(HTML.div("col-sm-10"));
		div.ac(element);
	}

	/**
	 * Add an arbitrary element without a label to the form such that it takes
	 * up the full width of the form.
	 */
	public static void addFullWidth(Element form, Element element)
	{
		Div group = form.ac(HTML.div("form-group"));
		Div div = group.ac(HTML.div("col-sm-12"));
		div.ac(element);
	}

}
