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

package de.topobyte.jsoup.bootstrap4.components;

public enum Column {

	XS_1("col-xs-1"),
	XS_2("col-xs-2"),
	XS_3("col-xs-3"),
	XS_4("col-xs-4"),
	XS_5("col-xs-5"),
	XS_6("col-xs-6"),
	XS_7("col-xs-7"),
	XS_8("col-xs-8"),
	XS_9("col-xs-9"),
	XS_10("col-xs-10"),
	XS_11("col-xs-11"),
	XS_12("col-xs-12"),

	SM_1("col-sm-1"),
	SM_2("col-sm-2"),
	SM_3("col-sm-3"),
	SM_4("col-sm-4"),
	SM_5("col-sm-5"),
	SM_6("col-sm-6"),
	SM_7("col-sm-7"),
	SM_8("col-sm-8"),
	SM_9("col-sm-9"),
	SM_10("col-sm-10"),
	SM_11("col-sm-11"),
	SM_12("col-sm-12"),

	MD_1("col-md-1"),
	MD_2("col-md-2"),
	MD_3("col-md-3"),
	MD_4("col-md-4"),
	MD_5("col-md-5"),
	MD_6("col-md-6"),
	MD_7("col-md-7"),
	MD_8("col-md-8"),
	MD_9("col-md-9"),
	MD_10("col-md-10"),
	MD_11("col-md-11"),
	MD_12("col-md-12"),

	LG_1("col-lg-1"),
	LG_2("col-lg-2"),
	LG_3("col-lg-3"),
	LG_4("col-lg-4"),
	LG_5("col-lg-5"),
	LG_6("col-lg-6"),
	LG_7("col-lg-7"),
	LG_8("col-lg-8"),
	LG_9("col-lg-9"),
	LG_10("col-lg-10"),
	LG_11("col-lg-11"),
	LG_12("col-lg-12");

	private String className;

	Column(String className)
	{
		this.className = className;
	}

	public String getClassName()
	{
		return className;
	}

}
