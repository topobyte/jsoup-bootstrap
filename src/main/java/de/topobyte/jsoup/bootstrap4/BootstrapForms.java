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

package de.topobyte.jsoup.bootstrap4;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import de.topobyte.jsoup.HTML;
import de.topobyte.jsoup.bootstrap4.forms.ButtonGroup;
import de.topobyte.jsoup.bootstrap4.forms.Checkbox;
import de.topobyte.jsoup.bootstrap4.forms.Group;
import de.topobyte.jsoup.bootstrap4.forms.InlineCheckbox;
import de.topobyte.jsoup.bootstrap4.forms.InputGroup;
import de.topobyte.jsoup.bootstrap4.forms.RadioGroup;
import de.topobyte.jsoup.bootstrap4.forms.SelectGroup;
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

	public Group addGroup(Element form)
	{
		Div group = form.ac(HTML.div("form-group"));

		return new Group(group, null, group);
	}

	public Group addGroup(Element form, String label)
	{
		Div group = form.ac(HTML.div("form-group"));

		Label eLabel = group.ac(HTML.label());
		eLabel.text(label);

		return new Group(group, eLabel, group);
	}

	public InputGroup addInput(Element form, String name)
	{
		Group group = addGroup(form);

		Input input = group.getContent().ac(HTML.input());
		input.setName(name);
		input.addClass("form-control");

		return new InputGroup(group, input);
	}

	public InputGroup addInput(Element form, String name, String label)
	{
		Group group = addGroup(form, label);

		Input input = group.getContent().ac(HTML.input());
		input.setName(name);
		input.addClass("form-control");

		return new InputGroup(group, input);
	}

	public ButtonGroup addSubmit(Element form, String buttonText)
	{
		Group group = addGroup(form);

		Button button = group.getContent().ac(HTML.button());
		button.attr("type", "submit");
		button.addClass("btn");
		button.addClass("btn-primary");
		button.appendText(buttonText);

		return new ButtonGroup(group, button);
	}

	public SelectGroup addSelect(Element form, String name, String label,
			List<String> names, List<String> values)
	{
		return addSelect(form, name, label, names, values, -1);
	}

	public SelectGroup addSelect(Element form, String name, String label,
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

	public RadioGroup addRadio(Element form, String name, String label,
			List<String> names, List<String> values, boolean inline)
	{
		return addRadio(form, name, label, names, values, -1, null, inline);
	}

	public RadioGroup addRadio(Element form, String name, String label,
			List<String> names, List<String> values, String onChange,
			boolean inline)
	{
		return addRadio(form, name, label, names, values, -1, onChange, inline);
	}

	public RadioGroup addRadio(Element form, String name, String label,
			List<String> names, List<String> values, int selectedIndex,
			String onChange, boolean inline)
	{
		Group group = addGroup(form, label);

		Element content = group.getContent().ac(HTML.div());

		List<Input> inputs = new ArrayList<>();
		Map<String, Input> map = new HashMap<>();
		for (int i = 0; i < names.size(); i++) {
			Div div = content.ac(HTML.div("form-check"));
			if (inline) {
				div.addClass("form-check-inline");
			}

			Input input = div.ac(HTML.input());
			input.addClass("form-check-input");
			input.attr("type", "radio");
			input.attr("name", name);
			input.attr("id", String.format("%s%d", name, i + 1));
			input.attr("value", values.get(i));
			if (i == selectedIndex) {
				input.setChecked(true);
			}
			if (onChange != null) {
				input.attr("onchange",
						String.format("%s(this.value)", onChange));
			}

			Label radioLabel = div.ac(HTML.label());
			radioLabel.addClass("form-check-label");
			radioLabel.appendText(names.get(i));

			inputs.add(input);
			map.put(values.get(i), input);
		}

		return new RadioGroup(group, inputs, map);
	}

	public Checkbox addCheckbox(Element form, String name, String label)
	{
		Div checkbox = form.ac(HTML.div("form-check"));

		Input input = checkbox.ac(HTML.input());
		input.addClass("form-check-input");
		input.setName(name);
		input.setType(Type.CHECKBOX);

		Label boxLabel = null;
		if (label != null) {
			boxLabel = checkbox.ac(HTML.label());
			boxLabel.addClass("form-check-label");
			boxLabel.appendText(label);
		}

		return new Checkbox(checkbox, boxLabel, input);
	}

	public InlineCheckbox addInlineCheckbox(Element element, String name,
			String label)
	{
		Div div = element.ac(HTML.div("form-check"));
		div.addClass("form-check-inline");

		Input input = div.ac(HTML.input());
		input.addClass("form-check-input");
		input.setName(name);
		input.setType(Type.CHECKBOX);
		Label boxLabel = div.ac(HTML.label());
		boxLabel.addClass("form-check-label");
		if (label != null) {
			boxLabel.appendText(label);
		}

		return new InlineCheckbox(boxLabel, input);
	}

	/**
	 * Add an arbitrary element with a label to the form.
	 */
	public void addElement(Element form, String label, Element element)
	{
		Group group = addGroup(form, label);
		group.getContent().ac(element);
	}

}
