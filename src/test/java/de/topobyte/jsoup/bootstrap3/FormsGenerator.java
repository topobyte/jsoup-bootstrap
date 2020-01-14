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

package de.topobyte.jsoup.bootstrap3;

import static de.topobyte.jsoup.HTML.h1;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;

import org.jsoup.nodes.Document;

import de.topobyte.jsoup.HTML;
import de.topobyte.jsoup.bootstrap3.components.Container;
import de.topobyte.jsoup.bootstrap3.forms.InputGroup;
import de.topobyte.jsoup.components.Form;
import de.topobyte.jsoup.components.Input.Type;
import de.topobyte.jsoup.nodes.Element;

public class FormsGenerator extends BaseGenerator
{

	private Path path = Paths.get("/tmp/jsoup-bootstrap/forms.html");

	@Override
	public void generate() throws IOException
	{
		super.generate();

		Element body = builder.getBody();

		// Content

		Container c = body.ac(Bootstrap.container());

		c.ap(h1().inner("Regular forms"));

		form(c);

		c.ap(h1().inner("Horizontal forms"));

		horizontalForm(c);

		Document doc = builder.getDocument();
		System.out.println(doc);

		builder.write(path);
	}

	private void form(Container content)
	{
		Form form = content.ac(HTML.form());
		form.attr("id", "form1");

		InputGroup inputName = BootstrapForms.addInput(form, "name", "Name");
		inputName.getInput().setPlaceholder("Your name");

		InputGroup inputPassword = BootstrapForms.addInput(form, "password",
				"Password");
		inputPassword.getInput().setType(Type.PASSWORD);

		BootstrapForms.addSelect(form, "pet", "Preferred Pet",
				Arrays.asList("Cat", "Dog", "Bird"),
				Arrays.asList("cat", "dog", "bird"));

		BootstrapForms.addSubmit(form, "Continue");
	}

	private void horizontalForm(Container content)
	{
		Form form = content.ac(HTML.form());
		form.attr("id", "form2");
		form.addClass("form-horizontal");

		InputGroup inputName = BootstrapFormsHorizontal.addInput(form, "name",
				"Name");
		inputName.getInput().setPlaceholder("Your name");

		InputGroup inputPassword = BootstrapFormsHorizontal.addInput(form,
				"password", "Password");
		inputPassword.getInput().setType(Type.PASSWORD);

		BootstrapFormsHorizontal.addSelect(form, "pet", "Preferred Pet",
				Arrays.asList("Cat", "Dog", "Bird"),
				Arrays.asList("cat", "dog", "bird"));

		BootstrapFormsHorizontal.addRadio(form, "dring", "Preferred Drink",
				Arrays.asList("Coke", "Water", "Beer"),
				Arrays.asList("coke", "water", "beer"));

		BootstrapFormsHorizontal.addSubmit(form, "Continue");
	}

}
