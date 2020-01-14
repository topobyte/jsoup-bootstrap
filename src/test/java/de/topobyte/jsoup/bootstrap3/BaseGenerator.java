package de.topobyte.jsoup.bootstrap3;

import static de.topobyte.jsoup.HTML.a;

import java.io.IOException;

import org.apache.commons.io.IOUtils;

import de.topobyte.jsoup.ElementUtil;
import de.topobyte.jsoup.HTML;
import de.topobyte.jsoup.HtmlBuilder;
import de.topobyte.jsoup.bootstrap3.components.Menu;
import de.topobyte.jsoup.nodes.Element;

public class BaseGenerator
{

	protected HtmlBuilder builder = new HtmlBuilder();

	public void generate() throws IOException
	{
		Element head = builder.getHead();

		String header = IOUtils
				.toString(Thread.currentThread().getContextClassLoader()
						.getResourceAsStream("bootstrap.headers.html"));
		System.out.println(header);
		ElementUtil.appendFragment(head, header);

		Element body = builder.getBody();

		// Menu

		menu(body);
	}

	protected static void menu(Element body)
	{
		Menu menu = new Menu();
		body.ap(menu);

		menu.addBrand(HTML.span().appendText("Awesome"));

		menu.addMain(a("#").appendText("Products"), false);
		menu.addMain(a("#").appendText("Services"), false);
		menu.addMain(a("#").appendText("Partners"), false);

		menu.addRight(a("#").appendText("About"), false);
	}

}
