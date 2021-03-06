package org.wicket_sapporo.workshop01.page.template.replace_pattern.panel;

import java.util.Date;

import org.apache.wicket.datetime.markup.html.basic.DateLabel;
import org.apache.wicket.markup.html.panel.Panel;
import org.apache.wicket.model.Model;

public class Content03Panel extends Panel {
	private static final long serialVersionUID = 5527966331413782970L;

	public Content03Panel(String id) {
		super(id);
		add(DateLabel.forDatePattern("dateLabel", Model.of(new Date()), "yyyy-MM-dd"));
	}

}
