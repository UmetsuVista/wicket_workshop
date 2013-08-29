/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.wicket_sapporo.workshop01.page.form;

import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.TextArea;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.model.CompoundPropertyModel;
import org.apache.wicket.model.IModel;
import org.wicket_sapporo.workshop01.page.form.bean.FormPageBean;

/**
 * FormコンポーネントとCompoundPropertyModelの使い方の解説ページ.
 *
 * @author Hiroto Yamakawa
 */
public class MinimalFormPage extends WebPage {
	private static final long serialVersionUID = -4397215481396142458L;

	public MinimalFormPage() {

		// フォームの入力値を格納するオブジェクトを用意する.
		FormPageBean fromPageBean = new FormPageBean();

		// 各コンポーネントの値を、 wicket:id 同じ名前の fromPageBean の変数の値とリンクできる CompoundPropertyModel を用意する.
		IModel<FormPageBean> formPageModel = new CompoundPropertyModel<>(fromPageBean);

		// Formコンポーネントに formPageModelをセットする.
		// CompoundPropertyModelの能力で、このFormコンポーネントにaddされた各コンポーネントの値と、fromPageBeanの変数の値がリンクされる.
		Form<FormPageBean> form = new Form<FormPageBean>("form", formPageModel) {
			private static final long serialVersionUID = 6843470916943201357L;

			/**
			 * 送信ボタンが押され、各コンポーネントの値（＝formPageBeanの変数の値）に入力フォームの値が反映された後の処理。
			 */
			@Override
			protected void onSubmit() {
				super.onSubmit();
				// formから formPageModel を取り出す.
				IModel<FormPageBean> formPageModel = getModel();

				// formPageModel にセットされていた fromPageBean を取り出す.
				FormPageBean formPageBean = formPageModel.getObject();

				// fromPageBean の値に、入力フォームの値が反映されていることを確認する.
				System.out.println(formPageBean.toString());

				// 値が反映された formPageModel を次のページへセット.
				setResponsePage(new FormConfirmationPage(getModel()));
			}
		};

		add(form);

		// 氏名部分のテキスト入力フォームコンポーネント.
		TextField<String> name = new TextField<>("name");

		form.add(name);

		// 年齢部分のテキスト入力フォームコンポーネント.
		TextField<Integer> age = new TextField<>("age");

		form.add(age);

		// 自己紹介部分のテキストエリアコンポーネント.
		TextArea<String> introduction = new TextArea<>("introduction");

		form.add(introduction);

	}

}
